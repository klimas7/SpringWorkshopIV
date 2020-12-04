package pl.klimas7.spring.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserMongoRepository extends MongoRepository<User, String> {
    List<User> findUserByFirstName(@Param("name") String name);
    List<User> findByFirstName(@Param("name") String name);
    User findTopByAgeIsAfterOrderByAgeDesc(@Param("age") Integer age);
}
