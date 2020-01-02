<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<spring:url value='/css/panier.css'/>">
</head>
<body>
<div class="shopping-cart">
    <div class="title">
        <spring:message code="panier"/>
    </div>
    <c:forEach items="${basket.getLines()}" var="item">
        <div class="item">
            <div class="image">
                <img class="imgpanier" src="${item.produit.urlImg}" alt="" />
            </div>

            <div class="description">
                <span>${item.produit.nom}</span>
            </div>

            <div class="quantity">
                <c:url var="rmQuantite" value="/panier/rmQuantite">
                    <c:param name="productId" value="${item.produit.numProduit}" />
                </c:url>
                <a  href="${rmQuantite}" type="button" name="button">
                    <img class="boutonImg" src="https://static.thenounproject.com/png/261368-200.png" alt="" />
                </a>
                <input type="text" name="name" value="${item.quantite} L">
                <c:url var="addQuantite" value="/panier/addQuantite">
                    <c:param name="productId" value="${item.produit.numProduit}" />
                </c:url>
                <a href="${addQuantite}" type="button" name="button">
                    <img class="boutonImg" src="https://static.thenounproject.com/png/645442-200.png" alt="" />
                </a>
            </div>
            <div class="total-price"><fmt:formatNumber type="number" pattern="0.00" value ="${item.prix*1+item.produit.tvaappliquee}"/> €</div>
            <div class="total-price"> Total - <fmt:formatNumber type="number" pattern="0.00" value ="${(item.prix*1+item.produit.tvaappliquee)*item.quantite}"/> €</div>
            <c:url var="rmFromBasket" value="/panier/rmFromBasket">
                <c:param name="productId" value="${item.produit.numProduit}" />
            </c:url>
            <a class="total-price" href="${rmFromBasket}"><spring:message code="suppriPanier"/></a>
        </div>
    </c:forEach>
    <div class="command-price"><spring:message code="prixTotal"/> - <fmt:formatNumber type="number" pattern="0.00" value ="${basket.getTotalPrice()}"/> €</div>
    <c:url var="commander" value="/panier/commander">
    </c:url>
    <a href="${commander}" type="button" name="button">
        <button class="btn-cmd"><spring:message code="commander"/></button>
    </a>
</div>
</body>
</html>
