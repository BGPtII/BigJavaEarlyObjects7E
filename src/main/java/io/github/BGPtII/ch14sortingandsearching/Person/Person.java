package bigjavaearlyobjectsexercisesprojects.chapterfourteen.practiceexercises.Person;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;

    /**
     *
     * @param firstName formatted with the first letter being capitalized; EX: Samantha, Sally
     * @param lastName formatted with the first letter being capitalized; EX: Christopher, Rogers
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public int compareTo(Person o) {
        return getFullName().replace(" ", "").toLowerCase().compareTo(o.getFullName().replace(" ", "").toLowerCase());
    }

    @Override
    public String toString() {
        return "[" + getFullName() + "]";
    }

}
