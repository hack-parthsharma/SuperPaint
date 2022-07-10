import javax.swing.*;

/**
 * TestDraw
 * Description: SuperPaint Assignment
 * TestDraw for SuperPaint. Instantiates GUI.
 *
 * @author Timothy Mui
 * @version Apr. 27, 2014
 */

public class TestDraw {
    public static void main(String[] args) {
        DrawFrame drawFrame = new DrawFrame();  // new DrawFrame object
        drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawFrame.setSize(600, 600); // set frame size
        drawFrame.setVisible(true); // display frame
    } // end main 
} // end class TestDraw