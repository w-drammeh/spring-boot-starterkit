package utg.edu.dto.mapper;

import utg.edu.dto.model.bus.TripScheduleDto;
import utg.edu.model.bus.Trip;
import utg.edu.model.bus.TripSchedule;

public class TripScheduleMapper {
    public static TripScheduleDto toTripScheduleDto(TripSchedule tripSchedule) {
        Trip tripDetails = tripSchedule.getTripDetail();
        return new TripScheduleDto()
                .setId(tripSchedule.getId())
                .setTripId(tripDetails.getId())
                .setBusCode(tripDetails.getBus().getCode())
                .setAvailableSeats(tripSchedule.getAvailableSeats())
                .setFare(tripDetails.getFare())
                .setJourneyTime(tripDetails.getJourneyTime())
                .setSourceStop(tripDetails.getSourceStop().getName())
                .setDestinationStop(tripDetails.getDestStop().getName());
    }

}
