<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2024-09-04
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
  브라우저에서 숫자를 입력하기 위해 호출되는 경로를 get,post 방식으로 처리하는 매체
--%>
<%--<%%> -> tomcat(WAS)가 처리하는 영역--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산기예제</title>
</head>
<body>
    <form action="/calc/makeResult" method="post">
        <input type="number" name="num1"/>
        <input type="number" name="num2"/>
        <button type="submit">SEND</button>
    </form>
</body>
</html>
