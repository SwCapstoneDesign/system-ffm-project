<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>양식어 정보 목록 조회</title>
</head>
<body>
    <div>
        <input type="text" id = "searchFarmedFishByName" name="searchFarmedFishByName" placeholder="양식어명">
        <input type="button" value="검색" id="search">
        <a href="/member/form"><input type="button" id="button_add" name="button_add" value="등록"></a>
    </div>
    <form action="/farmedfish" method="get">
        <input type="hidden" name="_method" value="delete">
        <table border="1" id="farmedfishTable" class="table table-bordered table-hover text-center">
            <thead>
            <tr>
                <th>NO</th>
                <th>양식어 명</th>
                <th>수온</th>
                <th>산도</th>
                <th>용존 산소량</th>
            </tr>
            </thead>
            <tbody id="fishRow">
            </tbody>
        </table>
    </form>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" >
        $(document).ready(function (){
            searchFishByName();
            $("#search").click(function (){
                $("#fishRow").html("");
                searchFishByName();
            });
        });

        function searchFishByName() {
            var fish = {
                name : document.getElementById("searchFarmedFishByName").value
            }
            var script = "";
            $.ajax({
                url: '/farmedfish',
                data: {
                    'name': $("#searchFarmedFishByName").val()
                },
                type: 'GET',
                dataType: 'json',
                headers: {"Content-Type": "application/json;charset=UTF-8"},
                success: function (row) {
                    console.log(row)

                    for (var i = 0; i < row.length; i++) {
                        script += "<tr style=\"cursor:pointer; color:blue;\" onclick=\"location.href='/farmedfish/"+ row[i].no +"'\">";
                        script += "    <td>" + (i+1) + "</td>";
                        script += "    <td>" + row[i].name +"</td>";
                        script += "    <td>" + row[i].temperature + "</td>";
                        script += "    <td>" + row[i].ph + "</td>";
                        script += "    <td>" + row[i].oxygen + "</td>";
                        script += "</tr>";
                    }
                    $("#fishRow").html(script);
                }
            });
        }
    </script>
</body>
</html>