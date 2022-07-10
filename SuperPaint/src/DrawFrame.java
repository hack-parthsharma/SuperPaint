import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * DrawFrame
 * Description: SuperPaint Assignment
 * DrawFrame for SuperPaint. Instantiates and handles GUI.
 *
 * @author Timothy Mui
 * @version Apr. 27, 2014
 */

public class DrawFrame extends JFrame {
    // ------Instance Variables------
    private final JPanel northPanel;
    private final JButton undoButton;
    private final JButton redoButton;
    private final JButton clearButton;
    private final JComboBox<String> colorCombo;
    private final String[] colors = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
            "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    private final JComboBox<String> shapeCombo;
    private final String[] shapes = {"Line", "Rectangle", "Oval"};
    private final JCheckBox filledBox;
    private final JLabel statusLabel;
    private final DrawPanel drawing;

    // ------ Constructor ------
    public DrawFrame() {
        super("SuperPaint Application!");

        //------North------
        northPanel = new JPanel();

        // Buttons
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        clearButton = new JButton("Clear");

        northPanel.add(undoButton);
        northPanel.add(redoButton);
        northPanel.add(clearButton);

        // ComboBoxes
        colorCombo = new JComboBox<String>(colors);
        shapeCombo = new JComboBox<String>(shapes);

        northPanel.add(colorCombo);
        northPanel.add(shapeCombo);

        // CheckBox

        filledBox = new JCheckBox("Filled");

        northPanel.add(filledBox);

        add(northPanel, BorderLayout.NORTH);

        //------South------
        statusLabel = new JLabel();
        add(statusLabel, BorderLayout.SOUTH);

        //------Center------
        drawing = new DrawPanel(statusLabel);
        add(drawing, BorderLayout.CENTER);

        //------Event Handlers------
        // button handler
        ButtonHandler buttonHandler = new ButtonHandler();
        undoButton.addActionListener(buttonHandler);
        redoButton.addActionListener(buttonHandler);
        clearButton.addActionListener(buttonHandler);

        // item handler
        ItemHandler itemHandler = new ItemHandler();
        colorCombo.addItemListener(itemHandler);
        shapeCombo.addItemListener(itemHandler);
        filledBox.addItemListener(itemHandler);

    } // end DrawFrame constructor 


    // ------ Button Handler ------
    private class ButtonHandler implements ActionListener {
        // handle button event 
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == undoButton) {
                drawing.clearLastShape();
            } else if (event.getSource() == redoButton) {
                drawing.redoLastShape();
            } else if (event.getSource() == clearButton) {
                drawing.clearDrawing();
            }
        } // end method actionPerformed 
    } // end ButtonHandler 

    // ------ Item Handler ------
    private class ItemHandler implements ItemListener {
        // respond to checkbox and combobox events 
        public void itemStateChanged(ItemEvent event) {
            // process bold checkbox events 
            if (event.getSource() == filledBox) {
                if (filledBox.isSelected()) {
                    drawing.setCurrentShapeFilled(true);
                } else {
                    drawing.setCurrentShapeFilled(false);
                }
            } else if (event.getSource() == colorCombo) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    switch (colors[colorCombo.getSelectedIndex()]) {
                        case "Black":
                            drawing.setCurrentShapeColor(Color.BLACK);
                            break;
                        case "Blue":
                            drawing.setCurrentShapeColor(Color.BLUE);
                            break;
                        case "Cyan":
                            drawing.setCurrentShapeColor(Color.CYAN);
                            break;
                        case "Dark Gray":
                            drawing.setCurrentShapeColor(Color.DARK_GRAY);
                            break;
                        case "Gray":
                            drawing.setCurrentShapeColor(Color.GRAY);
                            break;
                        case "Green":
                            drawing.setCurrentShapeColor(Color.GREEN);
                            break;
                        case "Light Gray":
                            drawing.setCurrentShapeColor(Color.LIGHT_GRAY);
                            break;
                        case "Magenta":
                            drawing.setCurrentShapeColor(Color.MAGENTA);
                            break;
                        case "Orange":
                            drawing.setCurrentShapeColor(Color.ORANGE);
                            break;
                        case "Pink":
                            drawing.setCurrentShapeColor(Color.PINK);
                            break;
                        case "Red":
                            drawing.setCurrentShapeColor(Color.RED);
                            break;
                        case "White":
                            drawing.setCurrentShapeColor(Color.WHITE);
                            break;
                        case "Yellow":
                            drawing.setCurrentShapeColor(Color.YELLOW);
                            break;
                    }
                }
            } else if (event.getSource() == shapeCombo) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    drawing.setCurrentShapeType(shapeCombo.getSelectedIndex());
                }
            }
        }

    } // end ItemHandler
} // end class DrawFrame
