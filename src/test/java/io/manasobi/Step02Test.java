package io.manasobi;

import io.manasobi.step02.AppRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by tw.jang on 2017-03-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class Step02Test {

    @Autowired
    private MessageChannel inputChannel;

    @Test
    public void test() throws Exception {

        for (int i = 0; i < 5; i++) {
            inputChannel.send(MessageBuilder.withPayload(new Random().nextInt(10)).build());
        }

        TimeUnit.SECONDS.sleep(5);
    }

}
