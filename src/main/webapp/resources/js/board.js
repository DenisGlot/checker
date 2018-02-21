$(document).ready(function(){

    var isSubmitting = false;
    var fromPoint;
    var toPoint;
    $('.square_black').on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        var post_url = $this.attr('action');
        if($this.hasClass(getClassSide())){
            fromPoint = $this.attr('id');
            // alert("from " + fromPoint);
            $this.css('background-color', "red");
            toPoint = -1;
            return;
        }
        if(toPoint == -1){
        toPoint = $this.attr('id');
        // alert("to " + toPoint);
        if(isSubmitting){
            return;
        }
        isSubmitting =true;
        var post_data = {
            from : fromPoint,
            to : toPoint
        };
        $.ajax({
            url: post_url,
            contentType: "application/json",
            data: JSON.stringify(post_data),
            type: 'POST',
            success: function(data) {
                // alert("given data = " + data);
                if(data == true){
                    $("#"+fromPoint).css('background-color', "#7C6249");
                    $("#"+fromPoint).removeClass("blackRegular whiteRegular");
                    $("#"+toPoint).addClass(getClassSide());
                }
                isSubmitting=false;
                fromPoint = null;
                toPoint = null;
            },
            error: function(msg) {
                alert("Error");
                isSubmitting=false;
                fromPoint = null;
                toPoint = null;
            }
        });
    }

    });
});

function getClassSide() {
    return $("#side").text() == "WHITE"  ? "whiteRegular": $("#side").text() == "BLACK"?"blackRegular":"noclass";
}
