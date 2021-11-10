package utg.edu.repository.bus;

import utg.edu.model.bus.Stop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StopRepository extends MongoRepository<Stop, String> {

    Stop findByCode(String code);

}
