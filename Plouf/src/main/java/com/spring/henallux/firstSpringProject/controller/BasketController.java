package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandDataAccess;
import com.spring.henallux.firstSpringProject.model.Basket;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import static com.spring.henallux.firstSpringProject.utilities.Constants.CURRENT_BASKET;

@Controller
@RequestMapping(value = "/panier")
@SessionAttributes({CURRENT_BASKET})
public class BasketController {


    private final BasketService basketService;

    @ModelAttribute(CURRENT_BASKET)
    public Basket basket(){
        return new Basket();
    }

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model, @ModelAttribute(value = CURRENT_BASKET)Basket basket) {
        model.addAttribute("basket",basket);
        return "integrated:basket";
    }

    @GetMapping("/rmFromBasket")
    public String rmFromBasket(@RequestParam("productId")int id, @ModelAttribute(value = CURRENT_BASKET) Basket basket){
        Product product = new Product();
        product.setNumProduit(id);
        basket.removeProduct(product);
        return "redirect:/panier";
    }
    @GetMapping("/rmQuantite")
    public String rmQuantite(@RequestParam("productId")int id, @ModelAttribute(value = CURRENT_BASKET) Basket basket) {
        Product product = new Product();
        product.setNumProduit(id);
        basket.rmQuantite(product);
        return "redirect:/panier";
    }

    @GetMapping("/addQuantite")
    public String addQuantite(@RequestParam("productId")int id, @ModelAttribute(value = CURRENT_BASKET) Basket basket) {
        Product product = new Product();
        product.setNumProduit(id);
        basket.addQuantite(product);
        return "redirect:/panier";
    }

    @GetMapping("/commander")
    public String commander(ModelMap model, @ModelAttribute(value = CURRENT_BASKET) Basket basket){
        if(!basket.getLines().isEmpty()){
            model.addAttribute("prix",basket.getTotalPrice());
            return "integrated:payment";
        }
        return "integrated:basket";
    }


    @GetMapping("/succesCommand")
    public String succesCommand(@ModelAttribute(value = CURRENT_BASKET) Basket basket){
        basketService.enregistrerLaCommande(basket);
        return "integrated:command_succes";
    }

    @GetMapping("/failedCommand")
    public String failedCommand(@ModelAttribute(value = CURRENT_BASKET) Basket basket){
        return "integrated:command_failure";
    }
}
