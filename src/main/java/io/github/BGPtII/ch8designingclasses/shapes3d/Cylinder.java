package bigjavaearlyobjectsexercisesprojects.chaptereight.practiceexercises.shapes3d;

public class Cylinder implements Shape3D {

    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2);
    }
}
