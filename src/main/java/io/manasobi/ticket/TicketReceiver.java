package io.manasobi.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Component
public class TicketReceiver implements Runnable {

    protected final static int RECEIVE_TIMEOUT = 1000;

    @Autowired
    protected QueueChannel ticketChannel;

    public void handleTicketMessage() {

        Message<?> ticketMessage;

        while(true) {
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

    protected void handleTicket(Ticket ticket) {
        System.out.println("Received ticket - " + ticket.toString());
    }

    @Override
    public void run() {
        handleTicketMessage();
    }

}
