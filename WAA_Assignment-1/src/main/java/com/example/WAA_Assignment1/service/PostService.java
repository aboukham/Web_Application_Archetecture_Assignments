package com.example.WAA_Assignment1.service;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.domain.Post;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();
    public PostDto findById(long id);
    public void save(PostDto post);
    public void deleteById(long id);
    public void update(long id, PostDto p);
    public List<PostDto> findAllPostsWithTitle(String title);
}
