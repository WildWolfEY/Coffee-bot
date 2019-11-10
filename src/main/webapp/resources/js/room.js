$(document).ready(function () {
        var maxX = $(".top-panel").offset().left - $(".stick").width();
        var maxY = $(".top-panel").offset().top + $(".top-panel").height();
        var x = getRandomInt(maxX);
        var y = getRandomInt(maxY);

        var existsMail = document.cookie.match("(^|;) ?" + "mail" + "=([^;]*)(;|$)");
        var existsToken = document.cookie.match("(^|;) ?" + "token" + "=([^;]*)(;|$)");

        if (existsMail) user.mail = existsMail[2];
        if (existsMail) user.token = existsToken[2];

        if (existsMail && existsToken) {
            $(".button-settings").click(function () {
                    $(".stopped").removeClass('stopped');
                    if ($(this).hasClass('select-btn'))
                        $(this).removeClass('select-btn');
                    else
                        $(this).addClass('select-btn');
                }
            )
            $(".button-settings").mouseover(function () {
                    setComment("Опции, которые можно выбрать");
                    if ($(".started").length == 0)
                        $(".display").text($(this).attr('value'));

                }
            )
            $(".button-group").mouseout(function () {
                    if ($(".started").length == 0)
                        $(".display").text('Select some settings, and START');
                }
            )
            $(".button-start").click(function () {
                    search();
                    $("#btn_exit").show();
                    $("#btn_entrance").hide();
                    setComment("Запускаю поиск пары...");
                }
            )
            $(".button-stop").click(function () {
                    cancelMeeting();
                }
            )
            $("#btn_exit").click(function () {
                    exit_coffee();
                }
            )
            $("#btn_entrance").click(function () {
                    entrance_coffee();
                }
            )
            getStatus();

            $(".button-start").mouseover(function () {
                    setComment("Это кнопка START. Как только вы её нажмёте, кофебот начнёт вам искать пару для встречи.");
                }
            )
            $(".button-stop").mouseover(function () {
                    setComment("Этой кнопкой вы можете отменить назначенную встречу");
                }
            )
            $("#btn_exit").mouseover(function () {
                    setComment("Нажмите, и вас больше не смогут приглашать на встречи. Если встреча вам уже назначена, она будет отменена");
                }
            )
            $("#btn_entrance").mouseover(function () {
                    setComment("Нажать, если вы вновь хотите быть приглашены на кофе");
                }
            )
            $(".stick").mouseover(function () {
                    setComment("Напоминалка");
                }
            )
        }
        else {
            document.location.href = "/coffee-bot/entrance";
            $(".display").text("UNAUTORIZE! I DON'T KNOW YOU");
        }
    }
)
var options = [];
var user = {
    mail: null,
    token: null,
    options: options
}
function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

function search() {
    if ($("#setting_talk").hasClass('select-btn')) {
        user.options.push("TALKIG");
    }
    if ($("#setting_listen").hasClass('select-btn')) {
        user.options.push("LISTENING");
    }
    if ($("#setting_work").hasClass('select-btn')) {
        user.options.push("ABOUTWORK");
    }
    if ($("#setting_talk").hasClass('setting_other')) {
        user.options.push("ABOUTALL");
    }


    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "search",
        type: 'POST',
        data: (
            JSON.stringify(user)
        )
    })
        .done(function (person) {
            if (person != null && person != "") {
                statusBisy();
                setComment("Встреча назначена. Ожитайте письма на почту");
            }
            else {
                statusWait();
                setComment("Нет свободных собеседников. Как только они появятся, вам придёт письмо");
            }
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            setComment(errorThrown, "err");
        });
}

function getStatus() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "get-status",
        type: 'POST',
        data: (
            JSON.stringify(user)
        )
    })
        .done(function (status) {
            $("#btn_exit").show();
            $("#btn_entrance").hide();
            if (status == "BISY") {
                statusBisy();
                setComment("Вам уже назначена встреча. Проверьте почту.");
            }
            else if (status == "WAITING") {
                statusWait();
                setComment("Пока что нет свободных коллег, с кем вам можно было бы назначить встречу." +
                    "Как только кто-нибудь появится, вам обязательно придёт письмо на почту");
            }
            else if (status == "DISABLED") {
                $("#btn_exit").hide();
                $("#btn_entrance").show();
                setComment("Вам не приходят уведомления, потому что вы вышли из игры. " +
                    "Чтобы вас вновь могли приглашать на встречи, просто нажмите ENTRANCE, или нажмите START, чтобы притгласить кого-то");
            }
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            setComment(errorThrown, "err");
        });
}

function statusBisy() {
    $(".button-start").addClass('started');
    $(".display").text('Enjoy your drink...');
    $(".coffee").addClass('line');
    $(".stopped").removeClass('stopped');
    $(".stick").show();
    $(".stick-text").removeClass('cancel-text');
    $(".stick").css("left", x);
    $(".stick").css("top", y);
}
function statusWait() {
    $(".button-start").addClass('started');
    $(".display").text('Searching pair. Wait, please...');
}

function statusCancel() {
    if ($(".started").length > 0) {
        $(".started").removeClass('started');
        $(".select-btn").removeClass('select-btn');
        $(".button-stop").addClass('stopped');
        $(".display").text('Canceled...');
        $(".coffee").removeClass('line');
        $(".stick-text").addClass('cancel-text');
    }
}
function cancelMeeting() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "cancel",
        type: 'POST',
        data: (
            JSON.stringify(user)
        )
    })
        .done(function (data) {
            statusCancel()
            setComment("Вы отменили встречу. Если снова захотите пригласить кого-то, просто нажмите на кнопку START");
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            setComment(errorThrown, "err");
        });
}

function exit_coffee() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "exit",
        type: 'POST',
        data: (
            JSON.stringify(user)
        )
    })
        .done(function (data) {
            $("#btn_exit").hide();
            $("#btn_entrance").show();
            statusCancel();

            setComment("Вы вышли из игры и отменили все свои встречи. Если снова захотите получать приглашения, просто нажмите на кнопку ENTRANCE или на кнопку START");

        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            setComment(errorThrown, "err");
        });

}
function entrance_coffee() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "back",
        type: 'POST',
        data: (
            JSON.stringify(user)
        )
    })
        .done(function (data) {
            $("#btn_exit").show();
            $("#btn_entrance").hide();
            setComment("Вы вернулись в игру. Теперь вас снова станут приглашать пить кофе!");
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            setComment(errorThrown, "err");
        });
}
function setComment(text, status) {
    if (status == "err")
        $(".footer").addClass("err");
    else
        $(".footer").removeClass("err");

    $(".footer").text(text);
}