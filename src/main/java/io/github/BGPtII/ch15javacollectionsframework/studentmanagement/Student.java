package bigjavaearlyobjectsexercisesprojects.chapterfifteen.programmingprojects.studentmanagement;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private static int nextID = 0;

    private int id;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("firstName & lastName can't be blank.");
        }
        id = nextID++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Student s) {
        int comparison = getLastName().compareTo(s.getLastName());
        if (comparison != 0) {
            return comparison;
        }
        comparison = getFirstName().compareTo(s.getFirstName());
        if (comparison != 0) {
            return comparison;
        }
        return Integer.compare(getId(), s.getId());
    }

    @Override
    public String toString() {
        return "Student{lastName='" + lastName + "',firstName='" + firstName + "',id=" + id + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student s = (Student) obj;
        return getId() == s.getId() && getFirstName().equals(s.getFirstName()) && getLastName().equals(s.getLastName());
    }
}
