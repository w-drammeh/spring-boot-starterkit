package utg.edu.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import utg.edu.model.user.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

    public Role findByRole(String role);

}
