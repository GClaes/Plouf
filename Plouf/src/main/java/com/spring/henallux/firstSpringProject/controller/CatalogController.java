package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.firstSpringProject.model.Basket;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import com.spring.henallux.firstSpringProject.model.Product;
import com.spring.henallux.firstSpringProject.service.BasketService;
import com.spring.henallux.firstSpringProject.utilities.Constants;
import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.spring.henallux.firstSpringProject.utilities.Constants.CURRENT_BASKET;

@Controller
@RequestMapping(value = "/catalogue")
@SessionAttributes({CURRENT_BASKET})
public class CatalogController {

    private final ProductDataAccess productDataAccess;
    private final BasketService basketService;

    @ModelAttribute(CURRENT_BASKET)
    public Basket basket(){
        return new Basket();
    }



    @Autowired
    public CatalogController(ProductDataAccess productDataAccess, BasketService basketService){
        this.productDataAccess = productDataAccess;
        this.basketService = basketService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale) {
        model.addAttribute("produits", productDataAccess.findAll(locale.getLanguage()));
        return "integrated:catalog";
    }


    @GetMapping("/addToBasket")
    public String addToBasket(@RequestParam("productId")int id, @ModelAttribute(value = CURRENT_BASKET) Basket basket, Locale locale){

        List<Product>products =  productDataAccess.findAll(locale.getLanguage());
        for (Product p : products){
            if(p.getNumProduit() == id){
                basketService.addToBasket(p, basket);
                return "redirect:/catalogue";
            }
        }
        return "integrated:error";
    }
}
