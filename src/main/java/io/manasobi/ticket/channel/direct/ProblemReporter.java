package io.manasobi.ticket.channel.direct;

import io.manasobi.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Component("directChannelProblemReporter")
public class ProblemReporter {

    @Autowired
    protected MessageChannel directChannel;

    public void openTicket(Ticket ticket) {
        directChannel.send(MessageBuilder.withPayload(ticket).build());
        System.out.println("Ticket Sent - " + ticket.toString());
    }
}
