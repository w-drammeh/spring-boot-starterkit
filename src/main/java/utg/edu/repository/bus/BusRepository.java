package utg.edu.repository.bus;

import utg.edu.model.bus.Agency;
import utg.edu.model.bus.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, String> {

    Bus findByCode(String busCode);

    Bus findByCodeAndAgency(String busCode, Agency agency);

}
