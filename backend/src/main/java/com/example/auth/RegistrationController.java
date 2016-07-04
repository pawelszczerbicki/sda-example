package com.example.auth;

import com.example.user.User;
import com.example.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = GET)
    public String registerView(){
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String register(User u){
        userService.add(u);
        return "redirect:/login";
    }
}
