package io.github.BGPtII.ch15javacollectionsframework;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListUtil {

    /**
     * Removes every nth string in a string LinkedList
     * @param strings the string LinkedList
     * @param n the index of the string to be removed - is re-occurring
     */
    public static void downsize(LinkedList<String> strings, int n) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("strings LinkedList must contain at least 1 element.");
        }
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        ListIterator<String> iterator = strings.listIterator();
        int i = 1;
        while (iterator.hasNext()) {
            iterator.next();
            if (i % n == 0) {
                iterator.remove();
            }
            i++;
        }
    }

    public static void reverse(LinkedList<String> strings) {
        int i = strings.size();
        int pos = 0;
        while (i-- > 1) {
            String s = strings.removeLast();
            strings.add(pos++, s);
        }
    }

    // For testing purposes
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>() {
            {
                add("Bob");
                add("Samantha");
                add("Jim");
                add("Rachel");
                add("Batman");
                add("Vader");
                add("Carson");
                add("Kim");
                add("Samantha");
                add("Luigi");
            }
        };
        System.out.println(names);
        downsize(names, 2);
        System.out.println("After downsize(names, 2): " + names);
        System.out.println();

        LinkedList<String> favouriteFoods = new LinkedList<>() {
            {
                add("Cheese");
                add("Lasagna");
                add("Spaghetti");
                add("Oatmeal");
                add("Raisins");
                add("Chocolate");
                add("Candy");
                add("Peanuts");
                add("Horseradish");
                add("Dandelions");
            }
        };
        System.out.println(favouriteFoods);
        reverse(favouriteFoods);
        System.out.println("After reverse(favouriteFoods): " + favouriteFoods);
    }

}
