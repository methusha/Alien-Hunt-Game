package com.example.alien_hunt;

/*
 * GameActions Class == A class to provide important methods needed for the Alien Hunt game
 *
 * @author methusha.jeyalingam
 * @version 1.8.0_181
 * @since 1.8
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.StringTokenizer;

public class GameActions {

    public int[] alienArray;
    final String stringPath;
    final Path path;
    public String[][] scores;

    /**
     * GameActions constructor == Contains and initializes important variables for the Alien Hunt game
     *
     * @param stringPath    a string representing a path where scores are contained within a csv
     */
    public GameActions(String stringPath) {
        // Initialize an integer array containing two zeros and six ones to represent Martians and Jupiterians
        this.alienArray = new int[]{0, 0, 1, 1, 1, 1, 1, 1};
        // Shuffle the alienArray for the game
        shuffleArray();
        // Initialize the class stringPath variable
        this.stringPath = stringPath;
        // Initialize a class Path variable using the stringPath
        this.path = Paths.get(stringPath);
    }

    /**
     * shuffleArray method == Shuffles the alienArray
     */
    public void shuffleArray() {
        // Initialize an integer to represent indices in the array
        int index;
        // Instantiate a Random object
        Random random = new Random();
        // A for loop to shuffle the alienArray
        for (int i = this.alienArray.length - 1; i > 0; i--) {
            // Set the index equal to a random integer that is within the bounds of the array
            index = random.nextInt(i + 1);
            // Switch positions of the index and each position in the array if not equal to each other
            if (index != i) {
                this.alienArray[index] ^= this.alienArray[i];
                this.alienArray[i] ^= this.alienArray[index];
                this.alienArray[index] ^= this.alienArray[i];
            }
        }
    }

    /**
     * checkFileExists method == Checks whether a file exists
     *
     * @return                   a boolean indicating whether the file exists
     */
    public boolean checkFileExists() {
        // A try/catch sequence is used in the case an IOException may be thrown
        try {
            // This checks whether the file exists. The code will return true if it does.
            this.path.getFileSystem().provider().checkAccess(this.path);
            return true;
        } catch (IOException e) {
            // This will return false when an IOException is thrown (file does not exist)
            return false;
        }
    }

    /**
     * findNumberRowsInFile method == returns an integer that represents the number of rows in the file that is
     *                                located at this class's local Path variable
     *
     * @return                        an integer representing the number of rows in the file
     */
    public int findNumberRowsInFile() {
        // A try/catch sequence is used in the case an IOException may be thrown
        try {
            // Instantiate an InputStream Object to perform input tasks
            InputStream input = Files.newInputStream(this.path);

            // Instantiate a BufferedReader Object to read text from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Initialize count variable to represent number of rows in the file
            int count = 0;

            // Initialize a string that reads the first line of the file here
            String s = reader.readLine();

            // A while loop to iterate through the file until a null value is return.
            // Null value is reached from the readLine method when no more data is available
            while (s != null) {
                // Add to the count for every loop executed to get the total number of rows
                count++;
                // Read the next line of the file
                s = reader.readLine();
            }

            // Return the number of rows
            return count;
        } catch (IOException e) {
            // Print in the console an input error occurs and the type of exception
            System.out.println("Input error!" + e);
        }
        // If the number of rows cannot be returned, return -1 to indicate the file was not read
        return -1;
    }

    public void csvToArray() {
        // A try/catch sequence is used in the case an IOException may be thrown
        try {
            // Instantiate an InputStream Object to perform input tasks
            InputStream input = Files.newInputStream(this.path);

            // Instantiate a BufferedReader Object to read text from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Initialize an integer to represent the row number for the upcoming while loop
            int row = 0;
            // Initialize an integer to represent the column number for the upcoming while loop
            int column;

            // Initialize a string that reads the first line of the file here
            String line = reader.readLine();

            /* Find the number of columns in the file by finding the number of Strings separated by a
               column in the first line of the file */
            int colLength = line.split(",").length;

            /* Initialize this class's private 2D string array variable using the findNumberRowsInFile()
               to determine the number of rows in the array and colLength of the number of columns */
            this.scores = new String[findNumberRowsInFile()][colLength];

            // A while loop to iterate through the file to transfer values to the array
            while (line != null) {
                // Instantiate a StringTokenizer object to separate the Strings by the comma in each line
                StringTokenizer z = new StringTokenizer(line, ",");
                // Set the value of the column as zero to represent the start of each row
                column = 0;
                // A while loop to iterate through each comma-separated value in each row
                while (z.hasMoreTokens()) {
                    // Assign the value from the csv to the corresponding location in the array
                    this.scores[row][column] = z.nextToken();
                    // Increment the column to gather the next value in the same row
                    column++;
                }
                // Increment the row number to gather values from the next row
                row++;
                // Place the line reader on the next row
                line = reader.readLine();
            }
        } catch (IOException e) {
            /* In the case of an exception, print a message indicating the csv file could not be
            converted into an array */
            System.out.println("Cannot convert csv file to array.");
        }
    }

    /**
     * sortArrayByScore method == sorts the class string array variable, scores, each player's scores, high to low
     */
    public void sortArrayByScore(){
        // A for loop to iterate through each row to sort values
        for(int i = 1; i < this.scores.length - 1; i++){
            /* An if loop that will switch rows if the value of the specified column is lower than
               the next row */
            if(Float.parseFloat(this.scores[i][1]) < Float.parseFloat(this.scores[i+1][1])){
                /* A for loop for performing the row switch. Will iterate through each column to
                   switch values from the next row. */
                for(int j = 0; j < this.scores[i].length; j++){
                    // Hold a temporary position of the current value because it will be overwritten
                    String tempPosition = this.scores[i][j];
                    // Change the value of the current row position to the value of the next row
                    this.scores[i][j] = this.scores[i+1][j];
                    // Change the value of the next row to what was originally in the current row
                    this.scores[i+1][j] = tempPosition;
                }
                /* Because the value of the next row was switched with this row, reset the value of i
                   to -1 to iterate through the array again */
                i = 0;
            }
        }
    }

    /**
     * writeHighScores method == Writes the new score and player name to a csv file. If a csv already exists, it will
     *                           sort and append the existing file. If the csv does not exist, it will create a new
     *                           one.
     *
     * @param player             A String representing the player's name
     * @param score              An integer representing the player's score
     */
    public void writeHighScores(String player, int score){

        /* Define the String delimiter as a comma so in csv files, each row will be defined as separated
           by a comma */
        String delimiter = ",";

        // Initialize a String that will be printed to a new csv file
        String s = player + delimiter + score + delimiter + new java.util.Date();

        // Try and Catch block to handle IOExceptions, which are likely to occur when writing to file
        try{

            // Initialize a boolean representing whether a file is located at the class's Path variable
            boolean existingFile = checkFileExists();

            // An if statement to write to the file if a file exists
            if(existingFile){
                // Initialize a File object using the class's stringPath
                File file = new File(this.stringPath);
                // Initialize a FileWriter object to write to the file just initialized
                FileWriter fw = new FileWriter(file,true);
                // Write the string of player and score information to the file
                fw.write(s,0,s.length());
                // Move the cursor to the next line so the same line would not be overwritten
                fw.write(System.getProperty("line.separator"));
                // Close the FileWriter
                fw.close();
                // Convert the just-written csv to an array, stored as the class's scores array
                csvToArray();
                // Sort the class's scores array by score
                sortArrayByScore();
            }

            /* Instantiate an OutputStream, which will output a file in the Path destination, newPath
               which was a parameter passed to the Object of this class */
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(this.path));

            // Instantiate a BufferedWriter Object to write text to the output stream
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            // An if statement to write to the file if a file does not exist
            if(!existingFile){
                /* Define the headings of each column, separated by a comma, to have its individual column
               in the csv file */
                String headings = "Player,Score,Date";

                // Write the headings to the csv file
                writer.write(headings,0,headings.length());

                // Position the writer onto the next row of the csv file
                writer.newLine();

                // Write the line to the new csv file
                writer.write(s,0,s.length());

                // Position the writer onto the next row of the csv file
                writer.newLine();
            }

            // An if statement to write to the file if a file exists to write the sorted array to csv
            if(existingFile){
                /* A for loop to write each data value and the difference between the open and close to the
                   new csv file */
                for(int i = 0; i < this.scores.length ; i++){

                    /* String that separates all data, called from the String array, separated by a comma,
                       including the difference between open and close */
                    s = this.scores[i][0] + delimiter + this.scores[i][1] + delimiter + this.scores[i][2];

                    // Write the line to the new csv file
                    writer.write(s,0,s.length());

                    // Position the writer onto the next row of the csv file
                    writer.newLine();
                }
            }
            // Close the writer
            writer.close();
        }
        catch (IOException e){
            System.out.println("A file cannot be created and written to.");
        }
    }

    /**
     * highScore method == Returns an integer representing the highest score in the csv containing all scores
     *
     * @return             An integer representing the highest score in the csv containing all scores
     */
    public int highScore(){
        // A try and catch loop to catch exceptions
        try{
            // Convert the csv to an array, the class's score variable, to gather the highest score
            csvToArray();
            // Return the high score, which is always located at the scores[1][1] position because the array is sorted
            return Integer.parseInt(this.scores[1][1]);
        }
        catch (Exception e){
            // Return a 0 if an exception is raised, including when a csv does not exist
            return 0;
        }
    }
}
