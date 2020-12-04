package pl.klimas7.spring.cache;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
    private final CacheService cacheService;

    @GetMapping("/cache/{name}/{age}")
    public String testCache(@PathVariable String name, @PathVariable Integer age) {
        log.info("In api controller {} {}", name, age);
        return cacheService.get(name, age);
    }

    @DeleteMapping("/cache/evict")
    public void cacheEvict() {
        log.info("Cache evict");
        //cacheService.evict();
        cacheService.evictCM();
    }
}
