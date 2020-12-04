package pl.klimas7.spring.mongo;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final MongoOperations mongoOperations;
    private final UserMongoRepository userMongoRepository;

    public UserRepository(MongoOperations mongoOperations, UserMongoRepository userMongoRepository) {
        this.mongoOperations = mongoOperations;
        this.userMongoRepository = userMongoRepository;
    }

    public List<User> save(Iterable<User> users) {
        return userMongoRepository.saveAll(users);
    }

    public List<User> findAll() {
//        return userMongoRepository.findAll();
        return mongoOperations.findAll(User.class);
    }

    public List<User> findByFirstName(String firstName) {
        return userMongoRepository.findUserByFirstName(firstName);
    }
}
