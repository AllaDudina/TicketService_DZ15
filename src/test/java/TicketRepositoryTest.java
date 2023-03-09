import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    Ticket ticket1 = new Ticket(1, 15_000, "DME", "LED", 320);
    Ticket ticket2 = new Ticket(2, 10_000, "DME", "LED", 120);
    Ticket ticket3 = new Ticket(3, 30_000, "PKC", "SVO", 480);

    TicketRepository repository = new TicketRepository();

    @Test
    public void findAllTickets() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeTicket() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.removeById(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
