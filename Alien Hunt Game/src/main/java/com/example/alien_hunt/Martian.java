package com.example.alien_hunt;

/*
 * Martian Class == A child class of the Alien class where the inherited attributes are defined. This
 *                  class also contains a method that can draw the Martian.
 *
 * @author methusha.jeyalingam
 * @version 1.8.0_181
 * @since 1.8
 */

import javafx.scene.canvas.GraphicsContext;

public class Martian extends Alien {

    // Constructor that assigns values to the attributes inherited from the Alien class
    public Martian() {
        super(2, "Mars", "Milky Way");
    }

    /**
     * draw Method == to draw a Martian using a Graphics object, starting x-coordinate position and starting
     * y-coordinate position. A shape or line is drawn and encapsulated within the Graphics object using
     * the coordinates passed relative to the starting x and y coordinates and the appropriate dimensions
     *
     * @param graphics      the GraphicsContext object that encapsulates the drawing commands
     * @param xStarting     the starting x-position of the drawing
     * @param yStarting     the starting y-position of the drawing
     */

    public void draw(GraphicsContext graphics, int xStarting, int yStarting){

        // Draw oval to represent the head shape.
        graphics.strokeOval(xStarting+10, yStarting+20, 100, 50);

        // Draw oval to represent the left eye.
        graphics.strokeOval(xStarting + 30, yStarting + 40, 10, 10);

        // Draw oval to represent the right eye.
        graphics.strokeOval(xStarting + 80, yStarting + 40, 10, 10);

        // Draw line to represent the left antenna.
        graphics.strokeLine(xStarting+14,yStarting+5,xStarting+16,yStarting+35);

        // Draw line to represent the right antenna.
        graphics.strokeLine(xStarting+104,yStarting+5,xStarting+102,yStarting+35);

        // Draw oval to represent the body of the Martian.
        graphics.strokeOval(xStarting + 30, yStarting + 70, 70, 100);

        // Draw line to represent the left arm.
        graphics.strokeLine(xStarting+32,yStarting+100,xStarting+18,yStarting+140);

        // Draw line to represent the right arm.
        graphics.strokeLine(xStarting+97,yStarting+100,xStarting+115,yStarting+140);

    }
}
