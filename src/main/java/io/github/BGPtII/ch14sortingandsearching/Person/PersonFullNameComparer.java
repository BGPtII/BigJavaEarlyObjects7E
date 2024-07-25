package bigjavaearlyobjectsexercisesprojects.chapterfourteen.practiceexercises.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Prompts the user to input as many Person objects (first + last name) into an arraylist, then
 * compares their full names lexicographically
 */
public class PersonFullNameComparer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentFirstName = "";
        String currentLastName = "";
        ArrayList<Person> people = new ArrayList<>();
        System.out.println("Person Full Name Comparing (\"q\" to quit, \"f\" to finish entering names)");
        System.out.println("Enter as many people as you want; supply first & last names for each.");
        while (true) {
            if (currentFirstName.isEmpty()) {
                System.out.print("Enter the first name: ");
                String line = scanner.nextLine().trim();
                if (line.equals("q")) {
                    System.out.println("Quitting...");
                    scanner.close();
                    System.exit(1);
                }
                else if (line.equals("f")) {
                    System.out.println("Finished adding people!");
                    break;
                }
                else if (line.isEmpty()) {
                    System.out.println("First name can't be blank.");
                }
                else {
                    currentFirstName = line;
                }
            }
            else if (currentLastName.isEmpty()) {
                System.out.print("Enter the last name: ");
                String line = scanner.nextLine().trim();
                if (line.equals("q")) {
                    System.out.println("Quitting...");
                    scanner.close();
                    System.exit(1);
                }
                else if (line.equals("f")) {
                    System.out.println("Finished adding people!");
                    break;
                }
                else if (line.isEmpty()) {
                    System.out.println("Last name can't be blank.");
                }
                else {
                    currentLastName = line;
                }
            }
            else {
                people.add(new Person(currentFirstName, currentLastName));
                currentFirstName = "";
                currentLastName = "";
            }
        }
        if (people.isEmpty()) {
            System.out.println("People list is empty");
        }
        else {
            System.out.println(people);
            if (people.size() > 1) {
                System.out.println("Sorting...");
                Collections.sort(people);
                System.out.println(people);
                if (people.size() > 2) {
                    System.out.println("First person: " + people.get(0));
                    System.out.println("Last person: " + people.get(people.size() - 1));
                }
            }
        }
    }
    
}
