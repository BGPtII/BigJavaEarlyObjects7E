package bigjavaearlyobjectsexercisesprojects.chapterfourteen.practiceexercises.Country;

public class Country {

    private String name;
    private double area;

    /**
     *
     * @param name use format: Russia, Canada, Australia - Capitalized
     * @param area is in km^2
     */
    public Country(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "[ " + name + ", " + area + "]";
    }

}
