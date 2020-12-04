package pl.klimas7.spring.cache;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CacheService {
    private final CacheManager cacheManager;

    @SneakyThrows
    @Cacheable("names")
    public String get(String name, Integer age) {
        log.info("Cache service {} {}", name, age);
        Thread.sleep(3000);
        log.info("Cache service after sleep {} {}", name, age);
        return name + " : " + age;
    }

    @CacheEvict(value = "names", allEntries = true)
    public void evict() {
    }

    public void evictCM() {
        Optional.ofNullable(cacheManager.getCache("names"))
                .ifPresent(Cache::clear);
    }
}
