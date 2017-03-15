package io.manasobi.ticket;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Component
public class EmergencyTicketSelector  implements MessageSelector {

    @Override
    public boolean accept(Message<?> message) {
        return ((Ticket) message.getPayload()).getPriority() != Ticket.Priority.EMERGENCY;
    }

}

