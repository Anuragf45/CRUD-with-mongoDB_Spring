package com.example.userData.Repositories;


import com.example.userData.Model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface Repository extends MongoRepository<Model,String> {
    @Query
    Optional<Model> findByUserName(String userName);
}
