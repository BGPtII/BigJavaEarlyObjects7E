package bigjavaearlyobjectsexercisesprojects.chapterfourteen.practiceexercises.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2) {
        return Double.compare(c2.getArea(), c1.getArea());
    }

    // For testing purposes - Country area data supplied from https://www.worldometers.info/geography/largest-countries-in-the-world/
    public static void main(String[] args) {
        ArrayList<Country> countries = new ArrayList<>() {
            {
                add(new Country("Russia", 17098242));
                add(new Country("Kazakhstan", 2724900));
                add(new Country("Niger", 1267000));
                add(new Country("Algeria", 2381741));
                add(new Country("Spain", 505992));
                add(new Country("South Korea", 100210));
                add(new Country("Laos", 236800));
                add(new Country("Germany", 357114));
                add(new Country("Kenya", 580367));
                add(new Country("China", 9706961));
                add(new Country("Caribbean Netherlands", 328));
            }
        };
        System.out.println(countries);
        System.out.println("Sorting using countries.sort using the CountryComparator...");
        countries.sort(new CountryComparator());
        System.out.println(countries);
    }

}
