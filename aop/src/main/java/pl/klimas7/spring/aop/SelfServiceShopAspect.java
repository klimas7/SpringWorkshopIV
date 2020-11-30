package pl.klimas7.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SelfServiceShopAspect {
    @DeclareParents(value = "pl.klimas7.spring.aop.IkeaShop", defaultImpl = SelfServiceShopImpl.class)
    public SelfServiceShop selfServiceShop;
}
