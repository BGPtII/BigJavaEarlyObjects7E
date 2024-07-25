package io.github.BGPtII.ch10interfaces;

public class Person implements Measurable, Comparable<Person> {

    private String name;
    private double heightCM;

    public Person(String name, double heightCM) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name can't be empty.");
        }
        else if (heightCM <= 0) {
            throw new IllegalArgumentException("height must be greater than 0.");
        }
        this.name = name;
        this.heightCM = heightCM;
    }

    @Override
    public double getMeasure() {
        return heightCM;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
}
