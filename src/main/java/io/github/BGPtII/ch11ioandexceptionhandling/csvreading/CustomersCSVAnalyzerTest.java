package io.github.BGPtII.ch11ioandexceptionhandling.csvreading;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CustomersCSVAnalyzerTest {

    private CustomersCSVAnalyzer customersCSVAnalyzer = new CustomersCSVAnalyzer("src\\bigjavaearlyobjectsexercisesprojects\\chaptereleven\\programmingprojects\\customers.csv");

    public CustomersCSVAnalyzerTest() throws FileNotFoundException {

    }

    @Test
    public void testGetNumberOfRows() throws FileNotFoundException {
        assertEquals(101, customersCSVAnalyzer.getTotalRowCount());
    }

    @Test
    public void testGetRowAsString() throws FileNotFoundException {
        assertEquals("Index,Customer Id,First Name,Last Name,Company,City,Country,Phone 1,Phone 2,Message,Subscription Date,Website", customersCSVAnalyzer.getRowAsString(0));
        assertThrows(IllegalArgumentException.class, () -> customersCSVAnalyzer.getRowAsString(101));
    }

    @Test
    public void testGetNumberOfFields() throws FileNotFoundException {
        assertEquals(12, customersCSVAnalyzer.getNumberOfFieldsForRow(0));
    }

    @Test
    public void testGetFieldData() throws FileNotFoundException {
        assertEquals("2021-11-08", customersCSVAnalyzer.getFieldData(10, 10));
        assertThrows(IllegalArgumentException.class, () -> customersCSVAnalyzer.getFieldData(10, 13));
        assertThrows(IllegalArgumentException.class, () -> customersCSVAnalyzer.getFieldData(101, 4));
    }

    @Test
    public void testGetColumnFields() throws FileNotFoundException {
        String[] expectedOutput1 = {
                "Last Name", "Baxter", "Lozano", "Berry", "Olsen", "Bender", "Downs", "Peck", "Mullen", "Meyers",
                "Gallagher", "Schroeder", "Dodson", "Mata", "Cox", "Lutz", "Beasley", "Foley", "Mata", "Jacobson",
                "Kirk", "Frye", "Houston", "Howard", "Valenzuela", "Wilcox", "Moody", "Poole", "Harper", "Fitzpatrick",
                "Bradshaw", "Tate", "Trujillo", "Mejia", "Santana", "Moon", "Haley", "Sosa", "Gay", "Esparza",
                "Garza", "Gentry", "Dunn", "Simpson", "Greer", "Frost", "Montes", "Guzman", "Mccall", "Cohen",
                "Mccann", "Hawkins", "Crawford", "Goodwin", "Richard", "West", "Haas", "Maldonado", "Parrish", "Hill",
                "Hardy", "Pham", "Harris", "Jimenez", "Hutchinson", "Lynch", "Lambert", "Cannon", "Alvarado", "Dudley",
                "Good", "Buck", "Roth", "Keller", "Benson", "Stein", "Riddle", "Zuniga", "Mcmahon", "Pennington",
                "Blair", "Jennings", "Mckay", "Moreno", "Davidson", "Holt", "Cunningham", "Woods", "Vargas", "Kane",
                "Flowers", "Chavez", "Foley", "Ayers", "Young", "Douglas", "Greer", "Atkinson", "Guerra", "Farmer",
                "Haynes"
        };
        assertArrayEquals(expectedOutput1, customersCSVAnalyzer.getColumnFields(3));
        assertThrows(IllegalArgumentException.class, () -> customersCSVAnalyzer.getColumnFields(12));
    }

    @Test
    public void testGetColumnFieldHistogram() throws FileNotFoundException {
        assertThrows(IllegalArgumentException.class, () -> customersCSVAnalyzer.getColumnFieldHistogram(12));
        HashMap<String, Integer> expectedOutput1 = new HashMap<>() {
            {
                put("Myanmar", 1);
                put("Benin", 1);
                put("Cyprus", 1);
                put("Paraguay", 1);
                put("Portugal", 1);
                put("Oman", 2);
                put("New Caledonia", 1);
                put("Iceland", 1);
                put("Bahamas", 1);
                put("Solomon Islands", 4);
                put("Mozambique", 1);
                put("Iran", 1);
                put("Morocco", 1);
                put("Monaco", 1);
                put("Mali", 1);
                put("Panama", 1);
                put("Guyana", 1);
                put("Algeria", 1);
                put("Chile", 1);
                put("Antigua and Barbuda", 1);
                put("Western Sahara", 1);
                put("Ecuador", 1);
                put("Hungary", 1);
                put("Isle of Man", 1);
                put("Tanzania", 1);
                put("Slovakia (Slovak Republic)", 1);
                put("Belize", 1);
                put("Ghana", 1);
                put("Belarus", 2);
                put("Anguilla", 1);
                put("Lao People's Democratic Republic", 1);
                put("Albania", 1);
                put("Kyrgyz Republic", 1);
                put("New Zealand", 1);
                put("Canada", 2);
                put("Maldives", 1);
                put("Saint Barthelemy", 1);
                put("Namibia", 1);
                put("Country", 1);
                put("Palestinian Territory", 1);
                put("Honduras", 1);
                put("Ethiopia", 1);
                put("Yemen", 1);
                put("Russian Federation", 1);
                put("Singapore", 1);
                put("Fiji", 1);
                put("United States of America", 1);
                put("Sao Tome and Principe", 1);
                put("Madagascar", 1);
                put("Aruba", 1);
                put("Pitcairn Islands", 1);
                put("Bolivia", 1);
                put("Kiribati", 1);
                put("Malta", 1);
                put("Vietnam", 1);
                put("South Georgia and the South Sandwich Islands", 2);
                put("Netherlands", 2);
                put("Liechtenstein", 1);
                put("Poland", 1);
                put("United States Virgin Islands", 1);
                put("Bulgaria", 2);
                put("Lithuania", 1);
                put("Bosnia and Herzegovina", 1);
                put("Bhutan", 1);
                put("Togo", 2);
                put("Sri Lanka", 2);
                put("Uruguay", 1);
                put("Timor-Leste", 1);
                put("Uzbekistan", 1);
                put("French Southern Territories", 1);
                put("United Arab Emirates", 2);
                put("Switzerland", 1);
                put("French Polynesia", 1);
                put("Djibouti", 1);
                put("Liberia", 1);
                put("Burkina Faso", 1);
                put("Guernsey", 1);
                put("Saint Vincent and the Grenadines", 2);
                put("Swaziland", 1);
                put("Dominican Republic", 2);
                put("Denmark", 1);
                put("Zimbabwe", 2);
                put("Palau", 1);
                put("Micronesia", 1);
                put("Montenegro", 1);
                put("Dominica", 1);
            }
        };
        assertEquals(expectedOutput1, customersCSVAnalyzer.getColumnFieldHistogram(6));
    }

    @Test
    public void testGetRowIndexesContainingEarliestSubscription() throws FileNotFoundException, ParseException {
        ArrayList<Integer> expectedEarliestSubscriptionIndexes = new ArrayList<>() {
            {
                add(10);
            }
        };
        assertEquals(expectedEarliestSubscriptionIndexes, customersCSVAnalyzer.getRowIndexesContainingEarliestSubscription());
    }

    @Test
    public void testGetNameFrequency() throws FileNotFoundException {
        HashMap<String, Integer> expectedOutput1 = new HashMap<>() {
            {
                put("Downs", 1);
                put("Montes", 1);
                put("Buck", 1);
                put("Mata", 2);
                put("Moon", 1);
                put("Alvarado", 1);
                put("Mckay", 1);
                put("Pennington", 1);
                put("Trujillo", 1);
                put("Dunn", 1);
                put("Mccall", 1);
                put("Howard", 1);
                put("Kirk", 1);
                put("Peck", 1);
                put("Keller", 1);
                put("Hawkins", 1);
                put("Benson", 1);
                put("Mejia", 1);
                put("Berry", 1);
                put("Meyers", 1);
                put("Haas", 1);
                put("Lambert", 1);
                put("Poole", 1);
                put("Hutchinson", 1);
                put("Moody", 1);
                put("Douglas", 1);
                put("Riddle", 1);
                put("Gallagher", 1);
                put("Parrish", 1);
                put("Last Name", 1);
                put("Maldonado", 1);
                put("Vargas", 1);
                put("Moreno", 1);
                put("Haley", 1);
                put("Hill", 1);
                put("Valenzuela", 1);
                put("Jennings", 1);
                put("Lozano", 1);
                put("Goodwin", 1);
                put("Mccann", 1);
                put("Richard", 1);
                put("Cunningham", 1);
                put("Simpson", 1);
                put("Gentry", 1);
                put("Mcmahon", 1);
                put("Pham", 1);
                put("Guerra", 1);
                put("Beasley", 1);
                put("Harris", 1);
                put("Cox", 1);
                put("Harper", 1);
                put("Haynes", 1);
                put("Blair", 1);
                put("Farmer", 1);
                put("Guzman", 1);
                put("Zuniga", 1);
                put("Dodson", 1);
                put("Kane", 1);
                put("Bradshaw", 1);
                put("Chavez", 1);
                put("Foley", 2);
                put("Tate", 1);
                put("Bender", 1);
                put("Baxter", 1);
                put("Frost", 1);
                put("Olsen", 1);
                put("Roth", 1);
                put("Woods", 1);
                put("Gay", 1);
                put("Cannon", 1);
                put("Ayers", 1);
                put("Dudley", 1);
                put("Atkinson", 1);
                put("Garza", 1);
                put("Lutz", 1);
                put("Flowers", 1);
                put("Holt", 1);
                put("Santana", 1);
                put("Frye", 1);
                put("Esparza", 1);
                put("Schroeder", 1);
                put("Cohen", 1);
                put("Lynch", 1);
                put("Davidson", 1);
                put("Young", 1);
                put("Jimenez", 1);
                put("West", 1);
                put("Hardy", 1);
                put("Fitzpatrick", 1);
                put("Sosa", 1);
                put("Stein", 1);
                put("Crawford", 1);
                put("Mullen", 1);
                put("Greer", 2);
                put("Good", 1);
                put("Wilcox", 1);
                put("Jacobson", 1);
                put("Houston", 1);
            }
        };
        assertEquals(expectedOutput1, customersCSVAnalyzer.getNameFrequency(false));
        HashMap<String, Integer> expectedOutput2 = new HashMap<>() {
            {
                put("Michelle", 1);
                put("Shane", 2);
                put("Kathy", 1);
                put("Yvonne", 1);
                put("Ralph", 1);
                put("Alejandro", 1);
                put("Patricia", 1);
                put("Gerald", 1);
                put("Lynn", 2);
                put("Maxwell", 1);
                put("Colleen", 1);
                put("Stacie", 1);
                put("Gloria", 1);
                put("Danny", 1);
                put("Brady", 1);
                put("Samuel", 1);
                put("Collin", 1);
                put("Darren", 1);
                put("Stefanie", 1);
                put("Karl", 1);
                put("Joanna", 2);
                put("Joanne", 1);
                put("Eddie", 1);
                put("Shelley", 1);
                put("Alexandria", 1);
                put("Eileen", 1);
                put("Bryan", 1);
                put("Hunter", 1);
                put("Frederick", 1);
                put("Sherry", 2);
                put("Jenna", 1);
                put("Janet", 1);
                put("Carl", 1);
                put("Tammie", 1);
                put("Nicholas", 1);
                put("Rhonda", 1);
                put("Fred", 1);
                put("Clifford", 1);
                put("Caroline", 1);
                put("Laurie", 1);
                put("Wayne", 1);
                put("Marcus", 1);
                put("Tom", 2);
                put("Makayla", 1);
                put("Natalie", 1);
                put("Kaitlyn", 1);
                put("Luis", 1);
                put("Leslie", 1);
                put("Gabriel", 1);
                put("Roy", 1);
                put("Robin", 1);
                put("Virginia", 1);
                put("Debra", 1);
                put("Lori", 1);
                put("Tracey", 1);
                put("Aimee", 1);
                put("Miranda", 1);
                put("Kiara", 1);
                put("Darrell", 1);
                put("Preston", 1);
                put("Regina", 1);
                put("Chad", 1);
                put("Brittany", 1);
                put("Greg", 1);
                put("Phyllis", 1);
                put("Linda", 1);
                put("Clarence", 1);
                put("Candice", 1);
                put("Geoffrey", 1);
                put("Richard", 1);
                put("Alison", 1);
                put("Jack", 1);
                put("Jordan", 1);
                put("Riley", 1);
                put("Kathleen", 1);
                put("Brett", 1);
                put("Kent", 1);
                put("Latoya", 1);
                put("Faith", 2);
                put("Kristine", 1);
                put("Nina", 1);
                put("Anita", 1);
                put("Vernon", 1);
                put("Bruce", 1);
                put("Cassidy", 1);
                put("Duane", 1);
                put("Fernando", 1);
                put("Dakota", 1);
                put("Chloe", 1);
                put("Emma", 1);
                put("Sheryl", 2);
                put("Corey", 1);
                put("Kelli", 1);
            }
        };
        assertEquals(expectedOutput2, customersCSVAnalyzer.getNameFrequency(true));
    }

}
