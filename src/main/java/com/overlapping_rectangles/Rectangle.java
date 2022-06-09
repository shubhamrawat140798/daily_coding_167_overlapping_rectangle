package com.overlapping_rectangles;

public class Rectangle {
    final private int xCoordinate;
    final private int yCoordinate;
    final private int length;
    final private int breadth;
    Rectangle(final int xCoordinate,final int yCoordinate, final int length, final int breadth) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.length = length;
        this.breadth = breadth;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }
    public int getyCoordinate() {
        return yCoordinate;
    }
    public int getLength() {
        return length;
    }
    public int getBreadth() {
        return breadth;
    }

}
