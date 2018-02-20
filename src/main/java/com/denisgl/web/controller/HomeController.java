package com.denisgl.web.controller;

import com.denisgl.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    User user;

    @ModelAttribute("userAttr")
    public User getUser(){
        return user;
    }

    @RequestMapping("/")
    public String getHome(Model model){
        model.addAttribute("user",user);
        return "home";
    }

    @RequestMapping(value = "post" ,method = RequestMethod.GET)
    public String postUser(){
        return "postUser";
    }

    @RequestMapping(value = "post" ,method = RequestMethod.POST)
    public String postUser(@ModelAttribute("userAttr") User user ){
        return "redirect:/";
    }
}
