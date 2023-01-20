package com.example.WAA_Assignment1.repository;

import com.example.WAA_Assignment1.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
