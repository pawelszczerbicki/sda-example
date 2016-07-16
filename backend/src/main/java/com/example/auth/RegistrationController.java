package com.example.auth;

import com.example.user.User;
import com.example.user.UserService;
import com.example.user.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator validator;

    @RequestMapping(value = "/register", method = GET)
    public String registerView() {
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String register(@Validated User user) {
        userService.add(user);
        return "redirect:/login";
    }

    @InitBinder("user")
    public void initUserValidator(WebDataBinder binder) {
        binder.addValidators(validator);
    }
}
