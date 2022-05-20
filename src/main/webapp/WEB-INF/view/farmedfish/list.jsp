<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="ThemeStarz">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/css/fontawesome-all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery.scrollbar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">

<html>
<head>
    <title>양식어 정보 목록 조회</title>
</head>
<body>
    <div>
        <input type="text" id = "searchFarmedFishByName" name="searchFarmedFishByName" placeholder="양식어명">
        <input type="button" value="검색" id="search">
    </div>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalCenter"> 등록 </button>
    <div class="modal fade" id="modalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="ModalLongTitle">양식어 등록</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table>
                        <tr>
                            <td>양식어 명</td>
                            <td><input type="text" name="name" id="name"></td>
                        </tr>
                        <tr>
                            <td>수온</td>
                            <td><input type="text" name="temperature" id="temperature"></td>
                        </tr>
                        <tr>
                            <td>산도</td>
                            <td><input type="text" name="ph" id="ph"></td>
                        </tr>
                        <tr>
                            <td>용존 산소량</td>
                            <td><input type="text" name="oxygen" id="oxygen"></td>
                        </tr>
                        <tr>
                            <td>급이 량</td>
                            <td><input type="text" name="feedingAmount" id="feedingAmount"></td>
                        </tr>
                        <tr>
                            <td>급이 시간 1</td>
                            <td>
                                <select name="feedingTime" id="feedingTime1">
                                    <c:forEach varStatus="status" begin="0" end="23">
                                        <c:if test="${status.index < 10}">
                                            <option value="0${status.index}00">0${status.index}:00</option>
                                        </c:if>
                                        <c:if test="${status.index >= 10}">
                                            <option value="${status.index}00">${status.index}:00</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>급이 시간 2</td>
                            <td>
                                <select name="feedingTime" id="feedingTime2">
                                    <c:forEach varStatus="status" begin="0" end="23">
                                        <c:if test="${status.index < 10}">
                                            <option value="0${status.index}00">0${status.index}:00</option>
                                        </c:if>
                                        <c:if test="${status.index >= 10}">
                                            <option value="${status.index}00">${status.index}:00</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>급이 시간 3</td>
                            <td>
                                <select name="feedingTime" id="feedingTime3">
                                    <c:forEach varStatus="status" begin="0" end="23">
                                        <c:if test="${status.index < 10}">
                                            <option value="0${status.index}00">0${status.index}:00</option>
                                        </c:if>
                                        <c:if test="${status.index >= 10}">
                                            <option value="${status.index}00">${status.index}:00</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>급이 시간 4</td>
                            <td>
                                <select name="feedingTime" id="feedingTime4">
                                    <c:forEach varStatus="status" begin="0" end="23">
                                        <c:if test="${status.index < 10}">
                                            <option value="0${status.index}00">0${status.index}:00</option>
                                        </c:if>
                                        <c:if test="${status.index >= 10}">
                                            <option value="${status.index}00">${status.index}:00</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    <button type="button" id="registFarmedFish" class="btn btn-primary">등록</button>
                </div>
            </div>
        </div>
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

            $("#search").click(function () {
                $("#fishRow").html("");
                searchFishByName();
            });

            $("#registFarmedFish").click(function () {
                registFarmedFish();
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

        function registFarmedFish() {
            var feedingTimes = "";
            feedingTimes
                = document.getElementById("feedingTime1").value + "/"
                + document.getElementById("feedingTime2").value + "/"
                + document.getElementById("feedingTime3").value + "/"
                + document.getElementById("feedingTime4").value;

            var fish = {
                name : document.getElementById("name").value
                , temperature : document.getElementById("temperature").value
                , ph : document.getElementById("ph").value
                , oxygen : document.getElementById("oxygen").value
                , feedingAmount : document.getElementById("feedingAmount").value
                , feedingTime : feedingTimes
            }

            var script = "";
            $.ajax({
                url: '/farmedfish',
                data: JSON.stringify(fish),
                type: 'POST',
                dataType: 'json',
                headers: {"Content-Type": "application/json;charset=UTF-8"},
                success: function (row) {
                    console.log(hello)
                }
            });
        }
    </script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/dragscroll.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.scrollbar.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
</body>
</html>