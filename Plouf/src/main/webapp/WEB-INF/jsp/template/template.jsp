<%@include file="../include/importTags.jsp"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="type=text/html; charset=utf-8">
    <link rel="stylesheet" href="<spring:url value='/css/assets/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abril+Fatface">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aclonica">
    <link rel="stylesheet" href="<spring:url value='/css/assets/fonts/ionicons.min.css'/>">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/Features-Clean.css'/>">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/Footer-Basic.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.8.2/css/lightbox.min.css">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/Navigation-Clean.css'/>">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/Navigation-with-Button.css'/>">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/styles.css'/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abril+Fatface">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aclonica">


    <title>Plouf</title>
</head>
<header>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button" style="background-color: rgb(22,65,210);">
        <div class="container"><a class="navbar-brand" href="/plouf/welcome" style="color: rgb(255,255,255);">Plouf</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mr-auto">
                    <spring:url var="catalogue" value="/catalogue">
                    </spring:url>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${catalogue}" style="color: rgb(255,255,255);"><spring:message code="catalogue"/></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="/plouf/panier" style="color: rgb(255,255,255);"><spring:message code="panier"/></a></li>
                </ul><span class="navbar-text">
                <spring:url var="localeFr" value="">
                    <spring:param name="locale" value="fr"/>
                </spring:url>

                <spring:url var="localeEn" value="">
                    <spring:param name="locale" value="en"/>
                </spring:url>
                <a href="${localeFr}"> <img class="drapeau" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Flag_of_France.svg/1200px-Flag_of_France.svg.png"></a>
                <a href="${localeEn}"><img class="drapeau" src="https://images-na.ssl-images-amazon.com/images/I/41cfK9pPRpL._SX425_.jpg"></a>
                <sec:authorize access="!isAuthenticated()">
                    <a class="login" href="/plouf/connection" style="color: rgb(255,255,255); margin-right: 20px"><spring:message code="seConnecter"/></a>
                    <a class="btn btn-light action-button" role="button" href="/plouf/inscription" style="background-color: rgb(255,255,255);color: rgb(0,0,0);"><spring:message code="sgnup"/></a></span></div>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <h2><spring:message code="salut"/> <sec:authentication property="principal.username"/>!</h2>
                    <a class="login" href="/plouf/logout" style="color: rgb(255,255,255); margin-right: 20px"><spring:message code="seDeco"/> </a>
                </sec:authorize>
        </div>
    </nav>
    <script src="<spring:url value='/css/assets/js/jquery.min.js'/>"></script>
    <script src="<spring:url value='/css/assets/bootstrap/js/bootstrap.min.js'/>"></script>
    <script src="<spring:url value='/css/assets/js/bs-init.js'/>"></script>
</header>
<body>
    <tiles:insertAttribute name="main-content"/>
</body>
<footer>
    <div class="footer-basic" style="background-color: rgb(22,65,210);">
        <div class="social"><a href="#"><i class="icon ion-social-instagram" style="color: rgb(255,255,255);"></i></a><a href="#"><i class="icon ion-social-snapchat" style="color: rgb(255,255,255);"></i></a><a href="#"><i class="icon ion-social-twitter" style="color: rgb(255,255,255);"></i></a>
            <a
                    href="#"><i class="icon ion-social-facebook" style="color: rgb(255,255,255);"></i></a>
        </div>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#" style="color: rgb(255,255,255);">Home</a></li>
            <li class="list-inline-item"><a href="#" style="color: rgb(255,255,255);">Services</a></li>
            <li class="list-inline-item"><a href="#" style="color: rgb(255,255,255);">About</a></li>
            <li class="list-inline-item"><a href="#" style="color: rgb(255,255,255);">Terms</a></li>
            <li class="list-inline-item"><a href="#" style="color: rgb(255,255,255);">Privacy Policy</a></li>
        </ul>
        <p class="copyright">Company Name © 2017</p>
    </div>
</footer>
<script src="<spring:url value='/css/assets/js/jquery.min.js'/>"></script>
<script src="<spring:url value='/css/assets/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<spring:url value='/css/assets/js/bs-init.js'/>"></script>
</html>
