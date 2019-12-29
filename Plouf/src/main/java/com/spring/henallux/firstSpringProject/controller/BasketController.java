package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandLineDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandeDataAccess;
import com.spring.henallux.firstSpringProject.model.Basket;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import com.spring.henallux.firstSpringProject.model.Commande;
import com.spring.henallux.firstSpringProject.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.spring.henallux.firstSpringProject.utilities.Constants.CURRENT_BASKET;

@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({CURRENT_BASKET})
public class BasketController {


    private final BasketService basketService;
    private final CommandeDataAccess commandeDataAccess;

    @ModelAttribute(CURRENT_BASKET)
    public Basket basket(){
        return new Basket();
    }

    @Autowired
    public BasketController(BasketService basketService, CommandeDataAccess commandeDataAccess) {
        this.basketService = basketService;
        this.commandeDataAccess = commandeDataAccess;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model, @ModelAttribute(value = CURRENT_BASKET)Basket basket) {
        model.addAttribute("basket",basket);
        return "integrated:basket";
    }

    @GetMapping("/rmFromBasket")
    public String rmFromBasket(@RequestParam("productId")int id, @ModelAttribute(value = CURRENT_BASKET) Basket basket){
        for (CommandLine c : basket.getLines()) {
            if (c.getProduit().getNumProduit() == id) {
                basket.removeProduct(c);
                return "redirect:/panier";
            }
        }
        return "integrated:error";
    }
    @GetMapping("/rmQuantite")
    public String rmQuantite(@RequestParam("productId")int id, @ModelAttribute(value = CURRENT_BASKET) Basket basket) {
        for (CommandLine c : basket.getLines()) {
            if (c.getProduit().getNumProduit() == id) {
                basketService.rmQuantite(c, basket);
                return "redirect:/panier";
            }
        }
        return "integrated:error";
    }

    @GetMapping("/addQuantite")
    public String addQuantite(@RequestParam("productId")int id, @ModelAttribute(value = CURRENT_BASKET) Basket basket) {
        for (CommandLine c : basket.getLines()) {
            if (c.getProduit().getNumProduit() == id) {
                basket.addQuantite(c);
                return "redirect:/panier";
            }
        }
        return "integrated:error";
    }

    @GetMapping("/commander")
    public String commander(@ModelAttribute(value = CURRENT_BASKET) Basket basket){
        if(basket.getLines().isEmpty()){
            //lancer exception / JSP
        }
        basketService.enregistrerLaCommande(basket);

        return "redirect:/welcome";
    }
}
