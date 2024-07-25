package io.github.BGPtII.ch15javacollectionsframework;

import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Driveway is in a last-in, first-out order.
 * When a car needs to be removed, the cars in front of it must be removed and temporarily park in the street
 * for that specified car to exit. Keeps track of the cars using Strings for the license plates.
 * Follows the Ontario, Canada license plate format for 6 or 7 characters that are alphanumeric.
 */
public class DrivewayCarParkOrganizer {

    private Stack<String> drivewayCars;
    private int drivewayCarsLimit;
    private Stack<String> streetCars; // Temporary so cars deeper in the drivewayCars stack can exit
    private Pattern licensePlatePattern = Pattern.compile("^[A-Z0-9]+$");

    public DrivewayCarParkOrganizer(int drivewayCarsLimit) {
        if (drivewayCarsLimit < 0) {
            throw new IllegalArgumentException("drivewayCarsLimit can't be < 0.");
        }
        drivewayCars = new Stack<>();
        streetCars = new Stack<>();
    }

    /**
     * @param drivewayCars the cars already present in the driveway
     * @param drivewayCarsLimit the limit of cars allowed in the driveway
     */
    public DrivewayCarParkOrganizer(Stack<String> drivewayCars, int drivewayCarsLimit) {
        if (drivewayCarsLimit < 0) {
            throw new IllegalArgumentException("drivewayCarsLimit can't be < 0.");
        }
        this.drivewayCars = drivewayCars;
    }

    /**
     * @param licensePlate the license plate as a String to remove
     * @return whether the removal was successful
     */
    public boolean removeCarFromDriveway(String licensePlate) {
        if (licensePlate.length() != 6 && licensePlate.length() != 7 && !licensePlatePattern.matcher(licensePlate).matches()) {
            throw new IllegalArgumentException("License plate must be 6 or 7 characters and capitalized alphanumeric.");
        }
        if (!drivewayCars.contains(licensePlate)) {
            return false;
        }
        while (!drivewayCars.peek().equals(licensePlate)) {
            streetCars.push(drivewayCars.pop());
        }
        streetCars.pop();
        while (!streetCars.isEmpty()) {
            drivewayCars.push(streetCars.pop());
        }
        return true;
    }

    /**
     * Does not accept duplicate license plate Strings
     * @param licensePlate the license plate as a String to add
     * @return whether the addition was successful
     */
    public boolean addCarToDriveway(String licensePlate) {
        if (licensePlate.length() != 6 && licensePlate.length() != 7 && !licensePlatePattern.matcher(licensePlate).matches()) {
            throw new IllegalArgumentException("License plate must be 6 or 7 characters and capitalized alphanumeric.");
        }
        if (drivewayCars.size() == drivewayCarsLimit || drivewayCars.contains(licensePlate)) {
            return false;
        }
        drivewayCars.push(licensePlate);
        return true;
    }

    public static void main(String[] args) {

    }

}
