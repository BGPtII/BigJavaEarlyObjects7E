package bigjavaearlyobjectsexercisesprojects.chapterfifteen.programmingprojects.shortestcitydistances;

/**
 * Stores the direct connection to a target city
 */
public class DistanceTo implements Comparable<DistanceTo> {

    private String target;
    private int distance;

    public DistanceTo(String city, int dist) {
        target = city;
        distance = dist;
    }

    public String getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(DistanceTo other) {
        return distance - other.distance;
    }

}
