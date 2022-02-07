package com.demo.controller;


import com.demo.model.User;
import com.demo.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    final
    UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public User addEditUser (@RequestBody  User user){
        return  userRepo.save(user);
    }
    @RequestMapping(value = "/deleteUser" , method = RequestMethod.DELETE)
    public void deleteUser (@PathVariable Integer id){
        userRepo.deleteById(id);
    }
    @RequestMapping(value = "/user/{id}" , method = RequestMethod.GET)
    public Optional<User> getUser (@PathVariable Integer id){
       return userRepo.findById(id) ;
    }
    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    public List<User> getAllUser (){
        return userRepo.findAll();
    }
}
