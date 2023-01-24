package com.example.WAA_Assignment1.service;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(long id);
    public void save(User user);
    public void deleteById(long id);
    public void update(long id, User user);
    public List<User> findAllUsersThatHaveMoreThanNPosts(int n);
    List<User>  findUsersWithTitle(String title);
}
