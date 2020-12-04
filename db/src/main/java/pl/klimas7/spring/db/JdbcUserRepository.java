package pl.klimas7.spring.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pl.klimas7.spring.db.model.User;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Repository("jdbc")
public class JdbcUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM user", Long.class);
    }

    @Override
    public List<User> findRecent() {
        return null;
    }

    @Override
    public List<User> findRecent(int count) {
        return null;
    }

    @Override
    public User findOne(long id) {
        return null;
    }

    @Override
    @Transactional
    public User save(User user) {
        Long id = insertUserAndReturnId(user);
        log.info("--------------------------");
        if (true) {
            throw new RuntimeException("ups!!!");
        }
        return new User(id, user.getFirstName(), user.getLastName(), user.getAge(), user.getBirthDate());
    }

    @Override
    public void delete(long id) {

    }

    private Long insertUserAndReturnId(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user");
        insert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("firstName", user.getFirstName());
        args.put("lastName", user.getLastName());
        args.put("age", user.getAge());
        args.put("birthDate", user.getBirthDate());

        return insert.executeAndReturnKey(args).longValue();
    }
}
