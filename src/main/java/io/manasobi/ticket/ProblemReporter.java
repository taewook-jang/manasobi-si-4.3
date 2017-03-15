package io.manasobi.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Component("problemReporter")
public class ProblemReporter {

    @Autowired
    protected PollableChannel ticketChannel;

    public void openTicket(Ticket ticket) {
        ticketChannel.send(MessageBuilder.withPayload(ticket).build());
        System.out.println("Ticket Sent - " + ticket.toString());
    }
}
