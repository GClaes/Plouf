<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/s-product-catalog.css'/>">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/s-product-catalog-1.css'/>">
    <link rel="stylesheet" href="<spring:url value='/css/assets/css/s-product-catalog-2.css'/>">
</head>
<body style="background-image: url('http://www.wallfizz.com/nature/montagne/2647-montagne-WallFizz.jpg');">
<div class="container">
    <div class="row">
    <c:forEach items="${produits}" var="product">
        <div class="col-md-4"><div class="border">
            <div class="wrap">
                <div class="product-wrap">
                    <a href=""><img src="${product.getUrlImg()}"></a>
                </div>
                <div class="loop-action">
                    <c:url var="addToBasket" value="/catalogue/addToBasket">
                        <c:param name="productId" value="${product.getNumProduit()}" />
                    </c:url>
                    <a href="${addToBasket}" class="loop-add-to-cart"><spring:message code="ajouterPanier"/></a>
                </div>
            </div>
            <div class="product-info">
                <h3 class="product-title">${product.getNom()}</h3>
                <div class="price">${product.getPrixcatalogue()} Eur/L</div>
                <div class="product-desc">${product.getDescription()}</div>
            </div>
        </div>
    </div>
    </c:forEach>
    </div>
</div>

<script src="<spring:url value='/css/assets/js/jquery.min.js'/>"></script>
<script src="<spring:url value='/css/assets/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<spring:url value='/css/assets/js/bs-init.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.8.2/js/lightbox.min.js"></script>

</body>
</html>
