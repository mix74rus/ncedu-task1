<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <style>
        fieldset {
            background: lawngreen;
            border:10px solid green;
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
            <h4>Put you number to form above to find out some new information</h4>
        </fieldset>
    </div>
</body>
</html>
