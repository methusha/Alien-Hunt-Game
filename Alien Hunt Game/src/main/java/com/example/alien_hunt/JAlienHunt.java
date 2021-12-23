package com.example.alien_hunt;

/*
 * JAlienHunt Class == A class that extends an Application and is used to launch the Alien Hunt Game.
 *
 * @author methusha.jeyalingam
 * @version 1.8.0_181
 * @since 1.8
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JAlienHunt extends Application {

    /**
     * start method == A method that initializes the Alien game by gathering resources from the appropriate
     *                 fxml file and sets a stage to house the game
     *
     * @param stage             a stage to hold the Alien Hunt game
     * @throws IOException      handling a likely-to-occur IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Instantiate a FXMLLoader object to assign the appropriate fxml file to this class
        FXMLLoader fxmlLoader = new FXMLLoader(JAlienHunt.class.getResource("alien-hunt.fxml"));
        // Set the scene using the fxml file and set the height and width for launching
        Scene scene = new Scene(fxmlLoader.load(), 650, 440);
        // Add a CSS style sheet to the scene to have the game controls and fields have a defined appearance
        scene.getStylesheets().add("AlienHunt.css");
        // Set the title of the launced game
        stage.setTitle("Alien Hunt");
        // Set the scene of the stage to the just-defined scene
        stage.setScene(scene);
        // Set the stage to be visible
        stage.show();
    }

    /**
     *
     * @param args This is the command line argument.
     */
    public static void main(String[] args) {
        // Launch the game
        launch();
    }
}