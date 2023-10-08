package main.trackers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.company.Logger;
import main.company.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;



import static main.company.Main.globalInformation;
import static main.company.Main.*;

/**
 * This class holds all the neccesary components of SCENEBUILDER (the format we used to create our GUI.
 * Within this class, we have options of when clicked, will prompt the user with certain text as a result.
 * This was built similiarly to our old MAIN class (which originally held our code prior to the GUI)
 */
public class TrackerController {

    public static String [] args;

    private int option = 0;
    private static ArrayList<String> namesArray = new ArrayList<String>(); //The arraylist of all the names, THIS IS JUST FOR USER TO VIEW THE OPTIONS FOR NAMES
    private static Integer question2Count = 1; //this is used for a loop for question 2 (will automatically based on how many users there are)
    private static HashMap<Integer, String> names = new HashMap<Integer, String>(); //setting up Hashmap for later usage
    int optionSetter = 0; //this is to setup for when the user chooses the dropdown menu (will cycle between 1-4)

    //ALL THE NECCESARY COMPONENTS OF SCENEBUILDER FOR GUI:
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private Label LeftLabel;

    @FXML
    private MenuItem about;

    @FXML
    private Button addUser;

    @FXML
    private TextField age;

    @FXML
    private TextField caloriesAte;

    @FXML
    private Menu file;

    @FXML
    private TextArea generalOutput;

    @FXML
    private TextField height;

    @FXML
    private TextField kilometresRan;

    @FXML
    private TextField name;

    @FXML
    private MenuButton output;

    @FXML
    private MenuItem quit;

    @FXML
    private Label rightStatus;

    @FXML
    private MenuItem save;

    @FXML
    private MenuItem load;

    @FXML
    private TextField weight;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private MenuItem BmiCalculation;

    @FXML
    private MenuItem ListOfUsers;

    @FXML
    private MenuItem PrintAll;

    @FXML
    private MenuItem TotalCalories;

    @FXML
    private MenuItem TotalKM;

    @FXML
    private TextField userID;

    @FXML
    private Button submitOutput;


    /**
     * A button the indicates what the program is ABOUT
     * @param event
     */
    @FXML
    void aboutMyTrackerApplication(ActionEvent event) {
        // if user clicks on the about under the help menu, it alerts the user with information about the program
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Author: Jiayi Teh");
        alert.show();
    }


    /**
     * Drop down menu (Kept just in case of code issues)
     * @param event
     */
    @FXML
    void additionalOutput(ActionEvent event) {
    }

    /**
     * When clicking on the "Create new User" button, we will attempts to create a new user
     * (Assuming that all of the input sections have been correctly filled out)
     * If the try fails, we will change the label to tell the user to input valid entries
     * @param event
     */
    @FXML
    void createNewUser(ActionEvent event) {
        // if not null for each, store that in the names variable of the class from main
        // add that to the arraylist of arraylist

        try{
            String stringName = name.getText();
            int stringAge = Integer.parseInt(age.getText());
            int stringkmRan = Integer.parseInt(kilometresRan.getText());
            int stringCalories = Integer.parseInt(caloriesAte.getText());
            int stringHeight = Integer.parseInt(height.getText());
            int stringWeight = Integer.parseInt(weight.getText());


            ArrayList<String> userInformation = new ArrayList<String>(); //The array list for individual user information
            globalCount++; // we are adding 1 to the counter so that the id is not confused, and gives a unique value.
            userInformation.add(String.valueOf(globalCount));
            userInformation.add(stringName);
            userInformation.add(String.valueOf(stringAge));
            userInformation.add(String.valueOf(stringHeight));
            userInformation.add(String.valueOf(stringWeight));
            userInformation.add(String.valueOf(stringkmRan));
            userInformation.add(String.valueOf(stringCalories));

            AddUserInfo(userInformation);
            System.out.println(globalInformation);

            //setting the output section to state the info about the user that was created
            generalOutput.setText(
                    "ID: " + globalCount + "\n" +
                    "Name: " + stringName + "\n"+
                    "Age: " + stringAge + "\n" +
                    "Height: " + stringHeight + "\n" +
                    "Weight: " + stringWeight + "\n" +
                    "KM Ran: " + stringkmRan + "\n" +
                    "Calories Ate: " + stringCalories
            );
            LeftLabel.setText("Succesfully added user");
            namesArray.add(Main.globalCount + "_" + stringName); //Adds every name we have so far including the key, to an array of names, which the user will get to choose from when adding information.
            names.put(Main.globalCount, stringName); //putting

        } catch (Exception e) {
            System.out.println("Error getting info");
            LeftLabel.setText("Please ensure valid inputs");

        }

    }

    /**
     * Loading from file, ensuring that we reset all values before hand.
     * @param actionEvent
     */
    public void loadFile(ActionEvent actionEvent) {

        try {
            //Since we dont want to repeat anything or leave any values, we are CLEARING the names, namesarray, and global information (will recreate them based on
            //user input.) This includes the global count "X" as well
            globalInformation.clear();
            namesArray.clear();
            names.clear();
            globalCount = 0;

            if (args.length == 1) { //IF and ONLY IF, the args length is 1 (assuming it is in fact a file, and it exists) then we will attempts to take its data.
                String argCheck = "";
                String filename = args[0];
                File fileChecker = new File(filename);
                System.out.println("HERE");
                try {
                    if (fileChecker.isFile() && fileChecker.exists() && fileChecker.canRead()) {
                        argCheck = filename;
                        globalInformation = Reader.ReaderAction(argCheck);
                        for (int y = 0; y < globalInformation.size(); y++) {
                            namesArray.add(globalInformation.get(y).get(0) + "_" + globalInformation.get(y).get(1));
                            int number = Integer.parseInt(globalInformation.get(y).get(0));
                            String string = globalInformation.get(y).get(1);
                            names.put(number, string);
                            LeftLabel.setText("Succeeded loading");
                        }
                    }
                } catch (NumberFormatException e) { //if the above code doesnt work (assuming the CSV goes wrong) then we will let the user know of this.
                    LeftLabel.setText("Issue interpreting custom file");
                }

            }
            else {

                    globalInformation = Reader.ReaderAction("");
                    for (int y = 0; y < globalInformation.size(); y++) {
                        namesArray.add(globalInformation.get(y).get(0) + "_" + globalInformation.get(y).get(1));
                        int number = Integer.parseInt(globalInformation.get(y).get(0));
                        String string = globalInformation.get(y).get(1);
                        names.put(number, string);
                        LeftLabel.setText("Succeeded loading");
                    }
                }
            }
            catch(Exception ex){
            LeftLabel.setText("Issue loading, returning empty");
            globalInformation.clear();
        }
    }

    /**
     * Saving to file (Data.txt)
     * @param event
     */
    @FXML
    void saveFile(ActionEvent event) {
        try {
            //calling onto function "Logger" to save file to Data.txt
            Logger.LoggerAction("Data.txt", globalInformation);
            LeftLabel.setText("Saved");
        } catch (Exception e) {
            LeftLabel.setText("Issue saving");
        }
    }

    /**
     * For the submit button (checks to make sure the user picks the proper output, and then displays it
     * @param event
     */
    @FXML
    void submitOutputAction(ActionEvent event) {
        try{
            int ID = Integer.parseInt(userID.getText());
            if (ID == 0){
                LeftLabel.setText("ID input cannot be 0");
            }
            else if(ID > globalInformation.size()){
                LeftLabel.setText("ID must be in range of users");
            }
            else if(ID < 0){
                LeftLabel.setText("ID must be in range of users");
            }
            else{

                //setting up to see what choice the user setup for themselves
                if (optionSetter == 1){
                    LeftLabel.setText("Outputted values");
                }
                else if(optionSetter == 2){
                    double BMI = Calculator.BMI(ID);
                    generalOutput.setText("The BMI for user with ID " + ID + " Is: " + BMI);
                    LeftLabel.setText("Outputted values");
                }
                else if(optionSetter == 3){
                    int userAbove18 = Calculator.userAbove18(ID);
                    generalOutput.setText("The total amount of users above 18 is: " + userAbove18);
                    LeftLabel.setText("Outputted values");
                }
                else if (optionSetter == 4){
                    float kmRan = Calculator.totalKm(ID);
                    generalOutput.setText("The amount of kmRan for all users is " + kmRan);
                    LeftLabel.setText("Outputted values");
                }
                else if(optionSetter == 5){
                    double netCalories =Calculator.netCalories(ID);
                    generalOutput.setText("The total net calories for the user with ID " + ID  +" is: " + netCalories);
                    LeftLabel.setText("OutputtedValues");
                }




            }

        } catch (Exception e) {
            LeftLabel.setText("Error getting output info, please enter valid entry");
        }
    }

    /**
     * Exits the program
     * @param event
     */
    @FXML
    void systemQuit(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Setup the window state
     */
    @FXML
    public void initialize() {

    }

    /**
     * If the bmi calculation was chosen, then we will be setting our option according
     * @param event
     */
    @FXML
    void BmiCalculationAction(ActionEvent event) {
        output.setText("BMI Calculation");
        optionSetter = 2;

    }

    /**
     * If listofusers is chosen, we set out options accoridngly
     * @param event
     */
    @FXML
    void ListOfUsersAction(ActionEvent event) {
        output.setText("List of all users 18+");
        optionSetter = 3;

    }

    @FXML
    void PrintAllAction(ActionEvent event) {
        output.setText("List of all users");
        String allUsers = "";
        for (int z = 0; z < namesArray.size(); z++)
        {
            allUsers = allUsers + namesArray.get(z) + "\n";
        }
        generalOutput.setText(allUsers);
        System.out.println(globalInformation);
        optionSetter = 1;


    }

    @FXML
    void TotalCaloriesAction(ActionEvent event) {
        output.setText("Total calories burnt");
        optionSetter = 5;

    }

    /**
     * Declaring the option setter 4 (the actionb for km ran)
     * @param event
     */
    @FXML
    void TotalKMAction(ActionEvent event) {
        output.setText("Total km ran");
        optionSetter = 4;
    }


}



