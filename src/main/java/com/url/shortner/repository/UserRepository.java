package com.url.shortner.repository;

import com.url.shortner.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
     //void createUser(User user);
}
