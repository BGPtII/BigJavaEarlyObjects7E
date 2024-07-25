package io.github.BGPtII.ch5decisions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Units available: fl. oz, gal, oz, lb, in, ft, mi, ml, l, g, kg, mm, cm, m, km
 * Conversions only work with compatible units (mass -> mass, capacity -> capacity, length -> length)
 * Unit conversion types: mass (oz, lb, g, kg), capacity (fl. oz, gal, ml, l), length (in, ft, mi, mm, cm, m, km)
 * CONVERSION RATES PROVIDED BY GOOGLE
 */
public class UnitConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String unitFrom = "";
        String unitTo = "";
        double valueToConvert = 0;

        // Arrays for the grouping of valid units
        String[] massUnits = { "oz", "lb", "g", "kg" };
        String[] capacityUnits = { "fl. oz", "gal", "ml", "l" };
        String[] lengthUnits = { "in", "ft", "mi", "mm", "cm", "m", "km" };
        String[] units = { "oz", "lb", "g", "kg", "fl. oz", "gal", "ml", "l", "in", "ft", "mi", "mm", "cm", "m", "km" }; // Array of all valid units

        System.out.println("Unit Converter (\"q\" to quit during any of the prompts)");
        System.out.println("Unit options: mass (oz, lb, g, kg), capacity (fl. oz, gal, ml, l), length (in, ft, mi, mm, cm, m, km)");
        System.out.println("CASE SENSITIVE, user must type units as they exactly appear above.");
        while (unitFrom.equals("") || unitTo.equals("") || valueToConvert == 0) {
            // Handle unitFrom String
            if (unitFrom.equals("")) {
                System.out.print("Convert from: ");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.exit(0);
                }
                else if (Arrays.asList(units).contains(input)) {
                    unitFrom = input;
                }
                else {
                    System.out.println("Invalid unit type. Options for: mass (oz, lb, g, kg), capacity (fl. oz, gal, ml, l), length (in, ft, mi, mm, cm, m, km).");
                }
            }
            // Handle unitTo String
            else if (unitTo.equals("")) {
                System.out.print("Convert to: ");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.exit(0);
                }
                else if (input.equals(unitFrom)) {
                    System.out.println("Can't convert from & to the same unit.");
                }
                else if (Arrays.asList(units).contains(input)) {
                    if (Arrays.asList(massUnits).contains(unitFrom)) {
                        if (Arrays.asList(massUnits).contains(input)) {
                            unitTo = input;
                        }
                        else {
                            System.out.println("Invalid conversion - mass units: oz, lb, g, kg");
                        }
                    }
                    else if (Arrays.asList(capacityUnits).contains(unitFrom)) {
                        if (Arrays.asList(capacityUnits).contains(input)) {
                            unitTo = input;
                        }
                        else {
                            System.out.println("Invalid conversion - capacity units: fl. oz, gal, ml, l");
                        }
                    }
                    else if (Arrays.asList(lengthUnits).contains(unitFrom)) {
                        if (Arrays.asList(lengthUnits).contains(input)) {
                            unitTo = input;
                        }
                        else {
                            System.out.println("Invalid conversion - length units: in, ft, mi, mm, cm, m, km");
                        }
                    }
                }
                else {
                    System.out.println("Invalid unit type. Options: mass (oz, lb, g, kg), capacity (fl. oz, gal, ml, l), length (in, ft, mi, mm, cm, m, km).");
                }
            }
            else if (valueToConvert == 0) {
                System.out.print("Value? ");
                if (scanner.hasNextDouble()) {
                    valueToConvert = scanner.nextDouble();
                }
                else {
                    System.out.println("Invalid input, numbers only (decimal & integer) that ISN'T 0.");
                    scanner.nextLine();
                }
            }
        }

        double conversionRate = 0;
        // Handle capacity conversion - fl. oz, gal, ml, l
        if (unitFrom.equals("fl. oz")) {
            if (unitTo.equals("gal")) {
                conversionRate = 0.0078125;
            }
            else if (unitTo.equals("ml")) {
                conversionRate = 29.5735;
            }
            else if (unitTo.equals("l")) {
                conversionRate = 0.0295735;
            }
        }
        else if (unitFrom.equals("gal")) {
            if (unitTo.equals("fl. oz")) {
                conversionRate = 128;
            }
            else if (unitTo.equals("ml")) {
                conversionRate = 3785.41;
            }
            else if (unitTo.equals("l")) {
                conversionRate = 3.78541;
            }
        }
        else if (unitFrom.equals("ml")) {
            if (unitTo.equals("fl. oz")) {
                conversionRate = 0.033814;
            }
            else if (unitTo.equals("gal")) {
                conversionRate = 0.000264172;
            }
            else if (unitTo.equals("l")) {
                conversionRate = 0.001;
            }
        }
        else if (unitFrom.equals("l")) {
            if (unitTo.equals("fl. oz")) {
                conversionRate = 33.814;
            }
            else if (unitTo.equals("ml")) {
                conversionRate = 1000;
            }
            else if (unitTo.equals("gal")) {
                conversionRate = 0.264172;
            }
        }
        // Handle mass conversion - oz, lb, g, kg
        else if (unitFrom.equals("oz")) {
            if (unitTo.equals("lb")) {
                conversionRate = 0.0625;
            }
            else if (unitTo.equals("g")) {
                conversionRate = 28.3495;
            }
            else if (unitTo.equals("kg")) {
                conversionRate = 0.0283495;
            }
        }
        else if (unitFrom.equals("lb")) {
            if (unitTo.equals("oz")) {
                conversionRate = 16;
            }
            else if (unitTo.equals("g")) {
                conversionRate = 453.592;
            }
            else if (unitTo.equals("kg")) {
                conversionRate = 0.453592;
            }
        }
        else if (unitFrom.equals("g")) {
            if (unitTo.equals("lb")) {
                conversionRate = 0.00220462;
            }
            else if (unitTo.equals("oz")) {
                conversionRate = 0.035274;
            }
            else if (unitTo.equals("kg")) {
                conversionRate = 0.001;
            }
        }
        else if (unitFrom.equals("kg")) {
            if (unitTo.equals("lb")) {
                conversionRate = 2.20462;
            }
            else if (unitTo.equals("g")) {
                conversionRate = 1000;
            }
            else if (unitTo.equals("oz")) {
                conversionRate = 35.274;
            }
        }
        // Handle length conversion - in, ft, mi, mm, cm, m, km
        else if (unitFrom.equals("in")) {
            if (unitTo.equals("ft")) {
                conversionRate = 0.0833333;
            }
            else if (unitTo.equals("mi")) {
                conversionRate = 0.0000157828;
            }
            else if (unitTo.equals("mm")) {
                conversionRate = 25.4;
            }
            else if (unitTo.equals("cm")) {
                conversionRate = 2.54;
            }
            else if (unitTo.equals("m")) {
                conversionRate = 0.0254;
            }
            else if (unitTo.equals("km")) {
                conversionRate = 0.0000254;
            }
        }
        else if (unitFrom.equals("ft")) {
            if (unitTo.equals("in")) {
                conversionRate = 12;
            }
            else if (unitTo.equals("mi")) {
                conversionRate = 0.000189394;
            }
            else if (unitTo.equals("mm")) {
                conversionRate = 304.8;
            }
            else if (unitTo.equals("cm")) {
                conversionRate = 30.48;
            }
            else if (unitTo.equals("m")) {
                conversionRate = 0.3048;
            }
            else if (unitTo.equals("km")) {
                conversionRate = 0.0003048;
            }
        }
        else if (unitFrom.equals("mi")) {
            if (unitTo.equals("ft")) {
                conversionRate = 5280;
            }
            else if (unitTo.equals("in")) {
                conversionRate = 63360;
            }
            else if (unitTo.equals("mm")) {
                conversionRate = 1609344;
            }
            else if (unitTo.equals("cm")) {
                conversionRate = 160934;
            }
            else if (unitTo.equals("m")) {
                conversionRate = 1609.3400007802;
            }
            else if (unitTo.equals("km")) {
                conversionRate = 1.60934;
            }
        }
        else if (unitFrom.equals("mm")) {
            if (unitTo.equals("ft")) {
                conversionRate = 0.00328084;
            }
            else if (unitTo.equals("mi")) {
                conversionRate = 0.000000621371;
            }
            else if (unitTo.equals("in")) {
                conversionRate = 0.0393701;
            }
            else if (unitTo.equals("cm")) {
                conversionRate = 0.1;
            }
            else if (unitTo.equals("m")) {
                conversionRate = 0.001;
            }
            else if (unitTo.equals("km")) {
                conversionRate = 0.000001;
            }
        }
        else if (unitFrom.equals("cm")) {
            if (unitTo.equals("ft")) {
                conversionRate = 0.0328084;
            }
            else if (unitTo.equals("mi")) {
                conversionRate = 0.00000621371;
            }
            else if (unitTo.equals("mm")) {
                conversionRate = 10;
            }
            else if (unitTo.equals("in")) {
                conversionRate = 0.393701;
            }
            else if (unitTo.equals("m")) {
                conversionRate = 0.01;
            }
            else if (unitTo.equals("km")) {
                conversionRate = 0.00001;
            }
        }
        else if (unitFrom.equals("m")) {
            if (unitTo.equals("ft")) {
                conversionRate = 3.28084;
            }
            else if (unitTo.equals("mi")) {
                conversionRate = 0.000621371;
            }
            else if (unitTo.equals("mm")) {
                conversionRate = 1000;
            }
            else if (unitTo.equals("cm")) {
                conversionRate = 100;
            }
            else if (unitTo.equals("in")) {
                conversionRate = 39.3701;
            }
            else if (unitTo.equals("km")) {
                conversionRate = 0.001;
            }
        }
        else if (unitFrom.equals("km")) {
            if (unitTo.equals("ft")) {
                conversionRate = 3280.84;
            }
            else if (unitTo.equals("mi")) {
                conversionRate = 0.621371;
            }
            else if (unitTo.equals("mm")) {
                conversionRate = 1000000;
            }
            else if (unitTo.equals("cm")) {
                conversionRate = 100000;
            }
            else if (unitTo.equals("m")) {
                conversionRate = 1000;
            }
            else if (unitTo.equals("in")) {
                conversionRate = 39370.1;
            }
        }

        double convertedValue = valueToConvert * conversionRate;
        System.out.println(valueToConvert + " " + unitFrom + " = " + convertedValue + " " + unitTo);
    }
}
