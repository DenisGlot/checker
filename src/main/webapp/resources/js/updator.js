$(document).ready(function(){
    setInterval(function () {
        if($('#updateChat').val() == true){
            $.ajax({
                url: "/",
                type: 'GET',
                success: function(html) {
                    $(".chat-section").html(jQuery(html).find('.chat-section').html());
                    $('#updateChat').val("false");
                },
                error: function(msg) {
                    alert("Error");
                    $('#updateChat').val("false");
                }
            });
        }
        if($('#updateBoard').val() == true){
            $.ajax({
                url: "/",
                type: 'GET',
                success: function(html) {
                    $("#canvasDiv").html(jQuery(html).find('#canvasDiv').html());
                    $('#updateBoard').val("false");
                },
                error: function(msg) {
                    alert("Error");
                    $('#updateBoard').val("false");
                }
            });
        }
    },1000);
});