package io.manasobi.ticket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Configuration
@EnableIntegration
public class AppConfig {

    @Bean
    public QueueChannel ticketChannel() {
        return MessageChannels.queue(50).datatype(Ticket.class).get();
    }

    @Bean
    public DirectChannel directChannel() {

        DirectChannel directChannel = MessageChannels.direct()
                                                     .datatype(Ticket.class)
                                                     .interceptor(stringChannelInterceptor())
                                                     .get();

        System.out.println("direct channel :: " + directChannel.toString());

        return directChannel;
    }

    public ChannelInterceptor stringChannelInterceptor() {
        return new StringChannelInterceptor();
    }

    @Bean
    public PublishSubscribeChannel publishSubscribeChannel() {

        PublishSubscribeChannel publishSubscribeChannel =
                MessageChannels.publishSubscribe().datatype(Ticket.class).get();

        System.out.println("publishSubscribeChannel :: " + publishSubscribeChannel.toString());

        return publishSubscribeChannel;
    }

    /*@Bean
    public PriorityChannel priorityChannel() {

        PriorityChannel priorityChannel = new PriorityChannel(50, new Comparator<Message<Ticket>>() {
            @Override
            public int compare(Message<Ticket> message1, Message<Ticket> message2) {
                Integer priority1 = message1.getPayload().getPriority().ordinal();
                Integer priority2 = message2.getPayload().getPriority().ordinal();

                priority1 = priority1 != null ? priority1 : 0;
                priority2 = priority2 != null ? priority2 : 0;

                return priority2.compareTo(priority1);
            }
        });


        priorityChannel.setDatatypes(Ticket.class);
        //priorityChannel.

        return priorityChannel;
    }*/



}
