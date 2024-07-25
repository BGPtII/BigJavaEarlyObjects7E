package io.github.BGPtII.ch13recursion;

public class Rectangle {

    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Uses recursion & creates a smaller Rectangle with every iteration
     */
    public int getArea() {
        if (width < 1 || length < 1) {
            return 0;
        }
        Rectangle smallerRectangle = new Rectangle(width - 1, length - 1);
        return length - 1 + width + smallerRectangle.getArea();
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(5, 3);
        System.out.println("getArea() - Expected: 15, actual: " + rect1.getArea());
        Rectangle rect2 = new Rectangle(5, 0);
        System.out.println("getArea() - Expected: 0, actual: " + rect2.getArea());
        Rectangle rect3 = new Rectangle(-1, 5);
        System.out.println("getArea() - Expected: 0, actual: " + rect3.getArea());
        Rectangle rect4 = new Rectangle(6, 3);
        System.out.println("getArea() - Expected: 18, actual: " + rect4.getArea());
        Rectangle rect5 = new Rectangle(9, 5);
        System.out.println("getArea() - Expected: 45, actual: " + rect5.getArea());
    }

}
