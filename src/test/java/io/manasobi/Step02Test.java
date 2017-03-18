package io.manasobi;

import io.manasobi.step02.AppRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by tw.jang on 2017-03-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class Step02Test {

    @Autowired
    private MessageChannel inputChannel;

    @Test
    public void test() {

        Integer index = new Integer(25);
        inputChannel.send(MessageBuilder.withPayload(index).build());
    }

}
