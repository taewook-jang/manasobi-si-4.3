package io.manasobi.step03;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-14.
 */
@Component
public class MyHelloWorld {

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public String printHello(String message) {
        return "hello " + message;
    }

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public String printHello(Order order) {
        return "hello " + order.getName();
    }
}
