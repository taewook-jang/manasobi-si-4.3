package io.manasobi;

import io.manasobi.step02.AppRunner;
import io.manasobi.step02.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by tw.jang on 2017-03-14.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class Step03Test {

    @Autowired
    private MessageChannel inputChannel;

    @Autowired
    private PollableChannel outputChannel;

    @Test
    public void test() {

        Order myOrder = new Order("myOrder");
        Order manasobiOrder = new Order("myOrder");

        inputChannel.send(new GenericMessage("world"));
        inputChannel.send(MessageBuilder.withPayload("test").build());
        inputChannel.send(new GenericMessage(myOrder));
        inputChannel.send(MessageBuilder.withPayload(manasobiOrder).build());


        System.out.println(outputChannel.receive().getPayload());
        System.out.println(outputChannel.receive().getPayload());
        System.out.println(outputChannel.receive().getPayload());
        System.out.println(outputChannel.receive().getPayload());

    }

}
