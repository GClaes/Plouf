package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "/inscription")
public class InscriptionController {

    private final UserDataAccess userDataAccess;
    private final MessageSource messageSource;

    @Autowired
    public InscriptionController(UserDataAccess userDataAccess, MessageSource messageSource) {
        this.userDataAccess = userDataAccess;
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        if(!model.containsAttribute("user"))
            model.addAttribute("user", new User());
        return "integrated:signIn";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@Valid @ModelAttribute(value = "user") User user, final BindingResult errors, Locale locale) {
        if(user.getLogin()!= null && !StringUtils.isEmpty(user.getLogin()) && userDataAccess.loadUserByUsername(user.getLogin())!= null){
            FieldError fieldError = new FieldError("user","login",messageSource.getMessage("loginExistant",null,locale));
            errors.addError(fieldError);
        }
        if (!user.getMotDePasse().equals(user.getMdpRep())) {
            FieldError fieldError = new FieldError("user","mdpRep",messageSource.getMessage("repetMDP",null,locale));
            errors.addError(fieldError);
        }
        if(errors.hasErrors()) {
            return "integrated:signIn";
        }
        user.setRoles("USER");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        userDataAccess.save(user);
        return "redirect:/welcome";
    }
}
