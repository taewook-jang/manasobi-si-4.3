package io.manasobi.step01;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-14.
 */
@Component
public class Settler {

    @ServiceActivator(inputChannel = "inputChannel")
    public void settle(Integer index) {

        System.out.println("Index: " + index);
    }

}
