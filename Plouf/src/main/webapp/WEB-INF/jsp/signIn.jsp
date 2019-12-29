<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/Registration-Form-with-Photo.css'/>">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/styles.css'/>">
</head>
<body>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder" style="background-image: url('http://a53.idata.over-blog.com/5/01/73/55/Eaux-et-jardins/eaux-des-montagnes/cascade-du-Nideck---Vosges0001.jpg');"></div>
        <form:form
                id="inscription"
                action="/plouf/inscription/send"
                modelAttribute="user"
                class="border rounded-0 border-primary" method="post">
            <h2 class="text-center"><spring:message code="createAccount"/></h2>
            <h2 class="text-center"><spring:message code="persoInfo"/></h2>
            <div class="form-group"><form:label path="login"><spring:message code="login"/></form:label><form:input class="form-control" type="text" path="login"/><form:errors path="login"/></div>
            <div class="form-group"><form:label path="motDePasse"><spring:message code="password"/></form:label><form:input class="form-control" type="password" path="motDePasse"/><form:errors path="motDePasse"/></div>
            <div class="form-group"><form:label path="mdpRep"><spring:message code="passwordR"/></form:label><form:input class="form-control" type="password" path="mdpRep"/><form:errors path="mdpRep"/></div>
            <div class="form-group"><form:label path="nom"><spring:message code="lastName"/></form:label><form:input class="form-control" type="text" path="nom"/><form:errors path="nom"/></div>
            <div class="form-group"><form:label path="prenom"><spring:message code="firstName"/></form:label><form:input class="form-control" type="text" path="prenom"/><form:errors path="prenom"/></div>
            <div class="form-group"><form:label path="email"><spring:message code="email"/></form:label><form:input class="form-control" type="email" path="email"/><form:errors path="email"/></div>
            <div class="form-group"><form:label path="numTel"><spring:message code="numTel"/></form:label><form:input class="form-control" type="text" path="numTel"/><form:errors path="numTel"/></div>

            <h2 class="text-center"><spring:message code="adrLiv"/></h2>
            <div class="form-group"><form:label path="rue"><spring:message code="rue"/></form:label><form:input class="form-control" type="text" path="rue"/><form:errors path="rue"/></div>
            <div class="form-group"><form:label path="localite"><spring:message code="localite"/></form:label><form:input class="form-control" type="text" path="localite"/><form:errors path="localite"/></div>
            <div class="form-group"><form:label path="codePostal"><spring:message code="postalCode"/></form:label><form:input class="form-control" type="text" path="codePostal"/><form:errors path="codePostal"/></div>
            <div class="form-group"><form:label path="numRue"><spring:message code="numRue"/></form:label><form:input class="form-control" type="text" path="numRue"/><form:errors path="numRue"/></div>

            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: rgb(22,65,210);"><spring:message code="sgnup"/></button></div><a class="already" href="/plouf/connection"><spring:message code="alrAcc"/></a>
        </form:form>
    </div>
</div>
<script src="<spring:url value='/css/assets/js/jquery.min.js'/>"></script>
<script src="<spring:url value='/css/assets/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<spring:url value='/css/assets/js/bs-init.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.8.2/js/lightbox.min.js"></script>
</body>
</html>
