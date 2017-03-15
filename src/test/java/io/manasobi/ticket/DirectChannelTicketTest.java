package io.manasobi.ticket;

import io.manasobi.ticket.channel.direct.ProblemReporter;
import io.manasobi.ticket.channel.direct.TicketMessageHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tw.jang on 2017-03-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class DirectChannelTicketTest {

    @Resource(name = "directChannelProblemReporter")
    private ProblemReporter problemReporter;

    @Autowired
    private TicketGenerator ticketGenerator;

    @Autowired
    private TicketMessageHandler ticketMessageHandler;

    @Autowired
    private DirectChannel directChannel;

    @Autowired
    private DirectChannel directChannel2;

    @Test
    public void test() {

        directChannel.subscribe(ticketMessageHandler);
        directChannel.subscribe(ticketMessageHandler);

        List<Ticket> tickets = ticketGenerator.createTickets();

        tickets.forEach(ticket -> problemReporter.openTicket(ticket));

    }

}
