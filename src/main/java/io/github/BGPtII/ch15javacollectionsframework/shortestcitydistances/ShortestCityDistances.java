package bigjavaearlyobjectsexercisesprojects.chapterfifteen.programmingprojects.shortestcitydistances;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Gets the shortest distances from a specified city to the cities in an interconnected map.
 * Relies on an interconnected web of cities to function properly.
 */
public class ShortestCityDistances {

    private HashMap<String, HashSet<DistanceTo>> connections;

    /**
     *
     * @param connections a map of city names to their connected cities & respective distances; the web of interconnected cities
     */
    public ShortestCityDistances(HashMap<String, HashSet<DistanceTo>> connections) {
        if (connections == null || connections.isEmpty()) {
            throw new IllegalArgumentException("connections can't be null or blank.");
        }
        this.connections = connections;
    }

    /**
     * Finds the shortest distances to the interconnected cities in connections
     * @param cityFrom the city to start out from
     * @return a PriorityQueue with the other cities and the shorted distances to
     */
    public HashMap<String, Integer> getShortestKnownDistances(String cityFrom) {
        PriorityQueue<DistanceTo> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new DistanceTo(cityFrom, 0));
        HashMap<String, Integer> shortestKnownDistance = new HashMap<>();
        while (!priorityQueue.isEmpty()) {
            DistanceTo current = priorityQueue.poll();
            String currentCity = current.getTarget();
            int currentDistance = current.getDistance();
            if (!shortestKnownDistance.containsKey(current.getTarget())) {
                shortestKnownDistance.put(currentCity, currentDistance);
                for (DistanceTo neighbour : connections.get(currentCity)) {
                    int newDistance = currentDistance + neighbour.getDistance();
                    priorityQueue.add(new DistanceTo(neighbour.getTarget(), newDistance));
                }
            }
        }
        return shortestKnownDistance;
    }

}
