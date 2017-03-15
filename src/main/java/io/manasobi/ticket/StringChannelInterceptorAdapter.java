package io.manasobi.ticket;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

/**
 * Created by tw.jang on 2017-03-13.
 */
public class StringChannelInterceptorAdapter extends ChannelInterceptorAdapter {

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

}
