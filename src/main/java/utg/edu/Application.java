package utg.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import utg.edu.model.bus.*;
import utg.edu.model.user.Role;
import utg.edu.model.user.User;
import utg.edu.repository.bus.*;
import utg.edu.repository.user.RoleRepository;
import utg.edu.repository.user.UserRepository;
import utg.edu.util.DateUtils;

import java.util.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, StopRepository stopRepository,
                           AgencyRepository agencyRepository, BusRepository busRepository, TripRepository tripRepository,
                           TripScheduleRepository tripScheduleRepository) {
        return args -> {
            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                adminRole = new Role("ADMIN");
                roleRepository.save(adminRole);
            }

            Role userRole = roleRepository.findByRole("PASSENGER");
            if (userRole == null) {
                userRole = new Role("PASSENGER");
                roleRepository.save(userRole);
            }

            User adminUser = userRepository.findByEmail("wakadrammeh@gmail.com");
            if (adminUser == null) {
                adminUser = new User()
                        .setEmail("wakadrammeh@gmail.com")
                        .setPassword("1234")
                        .setFirstName("Muhammed")
                        .setLastName("Drammeh")
                        .setMobileNumber("2205981679")
                        .setRoles(new HashSet<>(Arrays.asList(adminRole)));
                userRepository.save(adminUser);
            }

            Stop stopA = stopRepository.findByCode("STPA");
            if (stopA == null) {
                stopA = new Stop()
                        .setName("Stop A")
                        .setDetail("Near hills")
                        .setCode("STPA");
                stopRepository.save(stopA);
            }

            Stop stopB = stopRepository.findByCode("STPB");
            if (stopB == null) {
                stopB = new Stop()
                        .setName("Stop B")
                        .setDetail("Near river")
                        .setCode("STPB");
                stopRepository.save(stopB);
            }

            Stop stopC = stopRepository.findByCode("STPC");
            if (stopC == null) {
                stopC = new Stop()
                        .setName("Stop C")
                        .setDetail("Near desert")
                        .setCode("STPC");
                stopRepository.save(stopC);
            }

            Stop stopD = stopRepository.findByCode("STPD");
            if (stopD == null) {
                stopD = new Stop()
                        .setName("Stop D")
                        .setDetail("Near lake")
                        .setCode("STPD");
                stopRepository.save(stopD);
            }

            Agency agencyA = agencyRepository.findByCode("AGENCYA");
            if (agencyA == null) {
                agencyA = new Agency()
                        .setName("Green Mile Agency")
                        .setCode("AGENCYA")
                        .setDetails("Reaching destinations with ease")
                        .setOwner(adminUser);
                agencyRepository.save(agencyA);
            }

            Bus busA = busRepository.findByCode("AGENCYA-1");
            if (busA == null) {
                busA = new Bus()
                        .setCode("AGENCYA-1")
                        .setAgency(agencyA)
                        .setCapacity(60);
                busRepository.save(busA);
            }

            if (agencyA.getBuses() == null) {
                agencyA.setBuses(new HashSet<Bus>(Arrays.asList(busA)));
                agencyRepository.save(agencyA); // Update?
            }

            Trip trip = tripRepository.findBySourceStopAndDestStopAndBus(stopA, stopB, busA);
            if (trip == null) {
                trip = new Trip()
                        .setSourceStop(stopA)
                        .setDestStop(stopB)
                        .setBus(busA)
                        .setAgency(agencyA)
                        .setFare(100)
                        .setJourneyTime(60);
                tripRepository.save(trip);
            }

            TripSchedule tripSchedule = tripScheduleRepository.findByTripDetailAndTripDate(trip, DateUtils.todayStr());
            if (tripSchedule == null) {
                tripSchedule = new TripSchedule()
                        .setTripDetail(trip)
                        .setTripDate(DateUtils.todayStr())
                        .setAvailableSeats(trip.getBus().getCapacity());
                tripScheduleRepository.save(tripSchedule);
            }
        };
    }

}
