package com.example.WAA_Assignment1.service.Impl;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.domain.Post;
import com.example.WAA_Assignment1.domain.User;
import com.example.WAA_Assignment1.repository.PostRepo;
import com.example.WAA_Assignment1.repository.UserRepo;
import com.example.WAA_Assignment1.service.Adapter.ListAdapter;
import com.example.WAA_Assignment1.service.PostService;
import com.example.WAA_Assignment1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ListAdapter<Post, PostDto> listAdapter;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(u -> users.add(u));
        return users;
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User u) {
        userRepo.save(u);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(long id, User u) {
        u.setId(id);
        userRepo.deleteById(id);
        userRepo.save(u);
    }
}
