package io.manasobi;

import io.manasobi.step04.AppRunner;
import io.manasobi.step04.DataMessageHandler;
import io.manasobi.step04.MyData;
import io.manasobi.step04.OtherData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.DirectChannel;
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
    private DirectChannel channel;

    @Autowired
    private DataMessageHandler messageHandler;

    @Test
    public void test() {


        channel.subscribe(messageHandler);


        MyData myData = new MyData(5, "id-001");

        channel.send(new GenericMessage<Integer>(5));
        channel.send(new GenericMessage("MyString"));
        channel.send(new GenericMessage(myData));
/*        channel.send(new GenericMessage<Float>(5.53f));
        channel.send(new GenericMessage<Double>(5.52d));*/
        channel.send(new GenericMessage<OtherData>(new OtherData()));

    }

}
