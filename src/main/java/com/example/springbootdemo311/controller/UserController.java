package com.example.springbootdemo311.controller;

import com.example.springbootdemo311.model.User;
import com.example.springbootdemo311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public String users(Model model) {
        //List<User> users = userService.listUsers();
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("create")
    public String createUserForm(User user) {
        return "create";
    }

    @PostMapping("create")
    public String createUser(User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("update")
    public String updateUser(User user) {
        userService.update(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return "redirect:/users";
    }
}
