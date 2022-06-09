package com.overlapping_rectangles;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * for input from user.
 */
final class Main {
    /**
     * for taking input from user.
     * @param args for taking input from user.
     */
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Rectangle> listOfRectangle = new ArrayList<>();
            char choiceToContinue = 'y';
            while (choiceToContinue == 'y') {
                System.out.print("\n Enter x coordinate of rectangle: ");
                final int xCoordinate = scanner.nextInt();
                System.out.print("\n Enter y coordinate of rectangle: ");
                final int yCoordinate = scanner.nextInt();
                System.out.print("\n Enter length of rectangle: ");
                final int length = scanner.nextInt();
                System.out.print("\n Enter breadth of rectangle: ");
                final int breadth = scanner.nextInt();
                Rectangle rectangle
                        = new Rectangle(xCoordinate,
                        yCoordinate, length, breadth);
                listOfRectangle.add(rectangle);
                System.out.print("\n Do you want to continue? y/n: ");
                choiceToContinue = scanner.next().charAt(0);
                while (choiceToContinue != 'y' && choiceToContinue != 'n') {
                    System.out.println("Wrong Input " + choiceToContinue);
                    System.out.print("\n Do you want to continue? y/n: ");
                    choiceToContinue = scanner.next().charAt(0);
                }
            }
            for (Rectangle rectangle : listOfRectangle) {
                System.out.print("\nRectangle "
                        + (listOfRectangle.indexOf(rectangle) + 1));
                System.out.print("\nx: " + rectangle.getxCoordinate());
                System.out.print("\ny: " + rectangle.getyCoordinate());
                System.out.print("\nl: " + rectangle.getLength());
                System.out.print("\nb: " + rectangle.getBreadth());
            }
            if (listOfRectangle.size() > 1) {
                CheckRectanglesOverlap checkRectanglesOverlap
                        = new CheckRectanglesOverlap();
                System.out.println("\n Result : "
                        + checkRectanglesOverlap.checkrectangle(
                                listOfRectangle));
            } else {
                System.out.println(
                        "\nRectangle list contains only one rectangle");
            }
        } catch (InputMismatchException exception) {
            System.out.println("Input does not match. Enter Integer \n"
                    + exception);
        } catch (Exception exception) {
            System.out.println("exception occur: " + exception);
        }
    }
    private Main() {
        //Utility classes should not have a public or default constructor.
    }
}
