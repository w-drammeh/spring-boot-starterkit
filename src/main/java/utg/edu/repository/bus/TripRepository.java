package utg.edu.repository.bus;

import utg.edu.model.bus.Agency;
import utg.edu.model.bus.Bus;
import utg.edu.model.bus.Stop;
import utg.edu.model.bus.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip, String> {

    Trip findBySourceStopAndDestStopAndBus(Stop source, Stop destination, Bus bus);

    List<Trip> findAllBySourceStopAndDestStop(Stop source, Stop destination);

    List<Trip> findByAgency(Agency agency);

}
