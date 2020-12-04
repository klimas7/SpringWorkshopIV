package pl.klimas7.spring.cache;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheService {

    @SneakyThrows
    @Cacheable("names")
    public String get(String name, Integer age) {
        log.info("Cache service {} {}", name, age);
        Thread.sleep(3000);
        log.info("Cache service after sleep {} {}", name, age);
        return name + " : " + age;
    }
}
