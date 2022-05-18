<%--
  Created by IntelliJ IDEA.
  User: 2018A00588
  Date: 2022-05-18
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <h2>수조 ID</h2>
        ${result.id}
        <h2>양식어 명</h2>
        ${result.farmedFishName}
        <h2>에이전트 IP 주소</h2>
        ${result.agentIpAddress}
        <h2>등록일자</h2>
        ${result.registDate}
        <h2>활성</h2>
        ${result.active}
    </div>
</body>
</html>
