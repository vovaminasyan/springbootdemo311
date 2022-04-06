package com.example.springbootdemo311.controller;

import com.example.springbootdemo311.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserDao ud;

    List<String> messages = new ArrayList<>();

    {
        messages.add("Helo!!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {

        model.addAttribute("messages", messages);
        return "index";
    }
}

