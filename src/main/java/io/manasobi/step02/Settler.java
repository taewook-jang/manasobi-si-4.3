package io.manasobi.step02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-14.
 */
@Slf4j
@Component
public class Settler {

    @ServiceActivator(inputChannel = "outputChannel")
    public void settle(Integer index) {
        log.info("Index: {}", index);
    }

}
