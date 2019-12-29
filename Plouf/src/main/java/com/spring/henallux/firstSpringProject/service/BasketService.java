package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandeDataAccess;
import com.spring.henallux.firstSpringProject.model.Basket;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import com.spring.henallux.firstSpringProject.model.Commande;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BasketService {


    private final CommandeDataAccess commandeDataAccess;

    public BasketService(CommandeDataAccess commandeDataAccess) {
        this.commandeDataAccess = commandeDataAccess;
    }

    public void addToBasket(Product product, Basket basket){
        CommandLine c = new CommandLine(1,product.getPrixcatalogue(),product);
        if(!basket.getLines().contains(c))
            basket.addProduct(product);
    }


    public void clean(Basket basket){
        basket.clean();
    }

    public void enregistrerLaCommande(Basket basket){
        Commande commande = new Commande(basket.getLines(), new Date());
        commandeDataAccess.save(commande);

        clean(basket);
    }
}
