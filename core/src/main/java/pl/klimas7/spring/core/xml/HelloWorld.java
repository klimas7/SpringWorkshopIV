package pl.klimas7.spring.core.xml;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HelloWorld {
    private String message;

    public void print() {
        System.out.println("Your message: " + message);
    }
}
