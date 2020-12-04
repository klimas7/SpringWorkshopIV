package pl.klimas7.spring.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String secondName;
    private Integer age;
    private LocalDateTime birthDate;

    public User(String firstName, String secondName, Integer age, LocalDateTime birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.birthDate = birthDate;
    }
}
