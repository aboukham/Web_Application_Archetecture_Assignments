package com.example.WAA_Assignment1.controller;

import com.example.WAA_Assignment1.Dto.PostDto;
import com.example.WAA_Assignment1.domain.Comment;
import com.example.WAA_Assignment1.service.CommentService;
import com.example.WAA_Assignment1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable("id") long id){
        return commentService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Comment comment){
        commentService.save(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        commentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Comment comment){
        commentService.update(id, comment);
    }
}
