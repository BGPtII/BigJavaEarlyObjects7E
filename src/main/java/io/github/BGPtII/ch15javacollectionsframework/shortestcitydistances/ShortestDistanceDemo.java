package bigjavaearlyobjectsexercisesprojects.chapterfifteen.programmingprojects.shortestcitydistances;

import java.util.HashMap;
import java.util.HashSet;

public class ShortestDistanceDemo {

    public static void main(String[] args) {
        HashMap<String, HashSet<DistanceTo>> connections = new HashMap<>() {
            {
                put("Pendleton", new HashSet<>() {
                    {
                        add(new DistanceTo("Pierre", 2));
                        add(new DistanceTo("Pueblo", 8));
                        add(new DistanceTo("Phoenix", 4));
                    }
                });
                put("Pierre", new HashSet<>() {
                    {
                        add(new DistanceTo("Pendleton", 2));
                        add(new DistanceTo("Pueblo", 3));
                    }
                });
                put("Pueblo", new HashSet<>() {
                    {
                        add(new DistanceTo("Pierre", 3));
                        add(new DistanceTo("Pendleton", 8));
                        add(new DistanceTo("Phoenix", 3));
                        add(new DistanceTo("Peoria", 3));
                    }
                });
                put("Phoenix", new HashSet<>() {
                    {
                        add(new DistanceTo("Pendleton", 4));
                        add(new DistanceTo("Pueblo", 3));
                        add(new DistanceTo("Peoria", 4));
                        add(new DistanceTo("Pittsburgh", 10));
                        add(new DistanceTo("Pensacola", 5));
                    }
                });
                put("Peoria", new HashSet<>() {
                    {
                        add(new DistanceTo("Pueblo", 3));
                        add(new DistanceTo("Phoenix", 4));
                        add(new DistanceTo("Pittsburgh", 5));
                    }
                });
                put("Pittsburgh", new HashSet<>() {
                    {
                        add(new DistanceTo("Peoria", 5));
                        add(new DistanceTo("Phoenix", 10));
                        add(new DistanceTo("Pensacola", 4));
                        add(new DistanceTo("Princeton", 2));
                    }
                });
                put("Pensacola", new HashSet<>() {
                    {
                        add(new DistanceTo("Phoenix", 5));
                        add(new DistanceTo("Pittsburgh", 4));
                        add(new DistanceTo("Princeton", 5));
                    }
                });
                put("Princeton", new HashSet<>() {
                    {
                        add(new DistanceTo("Pittsburgh", 2));
                        add(new DistanceTo("Pensacola", 5));
                    }
                });
            }
        };
        ShortestCityDistances shortestCityDistances = new ShortestCityDistances(connections);
        System.out.println("Shorted Distances From Pittsburgh");
        HashMap<String, Integer> shortestKnownDistances = shortestCityDistances.getShortestKnownDistances("Pittsburgh");
        for (String cityName : shortestKnownDistances.keySet()) {
            System.out.println(cityName + ": " + shortestKnownDistances.get(cityName));
        }
    }
}
