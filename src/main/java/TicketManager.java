import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repo) {
        this.repository = repo;
    }

    public void add(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public Ticket[] findAll(String fromAirport, String toAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, fromAirport, toAirport)) {
                Ticket[] tickets = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tickets[i] = result[i];
                }
                tickets[result.length] = ticket;
                Arrays.sort(tickets);
                result = tickets;
            }
        }

        return result;
    }

    public boolean matches(Ticket ticket, String fromAirport, String toAirport) {
        if (ticket.getDepartAirport().contains(fromAirport) && ticket.getArriveAirport().contains(toAirport)){
            return true;
        } else {
            return false;
        }
    }

}

