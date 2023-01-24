package com.example.WAA_Assignment1.controller;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.domain.Post;
import com.example.WAA_Assignment1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<PostDto> getAllPosts(@RequestParam(value = "title", required = false) String title){
        return (title == null) ? postService.findAll(): postService.findAllPostsWithTitle(title);
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @PostMapping
    public void getPost(@RequestBody PostDto p){
        postService.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") long id){
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void getPost(@PathVariable("id") long id, @RequestBody PostDto p){
        postService.update(id, p);
    }
}
