package io.github.BGPtII.ch4fundamentaldatatypes;

public class IceCreamCone {
    private double radius;
    private double coneHeight;

    public IceCreamCone(double radius, double coneHeight) {
        this.radius = radius;
        this.coneHeight = coneHeight;
    }

    /**
     * Doesn't account for circle base of cone, as ice cream will be covering it
     * Assumes the ice cream sitting on the cone is half a sphere
     * @return surface area of the ice cream cone
     */
    public double getSurfaceArea() {
        return (Math.PI * radius * (radius + Math.sqrt(Math.pow(radius, 2) + Math.pow(coneHeight, 2)))) - (Math.PI * Math.pow(radius, 2)) // Cone surface area without the circle base
            + (4 * Math.PI * Math.pow(radius, 2) / 2); // Sphere surface area halved
    }

    /**
     * Assumes the cone is solid, ice cream is half a sphere
     * @return volume of the ice cream cone
     */
    public double getVolume() {
        return (Math.PI * Math.pow(radius, 2) * (coneHeight / 3)) // Cone volume
                + (((4 / 3.0) * Math.PI * Math.pow(radius, 3)) / 2); // Sphere volume
    }
}
