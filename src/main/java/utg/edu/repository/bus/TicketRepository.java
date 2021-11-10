package utg.edu.repository.bus;

import utg.edu.model.bus.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {

}
