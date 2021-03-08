package com.example.LAB2.controller;

import com.example.LAB2.model.Role;
import com.example.LAB2.model.User;
import com.example.LAB2.service.UserService;
import com.example.LAB2.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(path = "/home")
    public ModelAndView userDashboard(Principal principal) {
        ModelAndView mv = new ModelAndView("home.jsp");
        User u = userService.findByUsername(principal.getName());
        mv.addObject("user", u);

        for (Role role: u.getRoles()) {
            if (role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
                // do something
            }
            if (role.getName().equalsIgnoreCase("ROLE_USER")) {
                // do something
            }
            if (role.getName().equalsIgnoreCase("ROLE_PREMIUM_USER")) {
                // do something
            }
        }
        return mv;
    }

    @RequestMapping(path = "register", method= RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register.jsp";
    }

    @RequestMapping(path = "/register", method= RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register.jsp";
        }
        userService.save(user);

        return "login.jsp";
    }

    @RequestMapping(path = "/login")
    public String login() {
        return "login.jsp";
    }

    @RequestMapping(path = "/logout-success")
    public String logout() {
        return "logout.jsp";
    }

}
