package com.example.alien_hunt;

/*
 * Jupiterian Class == A child class of the Alien class where the inherited attributes are defined.
 *                     This class also contains a method that can draw the Jupiterian.
 *
 * @author methusha.jeyalingam
 * @version 1.8.0_181
 * @since 1.8
 */

import javafx.scene.canvas.GraphicsContext;

public class Jupiterian extends Alien {

    // Constructor that assigns values to the attributes inherited from the Alien class
    public Jupiterian() {
        super(3, "Jupiter", "Milky Way");
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
        graphics.strokeOval(xStarting+10, yStarting+10, 65, 65);

        // Draw oval to represent the left eye.
        graphics.strokeOval(xStarting + 27, yStarting + 40, 8, 5);

        // Draw oval to represent the middle eye.
        graphics.strokeOval(xStarting + 37, yStarting + 40, 8, 5);

        // Draw oval to represent the right eye.
        graphics.strokeOval(xStarting + 47, yStarting + 40, 8, 5);

        // Draw oval to represent the body of the Jupiterian.
        graphics.strokeOval(xStarting + 10, yStarting + 75, 70, 90);

        // Draw line to represent the left arm.
        graphics.strokeLine(xStarting+14,yStarting+100,xStarting+2,yStarting+50);

        // Draw line to represent the right arm.
        graphics.strokeLine(xStarting+76,yStarting+100,xStarting+88,yStarting+50);

    }
}
