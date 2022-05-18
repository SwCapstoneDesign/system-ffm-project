<%--
  Created by IntelliJ IDEA.
  User: 2018A00588
  Date: 2022-05-17
  Time: 오전 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <input type="text" id="keywordName">
    <button id="search">검색</button>
    <div id="table"></div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    var url = '/watertank';

    $(document).ready(function (){
        drawTable();
        $("#search").click(function (){
            $("#table").html("");
            drawTable();
        });
    });

    function drawTable() {
        $.ajax({
            url:'/watertank',
            data:{
                'farmedFishName' : $("#keywordName").val()
            },
            type:'GET',
            dataType:'json',
            headers: { "Content-Type" : "application/json;charset=UTF-8" },
            success:function (result) {
                console.log(this.data)
                var script = "";
                script += '<table id="table" border="1">';
                script += '<thead>';
                script += '<tr>';
                script += '    <th>수조 아이디</th>';
                script += '    <th>양식어 명</th>';
                script += '    <th>수온</th>';
                script += '    <th>산도</th>';
                script += '    <th>용존산소량</th>';
                script += '</tr>';
                script += '</thead>';
                script += '<tbody>';

                for (var i = 0; i < result.length; i++) {
                    script += '<tr>'
                    script += '    <td>' + result[i].id + '</td>';
                    script += '    <td><a href="${pageContext.servletContext.contextPath}/watertank/' + result[i].id + '">' + result[i].farmedFishName + '</a></td>';
                    script += '    <td>' + result[i].statusList[0].temperature + '</td>';
                    script += '    <td>' + result[i].statusList[0].ph + '</td>';
                    script += '    <td>' + result[i].statusList[0].oxygen + '</td>';
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
