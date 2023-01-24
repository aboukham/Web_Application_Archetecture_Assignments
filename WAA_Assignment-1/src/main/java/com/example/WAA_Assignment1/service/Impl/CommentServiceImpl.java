package com.example.WAA_Assignment1.service.Impl;

import com.example.WAA_Assignment1.domain.Comment;
import com.example.WAA_Assignment1.repository.CommentRepo;
import com.example.WAA_Assignment1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Override
    public List<Comment> findAll() {
        List<Comment>   list = new ArrayList<>();
        commentRepo.findAll().forEach(c -> list.add(c));
        return list;
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void deleteById(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void update(long id, Comment comment) {
        deleteById(id);
        comment.setId(id);
        save(comment);
    }
}
