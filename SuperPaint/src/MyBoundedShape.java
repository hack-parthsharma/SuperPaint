import java.awt.*;

/**
 * MyBoundedShape
 * Description: SuperPaint Assignment
 * Superclass for shapes that are 2D (Bounded). Inherits from MyShape.
 *
 * @author Timothy Mui
 * @version Apr. 27, 2014
 */

public abstract class MyBoundedShape extends MyShape {
    // Instance variables
    private Boolean filled;

    // constructor with no input values 
    MyBoundedShape() {
        setX1(0); // set x coordinate of first endpoint
        setY1(0); // set y coordinate of first endpoint
        setX2(0); // set x coordinate of second endpoint
        setY2(0); // set y coordinate of second endpoint
        setColor(Color.BLACK); // set the color 
        this.filled = true;

    } // end MyBoundedShape constructor 

    // constructor with input values  
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, Boolean filled) {
        setX1(x1); // set x coordinate of first endpoint
        setY1(y1); // set y coordinate of first endpoint
        setX2(x2); // set x coordinate of second endpoint
        setY2(y2); // set y coordinate of second endpoint
        setColor(color); // set the color 
        this.filled = filled;
    } // end MyBoundedShape constructor 

    // Mutator Methods ---------------------------------------------------------------------------------

    // Mutator method for setting whether the shape is filled.
    void setFilled(boolean filled) {
        this.filled = filled;
    }

    // End Mutator Method

    // Accessor Methods ---------------------------------------------------------------------------------

    // Acessor method for filled. Returns the whether the shape is filled.
    boolean getFilled() {
        return filled;
    }

    // End Accessor Methods

    // Method to calculate the top left x coordinate from x1 and x2
    int getUpperLeftX() {
        return (getX1() > getX2()) ? getX2() : getX1();
    }

    // Method to calculate the top left y coordinate from y1 and y2
    int getUpperLeftY() {
        return (getY1() > getY2()) ? getY2() : getY1();
    }

    // Method to calculate the width of the bounded shape
    int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    // Method to calculate the height of the bounded shape
    int getHeight() {
        return Math.abs(getY1() - getY2());
    }
}