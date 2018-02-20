$(document).ready(function(){
    $(".left-first-section").click(function(){
        $('.main-section').toggleClass("open-more");
    });
});
$(document).ready(function(){
    $(".fa-minus").click(function(){
        $('.main-section').toggleClass("open-more");
    });
});
$(document).ready(function(){
    $(".fa-clone").click(function(){
        $('.main-section').toggleClass("open-more");
    });
});
$(document).ready(function(){
    var words = 25;
    $("#send").click(function(){
        var image = 1;
        var side = "left-chat";
        if( $("#side").text() == "WHITE"){
            image = 2;
            side = "right-chat";
        }
        var message = $("#friend_message").val();

        var dividedMessage = "";
        for (var i = 0; i <= message.length; i+=words) {
            dividedMessage += message.substr(i,i+words) + "\n";
        }
        var send = "<div class=\"" + side + "\">\n" +
            "                        <img src=\"/resources/images/man0" + image + ".png\">\n" +
            "                        <p>" + dividedMessage + "\n" +
            "                        </p>\n" +
            "                    </div>"




        var post_data = {
            string : send,
        };
        $.ajax({
            url: "/message",
            contentType: "application/json",
            data: JSON.stringify(post_data),
            type: 'POST',
            success: function(data) {
                if(data){
                    $(".chat-section").append(send);
                    $("#friend_message").val("");
                }
            },
            error: function(msg) {
                alert("Error");
            }
        });
    });
});
