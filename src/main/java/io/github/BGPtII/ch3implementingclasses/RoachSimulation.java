package io.github.BGPtII.ch3implementingclasses;

public class RoachSimulation {
    public static void main(String[] args) {
        RoachPopulation tenRoachStart = new RoachPopulation(10);

        System.out.println("Breed");
        tenRoachStart.breed();
        System.out.println("Expected: 20");
        System.out.println("Actual: " + tenRoachStart.getRoaches());
        System.out.println("Spray for 10%");
        tenRoachStart.spray(10);
        System.out.println("Expected: 18");
        System.out.println("Actual: " + tenRoachStart.getRoaches() + "\n");

        System.out.println("Breed");
        tenRoachStart.breed();
        System.out.println("Expected: 36");
        System.out.println("Actual: " + tenRoachStart.getRoaches());
        System.out.println("Spray for 10%");
        tenRoachStart.spray(10);
        System.out.println("Expected: 32");
        System.out.println("Actual: " + tenRoachStart.getRoaches() + "\n");

        System.out.println("Breed");
        tenRoachStart.breed();
        System.out.println("Expected: 64");
        System.out.println("Actual: " + tenRoachStart.getRoaches());
        System.out.println("Spray for 10%");
        tenRoachStart.spray(10);
        System.out.println("Expected: 58");
        System.out.println("Actual: " + tenRoachStart.getRoaches() + "\n");

        System.out.println("Breed");
        tenRoachStart.breed();
        System.out.println("Expected: 116");
        System.out.println("Actual: " + tenRoachStart.getRoaches());
        System.out.println("Spray for 10%");
        tenRoachStart.spray(10);
        System.out.println("Expected: 104");
        System.out.println("Actual: " + tenRoachStart.getRoaches() + "\n");
    }
}
