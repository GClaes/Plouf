package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.BasketService;
import com.spring.henallux.firstSpringProject.utilities.Constants;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.spring.henallux.firstSpringProject.utilities.Constants.CURRENT_BASKET;

@Controller
@RequestMapping(value="/welcome")
@SessionAttributes({CURRENT_BASKET})
public class WelcomeController {

    @RequestMapping (method = RequestMethod.GET)
    public String home (Authentication authentication) {
        User user;
        if(authentication != null)
            user = (User)authentication.getPrincipal();
       return "integrated:welcome";
    }
}
