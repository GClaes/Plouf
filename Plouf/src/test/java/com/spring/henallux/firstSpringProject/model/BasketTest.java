package com.spring.henallux.firstSpringProject.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.parameters.P;

import static org.junit.Assert.*;

public class BasketTest {

    private Basket basket;

    @Before
    public void setup() {
        basket = new Basket();
    }

    @Test
    public void addProduct() {
        Product product = new Product();
        product.setPrixcatalogue(1.24f);

        basket.addProduct(product);

        assertEquals(1,basket.getLines().size());

        CommandLine commandLine = basket.getLines().get(0);
        assertEquals(product, commandLine.getProduit());
        assertEquals(1, commandLine.getQuantite());
        assertEquals(product.getPrixcatalogue(), commandLine.getPrix(),0.0);
    }

    @Test
    public void addNullProduct(){
        try {
            basket.addProduct(null);
            fail("Une exception aurait du etre lancee");
        }catch (IllegalArgumentException e){}
    }

    @Test
    public void addProductTwice(){
        Product product = new Product();
        product.setNumProduit(1);

        basket.addProduct(product);
        basket.addProduct(product);

        assertEquals(1, basket.getLines().size());
    }

    @Test
    public void removeProduct() {
        Product product1 = new Product();
        product1.setNumProduit(1);
        Product product2 = new Product();
        product2.setNumProduit(2);
        basket.addProduct(product1);
        basket.addProduct(product2);

        basket.removeProduct(product1);

        assertEquals(1, basket.getLines().size());
        assertEquals(product2, basket.getLines().get(0).getProduit());
    }

    @Test
    public void removeNullProduct(){
        Product product = new Product();
        basket.addProduct(product);

        basket.removeProduct(null);

        assertEquals(1, basket.getLines().size());
    }

    @Test
    public void removeNonExistingProduct(){
        Product product = new Product();
        product.setNumProduit(1);
        basket.addProduct(product);

        basket.removeProduct(new Product());

        assertEquals(1, basket.getLines().size());
    }


    @Test
    public void rmQuantite() {
        Product product = new Product();
        basket.addProduct(product);
        basket.addQuantite(product);
        basket.addQuantite(product);

        basket.rmQuantite(product);

        assertEquals(2, basket.getLines().get(0).getQuantite());
    }

    @Test
    public void rmQuantiteIf1(){
        Product product = new Product();
        basket.addProduct(product);

        basket.rmQuantite(product);

        assertEquals(1, basket.getLines().get(0).getQuantite());
    }

    @Test
    public void rmQuantiteNullProduct(){
        Product product = new Product();
        basket.addProduct(product);

        basket.rmQuantite(null);

        assertEquals(1, basket.getLines().get(0).getQuantite());
    }

    @Test
    public void rmQuantiteNonExistingProduct(){
        Product product = new Product();
        product.setNumProduit(1);
        basket.addProduct(product);
        Product product2 = new Product();
        product2.setNumProduit(2);

        basket.rmQuantite(product2);

        assertEquals(1, basket.getLines().size());
        assertEquals(1, basket.getLines().get(0).getQuantite());
    }

    @Test
    public void addQuantite() {
        Product product = new Product();
        basket.addProduct(product);

        basket.addQuantite(product);
        basket.addQuantite(product);

        assertEquals(3, basket.getLines().get(0).getQuantite());
    }

    @Test
    public void addQuantiteNonExistingProduct(){
        Product product = new Product();
        product.setNumProduit(1);
        basket.addProduct(product);
        Product product2 = new Product();
        product2.setNumProduit(2);

        basket.addQuantite(product2);

        assertEquals(1, basket.getLines().size());
        assertEquals(1, basket.getLines().get(0).getQuantite());
    }
    @Test
    public void addQuantiteNullProduct(){
        Product product = new Product();
        basket.addProduct(product);

        basket.addQuantite(null);

        assertEquals(1, basket.getLines().get(0).getQuantite());
    }

    @Test
    public void clean() {
        Product product = new Product();
        basket.addProduct(product);

        basket.clean();

        assertEquals(0, basket.getLines().size());
    }

    @Test
    public void getTotalPrice(){
        Product product = new Product();
        product.setPrixcatalogue(1.00f);
        product.setTvaappliquee(0.06f);
        basket.addProduct(product);

        double price = basket.getTotalPrice();

        assertEquals(1.06, price, 0.001);
    }
}