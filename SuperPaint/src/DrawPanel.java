import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * DrawPanel
 * Description: SuperPaint Assignment
 * DrawPanel for SuperPaint. Instantiates all shapes generated in subclasses.
 *
 * @author Timothy Mui
 * @version Apr. 27, 2014
 */

public class DrawPanel extends JPanel {
    // ------Instance Variables------
    private final ArrayList<MyShape> shapeObjects = new ArrayList<MyShape>(); // ArrayList to store shape objects
    private int currentShapeType; // O- line, 1- rectangle, 2- oval
    private MyShape currentShapeObject;
    private Color currentShapeColor;
    private boolean currentShapeFilled;
    private final JLabel statusLabel;
    private MyShape clearedObject;

    // ------ Constructor ------
    public DrawPanel(JLabel label) {
        statusLabel = label;
        currentShapeType = 0;
        currentShapeColor = Color.BLACK;
        currentShapeFilled = false;

        setBackground(Color.WHITE);

        // Mouse Handler
        MouseHandler mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);

    } // end DrawPanel 

    // ------ Handler ------
    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            // Line
            if (currentShapeType == 0) {
                currentShapeObject = new MyLine(event.getX(), event.getY(),
                        event.getX(), event.getY(), currentShapeColor);
            }
            // Rectangle
            else if (currentShapeType == 1) {
                currentShapeObject = new MyRectangle(event.getX(), event.getY(),
                        event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
            }
            // Oval
            else if (currentShapeType == 2) {
                currentShapeObject = new MyOval(event.getX(), event.getY(),
                        event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
            }


        } // end method mousePressed 


        public void mouseReleased(MouseEvent event) {
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());

            shapeObjects.add(currentShapeObject);

            currentShapeObject = null;

            repaint();
        } // end method mouseReleased 

        public void mouseMoved(MouseEvent event) {
            statusLabel.setText(String.format("(%d,%d)", event.getX(), event.getY()));
        } // end method mouseMoved

        public void mouseDragged(MouseEvent event) {
            //sets currentShapeObject x2 & y2
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());

            repaint();

            statusLabel.setText(String.format("(%d,%d)", event.getX(), event.getY()));
        } // end method mouseDragged

    } // end private inner class MouseCHandler


    // ------ Accessor Methods ------
    public int getCurrentShapeType() {
        return currentShapeType;
    }

    public Color getCurrentShapeColor() {
        return currentShapeColor;
    }

    public Boolean getCurrentShapeFilled() {
        return currentShapeFilled;
    }

    // ------ Mutator Methods ------
    public void setCurrentShapeType(int type) {
        currentShapeType = type;
    }

    public void setCurrentShapeColor(Color color) {
        currentShapeColor = color;
    }

    public void setCurrentShapeFilled(Boolean filled) {
        currentShapeFilled = filled;
    }

    // ------ Other Methods ------
    public void clearLastShape() { // Clears last shape
        if (!(shapeObjects.isEmpty())) {
            clearedObject = shapeObjects.get(shapeObjects.size() - 1);
            shapeObjects.remove(shapeObjects.size() - 1);
        }
        repaint();
    }

    public void redoLastShape() { // Redos last shape
        if (clearedObject != null) {
            shapeObjects.add(clearedObject);
            clearedObject = null;
        }
        repaint();
    }

    public void clearDrawing() { // Clears drawing
        shapeObjects.clear();
        repaint();
    }

    // ------ paintComponent ------
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the shapes 
        for (MyShape shape : shapeObjects) {
            if (shape != null)
                shape.draw(g);
        }

        if (currentShapeObject != null)
            currentShapeObject.draw(g);
    } // end paintComponent
} // end class DrawPanel
