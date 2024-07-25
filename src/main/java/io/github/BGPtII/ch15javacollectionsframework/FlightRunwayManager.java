package io.github.BGPtII.ch15javacollectionsframework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Simulates a runway with a takeoff queue and a landing queue. Only one plane can be on the runway at a time;
 * landing planes get priority of the runway over takeoff planes.
 */
public class FlightRunwayManager {

    private String runwayOccupiedBy;
    private Queue<String> takeoffQueue;
    private Queue<String> landingQueue;

    public FlightRunwayManager() {
        runwayOccupiedBy = "";
        takeoffQueue = new LinkedList<>();
        landingQueue = new LinkedList<>();
    }

    public void addToTakeoffQueue(String flightNumber) {
        takeoffQueue.add(flightNumber);
    }

    public void addToLandingQueue(String flightNumber) {
        landingQueue.add(flightNumber);
    }

    /**
     * Assigns the flight to the runway, landingQueue takes priority over takeoffQueue
     * @return "Occupied" if the runway is occupied, "No flights in queue" if both queues are empty,
     *         "Takeoff " or "Landing " with the flightNumber if the queues aren't empty
     */
    public String assignFlightToRunway() {
        if (!runwayOccupiedBy.isEmpty()) {
            return "Occupied";
        }
        if (takeoffQueue.isEmpty() && landingQueue.isEmpty()) {
            return "No flights in queue";
        }
        if (!landingQueue.isEmpty()) {
            runwayOccupiedBy = landingQueue.remove();
            return "Landing " + runwayOccupiedBy;
        }
        return "Takeoff " + takeoffQueue.remove();
    }

    public void clearRunway() {
        runwayOccupiedBy = "";
    }

}
