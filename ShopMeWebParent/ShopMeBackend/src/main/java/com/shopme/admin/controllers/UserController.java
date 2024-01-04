package com.shopme.admin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopme.admin.services.UserService;
import com.shopme.common.entity.Role;
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

     @GetMapping("/newUser")
     public String newUser(Model model){
      List<Role> listRoles = service.listRoles();
      User user = new User();
		user.setEnabled(true);
		
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("pageTitle", "Create New User");
        return "user_form";
     }

     @PostMapping("/saveUser")
     public String newUser(User user){
      service.saveUser(user);
      return "redirect:users";
     }

    
}
