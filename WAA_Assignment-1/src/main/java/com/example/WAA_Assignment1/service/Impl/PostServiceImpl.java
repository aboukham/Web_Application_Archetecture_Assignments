package com.example.WAA_Assignment1.service.Impl;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.domain.Post;
import com.example.WAA_Assignment1.repository.PostRepo;
import com.example.WAA_Assignment1.service.Adapter.ListAdapter;
import com.example.WAA_Assignment1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo    postRepo;
    @Autowired
    ListAdapter<Post, PostDto> listAdapter;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<PostDto> findAll() {
        List<Post> posts = new ArrayList<>();
        postRepo.findAll().forEach(p -> posts.add(p));
        return (List<PostDto>)listAdapter.mapToList(posts, new PostDto());
    }

    @Override
    public PostDto findById(long id) {
        return (PostDto) modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(PostDto post) {
        Post p = modelMapper.map(post, Post.class);
        postRepo.save(p);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(long id, PostDto p) {
        Post post = modelMapper.map(p, Post.class);
        post.setId(id);
        postRepo.deleteById(id);
        postRepo.save(post);
    }

    @Override
    public List<PostDto> findAllPostsWithTitle(String title) {
        return (List<PostDto>) listAdapter.mapToList(postRepo.findByTitle(title), new PostDto());
    }
}
