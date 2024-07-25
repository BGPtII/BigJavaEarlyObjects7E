package io.github.BGPtII.ch13recursion;

public class Square {

    private int width;

    public Square(int width) {
        this.width = width;
    }

    public int getArea() {
        if (width < 1) {
            return 0;
        }
        Square smallerSquare = new Square(width - 1);
        return width + width - 1 + smallerSquare.getArea();
    }

    public static void main(String[] args) {
        Square square1 = new Square(5);
        System.out.println("getArea() - Expected: 25, actual: " + square1.getArea());
        Square square2 = new Square(-1);
        System.out.println("getArea() - Expected: 0, actual: " + square2.getArea());
        Square square3 = new Square(0);
        System.out.println("getArea() - Expected: 0, actual: " + square3.getArea());
        Square square4 = new Square(7);
        System.out.println("getArea() - Expected: 49, actual: " + square4.getArea());
        Square square5 = new Square(9);
        System.out.println("getArea() - Expected: 81, actual: " + square5.getArea());
    }

}
