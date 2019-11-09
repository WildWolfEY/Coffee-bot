$(document).ready(function()
    {
        var maxX = $(".top-panel").offset().left-$(".stick").width();
        var maxY = $(".top-panel").offset().top+$(".top-panel").height();
        var x=getRandomInt(maxX);
        var y=getRandomInt(maxY);
        $(".button-settings").click(function()
            {
                $(".stopped").removeClass('stopped');
                if($(this).hasClass('select-btn'))
                    $(this).removeClass('select-btn');
                else
                    $(this).addClass('select-btn');
            }
        )
        $(".button-settings").mouseover(function()
            {
                if ($(".started").length==0)
                    $(".display").text($(this).attr('value'));
            }
        )
        $(".button-group").mouseout(function()
            {
                if ($(".started").length==0)
                    $(".display").text('Select some settings, and START');
            }
        )
        $(".button-start").click(function()
            {
                $(this).addClass('started');
                $(".display").text('Enjoy your drink...');
                $(".coffee").addClass('line');
                $(".stopped").removeClass('stopped');
                $(".stick").show();
                $(".stick-text").removeClass('cancel-text');
                $(".stick").css("left",x);
                $(".stick").css("top",y);
            }

        )
        $(".button-stop").click(function()
            {
                if($(".started").length>0)
                {
                    $(".started").removeClass('started');
                    $(".select-btn").removeClass('select-btn');
                    $(this).addClass('stopped');
                    $(".display").text('Canceled...');
                    $(".coffee").removeClass('line');
                    $(".stick-text").addClass('cancel-text');
                }
            }
        )
    }
)
function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}