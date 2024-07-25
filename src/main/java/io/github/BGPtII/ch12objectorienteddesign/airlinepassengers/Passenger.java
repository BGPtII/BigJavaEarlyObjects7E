package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers;

import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating.SeatingType;
import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating.SectionClass;

public class Passenger {

    private SectionClass sectionClass;
    private SeatingType seatingType;
    private double amountOwed;

    public Passenger(SectionClass sectionClass, SeatingType seatingType) {
        this.sectionClass = sectionClass;
        this.seatingType = seatingType;
        this.amountOwed = 0;
    }

    public SectionClass getSectionClass() {
        return sectionClass;
    }

    public void setSectionClass(SectionClass sectionClass) {
        this.sectionClass = sectionClass;
    }

    public SeatingType getSeatingType() {
        return seatingType;
    }

    public void setSeatingType(SeatingType seatingType) {
        this.seatingType = seatingType;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void incrementAmountOwed(double amount) {
        amountOwed += amount;
    }

}
