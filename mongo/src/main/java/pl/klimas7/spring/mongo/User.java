package pl.klimas7.spring.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String secondName;
    private Integer age;
    private LocalDateTime birthDate;
}
