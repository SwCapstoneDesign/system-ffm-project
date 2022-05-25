<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <%@ include file="/WEB-INF/view/include/head.jsp" %>

    <title>양식어 정보 목록 조회</title>
</head>
<body style="font-family: 'Noto Sans KR', sans-serif;">
    <div class="ts-page-wrapper ts-has-bokeh-bg" id="page-top">
        <%@ include file="/WEB-INF/view/include/header.jsp" %>
        <main id="ts-main">
            <section id="page-title" style="height: 40px">
                <div class="container">
                    <div class="ts-title mb-0">
                        <div class="row">
                            <div class="ts-title mb-0 col-sm-4">
                                <h1 style="font-weight : 400">양식어</h1>
                            </div>
                            <div class="ts-title mb-1 col-sm-3" style="padding-right: 0px;">
                                <input class="form-control"  type="text" id = "searchFarmedFishByName" name="searchFarmedFishByName" placeholder="양식어명">
                            </div>
                            <div class="ts-title mb-2 col-sm-1" style="padding-left: 5px;">
                                <input class="btn btn-primary w-100" type="button" value="검색" id="search">
                            </div>
                            <div class="ts-title mb-3 col-sm-2"></div>
                            <div class="ts-title mb-4 col-sm-2" style="text-align: center">
                                <button type="button" class="card btn-outline-primary btn-sm m-1 px-3" data-toggle="modal" data-target="#modalCenter" style="font-size: 1.3em"> 등록 </button>
                            </div>
                            <div class="modal fade" id="modalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="ModalLongTitle">양식어 등록</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="/farmedfish" method="post">
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
                                            <button type="submit"  class="btn btn-primary">등록</button>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <div id="drawInfo" style="text-align: center"></div>
        </main>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" >

    $(document).ready(function (){
        searchFishByName(1);

        $("#search").click(function () {
            $("#drawInfo").html("");
            searchFishByName(1);
        });

        $("#registFarmedFish").click(function () {
            registFarmedFish();
        });
    });

    function searchFishByName(pageNo) {
        $.ajax({
            url: '/farmedfish',
            data: {
                'name': $("#searchFarmedFishByName").val()
                , 'pageNo' : pageNo
            },
            type: 'GET',
            dataType: 'json',
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        }).always(function (row) {
            var text = row.responseText;

            $("#drawInfo").html(text);
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
<%@ include file="/WEB-INF/view/include/bottom.jsp" %>
</html>