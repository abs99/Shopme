package com.shopme.admin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopme.admin.services.UserService;
import com.shopme.common.entity.User;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    UserService service;

     @GetMapping("/users")
     public String getUsers(Model model){

        List<User> users = service.getAllUsers();
        model.addAttribute("userList", users);
        return "users";
     }
}
