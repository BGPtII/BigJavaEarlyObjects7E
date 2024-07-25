package io.github.BGPtII.ch3implementingclasses;

public class CarTempController {
    public static void main(String[] args) {
        RangeInput passengerSeatController = new RangeInput(60, 80);

        System.out.println("Passenger Seat Controller (expected: 70): actual " +
                passengerSeatController.getCurrentValue());
        System.out.println("Front Seat Controller (expected 70): actual " +
                passengerSeatController.getCurrentValue());

        for (int i = 0; i < 20; i++) {
            passengerSeatController.up();
        }
        System.out.println("After moving passenger seat controller up by 20 units:");
        System.out.println("Passenger Seat Controller (expected 80): actual "
                + passengerSeatController.getCurrentValue());

        for (int i = 0; i < 20; i++) {
            passengerSeatController.down();
        }
        System.out.println("After moving passenger seat controller down by 20 units:");
        System.out.println("Passenger Seat Controller (expected 60): actual "
                + passengerSeatController.getCurrentValue());
    }
}


