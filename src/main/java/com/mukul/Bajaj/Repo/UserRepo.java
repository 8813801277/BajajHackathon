package com.mukul.Bajaj.Repo;

import com.mukul.Bajaj.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
