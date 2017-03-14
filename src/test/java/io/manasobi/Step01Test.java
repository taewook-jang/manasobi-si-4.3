package io.manasobi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by tw.jang on 2017-03-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class Step01Test {

    @Autowired
    private MessageChannel inputChannel;

    @Test
    public void test() {

        Integer index = new Integer(25);

        inputChannel.send(MessageBuilder.withPayload(index).build());

        /*try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/



    }

}
