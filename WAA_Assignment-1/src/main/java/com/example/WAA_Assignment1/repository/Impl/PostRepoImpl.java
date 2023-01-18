package com.example.WAA_Assignment1.repository.Impl;

import com.example.WAA_Assignment1.domain.Post;
import com.example.WAA_Assignment1.repository.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PostRepoImpl implements PostRepo {
    private List<Post>  posts = new ArrayList<>();
    public PostRepoImpl(){
        Post p1 = new Post(1, "European soccer", "the game today was amazing", "Abdelaziz");
        Post p2 = new Post(2, "European soccer", "the game today was boring", "John");
        Post p3 = new Post(3, "European soccer", "the game today was wonderful", "David");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    @Override
    public void save(Post post) {
        posts.add(post);
    }

    @Override
    public void deleteById(long id) {
        Post p = findById(id);
        posts.remove(p);
    }

    @Override
    public void update(long id, Post p) {
        Post post = findById(id);
        deleteById(id);
        p.setId(id);
        save(p);
    }
}
