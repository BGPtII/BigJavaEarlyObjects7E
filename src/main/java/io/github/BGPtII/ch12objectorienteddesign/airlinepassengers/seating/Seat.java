package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating;


import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.Passenger;

public class Seat {

    private SeatingAvailability seatingAvailability;
    private Passenger occupyingPassenger;

    public Seat(SeatingAvailability seatingAvailability) {
        this.seatingAvailability = seatingAvailability;
        occupyingPassenger = null;
    }

    public Seat() {
        seatingAvailability = SeatingAvailability.AVAILABLE;
    }

    public SeatingAvailability getSeatingAvailability() {
        return seatingAvailability;
    }

    public boolean isAvailable() {
        return seatingAvailability == SeatingAvailability.AVAILABLE;
    }

    public Passenger getOccupyingPassenger() {
        return occupyingPassenger;
    }

    public void removeAvailability() {
        seatingAvailability = SeatingAvailability.UNAVAILABLE;
    }

    public void assignPassenger(Passenger passenger) {
        this.occupyingPassenger = passenger;
        seatingAvailability = SeatingAvailability.OCCUPIED;
    }

    public void relinquishSeat() {
        occupyingPassenger = null;
        seatingAvailability = SeatingAvailability.AVAILABLE;
    }

}
