package io.manasobi;

import io.manasobi.step04.rabbitmq.AppRunner;
import io.manasobi.step04.rabbitmq.TestEntity;
import io.manasobi.step04.rabbitmq.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class Step04Test_RabbitMQ {

    @Autowired
    private TestService testService;

    @Test
    public void testSendAndReceive() throws Exception {

        final String testVal = UUID.randomUUID().toString();
        final String res = testService.process(new TestEntity(testVal));
        Assert.assertEquals(testVal, res);

    }
}
