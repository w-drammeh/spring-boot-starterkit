package utg.edu.service;

import utg.edu.dto.model.bus.*;
import utg.edu.dto.model.user.UserDto;

import java.util.List;
import java.util.Set;

public interface BusReservationService {

    //Stop related methods
    Set<StopDto> getAllStops();

    StopDto getStopByCode(String stopCode);

    //Agency related methods
    AgencyDto getAgency(UserDto userDto);

    AgencyDto addAgency(AgencyDto agencyDto);

    AgencyDto updateAgency(AgencyDto agencyDto, BusDto busDto);

    //Trip related methods
    TripDto getTripById(String tripID);

    List<TripDto> addTrip(TripDto tripDto);

    List<TripDto> getAgencyTrips(String agencyCode);

    List<TripDto> getAvailableTripsBetweenStops(String sourceStopCode, String destinationStopCode);

    //Trips Schedule related methods
    List<TripScheduleDto> getAvailableTripSchedules(String sourceStopCode, String destinationStopCode, String tripDate);

    TripScheduleDto getTripSchedule(TripDto tripDto, String tripDate, boolean createSchedForTrip);

    //Ticket related method
    TicketDto bookTicket(TripScheduleDto tripScheduleDto, UserDto passenger);

}
