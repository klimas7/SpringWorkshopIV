package pl.klimas7.spring.db;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pl.klimas7.spring.db.model.User;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Repository("jdbc")
public class JdbcUserRepository implements UserRepository {
    private static final String SELECT_USER = "SELECT u.id, u.firstName, u.lastName, u.age, u.birthDate from user u";
    private static final String SELECT_RECENT_USER = SELECT_USER + " order by u.birthDate desc limit ?";
    private static final String SELECT_USER_BY_ID = SELECT_USER + " where u.id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM user", Long.class);
    }

    @Override
    public List<User> findRecent() {
        return findRecent(3);
    }

    @Override
    public List<User> findRecent(int count) {
        return jdbcTemplate.query(SELECT_RECENT_USER, new UserRowMapping(), count);
    }

    @Override
    public User findOne(long id) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new UserRowMapping(), id);
    }

    @Override
    @Transactional
    public User save(User user) {
        Long id = insertUserAndReturnId(user);
        log.info("--------------------------");
        if (false) {
            throw new RuntimeException("ups!!!");
        }
        return new User(id, user.getFirstName(), user.getLastName(), user.getAge(), user.getBirthDate());
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE from user WHERE identity = ?", id);
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

    private static class UserRowMapping implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            Integer age = rs.getInt("age");
            Date date = rs.getDate("birthDate");
            LocalDateTime birthDate = LocalDateTime.of(date.toLocalDate(), LocalTime.MIN);
            return new User(id, firstName, lastName, age, birthDate);
        }
    }
}
