package com.example.alien_hunt;

/*
 * AlienController Class == A class to provide responsive actions to when controls in the stage are selected
 *
 * @author methusha.jeyalingam
 * @version 1.8.0_181
 * @since 1.8
 */

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.io.File;

public class AlienController {

    private int martianCounter = 0;
    private int jupiterianCounter = 0;
    private boolean musicOn;
    private int score = 0;
    private String playerName;

    @FXML
    private Label welcomeText, highScore, yourScore;
    @FXML
    private TextField playerPrompt;
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, submit;
    @FXML
    private Canvas drawingCanvas;
    @FXML
    private ToggleButton musicToggle;
    @FXML
    private ImageView earthImage;

    // Initialize a GameActions Object to use their methods. Pass the parameter of where the scores are stored
    final GameActions game = new GameActions("C:\\temp\\scores.csv");

    /**
     * enterPlayer method == When the player enters their name in the text field and hits the submit button, the
     *                       game will begin and the current high score will be displayed.
     */
    @FXML
    protected void enterPlayer(){
        // Retrieve the player's name from the playerPrompt text field and save as a variable.
        this.playerName = playerPrompt.getText();
        // Have the highScore label display the current high score
        highScore.setText("Current High Score: " + game.highScore());
        // Have the yourScore label display the player's current score
        yourScore.setText("Your Score: " + this.score);
        // Enable all the buttons so the player may start playing
        setButtonDisable(false);
        // Make the playerPrompt not visible, to remove clutter on the screen
        playerPrompt.setVisible(false);
        // Make the submit button not visible, to remove clutter on the screen
        submit.setVisible(false);
    }

    /**
     * onButton1Click method == Once Button 1 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton1Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button1, 0);
    }

    /**
     * onButton2Click method == Once Button 2 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton2Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button2, 1);
    }

    /**
     * onButton3Click method == Once Button 3 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton3Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button3, 2);
    }

    /**
     * onButton4Click method == Once Button 4 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton4Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button4, 3);
    }

    /**
     * onButton5Click method == Once Button 5 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton5Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button5, 4);
    }

    /**
     * onButton6Click method == Once Button 6 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton6Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button6, 5);
    }

    /**
     * onButton7Click method == Once Button 7 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton7Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button7, 6);
    }

    /**
     * onButton8Click method == Once Button 8 is clicked by the player, the button will be disabled from being clicked
     *                          again. The corresponding alien to this button will be displayed and the score will be
     *                          updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                          will end.
     */
    @FXML
    protected void onButton8Click() {
        // Display appropriate alien using position of alien array and update score when this button is pressed
        buttonAction(button8, 7);
    }

    /**
     * onMusicToggle method == Assigned to a button to toggle the music on and off.
     */
    @FXML
    protected void onMusicToggle(){
        // Switch the boolean of whether music is playing or not, to toggle the music
        musicOn = !musicOn;
        // A string representing the location of the music file
        String musicString = new File("C:\\temp\\" +
                "music.mp3").toURI().toString();
        // Instantiate an AudioClip object to hold the music of the string location passed to it
        AudioClip music = new AudioClip(musicString);
        // Set volume to 20% so it is not too loud
        music.setVolume(0.2);
        // An if and else statement to either play music or turn it off
        if(musicOn){
            // Change the text of the button to turn music off
            musicToggle.setText("Turn Music Off");
            // Play the music
            music.play();
        } else {
            // Change the text of the button to turn music on
            musicToggle.setText("Turn Music On");
            // Stop the playing music
            music.stop();
        }
    }

    /**
     * buttonAction method == Once the button is clicked by the player, the button will be disabled from being clicked
     *                        again. The corresponding alien to this button will be displayed and the score will be
     *                        updated if a Martian is chosen. If all Martians or all Jupiterians are found, the game
     *                        will end.
     *
     * @param button          represents the button being clicked
     * @param position        represents the corresponding index in the game.alienArray for the passed button
     */
    public void buttonAction(Button button, int position){
        // Disable button upon being clicked
        button.setDisable(true);
        // Display the alien selected and update the score if a Martian is selected
        alienSelected(position);
        // End the game if 6 Martians or 2 Jupiterians are found
        endGame();
    }

    /**
     * alienSelected method == Checks the whether the index of the button represents a Martian or Jupiterian in
     *                         the game.alienArray. If a Martian is selected, the score will be concatenated and
     *                         a Martian will appear on the screen. If a Jupiterian is selected, a Jupiterian will
     *                         appear on the screen.
     *
     * @param alienNum         represents the index of the button in the corresponding game.alienArray
     */
    public void alienSelected(int alienNum) {
        // Initialize a GraphicsContext object to represent the graphics of the Canvas
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        // Set line width of the graphics to 2
        gc.setLineWidth(2);
        // Clear the canvas if a drawing already exists on it, to prevent drawing over it
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        // An if statement to distinguish between Martians and Jupiterians
        if(game.alienArray[alienNum] == 1) {
            // Increase the number of Martians counted by one
            this.martianCounter++;
            // Set the text of the label to indicate what alien was found and how many were found so far
            welcomeText.setText("Martian Selected. " + this.martianCounter + " total Martians selected.");
            // Initialize a Martian Object
            Martian martian = new Martian();
            // Draw the Martian to the GraphicsContext object to appear on the canvas
            martian.draw(gc,0,0);
            // Add a fade transition to have the canvas fade out
            fadeInOut(drawingCanvas,10,0);
            // Increase the score by one for finding the Martian
            this.score++;
            // Update the yourScore label to show the updated score
            yourScore.setText("Your Score: " + this.score);
        } else {
            // Increase the number of Jupiterians counted by one
            this.jupiterianCounter++;
            // Set the text of the label to indicate what alien was found and how many were found so far
            welcomeText.setText("Jupiterian Selected. " + this.jupiterianCounter + " total Jupiterians selected.");
            // Initialize a Jupiterian Object
            Jupiterian jupiterian = new Jupiterian();
            // Draw the Jupiterian to the GraphicsContext object to appear on the canvas
            jupiterian.draw(gc,0,0);
            // Add a fade transition to have the canvas fade out
            fadeInOut(drawingCanvas,10,0);
        }
    }

    /**
     * endGame method == A method executed after each game button click. Checks whether 6 Martians or 2 Jupiterians
     *                   have been reached. If reached, an appropriate gif will be displayed on the ImageView object.
     *                   If 6 Martians are found, score will be updated to 10. If 2 Jupiterians are found, 2
     *                   Jupiterians will be drawn on the canvas.
     */
    public void endGame(){
        // Initialize a GraphicsContext object to represent the graphics of the Canvas
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        // Set line width of the graphics to 2
        gc.setLineWidth(2);

        // An if statement for when all the Martians are found
        if(this.martianCounter == 6){
            // Set the label to inform the user they have found all the Martians
            welcomeText.setText("Congratulations! You've found all the Martians and saved the earth!");

            // Instantiate a File object containing a path of a happy earth gif
            File earthFile = new File("C:\\temp\\happyearth.gif");
            // Instantiate an Image object that contains the File object containing the happy earth gif
            Image earthPic = new Image(earthFile.toURI().toString());
            // Set the earthImage ImageView to the happy earth gif
            earthImage.setImage(earthPic);

            // Initialize a Martian Object
            Martian martian = new Martian();
            // Draw the Martian to the GraphicsContext object to appear on the canvas
            martian.draw(gc,0,0);
            // Add a fade transition to have the canvas fade out
            fadeInOut(drawingCanvas,0,10);

            // Update the score to 10 points for winning
            this.score = 10;
            // Update the yourScore label to reflect the new score
            yourScore.setText("Your Score: " + this.score);

            // Disable all buttons because the game is over
            setButtonDisable(true);
            // Write the current score to the csv file containing all scores
            game.writeHighScores(this.playerName, this.score);
        }
        // An if statement for when all the Jupiterians are found
        if(this.jupiterianCounter == 2){
            // Set the label to inform the user they have found all the Jupiterians
            welcomeText.setText("Game Over. The Jupiterians have destroyed the Earth!");

            // Instantiate a File object containing a path of an earth explosion gif
            File earthFile = new File("C:\\temp\\explodingearth.gif");
            // Instantiate an Image object that contains the File object containing the earth explosion gif
            Image earthPic = new Image(earthFile.toURI().toString());
            // Set the earthImage ImageView to the earth explosion gif
            earthImage.setImage(earthPic);

            // Initialize a Jupiterian Object
            Jupiterian jupiterian = new Jupiterian();
            // Draw the Jupiterian to the GraphicsContext object to appear on the canvas
            jupiterian.draw(gc,0,0);
            // Draw another Jupiterian to the GraphicsContext object to appear on the canvas
            jupiterian.draw(gc,100,0);
            // Add a fade transition to have the canvas fade out
            fadeInOut(drawingCanvas,0,10);

            // Disable all buttons because the game is over
            setButtonDisable(true);
            // Write the current score to the csv file containing all scores
            game.writeHighScores(this.playerName, this.score);
        }
    }

    /**
     * fadeInOut method == A method to fade in or out a Canvas
     *
     * @param canvas       The canvas to be faded in or out
     * @param fadeFrom     The initial fade value of the image at the start (between 1 and 10)
     * @param fadeTo       The final fade value of the image at the end (between 1 and 10)
     */
    private void fadeInOut(Canvas canvas, int fadeFrom, int fadeTo){
        // Instantiate a FadeTransition object to allow for fade transitions
        FadeTransition fade = new FadeTransition();
        // Set the duration of the fade to 3000 milliseconds
        fade.setDuration(Duration.millis(3000));
        // Set the value to fade from
        fade.setFromValue(fadeFrom);
        // Set the value to fade to
        fade.setToValue(fadeTo);
        // Set the number of fade cycles
        fade.setCycleCount(1);
        // Set whether the image runs back and forth while looping
        fade.setAutoReverse(true);
        // Set which Node will be faded in or out
        fade.setNode(canvas);
        // Play the fade
        fade.play();
    }

    /**
     * setButtonDisable method == Either disables or enables all game buttons 1-8
     *
     * @param bool                a boolean to indicate whether all buttons shall be enabled or disabled
     */
    private void setButtonDisable(boolean bool){
        // An if statement to disable all buttons if a true value is passed
        if(bool){
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            button5.setDisable(true);
            button6.setDisable(true);
            button7.setDisable(true);
            button8.setDisable(true);
        }
        // An else statement to enable all buttons if a false value is passed
        else{
            button1.setDisable(false);
            button2.setDisable(false);
            button3.setDisable(false);
            button4.setDisable(false);
            button5.setDisable(false);
            button6.setDisable(false);
            button7.setDisable(false);
            button8.setDisable(false);
        }
    }
}