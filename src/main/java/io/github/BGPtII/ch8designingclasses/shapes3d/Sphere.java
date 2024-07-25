package bigjavaearlyobjectsexercisesprojects.chaptereight.practiceexercises.shapes3d;

public class Sphere implements Shape3D {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3) ;
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
