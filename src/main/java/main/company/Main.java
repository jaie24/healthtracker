package main.company;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static javafx.application.Application.launch;


/**
 * A class that tracks the information of user's age,height,weight,kilometres ran and calories
 * Allows user to obtain BMI, Total calories burnt, Total km ran by all users, list of users past the age of 18, and printing all users
 * The program utilizes Hashmaps, Arraylists, and Arraylist of Arraylists in order to store data.
 * This class was originally held for DEMO 2, however it now holds neccesary components for our GUI project as well.
 * Author: Jiayi Teh
 * @version 1.0
 */

public class Main {
    public static int globalCount = 0; //declaring a public integer x as 0, this will be used for hashmap counting for names, which gives an ID
    private static ArrayList<String> namesArray = new ArrayList<String>(); //The arraylist of all the names, THIS IS JUST FOR USER TO VIEW THE OPTIONS FOR NAMES
    public static ArrayList<ArrayList<String>> globalInformation = new ArrayList<ArrayList<String>>(); //The array list for ALL user information
    private static Scanner scanner = new Scanner(System.in); // setting up public scanner for inputs
    private static HashMap<Integer,String> Names = new HashMap<Integer,String>(); //setting up a public Hashmap for later usage
    private static HashMap<Integer, String> names = new HashMap<Integer, String>(); //setting up Hashmap for later usage
    private static Integer question2Count = 1; //this is used for a loop for question 2 (will automatically based on how many users there are)

    //primarily used for demo 2
    /**
     * Start of the Tracker Program
     * Program starts by providing several options for the user
     * User chooses a number to input information
     * Options are given for user to either continue the program or to return to the main menu
     * @param args No arguments will be passed into this function
     */
    public static void main(String[] args) {
//        // write your code here
//        Scanner scanner = new Scanner(System.in); // setting up scanner for inputs
//
//        boolean loopControl = false;
//        while (loopControl != true) {
//
//            System.out.println("Hello! Please enter a number for the following options:");
//            System.out.println("1: Load data file(Overwrites current info)");
//            System.out.println("2: Add a name");
//            System.out.println("3: Add Users data");
//            System.out.println("4: General output");
//            System.out.println("5: Save current status(Overwrite Log File)");
//            System.out.println("6: Exit");
//            String initialQuestion = scanner.nextLine();
//
//
//
//            //If user chooses to load the text file, then we will override anything that has happened in this run, with that information to the globalInformation.
//            //This INCLUDES the possibility if the user has inputted a command line argument.
//            if (initialQuestion.equals("1")) {
//                String argCheck = "";
//                if(args.length == 1){
//                    String filename = args[0];
//                    File fileChecker = new File(filename);
//                    if (fileChecker.isFile() && fileChecker.exists() && fileChecker.canRead()){ //making sure the file in commandline is a real usable file
//                        argCheck = filename;
//                        System.out.println("Using argument checker");
//                        globalInformation.clear();
//                        globalInformation = Reader.ReaderAction();
//                    }
//                }
//
//                //if there are too MANY arguments (more than 1) the program exits, as we are only saving and loading to one file
//                else if (args.length > 1){
//                    System.err.println("Too many arguments inputter (MUST BE ONE)");
//                    System.exit(0);
//                }
//
//                //if the previous claims do not arrive (no command line argument or invalid file, then we default to NOT using a custom filename.
//                else {
//                    globalInformation.clear();
//                    globalInformation = Reader.ReaderAction();
//                }
//                //ensuring that we create a hashmap for every single value that currently exists in the global information when loading, (this is for when a user adds user data)
//                for (int y = 0; y < globalInformation.size(); y++) {
//                    namesArray.add(globalInformation.get(y).get(0) + "_" + globalInformation.get(y).get(1));
//                    int number = Integer.parseInt(globalInformation.get(y).get(0));
//                    String string = globalInformation.get(y).get(1);
//                    question2Count++;
//                    names.put(number, string);
//                    }
//                System.out.println("Loaded");
//
//            }
//            //if user chooses 2, we will be constantly adding names untill the user chooses to stop adding names
//            else if (initialQuestion.equals("2")) {
//                HashMap<Integer, String> NewName = NameDefine(); //declaring a new hashmap which retrieves the information from "NameDefine" Function.
//                names.putAll(NewName); //putting ALL new names
//                System.out.println(names); //Currently here for debugging purposes (this prints the entire hashmap 'names')
//                for (int q = question2Count ; q <= names.size(); q++) {
//                    question2Count++; //this is to ENSURE that we do not have repeated names inside the namesArray (if this isn't here, we will continuously have repeats)
//                    namesArray.add(q + "_" + names.get(q)); //Adds every name we have so far including the key, to an array of names, which the user will get to choose from when adding information.
//                }
//            }
//
//
//            //This section will be for the second option "Add User Data" which will be asking the user for certain question, which will then
//            //add there name and information to a list, which will be inside of another list full of other people information.
//            //(I haven't really started this code yet, this is mainly placeholder)
//            else if (initialQuestion.equals("3")) {
//                ArrayList<String> userInformation = new ArrayList<String>(); //The array list for individual user information
//                userInformation = userData(names);
//                AddUserInfo(userInformation);
//                System.out.println(globalInformation);
//
//            }
//            //if user chooses 4, we will be running the outputs
//            else if (initialQuestion.equals("4")) {
//                genOutput(names);
//            }
//
//
//            //will save info
//            else if(initialQuestion.equals("5")){
//                //THIS IS THE LOADER, this saves user data to the file by overwriting the file.
//
//                //Double checking to ensure the user has inputted a valid option for the argument.
//                String argCheck = "";
//                if(args.length == 1){
//                    String filename = args[0];
//                    File fileChecker = new File(filename);
//                    if (fileChecker.isFile() && fileChecker.exists() && fileChecker.canRead()){ //making sure the file in commandline is a real usable file
//                        Logger.LoggerAction(filename,globalInformation);
//                    }
//                    else {
//                        System.out.println("Warning, info will be printed to a non text file");
//                        Logger.LoggerAction(filename,globalInformation);
//                    }
//                }
//
//                //if there are too MANY arguments (more than 1) the program exits, as we are only saving and loading to one file
//                else if (args.length > 1){
//                    System.err.println("Too many arguments inputter (MUST BE ONE)");
//                    System.exit(0);
//                }
//
//                else{
//                    Logger.LoggerAction("",globalInformation);
//                }
//
//            }
//
//
//
//            System.out.println("Would you like to go back to the menu?");
//            System.out.println("Yes: Enter");
//            System.out.println("No: Any other key");
//            String Answer = scanner.nextLine(); // This is referring to the answer the user inputs to return to menu.
//            loopControl = true;
//            if (Answer.equals("")) {
//                loopControl = false;
//            }
//        }

    }

    // Below this line are functions
    // =============================================================================================================


    /**
     * Function that requests for names and additional names (if any) from user and store the names that have been entered by user into the hashmap Names
     * @return Hashmap containing names entered by user (value) attached to the key x which is a number
     */
    public static HashMap<Integer,String> NameDefine() //this function is for choice 1 "Adding a name"
    {
        boolean loopControl = false;
        while (loopControl != true) { //Placed inside of a loop, so that the user is able to continuously add new names if they choose so.
            globalCount = globalCount + 1; //continuously increases by 1 for the global variable, in order to attach future names to this value
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            Names.put(globalCount, name); //Adding the users name, as well as a number to associate with the name
            System.out.println("Enter another name?");
            System.out.println("Enter = Yes");
            System.out.println("Any other key = No");
            String loopBreaker = scanner.nextLine();
            if (!(loopBreaker.equals(""))) {
                loopControl = true;
            }
        }
        return Names; //returns the names (Hashmap) to then add them to an arraylist
    }

    /**
     * Function that stores user data for each question asked,
     * @param names initial names that has been entered by user
     * @return an arraylist userInformation containing information of every user
     */
    public static ArrayList<String> userData(HashMap<Integer, String> names) {
        ArrayList<String> userInformation = new ArrayList<String>(); //The array list for individual user information
        String nameChosen = null;
        String questionAge = null;
        String questionHeight = null;
        String questionWeight = null;
        String questionKM = null;
        String questionCalories = null;
        System.out.println("Which user would you like to enter information for?");
        System.out.println(namesArray);
        System.out.println("Please enter the number that corresponds to the name");
        nameChosen = scanner.nextLine();


        try { //this line of texts attempts to convert the nameChosen(number) into an integer, if there is an error, then the program crashes.
            Integer.parseInt(nameChosen);
        } catch (NumberFormatException e) {
            System.out.println("You MUST input a valid number as your option");
            System.exit(0);
        }


        if (Integer.parseInt(nameChosen) > names.size()) {//checking to see if its in range of the index provided
            System.out.println("You must input a name that has been provided");
            System.exit(0);
        }
        if (Integer.parseInt(nameChosen) < 1) {//checking to see if its in range of the index provided
            System.out.println("You must input a name that has been provided");
            System.exit(0);
        }


        userInformation.add(nameChosen);//Adds the id to the user arraylist
        userInformation.add(names.get(Integer.parseInt(nameChosen))); //adds the name chosen to the array list.


        System.out.println("Enter your age(Enter to skip):");
        questionAge = scanner.nextLine();
        if (questionAge == "") {
            questionAge = null;
        }
        try { //this line of texts attempts to convert the nameChosen(number) into an integer, if there is an error, then the program crashes.
            Float.parseFloat(questionAge);
        } catch (NumberFormatException e) {
            System.out.println("You MUST input a valid number as your option");
            System.exit(0);
        }
        userInformation.add(questionAge); //adds weight to the arraylist


        System.out.println("Enter your height in meters(Enter to skip):");
        questionHeight = scanner.nextLine();
        if (questionHeight == "") {
            questionHeight = null;
        }
        try { //this line of texts attempts to convert the nameChosen(number) into an integer, if there is an error, then the program crashes.
            Float.parseFloat(questionHeight);
        } catch (NumberFormatException e) {
            System.out.println("You MUST input a valid number as your option");
            System.exit(0);
        }
        userInformation.add(questionHeight); //adds weight to the arraylist


        System.out.println("Enter your weight in kg(Enter to skip):");
        questionWeight = scanner.nextLine();
        if (questionWeight == "") {
            questionWeight = null;
        }
        try { //this line of texts attempts to convert the nameChosen(number) into an integer, if there is an error, then the program crashes.
            Float.parseFloat(questionWeight);
        } catch (NumberFormatException e) {
            System.out.println("You MUST input a valid number as your option");
            System.exit(0);
        }
        userInformation.add(questionWeight); //adds weight to the arraylist


        System.out.println("Add the number of km ran for the day(Enter to skip):");
        questionKM = scanner.nextLine();
        if (questionKM == "") {
            questionKM = null;
        }
        try { //this line of texts attempts to convert the nameChosen(number) into an integer, if there is an error, then the program crashes.
            Float.parseFloat(questionKM);
        } catch (NumberFormatException e) {
            System.out.println("You MUST input a valid number as your option");
            System.exit(0);
        }
        userInformation.add(questionKM);


        System.out.println("Add the number of calories you had for the day(Enter to skip):");
        questionCalories = scanner.nextLine();
        if (questionCalories == "") {
            questionCalories = null;
        }
        try { //this line of texts attempts to convert the nameChosen(number) into an integer, if there is an error, then the program crashes.
            Float.parseFloat(questionCalories);
        } catch (NumberFormatException e) {
            System.out.println("You MUST input a valid number as your option");
            System.exit(0);
        }
        userInformation.add(questionCalories);
        System.out.println(userInformation);

        return userInformation;

    }


    /**
     * A simple quick method which adds arraylists to an arraylist, and returns it
     * @param userInformation, an independant arraylist of all information for ONE specific user
     * @return globalInformaition. This returns the now UPDATED global arraylist of arraylist of information
     */
    public static ArrayList<ArrayList<String>> AddUserInfo(ArrayList<String> userInformation) { //function that is specifically for adding user independant information to the global Information of all users
        for(int testrepeat = 0; testrepeat< globalInformation.size(); testrepeat++){
            if (Integer.parseInt(globalInformation.get(testrepeat).get(0)) == Integer.parseInt(userInformation.get(0))){
                //globalInformation.set(testrepeat,userInformation);
                globalInformation.remove(globalInformation.get(testrepeat));
                return globalInformation;
            }
        }
        globalInformation.add(userInformation);
        return globalInformation;
    }


    /**
     * Function which is called when the third option is triggered in the main menu (General output)
     * @param names, A hashmap that stores names (this is here just to make sure the user inputs a valid key when inputting a user option
     */
    public static void genOutput(HashMap<Integer, String> names) {
        String nameChosen = null;
        String userChoice; //the user gets to input a choice between 1-5
        System.out.println("Pick a user:");
        System.out.println(namesArray);
        System.out.println("Please enter the number that corresponds to the name");
        nameChosen = scanner.nextLine();


        try { //this line of texts attempts to convert the nameChosen(number) into an integer, if there is an error, then the program crashes.
            Integer.parseInt(nameChosen);
        } catch (NumberFormatException e) {
            System.out.println("You MUST input a valid number as your option");
            System.exit(0);
        }


        if (Integer.parseInt(nameChosen) > names.size()) {//checking to see if its in range of the index provided
            System.out.println("You must input a name that has been provided");
            System.exit(0);
        }
        if (Integer.parseInt(nameChosen) < 1) {//checking to see if its in range of the index provided
            System.out.println("You must input a name that has been provided");
            System.exit(0);
        }


        System.out.println("Enter an option for output:");
        System.out.println("1: Print ALL Users");
        System.out.println("2: BMI calculation");
        System.out.println("3: Total calories burnt today from running(estimate)");
        System.out.println("4: Total km ran across all users");
        System.out.println("5: List of users past the age of 18");
        userChoice = scanner.nextLine();

        switch (Integer.parseInt(userChoice)) {//switch, which calls onto a function based on what the user
            case 1:
                System.out.println(namesArray);
                break;
            case 2:
                System.out.println(Calculator.BMI(Integer.parseInt(nameChosen)) + " Is your BMI");
                break;
            case 3:
                System.out.println(Calculator.netCalories(Integer.parseInt(nameChosen)) + " Is your total calories burnt from running");
                break;
            case 4:
                System.out.println(Calculator.totalKm(Integer.parseInt(nameChosen)) + " Is the total km ran across all users");
                break;
            case 5:
                System.out.println("The amount of users above 18 is " + (Calculator.userAbove18(Integer.parseInt(nameChosen))));
                break;
            default:
                System.out.println("You have to enter a valid input");
        }


    }
//Below is previous used code from demo 1. Kept just in case.
    /**
     * A function that returns bmi, which looks through the arraylist of arraylists of information
     *
     * @param nameChosen which is the id to the user that you choose to get info for.
     * @return bmi, which is a calculation of the bmi using weight and height
     
    public static double BMI(int nameChosen) {
        float weight = 0;
        float height = 0;
        double bmi = 0;
        for (int x = 0; x < globalInformation.size(); x++) { //for loop to check everything inside of the arraylist of arraylist to ensure that
            if (Integer.parseInt(((globalInformation.get(x)).get(0))) == (nameChosen)) { //messy section of code, checks to see if the users key name matches with the arraylist key
                weight = Float.parseFloat((globalInformation.get(x)).get(4));
                height = Float.parseFloat((globalInformation.get(x)).get(3));
                bmi = (weight / (Math.pow(height, 2))); //bmi formula calculation
            }
        }
        return bmi; //returns the bmi calculation
    }

    /**
     * A function that returns netCalories, which looks through the arraylist of arraylists of information.
     *
     * @param nameChosen which is the id to the user that you choose to get info for.
     * @return netCalories, which is a rough estimate of the calories burnt when taking into account the ammount ran for the day, as well as calories eaten. (passive calories are not included)
     
    public static double netCalories(int nameChosen) {
        float kmRan = 0;
        float caloriesEat = 0;
        double netCalories = 0;
        for (int x = 0; x < globalInformation.size(); x++) { //for loop to check everything inside of the arraylist of arraylist to ensure that
            if (Integer.parseInt(((globalInformation.get(x)).get(0))) == (nameChosen)) { //messy section of code, checks to see if the users key name matches with the arraylist key
                kmRan = Float.parseFloat((globalInformation.get(x)).get(5));
                caloriesEat = Float.parseFloat((globalInformation.get(x)).get(6));
                netCalories = ((kmRan * 60) - caloriesEat);
            }
        }
        return netCalories; //returns the net calories burnt off from the run
    }

    /**
     * //A method which adds all of the km ran.
     *
     * @param nameChosen which is the id to the user that you choose to get info for.
     * @return totalKM, which is the total km that ALL users have ran.
     
    public static double totalKm(int nameChosen) {
        float totalKM = 0;
        for (int x = 0; x < globalInformation.size(); x++) { //for loop to check everything inside of the arraylist of arraylist to ensure that
            totalKM += Float.parseFloat((globalInformation.get(x)).get(5)); //continously adds the km of ALL users untill for loop is done
        }
        return totalKM;
    }

    /**
     * A Method which adds a count if a user is above 18 (loops through all users)
     * @param nameChosen which is the id to the user that you choose to get info for.
     * @return userAbove18, which is a count of users above 18.
     
    public static int userAbove18(int nameChosen) {
        int userAbove18 = 0;
        for (int x = 0; x < globalInformation.size(); x++) { //for loop to check everything inside of the arraylist of arraylist to ensure that
            if (Float.parseFloat((globalInformation.get(x)).get(2)) > 18) { //if the users age is higher than 18, we add a +1 to userAbove18.
                userAbove18++;
            }

        }
        return userAbove18;
    }*/
}
