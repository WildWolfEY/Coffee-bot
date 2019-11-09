$(document).ready(function()
    {
        $(".key").click(function()
            {
                $(".envelope").show();
            }
        )
        $(".close-btn").click(function()
            {
                $(".envelope").hide();
            }
        )
    }
)
var user
{
    
}
function registrateUser() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: url,
        type: 'POST',
        data: (
            JSON.stringify(checkedRow)
        )
    })
        .done(function (data) {
        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            alert("Ошибка: " + errorThrown);
            obj.checked = url == 'check' ? true : false;
        });
}