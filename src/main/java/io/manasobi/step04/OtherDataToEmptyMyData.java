package io.manasobi.step04;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by tw.jang on 2017-03-15.
 */
public class OtherDataToEmptyMyData implements MessageConverter {

    @Override
    public Object fromMessage(Message<?> message, Class<?> targetClass) {

        if (message.getPayload() instanceof OtherData) {
            return new MyData(9, "id-999");
        }

        return message.getPayload();
    }

    @Override
    public Message<?> toMessage(Object payload, MessageHeaders headers) {
        return MessageBuilder.createMessage(payload, headers);
    }
}
