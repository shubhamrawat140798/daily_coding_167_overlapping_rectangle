package com.overlapping_rectangles;

import java.util.List;

/**
 * for checking list of rectangle is overlapping.
 */
 class CheckRectanglesOverlap {
    /**
     * for checking list of rectangle is overlapping.
     * @param rectangleList list of rectangle coordinates and dimensions
     * @return true or false whether rectangle is overlapping.
     */
    public boolean checkrectangle(final List<Rectangle> rectangleList) {
        boolean overlapp = false;
        for (int firstRectangle = 0; firstRectangle < rectangleList.size() - 1; firstRectangle++) {
            for (int secondRectangle = firstRectangle + 1; secondRectangle < rectangleList.size(); secondRectangle++) {
                final int firstTopLeftXCoordinate = rectangleList.get(firstRectangle).getxCoordinate();
                final int firstTopLeftYCoordinate = rectangleList.get(firstRectangle).getyCoordinate();
                final int firstBottomRightXCoordinate = rectangleList.get(firstRectangle).getxCoordinate() + rectangleList.get(firstRectangle).getLength();
                final int firstBottomRightYCoordinate = rectangleList.get(firstRectangle).getyCoordinate() - rectangleList.get(firstRectangle).getBreadth();
                final int secondTopLeftXCoordinate = rectangleList.get(secondRectangle).getxCoordinate();
                final int secondTopLeftYCoordinate = rectangleList.get(secondRectangle).getyCoordinate();
                final int secondBottomRightXCoordinate = rectangleList.get(secondRectangle).getxCoordinate() + rectangleList.get(secondRectangle).getLength();
                final int secondBottomRightYCoordinate = rectangleList.get(secondRectangle).getyCoordinate() - rectangleList.get(secondRectangle).getBreadth();
               overlapp = doOverlap(firstTopLeftXCoordinate,firstTopLeftYCoordinate,firstBottomRightXCoordinate,firstBottomRightYCoordinate,secondTopLeftXCoordinate,secondTopLeftYCoordinate,secondBottomRightXCoordinate,secondBottomRightYCoordinate);
               if (overlapp == true){
                   return true;
               }
            }
        }
        return false;
    }

    /**
     * helper method for checking two rectangles.
     * @param firstTopLeftXCoordinate first Top Left X Coordinate.
     * @param firstTopLeftYCoordinate first Top Left Y Coordinate.
     * @param firstBottomRightXCoordinate first Bottom Right X Coordinate.
     * @param firstBottomRightYCoordinate first Bottom Right Y Coordinate.
     * @param secondTopLeftXCoordinate second Top Left X Coordinate.
     * @param secondTopLeftYCoordinate second Top Left Y Coordinate.
     * @param secondBottomRightXCoordinate second Bottom Right X Coordinate.
     * @param secondBottomRightYCoordinate second Bottom Right Y Coordinate.
     * @return
     */
    private boolean doOverlap(final int firstTopLeftXCoordinate,final int firstTopLeftYCoordinate,final int firstBottomRightXCoordinate, final int firstBottomRightYCoordinate,final int secondTopLeftXCoordinate, final int secondTopLeftYCoordinate,final int secondBottomRightXCoordinate, final int secondBottomRightYCoordinate) {
        if (firstTopLeftXCoordinate == firstBottomRightXCoordinate || firstTopLeftYCoordinate == firstBottomRightYCoordinate || secondTopLeftXCoordinate == secondBottomRightXCoordinate || secondTopLeftYCoordinate == secondBottomRightYCoordinate)
        {
            // the line cannot have positive overlap
            return false;
        }


        // If one rectangle is on left side of other
        if (firstTopLeftXCoordinate >= secondBottomRightXCoordinate || secondTopLeftXCoordinate >= firstBottomRightXCoordinate) {
            return false;
        }

        // If one rectangle is above other
        if (firstBottomRightYCoordinate >= secondTopLeftYCoordinate || secondBottomRightYCoordinate >= firstTopLeftYCoordinate) {
            return false;
        }

        return true;
    }
}
