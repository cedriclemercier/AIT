package com.example.midterm.controller;

import com.example.midterm.model.Employee;
import com.example.midterm.model.Role;
import com.example.midterm.model.User;
import com.example.midterm.service.EmployeeService;
import com.example.midterm.service.UserService;
import com.example.midterm.validation.UserValidator;
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
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(path = "/home")
    public ModelAndView userDashboard(Principal principal) {
        ModelAndView mv = new ModelAndView("home.jsp");
        User u = userService.findByUsername(principal.getName());
        List<User> users = userService.findAll();
        mv.addObject("user", u);
        mv.addObject("users", users);

        for (Role role: u.getRoles()) {
            if (role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
                // do something
            }
            if (role.getName().equalsIgnoreCase("ROLE_USER")) {
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

    /*@RequestMapping(path = "create", method= RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "register.jsp";
    }

    @RequestMapping(path = "/create", method= RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register.jsp";
        }
        userService.save(user);

        return "home.jsp";
    }*/

    @RequestMapping(path = "create", method= RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "home.jsp";
    }

    @RequestMapping(path = "/create", method= RequestMethod.POST)
    public String createUser(@ModelAttribute("employee") Employee employee,
                             BindingResult bindingResult) {
        employeeService.save(employee);

        return "home.jsp";
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
