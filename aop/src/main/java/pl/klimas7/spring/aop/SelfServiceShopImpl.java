package pl.klimas7.spring.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelfServiceShopImpl implements SelfServiceShop {
    @Override
    public void selfBuy() {
        log.info("selfBuy()");
    }
}
