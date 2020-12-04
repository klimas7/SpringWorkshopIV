package pl.klimas7.spring.db;

import pl.klimas7.spring.db.model.User;

import java.util.List;

public interface UserRepository {
    Long count();
    List<User> findRecent();
    List<User> findRecent(int count);
    User findOne(long id);
    User save(User user);
    void delete(long id);
}
