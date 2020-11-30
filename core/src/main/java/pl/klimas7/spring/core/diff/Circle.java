package pl.klimas7.spring.core.diff;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
    private final static int r = 5;
    @Override
    public int area() {
        return (int) Math.PI * r * r;
    }
}
