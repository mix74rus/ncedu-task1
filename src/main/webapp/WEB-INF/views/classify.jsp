<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Classify number</title>
    <style>
        fieldset {
             background: lightyellow;
             border:10px solid yellow;
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
            <legend style="font-size: 20px">Number Classifier</legend>
            <h4>Hello!</h4>
            <form action="${pageContext.request.contextPath}/ClassifyNumber/">
                <label for="name">Put your number: </label>
                <input name="number" id="name" type=text autofocus required>
            </form>
            <c:set var="isFromCache" value="${isFromCache}"/>
            <h4>Your number was: <c:out value="${number}"/></h4>
            <h4>Some info about your number:</h4>
            <ul>
                <c:forEach var="entry" items="${classification}">
                    <li><b><c:out value="${entry.key}"/></b>: <c:out value="${entry.value}"/></li>
                </c:forEach>
            </ul>
            <c:if test="${isFromCache}">
                <small>This result is from DB cache</small>
            </c:if>
        </fieldset>
    </div>
</body>
</html>