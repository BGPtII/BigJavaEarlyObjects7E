package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating;

import java.util.List;

/**
 * Used in Row to show separation between an aisle
 */
public class RowPartition {

    private List<Seat> seats;
    private SeatingType seatingType;

    public RowPartition(List<Seat> seats, SeatingType seatingType) {
        this.seats = seats;
        this.seatingType = seatingType;
    }

    public SeatingType getSeatingType() {
        return seatingType;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int size() {
        return seats.size();
    }

}
