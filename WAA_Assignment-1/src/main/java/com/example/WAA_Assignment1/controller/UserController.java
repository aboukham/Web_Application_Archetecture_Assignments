package com.example.WAA_Assignment1.controller;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.domain.Post;
import com.example.WAA_Assignment1.domain.User;
import com.example.WAA_Assignment1.repository.PostRepo;
import com.example.WAA_Assignment1.service.PostService;
import com.example.WAA_Assignment1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
   @Autowired
    PostRepo    postRepo;
    @GetMapping
    public List<User> getAllUsers(@RequestParam(value = "numberOfPosts", required = false) Integer n, @RequestParam(value = "title", required = false) String title){
        if (n != null)
            return userService.findAllUsersThatHaveMoreThanNPosts(n);
        else if (title != null)
            return userService.findUsersWithTitle(title);
        else
            return userService.findAll();
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody User user){
        userService.update(id, user);
    }



}
