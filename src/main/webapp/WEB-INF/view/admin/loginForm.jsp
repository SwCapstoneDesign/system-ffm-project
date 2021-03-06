<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/view/include/head.jsp" %>

    <title>실내 양식장 관리 시스템 - 로그인</title>
</head>
<body style="font-family: 'Noto Sans KR', sans-serif;">
<div class="ts-page-wrapper ts-has-bokeh-bg" id="page-top">
    <header id="ts-header" class="fixed-top">
        <nav id="ts-primary-navigation" class="navbar navbar-expand-md navbar-light">
            <div class="container">
                <p style="font-size: 2.5em; font-weight : 700; color: #005cbf" >실내 양식장 관리 시스템</p>
            </div>
        </nav>
    </header>
    <main id="ts-main">
        <section id="breadcrumb" />
        <section id="login-register">
            <br><br>
            <div class="container">
                <div class="row col-md-9" style="margin: auto">
                    <div class="offset-md-2 col-md-8 offset-lg-3 col-lg-6">
                        <ul class="nav nav-tabs" id="login-register-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="login-tab" data-toggle="tab" role="tab">
                                    <h3 style="font-weight : 500">관리자 인증</h3>
                                </a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" style="font-weight : 100" id="login" role="tabpanel" aria-labelledby="login-tab">
                                <form action="/login" method="post" class="ts-form" id="form-login">
                                    <div class="form-group">
                                        <input type="text"  class="form-control" id="login-email" name="id" placeholder="아이디" required="" />
                                    </div>
                                    <div class="input-group ts-has-password-toggle">
                                        <input type="password" class="form-control border-right-0" name="password" placeholder="비밀번호" required="" />
                                        <div class="input-group-append">
                                            <a href="#" class="input-group-text bg-white border-left-0 ts-password-toggle">
                                                <i class="fa fa-eye"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <div class="mr-auto p-0 custom-control custom-checkbox mb-0">
                                            <c:if test="${adminMatch eq false}">
                                                <p style="font-size: 1em" class="text-danger">아이디 또는 비밀번호가 일치 하지 않습니다.</p>
                                            </c:if>
                                        </div>
                                        <button style="font-weight : 100" type="submit" class="p-2 btn btn-primary">로그인</button>
                                    </div>
                                    <hr>
                                </form>
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
