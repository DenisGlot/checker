<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/board.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/chatbox.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/desc.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bg.css"/>">
    <style>
        .square_button{
            width: 100%;
            height: 100%;
            background-color: Transparent;
            border: none;
        }
    </style>
</head>
<body>
<div class ="imageOnBackground">
    <div id="descContainer">
        <table id="descTable" cellpadding="0" cellspacing="0" style="width: 444px; height: 444px; background-color: rgb(231, 207, 169); border-color: rgb(124, 98, 73);">
            <tbody><tr>
                <td>&nbsp;</td>

                <td></td>

                <td></td>

                <td></td>

                <td></td>

                <td></td>

                <td></td>

                <td></td>

                <td></td>

                <td></td>

            </tr>
            <tr>
                <td>8</td>
                <td id="canvasTd" colspan="8" rowspan="8">
                    <div id="canvasDiv">
                        <%
                            for(int i=8; i>0 ; i--) {
                                for (int j = 1; j < 5; j++) {
                                    if((i%2) == 0){
                                        out.println("                <div class = \"square_white" + (j==0?" new_line":"") + "\"></div>\n" +
                                                "                <div id = \"" + i +"" + j*2 + "\" class = \"square_black "+ (i>=6?"blackRegular":"") + (i<=3?"whiteRegular":"") + "\"><button class=\"square_button\"></button></div>");
                                    } else {
                                        out.println("                <div id = \"" + i + (j*2-1) +"\"  class = \"square_black " + (i>=6?"blackRegular":"") + (i<=3?"whiteRegular":"") + "" + (j==0?" new_line":"") + "\"><button class=\"square_button\"></button></div>\n" +
                                                "                <div class = \"square_white\"></div>");
                                    }
                                }
                            }
                        %>
                    </div>
                </td>
                <td></td>
            </tr>


            <tr>
                <td>7</td>
                <td></td>
            </tr>

            <tr>
                <td>6</td>
                <td></td>
            </tr>

            <tr>
                <td>5</td>
                <td></td>
            </tr>

            <tr>
                <td>4</td>
                <td></td>
            </tr>

            <tr>
                <td>3</td>
                <td></td>
            </tr>

            <tr>
                <td>2</td>
                <td></td>
            </tr>

            <tr>
                <td>1</td>
                <td></td>
            </tr>

            <tr>
                <td>&nbsp;</td>

                <td>a</td>

                <td>b</td>

                <td>c</td>

                <td>d</td>

                <td>e</td>

                <td>f</td>

                <td>g</td>

                <td>h</td>

                <td></td>

            </tr>
            </tbody>
        </table>
    </div>
</div>

<div id = "side">${side.toString()}</div>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/chatbox.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>">
    <div class="main-section open-more">
        <div class="row border-chat">
            <div class="col-md-12 col-sm-12 col-xs-12 first-section">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-xs-6 right-first-section">
                        <a href="#"><i class="fa fa-minus" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-clone" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-times" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row border-chat">
            <div class="col-md-12 col-sm-12 col-xs-12 second-section">
                <div class="chat-section">
                    <c:forEach items="${list}" var="message">
                        ${message}
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="row border-chat">
            <div class="col-md-12 col-sm-12 col-xs-12 third-section">
                <div class="text-bar">
                    <input id="friend_message" style="margin-left: 1%;" type="text" placeholder="Write messege"><button id = "send" style="width: 9%;"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                </div>
            </div>
        </div>
    </div>

    <script>
        setInterval(function() {
            $.ajax({
                url: "/",
                type: 'GET',
                success: function(html) {
                    $(".chat-section").html(jQuery(html).find('.chat-section').html());
                },
                error: function(msg) {
                    alert("Error");
                }
            });
        }, 5000)
    </script>
</body>
</html>
