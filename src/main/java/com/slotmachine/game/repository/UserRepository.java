package com.leovegas.game.repository;

import com.leovegas.game.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@Qualifier("userMongoRepository")
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String id);
}
