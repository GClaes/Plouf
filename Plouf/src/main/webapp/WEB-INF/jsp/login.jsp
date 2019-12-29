<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/Login-Form-Clean.css'/>">
</head>
<body>
<div class="login-clean" style="background-image: url(&quot;http://www.pechefaucigny-montblanc.com/wp-content/uploads/2014/12/Lac_183055298.jpg&quot;);">
    <form:form modelAttribute="user" method="post">
        <h2 class="sr-only"><spring:message code="connecterForm"/></h2>
        <div class="illustration"><i class="icon ion-waterdrop" style="color: rgb(22,65,210);"></i></div>
        <div class="form-group"><form:label path="login"><spring:message code="login"/></form:label><form:input class="form-control" type="text" path="username"/><form:errors path="login"></form:errors></div>
        <div class="form-group"><form:label path="password"><spring:message code="password"/></form:label><form:input class="form-control" type="password" path="password"/><form:errors path="password"></form:errors></div>
        <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: rgb(22,65,210);"><spring:message code="seConnecter"/></button></div>
    </form:form>
</div>
<script src="<spring:url value='/css/assets/js/jquery.min.js'/>"></script>
<script src="<spring:url value='/css/assets/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<spring:url value='/css/assets/js/bs-init.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.8.2/js/lightbox.min.js"></script>
</body>
</html>
