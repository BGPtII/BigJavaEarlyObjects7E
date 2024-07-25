package io.github.BGPtII.ch4fundamentaldatatypes;

public class BalloonTest {
    public static void main(String[] args) {
        Balloon testBalloon = new Balloon();
        System.out.println("Adding 100cm^3 of air...");
        testBalloon.addAir(100);
        System.out.println("Volume: Expected: 100.0, Actual: " + testBalloon.getVolume());
        System.out.println("Surface area: Expected: 104.23, Actual: " + testBalloon.getSurfaceArea());
        System.out.println("Radius: Expected: 2.88, Actual: " + testBalloon.getRadius() + "\n");

        System.out.println("Adding another 100cm^3 of air...");
        testBalloon.addAir(100);
        System.out.println("Volume: Expected: 200, Actual: " + testBalloon.getVolume());
        System.out.println("Surface area: Expected: 165.59, Actual: " + testBalloon.getSurfaceArea());
        System.out.println("Radius: Expected: 3.63, Actual: " + testBalloon.getRadius() + "\n");
    }
}
