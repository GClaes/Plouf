<%@ include file="include/importTags.jsp"%>
<html>
<head>
        <link rel="stylesheet" href="<spring:url value='/css/assets/bootstrap/css/bootstrap.min.css'/>">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abril+Fatface">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aclonica">
        <link rel="stylesheet" href="<spring:url value='/css/assets/fonts/ionicons.min.css'/>">
        <link rel="stylesheet" href="<spring:url value='/css/assets/css/Features-Clean.css'/>">
        <link rel="stylesheet" href="<spring:url value='/css/assets/css/Footer-Basic.css'/>">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.8.2/css/lightbox.min.css">
        <link rel="stylesheet" href="<spring:url value='/css/assets/css/Lightbox-Gallery.css'/>">
        <link rel="stylesheet" href="<spring:url value='/css/assets/css/Navigation-Clean.css'/>">
        <link rel="stylesheet" href="<spring:url value='/css/assets/css/Navigation-with-Button.css'/>">
        <link rel="stylesheet" href="<spring:url value='/css/assets/css/styles.css'/>"></head>
<body>
<div data-bs-parallax-bg="true" style="height: 500px;background-image: url('css/images/fondMenu.jpg');background-position: center;background-size: cover;font-family: Aclonica, sans-serif;">
        <p class="text-center" style="font-family: 'Abril Fatface', cursive;font-size: 36px;"><spring:message code="sourcePure"/></p>
</div>
<div class="photo-gallery">
        <div class="container">
                <div class="intro">
                        <h2 class="text-center" style="font-family: 'Abril Fatface', cursive;"><spring:message code="preferee"/></h2>
                </div>
                <div class="row photos">
                        <div class="col-sm-6 col-md-4 col-lg-3 item"><a data-lightbox="photos"><img class="img-fluid" data-bs-hover-animate="bounce" src="https://www.everykid.com/boutique/976-large_default/bouteille-d-eau-mont-blanc-1l-6x100-cl.jpg"></a></div>
                        <div class="col-sm-6 col-md-4 col-lg-3 item"><a data-lightbox="photos"><img class="img-fluid" data-bs-hover-animate="bounce" src="https://www.welcomeoffice.com/WO_Products_Images/xlarge/569808.jpg"></a></div>
                        <div class="col-sm-6 col-md-4 col-lg-3 item"><a data-lightbox="photos"><img class="img-fluid" data-bs-hover-animate="bounce" src="https://www.jpg.fr/content/images/product/79166-00J_1_xnl.jpg"></a></div>
                        <div class="col-sm-6 col-md-4 col-lg-3 item"><a data-lightbox="photos"><img class="img-fluid" data-bs-hover-animate="bounce" src="https://www.jpg.fr/content/images/product/01816-00J_1_xnl.jpg"></a></div>
                        <div class="col">
                                <p class="text-center" style="font-family: 'Abril Fatface', cursive;color: rgb(0,0,0);font-size: 27px;"><spring:message code="autreADec"/></p>
                        </div>
                </div>
        </div>
</div>
<script src="<spring:url value='/css/assets/js/jquery.min.js'/>"></script>
<script src="<spring:url value='/css/assets/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<spring:url value='/css/assets/js/bs-init.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.8.2/js/lightbox.min.js"></script>
</body>
</html>