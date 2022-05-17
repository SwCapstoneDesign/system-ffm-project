<%--
  Created by IntelliJ IDEA.
  User: 2020A00160
  Date: 2022-05-18
  Time: 오전 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <form action="/login" method="post" >
      아이디 : <input type="text" name="id">
      비밀번호 : <input type="password" name="password">
      <input type="submit" value="로그인하기">
    </form>
</body>
</html>
