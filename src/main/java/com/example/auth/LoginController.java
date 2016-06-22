package com.example.auth;

import com.example.user.User;
import com.example.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = GET)
    public String loginView() {
        return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(Model m, User user) {
        if (userService.canLogUser(user))
            return "redirect:/dashboard";
        m.addAttribute("fail", true);
        return "login";
    }
}
