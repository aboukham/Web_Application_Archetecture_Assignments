package com.example.WAA_Assignment1.service.Impl;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.controller.PostController;
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
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PostController postController;
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

    @Override
    public List<User> findAllUsersThatHaveMoreThanNPosts(int n) {
        List<User>  list = findAll();
        return list.stream().filter(u -> u.getPosts().size() > n)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersWithTitle(String title) {
        return findAll().stream().filter(u -> {return u.getPosts().stream().filter(p -> p.getTitle().equals(title)).isParallel();})
                .collect(Collectors.toList());
    }
}
