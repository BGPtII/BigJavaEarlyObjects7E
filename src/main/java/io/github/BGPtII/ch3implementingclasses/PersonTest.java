package io.github.BGPtII.ch3implementingclasses;

public class PersonTest {
    public static void main(String[] args) {
        Person jason = new Person("Jason");
        Person fred = new Person("fred");
        Person jane = new Person("JaNeE");
        Person joe = new Person("Joe");

        joe.befriend(jane);
        joe.befriend(fred);
        joe.befriend(jason);
        System.out.println("joe.getFriendNames();");
        System.out.println("Expected: JaNeE fred Jason");
        System.out.println("Actual: " + joe.getFriendNames());
        System.out.println("joe.getFriendCount();");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + joe.getFriendCount() + "\n");

        joe.unfriend(fred);
        System.out.println("joe.getFriendNames();");
        System.out.println("Expected: jaNeE Jason");
        System.out.println("Actual: " + joe.getFriendNames());
        System.out.println("joe.getFriendCount();");
        System.out.println("Expected: 2");
        System.out.println("Actual: " + joe.getFriendCount());
    }
}
