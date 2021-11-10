package utg.edu.repository.bus;

import utg.edu.model.bus.Trip;
import utg.edu.model.bus.TripSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripScheduleRepository extends MongoRepository<TripSchedule, String> {

    TripSchedule findByTripDetailAndTripDate(Trip tripDetail, String tripDate);

}
