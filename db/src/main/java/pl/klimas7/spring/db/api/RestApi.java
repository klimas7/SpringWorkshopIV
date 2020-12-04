package pl.klimas7.spring.db.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.klimas7.spring.db.UserRepository;
import pl.klimas7.spring.db.model.User;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApi {
    private final UserRepository userRepository;

    public RestApi(@Qualifier("jdbc")  UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/count")
    public Long countUser() {
        return userRepository.count();
    }

    @GetMapping("/findRecent")
    public List<User> findRecent() {
        return userRepository.findRecent();
    }

    @PostMapping("/add/{firstName}/{lastName}")
    public User addUser(@PathVariable String firstName, @PathVariable String lastName) {
        User user = new User(null, firstName, lastName, 10, LocalDateTime.now());
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.delete(id);
    }
}

/*
GET http://localhost:8080/api/count

POST http://localhost:8080/api/John/Rambo
 */