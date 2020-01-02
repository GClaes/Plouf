<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

    <h1>CHOISSISEZ UN MOYEN DE PAIEMENT</h1>

    <h2>PAYPAL</h2>
    <form
        id="inscription"
        action="https://www.sandbox.paypal.com/cgi-bin/webscr"
        class="border rounded-0 border-primary" method="post">

        <input type="hidden" name="business" value="sb-9fxij821401@business.example.com"/>
        <input type="hidden" name="password" value="ECp5jqdBlFp2sokehXo9j7atx8JROBz6e4QcXm01JmYhbOfJug7lMirMg2aWPzqOk_-3A5rYp-JB6pN8"/>
        <input type="hidden" name="cert_id" value="AclagtV_948hDO5uOgJ-7n1hshjwo6ZVEHMLc2waEEEwgM1BxvRGWlAjrqs0stxBAjhc2FHrFn-yuxqT"/>
        <input type="hidden" name="cmd" value="_xclick"/>

        <input type="hidden" name="item_name" value="MA COMMANDE"/>
        <input type="hidden" name="amount" value="${prix}"/>
        <input type="hidden" name="currency_code" value="EUR">

        <input TYPE="hidden" name="return" value="http://localhost:8082/plouf/panier/succesCommand"/>
        <input TYPE="hidden" name="cancel_return" value="http://localhost:8082/plouf/panier//failedCommand"/>

        <input type="image" name="submit"
                    src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                    alt="PayPal - The safer, easier way to pay online"/>


    </form>

</body>
</html>
