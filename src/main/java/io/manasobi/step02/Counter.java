package io.manasobi.step02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tw.jang on 2017-03-14.
 */
@Slf4j
@Component
public class Counter {

    public AtomicLong count = new AtomicLong(5l);

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public Integer count(Integer num) {
        count.addAndGet(num);
        log.info("count int value: {}", count.intValue());
        return count.intValue();
    }
}
