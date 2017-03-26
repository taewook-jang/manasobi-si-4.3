package io.manasobi;

import io.manasobi.step04.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by tw.jang on 2017-03-14.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class Step04Test {

    @Autowired
    private SubscribableChannel channel;

    @Autowired
    private DataMessageHandler messageHandler;

    @Autowired
    private DataMessage2Handler messageHandler2;

    @Test
    public void test() {

        channel.subscribe(messageHandler);
        channel.subscribe(messageHandler2);

        MyData myData = new MyData(5, "id-001");

        channel.send(new GenericMessage<Integer>(5));
        channel.send(new GenericMessage("MyString"));
        channel.send(new GenericMessage(myData));
/*        channel.send(new GenericMessage<Float>(5.53f));
        channel.send(new GenericMessage<Double>(5.52d));*/
        channel.send(new GenericMessage<OtherData>(new OtherData()));

    }

}
