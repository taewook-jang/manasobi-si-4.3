package io.manasobi.ticket;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by tw.jang on 2017-03-13.
 */
@Component
public class TicketGenerator {

    private long nextTicketId;

    public TicketGenerator() {
        this.nextTicketId = 1000L;
    }

    public List<Ticket> createTickets() {

        List<Ticket> tickets = new ArrayList<Ticket>();

        tickets.add(createLowPriorityTicket());
        tickets.add(createLowPriorityTicket());
        tickets.add(createLowPriorityTicket());
        tickets.add(createLowPriorityTicket());
        tickets.add(createLowPriorityTicket());
        tickets.add(createMediumPriorityTicket());
        tickets.add(createMediumPriorityTicket());
        tickets.add(createMediumPriorityTicket());
        tickets.add(createMediumPriorityTicket());
        tickets.add(createMediumPriorityTicket());
        tickets.add(createHighPriorityTicket());
        tickets.add(createHighPriorityTicket());
        tickets.add(createHighPriorityTicket());
        tickets.add(createHighPriorityTicket());
        tickets.add(createHighPriorityTicket());
        tickets.add(createEmergencyPriorityTicket());
        tickets.add(createEmergencyPriorityTicket());
        tickets.add(createEmergencyPriorityTicket());
        tickets.add(createEmergencyPriorityTicket());
        tickets.add(createEmergencyPriorityTicket());

        return tickets;
    }

    private Ticket createEmergencyPriorityTicket() {
        return createTicket(Ticket.Priority.EMERGENCY, "Urgent problem. Fix immediately or revenue will be lost!");
    }

    private Ticket createHighPriorityTicket() {
        return createTicket(Ticket.Priority.HIGH, "Serious issue. Fix immediately.");
    }

    private Ticket createMediumPriorityTicket() {
        return createTicket(Ticket.Priority.MEDIUM, "There is an issue; take a look whenever you have time.");
    }

    private Ticket createLowPriorityTicket() {
        return createTicket(Ticket.Priority.LOW, "Some minor problems have been found.");
    }

    private Ticket createTicket(Ticket.Priority priority, String description) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(nextTicketId++);
        ticket.setPriority(priority);
        ticket.setIssueDateTime(GregorianCalendar.getInstance());
        ticket.setDescription(description);
        return ticket;
    }
}
