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

    <input type="date" id="keywordName">
    <button id="search">검색</button>
    <div id="table"></div>

    <a href="/watertank">
        <button type="button" >
            목록
        </button>
    </a>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        drawStatusTable();
        $("#search").click(function (){
            $("#table").html("");
            drawStatusTable();
        });
    });

    function drawStatusTable() {
        $.ajax({
            url:'/status',
            data:{
                'watertankId' : "${result.id}",
                'measureTime' : $("#keywordName").val()
            },
            type:'GET',
            dataType:'json',
            headers: { "Content-Type" : "application/json;charset=UTF-8" },
            success:function (result) {
                console.log(result)
                var script = "";
                script += '<table id="table" border="1">';
                script += '<thead>';
                script += '<tr>';
                script += '    <th>no</th>';
                script += '    <th>수온</th>';
                script += '    <th>산도</th>';
                script += '    <th>용존산소량</th>';
                script += '    <th>측정시간</th>';
                script += '</tr>';
                script += '</thead>';
                script += '<tbody>';

                for (var i = 0; i < result.length; i++) {
                    script += '<tr>'
                    script += '    <td>' + result[i].no + '</td>';
                    script += '    <td>' + result[i].temperature + '</td>';
                    script += '    <td>' + result[i].ph + '</td>';
                    script += '    <td>' + result[i].oxygen + '</td>';
                    script += '    <td>' + result[i].measureTime + '</td>';
                    script += '</tr>';
                }
                script += '</tbody>';
                script += '</table>';
                $("#table").html(script);
            }
        });
    }
</script>
</html>
