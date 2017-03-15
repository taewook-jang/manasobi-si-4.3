package io.manasobi.step02;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tw.jang on 2017-03-14.
 */
@Component
public class Counter {

    public AtomicLong count = new AtomicLong(5l);

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public Integer count(Integer num) {
        count.addAndGet(num);
        return count.intValue();
    }
}
