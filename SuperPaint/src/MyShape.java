import java.awt.*;

/**
 * MyShape
 * Description: SuperPaint Assignment
 * Superclass for all shapes.
 *
 * @author Timothy Mui
 * @version Apr. 27, 2014
 */

public abstract class MyShape {
    // Instance Variables
    private int x1; // x coordinate of first endpoint 
    private int y1; // y coordinate of first endpoint 
    private int x2; // x coordinate of second endpoint 
    private int y2; // y coordinate of second endpoint 
    private Color myColor; // color of this shape 

    // constructor with no input values 
    MyShape() {
        this.x1 = 0; // set x coordinate of first endpoint 
        this.y1 = 0; // set y coordinate of first endpoint 
        this.x2 = 0; // set x coordinate of second endpoint 
        this.y2 = 0; // set y coordinate of second endpoint 
        myColor = Color.BLACK; // set the color 
    } // end MyShape constructor 

    // constructor with input values 
    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1; // set x coordinate of first endpoint 
        this.y1 = y1; // set y coordinate of first endpoint 
        this.x2 = x2; // set x coordinate of second endpoint 
        this.y2 = y2; // set y coordinate of second endpoint 
        myColor = color; // set the color 
    } // end MyShape constructor 

    // Mutator Methods ---------------------------------------------------------------------------------

    // Mutator method for first x coordinate
    void setX1(int x1) {
        this.x1 = x1; // set x coordinate of first endpoint 
    }

    // Mutator method for first y coordinate
    void setY1(int y1) {
        this.y1 = y1; // set y coordinate of first endpoint 
    }

    // Mutator method for second x coordinate
    public void setX2(int x2) {
        this.x2 = x2; // set x coordinate of second endpoint 
    }

    // Mutator method for second y coordinate
    public void setY2(int y2) {
        this.y2 = y2; // set y coordinate of second endpoint
    }

    // Mutator Method for the color of the shape
    void setColor(Color color) {
        myColor = color;
    }

    // End Mutator Methods

    // Accessor Methods ---------------------------------------------------------------------------------

    // Accessor method for the first x coordinate
    int getX1() {
        return x1;
    }

    // Accessor method for the first y coordinate
    int getY1() {
        return y1;
    }

    // Accessor method for the second x coordinate
    int getX2() {
        return x2;
    }

    // Accessor method for the second y coordinate
    int getY2() {
        return y2;
    }

    // Accessor method for the color of the shape
    Color getColor() {
        return myColor;
    }

    // End Accessor Methods

    // Abstract draw Method for outputing shapes.
    public abstract void draw(Graphics g);
}