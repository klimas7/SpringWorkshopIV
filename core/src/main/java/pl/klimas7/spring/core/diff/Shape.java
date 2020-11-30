package pl.klimas7.spring.core.diff;

public interface Shape {
    int area();

    default String description() {
        return this.getClass().getName() + " area: " + area();
    }
}
