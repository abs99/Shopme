package com.shopme.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shopme.admin.user.UserRepository;
import com.shopme.common.entity.User;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> getAllUsers(){

        List<User> users= repo.findAll(Sort.by("firstName").ascending());
        return users;
    }
}
