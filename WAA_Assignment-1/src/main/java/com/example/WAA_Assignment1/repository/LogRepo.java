package com.example.WAA_Assignment1.repository;

import com.example.WAA_Assignment1.domain.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends CrudRepository<Log, Long> {
}
