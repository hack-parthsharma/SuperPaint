import java.awt.*;

/**
 * MyLine
 * Description: SuperPaint Assignment
 * Draws line shapes.
 *
 * @author Timothy Mui
 * @version Apr. 27, 2014
 */

public class MyLine extends MyShape {
    // constructor with no input values 
    public MyLine() {
        setX1(0); // set x coordinate of first endpoint
        setY1(0); // set y coordinate of first endpoint
        setX2(0); // set x coordinate of second endpoint
        setY2(0); // set y coordinate of second endpoint
        setColor(Color.BLACK); // set the color
    } // end MyLine constructor 

    // constructor with input values 
    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        setX1(x1); // set x coordinate of first endpoint
        setY1(y1); // set y coordinate of first endpoint
        setX2(x2); // set x coordinate of second endpoint
        setY2(y2); // set y coordinate of second endpoint
        setColor(color); // set the color
    } // end MyLine constructor 

    // Method for drawing the shape
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    } // end method draw 
} // end class MyLine
