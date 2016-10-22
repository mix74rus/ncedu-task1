<%--
  Created by IntelliJ IDEA.
  User: Mix74rus
  Date: 20.10.16
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
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
<body>
    <div id="global">
        <fieldset>
            <legend style="font-size: 20px">Number Classifier</legend>
            <h4>Hello!</h4>
            <form action="/ClassifyNumber/">
                Put your number: <input name="number" type=text>
            </form>
            <c:set var="acceptNumberParam" value="${acceptNumberParam}"/>
            <c:if test="${acceptNumberParam}">
                <c:set var="isNumber" value="${isNumber}"/>

                <c:if test="${isNumber}">
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
                </c:if>
                <c:if test="${!isNumber}">
                    <h4><c:out value="${number}"/> is not a number!</h4>
                </c:if>
            </c:if>
            <c:if test="${!acceptNumberParam}">
                <h4>Put you number to form above to find out some new information</h4>
            </c:if>
        </fieldset>
    </div>
</body>
</html>
