package utg.edu.repository.bus;

import utg.edu.model.bus.Agency;
import utg.edu.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgencyRepository extends MongoRepository<Agency, String> {
    Agency findByCode(String agencyCode);

    Agency findByOwner(User owner);

    Agency findByName(String name);

}
