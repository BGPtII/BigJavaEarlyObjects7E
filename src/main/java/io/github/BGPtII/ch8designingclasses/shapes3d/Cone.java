package bigjavaearlyobjectsexercisesprojects.chaptereight.practiceexercises.shapes3d;

public class Cone implements Shape3D {

    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double surfaceArea() {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }
}
