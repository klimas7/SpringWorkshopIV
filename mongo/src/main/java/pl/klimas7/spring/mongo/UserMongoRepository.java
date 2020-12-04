package pl.klimas7.spring.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserMongoRepository extends MongoRepository<User, String> {
    List<User> findUserByFirstName(String name);
    List<User> findByFirstName(String name);
    User findTopByAgeIsAfterOrderByAgeDesc(Integer age);
}
