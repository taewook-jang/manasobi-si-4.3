package io.manasobi.ticket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by tw.jang on 2017-03-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class EmergencyTicketTest {

    @Autowired
    private ProblemReporter problemReporter;

    @Autowired
    private EmergencyTicketReceiver ticketReceiver;

    @Autowired
    private TicketGenerator ticketGenerator;

    @Test
    public void test() {

        List<Ticket> tickets = ticketGenerator.createTickets();

        tickets.forEach(ticket -> problemReporter.openTicket(ticket));

        Thread consumerThread = new Thread(ticketReceiver);

        consumerThread.start();

    }

}
