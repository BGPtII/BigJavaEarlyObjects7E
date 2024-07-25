package io.github.BGPtII.ch1introduction;

import java.util.Scanner;

/**
 * Decides the cheaper commute between the train or your car.
 * Canada centered - uses liters per 100km for fuel efficiency, cents per KM for the distance, cents per liter for
 * the gas price.
 * The train option assumes only a one-way ticket is needed to get to work on time.
 * Uses doubles for accuracy & precision when calculating costs.
 */
public class CheaperWorkCommuteCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the 1-way distance to your work in KM: ");
        if (scanner.hasNextDouble()) {
            double distance1Way = scanner.nextDouble();
            if (distance1Way > 0 && distance1Way < 1001) {
                System.out.print("Enter your car's fuel efficiency in liters per 100KM: ");
                if (scanner.hasNextDouble()) {
                    double carFuelEfficiency = scanner.nextDouble();
                    if (carFuelEfficiency > 0 && carFuelEfficiency < 51) {
                        System.out.print("Enter the cost of maintenance for your car in cents per KM: ");
                        if (scanner.hasNextDouble()) {
                            double maintenanceCost = scanner.nextDouble();
                            if (maintenanceCost > 0 && maintenanceCost <= 1) {
                                System.out.println("Enter the price of gas in cents per liter");
                                if (scanner.hasNextDouble()) {
                                    double gasCost = scanner.nextDouble();
                                    if (gasCost > 0 && gasCost < 1001) {
                                        System.out.print("Enter the price of a one-way train ticket: ");
                                        if (scanner.hasNextDouble()) {
                                            double trainTicketCost = scanner.nextDouble();
                                            if (trainTicketCost > 0 && trainTicketCost < 1001) {
                                                double carCommuteCost = ((distance1Way / 100) * carFuelEfficiency * gasCost) + (distance1Way * maintenanceCost);
                                                String fastestCommuteOption = (carCommuteCost > trainTicketCost) ? "the train" : "your car";
                                                System.out.println("Your best option would be to take " + fastestCommuteOption);
                                            }
                                            else {
                                                System.out.println("Unreasonable train ticket cost - range is 1-1000 inclusive.");
                                            }
                                        }
                                        else {
                                            System.out.println("Invalid input - whole/decimal numbers only.");
                                        }
                                    }
                                    else {
                                        System.out.println("Unreasonable price of gas - range is 1-1000 inclusive.");
                                    }
                                }
                                else {
                                    System.out.println("Invalid input - whole/decimal numbers only.");
                                }
                            }
                            else {
                                System.out.println("Unreasonable car maintenance - range is 0 (exclusive) to 1 (inclusive).");
                            }
                        }
                        else {
                            System.out.println("Invalid input - whole/decimal numbers only.");
                        }
                    }
                    else {
                        System.out.println("Unreasonable fuel efficiency - range is 1-50 inclusive.");
                    }
                }
                else {
                    System.out.println("Invalid input - whole/decimal numbers only.");
                }
            }
            else {
                System.out.println("Unreasonable distance - range is 1-1000 inclusive.");
            }
        }
        else {
            System.out.println("Invalid input - whole/decimal numbers only.");
        }
        scanner.close();
    }
}
