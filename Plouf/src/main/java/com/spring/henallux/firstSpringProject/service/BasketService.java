package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandDataAccess;
import com.spring.henallux.firstSpringProject.model.Basket;
import com.spring.henallux.firstSpringProject.model.Command;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BasketService {


    private final CommandDataAccess commandDataAccess;

    public BasketService(CommandDataAccess commandDataAccess) {
        this.commandDataAccess = commandDataAccess;
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
        Command command = new Command(basket.getLines(), new Date());
        commandDataAccess.save(command);

        clean(basket);
    }
}
