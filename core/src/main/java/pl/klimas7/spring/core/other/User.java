package pl.klimas7.spring.core.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private final String id;
    private final String name;
    private final String email;
}
