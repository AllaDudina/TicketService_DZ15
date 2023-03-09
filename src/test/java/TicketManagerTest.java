import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 15_000, "DME", "LED", 320);
    Ticket ticket2 = new Ticket(2, 10_000, "DME", "LED", 120);
    Ticket ticket3 = new Ticket(3, 30_000, "PKC", "SVO", 480);

    @Test
    public void findMatchingTickets(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] result = manager.findAll("DME", "LED");

        Ticket [] expected = {ticket2, ticket1};
        Ticket [] actual = result;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findMatchingOneTicket(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] result = manager.findAll("PKC", "SVO");

        Ticket [] expected = {ticket3};
        Ticket [] actual = result;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findMatchingNullTicket(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] result = manager.findAll("PKC", "DME");

        Ticket [] expected = {};
        Ticket [] actual = result;

        Assertions.assertArrayEquals(expected, actual);

    }

}
