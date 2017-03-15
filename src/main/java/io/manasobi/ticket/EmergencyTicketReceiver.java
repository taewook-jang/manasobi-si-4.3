package io.manasobi.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Component
public class EmergencyTicketReceiver extends TicketReceiver {

    private MessageSelector emergencyTicketSelector;

    @Autowired
    public void setEmergencyTicketSelector(MessageSelector emergencyTicketSelector) {
        this.emergencyTicketSelector = emergencyTicketSelector;
    }

    public void handleTicketMessage() {
        Message<?> ticketMessage;

        while(true) {
            List<Message<?>> emergencyTicketMessages = ticketChannel.purge(emergencyTicketSelector);
            handleEmergencyTickets(emergencyTicketMessages);

            ticketMessage = ticketChannel.receive(RECEIVE_TIMEOUT);
            if(ticketMessage != null) {
                handleTicket((Ticket) ticketMessage.getPayload());
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleEmergencyTickets(List<Message<?>> highPriorityTicketMessage) {

        highPriorityTicketMessage.forEach(ticketMessage -> handleTicket((Ticket) ticketMessage.getPayload()));

        /*Assert.notNull(highPriorityTicketMessage);
        for(Message<?> ticketMessage : highPriorityTicketMessage) {
            handleTicket((Ticket) ticketMessage.getPayload());
        }*/
    }

}