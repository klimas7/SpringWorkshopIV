package pl.klimas7.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Slf4j
@Aspect
@Component
public class VerySmartCustomer implements Customer{
    Map<String, Integer> thingsCount = new HashMap<>();

    @Before(value = "addToBasket(name)", argNames = "name")
    public void countThings(String name) {
        int count = getThingsCount(name);
        thingsCount.put(name, count + 1);
    }

    private int getThingsCount(String name) {
        return Optional.ofNullable(thingsCount.get(name)).orElse(0);
    }

    void showCounts() {
        thingsCount.forEach((key, value) -> log.info(key + " " + value));
    }

    @Around(value = "addToBasket(name)", argNames = "pjp,name")
    public Object aroundAddToBasket(ProceedingJoinPoint pjp, String name) {
        if (isEmpty(name)) {
            return null;
        }
        Object retValue = null;
        try {
            String newName = proceedName(name);
            retValue = pjp.proceed(new String[]{newName});
        } catch (Throwable throwable) {
            log.error("error", throwable);
        }

        return retValue;
    }

    private String proceedName(String name) {
        return name.toUpperCase().trim();
    }


    @Around("buy()")
    public Object shopping(ProceedingJoinPoint pjp) {
        log.info("Before shopping");
        Object retValue = null;
        try {
            retValue =  pjp.proceed();
        } catch (Throwable throwable) {
            log.error("error", throwable);
        }

        log.info("After shopping");
        return retValue;
    }
}
