package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.management;

import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.Passenger;
import bigjavaearlyobjectsexercisesprojects.chaptertwelve.programmingprojects.airlinepassengers.seating.*;

import java.util.ArrayList;
import java.util.List;

public class SeatingManager implements ReportHandling {

    private SectionManager sectionManager;

    public SeatingManager(SectionManager sectionManager) {
        this.sectionManager = sectionManager;
    }

    public List<Seat> findFirstContiguousAvailableSeats(SectionClass sectionClass, SeatingType seatingType, int amountOfContiguousSeats) {
        if (amountOfContiguousSeats < 1) {
            throw new IllegalArgumentException("amountOfContiguousSeats can't be < 1.");
        }
        List<Seat> contiguousAvailableSeats = new ArrayList<>();
        for (Section section : sectionManager.getSections()) {
            if (section.getSectionClass().equals(sectionClass)) {
                for (Row row : section.getRows()) {
                    for (RowPartition rowPartition : row.getRowPartitions()) {
                        if (rowPartition.getSeatingType() == seatingType && rowPartition.size() >= amountOfContiguousSeats) {
                            for (Seat seat : rowPartition.getSeats()) {
                                if (seat.isAvailable()) {
                                    contiguousAvailableSeats.add(seat);
                                    if (contiguousAvailableSeats.size() == amountOfContiguousSeats) {
                                        break;
                                    }
                                }
                                else {
                                    contiguousAvailableSeats.clear();
                                }
                            }
                            if (contiguousAvailableSeats.size() == amountOfContiguousSeats) {
                                return contiguousAvailableSeats;
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public boolean assignSeat(Passenger passenger) {
        List<Seat> seats = findFirstContiguousAvailableSeats(passenger.getSectionClass(), passenger.getSeatingType(), 1);
        if (seats.size() == 1) {
            seats.get(0).assignPassenger(passenger);
            return true;
        }
        return false;
    }

    public boolean assignContiguousPassengers(SectionClass sectionClass, SeatingType seatingType, Passenger... passengers) {
        for (Passenger passenger: passengers) {
            if (passenger.getSectionClass() != sectionClass) {
                throw new IllegalArgumentException("Passenger sectionClass must match the specified sectionClass.");
            }
            if (passenger.getSeatingType() != seatingType) {
                throw new IllegalArgumentException("Passenger seatingType must match the specified seatingType.");
            }
        }
        List<Seat> seats = findFirstContiguousAvailableSeats(sectionClass, seatingType, passengers.length);
        if (seats.size() != passengers.length) {
            return false;
        }
        for (int i = 0; i < seats.size(); i++) {
            seats.get(i).assignPassenger(passengers[i]);
        }
        return true;
    }

    @Override
    public String getReport() {
        StringBuilder seatsToAvailability = new StringBuilder();
        for (Section section : sectionManager.getSections()) {
            for (Row row : section.getRows()) {
                for (RowPartition rowPartition : row.getRowPartitions()) {
                    seatsToAvailability.append("{");
                    for (Seat seat : rowPartition.getSeats()) {
                        seatsToAvailability.append(" ");
                        String availabilityCharacter;
                        switch (seat.getSeatingAvailability()) {
                            case AVAILABLE -> availabilityCharacter = "A";
                            case OCCUPIED -> availabilityCharacter = "O";
                            case UNAVAILABLE -> availabilityCharacter = "U";
                            default ->  availabilityCharacter = "?";
                        }
                        seatsToAvailability.append(availabilityCharacter);
                    }
                    seatsToAvailability.append("}");
                }
                seatsToAvailability.append("\n");
            }
            seatsToAvailability.append("\n");
        }
        return seatsToAvailability.toString();
    }

}
