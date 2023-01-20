package com.example.WAA_Assignment1.repository;

import com.example.WAA_Assignment1.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo  extends CrudRepository<Post, Long> {
    /*public List<Post> findAll();
    public Post findById(long id);
    public void save(Post post);
    public void deleteById(long id);
    public void update(long id, Post p);*/
}
