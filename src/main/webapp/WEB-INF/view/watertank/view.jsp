<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/view/include/head.jsp" %>

    <title>수조 상세 정보</title>
</head>
<body style="font-family: 'Noto Sans KR', sans-serif;">
<div class="ts-page-wrapper ts-has-bokeh-bg" id="page-top">
    <%@ include file="/WEB-INF/view/include/header.jsp" %>
    <main id="ts-main">
        <section id="page-title" style="height: 40px">
            <div class="container">
                <div class="ts-title mb-0">
                    <div class="row">
                        <div class="ts-title mb-1 col-sm-11">
                            <h1>수조 상세 정보</h1>
                        </div>
                        <div class="ts-title mb-1 col-sm-1">
                            <a href="${pageContext.servletContext.contextPath}/watertank">
                                <button type="button" class="btn btn-primary w-100">
                                    목록
                                </button>
                            </a>
<%--                            <input class="btn btn-primary w-100" type="button" value="목록" id="search">--%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="items-grid">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-lg-6 align-items-stretch">
                        <div class="card h-auto">
                            <div class="card-body ts-item__body">
                                <div class="ts-description-lists">
                                    <h3>수조 ID</h3>
                                    <h4>${result.id}</h4>
                                    <h3>양식어 명</h3>
                                    <h4>${result.farmedFishName}</h4>
                                    <h3>에이전트 IP 주소</h3>
                                    <h4>${result.agentIpAddress}</h4>
                                    <h3>등록 일자</h3>
                                    <h4>${result.registDate}</h4>
                                    <h3>활성</h3>
                                    <h4>${result.active}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</div>
<%--    <div class="ts-title">--%>
<%--        <h1>수조 상세 정보</h1>--%>
<%--    </div>--%>

<%--    <input type="date" id="keywordName">--%>
<%--    <button id="search">검색</button>--%>
<%--    <div id="table"></div>--%>

<%--    <a href="/watertank">--%>
<%--        <button type="button" >--%>
<%--            목록--%>
<%--        </button>--%>
<%--    </a>--%>
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
<%@ include file="/WEB-INF/view/include/bottom.jsp" %>
</html>
