package com.shopme.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shopme.admin.user.RoleRepository;
import com.shopme.admin.user.UserRepository;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    @Autowired
    RoleRepository roleRepo;
    public List<User> getAllUsers(){

        List<User> users= repo.findAll(Sort.by("firstName").ascending());
        return users;
    }
     public void saveUser(User user){

        try {
            repo.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Role> listRoles() {
		return (List<Role>) roleRepo.findAll();
	}
}
