<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Error</title>
    <style>
        fieldset {
            background: lightcoral;
            border:10px solid red;
            margin-bottom: 10px;
            width: 720px;
        }
        #global {
            position: absolute;
            z-index: 15;
            top: 20%;
            left: 20%;
        }
    </style>
</head>
<body style="background-color: bisque">
    <div id="global">
        <fieldset>
            <legend>Error</legend>
            <b><c:out value="${Message}"/></b>
            <br><br>
            <form action="${pageContext.request.contextPath}/ClassifyNumber/">
                <label for="name">Try again:</label>
                <input name="number" id="name" type=text autofocus required>
            </form>
        </fieldset>
    </div>
</body>
</html>
