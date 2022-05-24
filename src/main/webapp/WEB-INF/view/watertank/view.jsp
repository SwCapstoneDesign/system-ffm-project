<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                    <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">수조 ID</label>
                                    <p style="font-size: 1.5em">${result.id}</p>
                                    <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">양식어 명</label>
                                    <p style="font-size: 1.5em">${result.farmedFishName}</p>
                                    <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">에이전트 IP 주소</label>
                                    <p style="font-size: 1.5em">${result.agentIpAddress}</p>
                                    <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">등록 일자</label>
                                    <p style="font-size: 1.5em">${result.registDate}</p>
                                    <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">활성</label>
                                    <c:choose>
                                        <c:when test="${result.active == 'Y'}">
                                            <h3 class="p-2" style="margin: auto" data-toggle="tooltip" data-placement="right" title="상태 변경 : 비활성 버튼">
                                            <button type="button" class="card ts-item ts-card ts-result border text-primary" style="font-size: 1.5em" data-toggle="modal" data-target="#activeCenter">${result.active}</button>
                                        </c:when>
                                        <c:otherwise>
                                            <h3 class="p-2" style="margin: auto" data-toggle="tooltip" data-placement="right" title="상태 변경 : 활성 버튼">
                                            <button type="button" class="card ts-item ts-card ts-result border text-danger" style="font-size: 1.5em" data-toggle="modal" data-target="#activeCenter">${result.active}</button>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="modal fade" id="activeCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="activeLongTitle">활성화 변경</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <form action="/watertank" method="post">
                                                <input type="hidden" name="_method" value="put">
                                                <input type="hidden" name="id" value="${result.id}">
                                                <div class="modal-body">
                                                    <c:choose>
                                                        <c:when test="${result.active == 'Y'}">
                                                            <h3 class="form-check">비활성 상태로 변경하시겠습니까?</h3>
                                                        </c:when>
                                                    </c:choose>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                                                    <button type="submit" class="btn btn-primary">확인</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</div>
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
