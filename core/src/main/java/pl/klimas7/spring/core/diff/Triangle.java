package pl.klimas7.spring.core.diff;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {
    private static final int a = 5;
    @Override
    public int area() {
        return (int) (a * a * Math.sqrt(3) / 2);
    }
}
