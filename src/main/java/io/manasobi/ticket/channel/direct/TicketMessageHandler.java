package io.manasobi.ticket.channel.direct;

import io.manasobi.ticket.Ticket;
import org.springframework.integration.MessageRejectedException;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Component
public class TicketMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

        Object payload = message.getPayload();

        if (payload instanceof Ticket) {
            handleTicket((Ticket) payload);
        } else {
            throw new MessageRejectedException(message, "Unknown data type has been received.");
        }
    }

    private void handleTicket(Ticket ticket) {
        System.out.println("Received ticket - " + ticket.toString());
    }

}

