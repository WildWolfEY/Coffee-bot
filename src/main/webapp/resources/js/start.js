$(document).ready(function () {
        $(".key").click(function () {
                $(".envelope").addClass('envelope-entrance');
                $(".envelope").removeClass('envelope-registrate');
                $("#tbl_registrate").hide();
                $("#submit-registrate").hide();
                $("#tbl_entrance").show();
                $("#submit-entrance").show();
                $(".envelope").show();
            }
        )

        $(".node").click(function () {
                $(".envelope").removeClass('envelope-entrance');
                $(".envelope").addClass('envelope-registrate');
                $("#tbl_entrance").hide();
                $("#submit-entrance").hide();
                $("#tbl_registrate").show();
                $("#submit-registrate").show();
                $(".envelope").show();
            }
        )

        $(".close-btn").click(function () {
                $(".envelope").hide();
            }
        )
        $("#submit-registrate").click(function () {
                registrateUser();
            }
        )
        $("#submit-entrance").click(function () {
                $(".envelope").hide();
                autorizeUser();
            }
        )
        $("#reg_mail").focusout(function () {
                validateMail();
            }
        )

    }
)
var user = {
    name: null,
    sex: null,
    job: null,
    area: null,
    mail: null,
    password: null
};
function registrateUser() {
    user.name = $("#reg_name").val();
    user.sex = $("#reg_sex option:selected").val();
    user.job = $("#reg_job").val();
    user.area = $("#reg_area option:selected").text();
    user.mail = $("#reg_mail").val();
    user.password = $("#reg_pwd1").val();

    if ($("#reg_pwd1").val() != $("#reg_pwd2").val())
        alert("Пароли не совпадают");
    else if (validateMail()) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "registrate",
            type: 'POST',
            data: (
                JSON.stringify(user)
            )
        })
            .done(function (data) {
                $(".envelope").hide();
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                alert("Ошибка: " + errorThrown);
            });
    }
}

function autorizeUser() {
    user.mail = $("#ent_mail").val();
    user.password = $("#ent_pwd").val();

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "autenticate",
        type: 'POST',
        data: (
            JSON.stringify(user)
        )
    })
        .done(function (data) {
            document.cookie = "token=" + data.token;
            document.cookie = "mail=" + data.mail;
            document.location.href = "/coffee-bot/";
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            alert("Ошибка: " + errorThrown);
        });

}
function validateMail() {
    if (!$("#reg_mail").val().endsWith("@open.ru") || $("#reg_mail").val().replace("@open.ru").length == 0) {
        alert("Неверно введена почта");
        return false;
    }
    return true;
}