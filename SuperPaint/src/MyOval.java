import java.awt.*;

/**
 * MyOval
 * Description: SuperPaint Assignment
 * Draws oval shapes.
 *
 * @author Timothy Mui
 * @version Apr. 27, 2014
 */

public class MyOval extends MyBoundedShape {
    // constructor with no input values 
    public MyOval() {
        setX1(0); // set x coordinate of first endpoint
        setY1(0); // set y coordinate of first endpoint
        setX2(0); // set x coordinate of second endpoint
        setY2(0); // set y coordinate of second endpoint
        setColor(Color.BLACK); // set the color 
        setFilled(false); // set if the shape is filled.
    } // end MyOval constructor 

    // constructor with input values 
    public MyOval(int x1, int y1, int x2, int y2, Color color, Boolean filled) {
        setX1(x1); // set x coordinate of first endpoint
        setY1(y1); // set y coordinate of first endpoint
        setX2(x2); // set x coordinate of second endpoint
        setY2(y2); // set y coordinate of second endpoint
        setColor(color); // set the color 
        setFilled(filled); // set if the shape is filled.
    } // end MyOval constructor 

    // Method for drawing the shape 
    public void draw(Graphics g) {
        g.setColor(getColor());

        if (getFilled())
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

    } // end method draw 
} // end class MyOval
