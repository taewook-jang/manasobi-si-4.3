package io.manasobi.step04;

import org.springframework.integration.MessageRejectedException;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by tw.jang on 2017-03-15.
 */
@Component
public class DataMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

        Object payload = message.getPayload();

        if(payload instanceof String) {
            System.out.println("Received the String object. " + payload.toString());
        } else if(payload instanceof Integer) {
            System.out.println("Received the Integer object. " + payload.toString());
        } else if(payload instanceof MyData) {
            System.out.println("Received the MyData object. " + payload.toString());
        } else {
            throw new MessageRejectedException(message, "Unknown data type.");
        }
    }

}
