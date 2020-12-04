package pl.klimas7.spring.mongo;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApi {
    private UserRepository userRepository;

    public RestApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/createUsers")
    private ResponseEntity<List<User>> crateUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("John", "Rambo", 42, LocalDateTime.of(1960, Month.JANUARY, 12, 0 ,0 )));
        users.add(new User("Neo", "Matrix", 42, LocalDateTime.of(1963, Month.MAY, 13, 0 ,0 )));
        users.add(new User("Myszka", "Miki", 12, LocalDateTime.of(2017, Month.JANUARY, 12, 0 ,0 )));
        users.add(new User("Kaczor", "Donald", 42, LocalDateTime.of(2017, Month.JANUARY, 12, 0 ,0 )));
        users.add(new User("Dziadek", "Mroz", 142, LocalDateTime.of(1860, Month.JANUARY, 12, 0 ,0 )));

        List<User> save = userRepository.save(users);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{firstName}")
    public List<User> getUserByName(@PathVariable String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @GetMapping("/oldestUser")
    public User getOldestUser() {
        return userRepository.getOldestUser();
    }
}

/*
POST http://localhost:8080/api/createUsers

GET http://localhost:8080/api/users

GET http://localhost:8080/api/user/John

GET http://localhost:8080/api/oldestUser
 */

/*
$ docker exec -it mongo bash
root@c65968c1024b:/# mongo -u admin -p k7admin

> show dbs
> use test
> db.user.find()
> db.user.remove({})
 */