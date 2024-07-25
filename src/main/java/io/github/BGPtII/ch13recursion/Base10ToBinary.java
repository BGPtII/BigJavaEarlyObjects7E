package io.github.BGPtII.ch13recursion;

public class Base10ToBinary {

    public static String convertToBinary(double n) {
        if (n == 0.0) {
            return "0";
        }
        StringBuilder binaryString = new StringBuilder();
        if (n < 0) {
            binaryString.append("-");
        }

        String[] parts = Double.toString(Math.abs(n)).split("\\.");

        int wholePart = Integer.parseInt(parts[0]);
        binaryString.append(convertToBinaryHelper(wholePart));

        int decimalPart = Integer.parseInt(parts[1]);
        if (decimalPart != 0) {
            binaryString.append(".");
            binaryString.append(convertToBinaryHelper(decimalPart));
        }

        return binaryString.toString();
    }

    private static String convertToBinaryHelper(int n) {
        if (n == 0) {
            return "0";
        }
        else if (n == 1) {
            return "1";
        }
        return convertToBinaryHelper(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        System.out.println(convertToBinary(1));
        System.out.println(convertToBinary(0.0));
        System.out.println(convertToBinary(0));
        System.out.println(convertToBinary(25));
        System.out.println(convertToBinary(-34));
        System.out.println(convertToBinary(10.4));
        System.out.println(convertToBinary(-6.7));
    }

}
