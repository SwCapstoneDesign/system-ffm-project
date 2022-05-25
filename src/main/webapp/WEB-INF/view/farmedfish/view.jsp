<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ include file="/WEB-INF/view/include/head.jsp" %>

    <title>실내 양식장 관리 시스템 - 양식어 상세 정보</title>
</head>
<body style="font-family: 'Noto Sans KR', sans-serif;">
<div class="ts-page-wrapper ts-has-bokeh-bg" id="page-top">
    <%@ include file="/WEB-INF/view/include/header.jsp"%>
    <main id="ts-main">
        <section id="page-title" style="margin-bottom: 0px;">
            <div class="container">
                <div class="ts-title mb-0" style="padding-top: 30px;padding-bottom: 0px;">
                    <div class="row">
                        <div class="ts-title mb-0 col-sm-10">
                            <h1 style="font-weight : 400">양식어 상세 정보</h1>
                        </div>
                        <div class="ts-title mb-2 col-sm-2" style="text-align: center">
                            <a class="card btn-outline-primary btn-sm m-1 px-3" style="font-size: 1.3em" href="/farmedfish">목록</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="agent-info">
            <div class="container col-md-9">
                <div class="ts-box col-md-auto">
                    <div class="row col-md-auto">
                        <div class="col-md-12">
                            <div class="py-2 col-md-12">
                                <section id="basic-information" class="mb-0 pl-3">
                                    <div class="row">
                                        <div class="ts-title mb-2 col-sm-10">
                                            <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">양식어 명</label>
                                            <h3 style="font-size: 1.8em" class="mb-1 border-bottom">${farmedFish.name}</h3>
                                        </div>
                                        <div class="d-flex align-items-start flex-column" style="text-align: center">
                                            <label class="badge badge-light p-2" style="text-align: center; font-size: 1.3em; font-weight: 500; width: 55px">상태</label>
                                            <c:choose>
                                                <c:when test="${farmedFish.active == 'Y'}">
                                                    <c:if test="${!existence}">
                                                        <h3 class="p-2" style="margin: auto" data-toggle="tooltip" data-placement="right" title="상태 변경 : 비활성 버튼">
                                                        <button type="button" class="card ts-item ts-card ts-result border text-primary" style="font-size: 1em" data-toggle="modal" data-target="#activeCenter">비활성</button>
                                                    </c:if>
                                                    <c:if test="${existence}">
                                                        <h3 class="p-2" style="margin: auto" data-toggle="tooltip" data-placement="right" title="상태 변경 불가능 : 사용중인 양식어 정보">
                                                        <button type="button" class="card ts-item ts-card ts-result border" style="font-size: 1em" >비활성</button>
                                                    </c:if>
                                                </c:when>
                                                <c:otherwise>
                                                    <h3 class="p-2" style="margin: auto" data-toggle="tooltip" data-placement="right" title="상태 변경 : 활성 버튼">
                                                    <button type="button" class="card ts-item ts-card ts-result border text-danger" style="font-size: 1em" data-toggle="modal" data-target="#activeCenter">활성</button>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
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
                                                <form action="/farmedfish" method="post">
                                                    <input type="hidden" name="_method" value="put">
                                                    <input type="hidden" name="no" value="${farmedFish.no}">
                                                    <div class="modal-body">
                                                        <c:choose>
                                                            <c:when test="${farmedFish.active == 'Y'}">
                                                                <h3 class="form-check">비활성 상태로 변경하시겠습니까?</h3>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <h3 class="form-check">활성 상태로 변경하시겠습니까?</h3>
                                                            </c:otherwise>
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
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">일련번호</label>
                                            <p style="font-size: 1.5em">${farmedFish.no}</p>
                                        </div>
                                        <div class="col-sm-4">
                                            <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">급이 시간</label>
                                            <p style="font-size: 1.5em">${farmedFish.feedingTime}</p>
                                        </div>
                                        <div class="col-sm-4">
                                            <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">급이 량</label>
                                            <p style="font-size: 1.5em">${farmedFish.feedingAmount}g</p>
                                        </div>
                                        <div class="col-sm-4">
                                            <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">수온</label>
                                            <p style="font-size: 1.5em">${farmedFish.temperature}</p>
                                        </div>
                                        <div class="col-sm-4">
                                            <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">산도</label>
                                            <p style="font-size: 1.5em">${farmedFish.ph}</p>
                                        </div>
                                        <div class="col-sm-4">
                                            <label class="badge badge-light" style="font-size: 1.3em; font-weight: 500">용존 산소량</label>
                                            <p style="font-size: 1.5em">${farmedFish.oxygen}</p>
                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</div>
<%@ include file="/WEB-INF/view/include/bottom.jsp" %>
</body>
</html>