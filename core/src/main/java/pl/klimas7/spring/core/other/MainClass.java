package pl.klimas7.spring.core.other;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;

@Log
public class MainClass {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }
    public static void main(String[] args) {
        log.info("--------------");
        SpringApplication.run(AppConfiguration.class, args);
        log.info("--------------");
    }
}
