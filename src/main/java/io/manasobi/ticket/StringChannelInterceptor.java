package io.manasobi.ticket;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * Created by tw.jang on 2017-03-13.
 */
public class StringChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        System.out.println("preSend :: " + message);
        System.out.println("preSend channel :: " + channel);

        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

        System.out.println("postSend :: " + message);
        System.out.println("postSend channel :: " + channel);
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {

    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        return false;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        return null;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {

    }
}
