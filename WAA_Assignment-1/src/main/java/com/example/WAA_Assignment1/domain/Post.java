package com.example.WAA_Assignment1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    private long  id;
    private String  title;
    private String  content;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Comment> comments;
}
