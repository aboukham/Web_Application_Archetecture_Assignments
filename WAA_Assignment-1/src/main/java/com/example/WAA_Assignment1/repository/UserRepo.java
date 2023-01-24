package com.example.WAA_Assignment1.repository;

import com.example.WAA_Assignment1.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

}
