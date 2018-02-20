<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/board.js"/>"></script>
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
</body>
</html>
