package io.github.BGPtII.ch3implementingclasses;

public class Person {
    private String firstName;
    private String friends;

    public Person(String firstName) {
        this.firstName = firstName;
        friends = "";
    }

    public void befriend(Person p) {
        String friendName = p.getFirstName().toLowerCase();
        if (friends.toLowerCase().contains(friendName)) {
            System.out.println(p.getFirstName() + " already in friend list, unable to add.");
        }
        else {
            friends += friendName + " ";
        }
    }

    public void unfriend(Person p) {
        friends = friends.replace(p.getFirstName() + " ", "");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFriendNames() {
        return friends;
    }

    public int getFriendCount() {
        int count = 0;
        for (int i = 0; i < friends.length(); i++) {
            if (friends.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}
