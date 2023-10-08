package main.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Reader Class, This class is used at the start of the program (If the user chooses to load this file.)
 * This Class will then interpret all the lines as proper usable data, and then send it back to the main function
 */
public class Reader {
    //declaring the entire arraylist of each user in the file.
    private static ArrayList<String> userData = new ArrayList<String>();
    private static ArrayList<ArrayList<String>> usersData = new ArrayList<ArrayList<String>>();

    /**
     * Reader method ensures that we return an arraylist of arraylists from file
     * @return ArrayList of Arraylists
     */
    public static ArrayList<ArrayList<String>> ReaderAction(String argCheck){
        //declaring the file we're loading BY DEFAULT as being "Data.txt"
        File file = new File("Data.txt");

        //if we have an argument with a different data.txt name, we will be overrunning the previous file with whatever the user entered.
        if (!argCheck.equals("")){
            file = new File(argCheck);
        }
        if (!file.exists()) {
                try {
                    file.createNewFile();
                    System.out.println(file.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Issue with creating:");
                    e.printStackTrace();
                    System.exit(0);
                }
                System.out.println("Returning empty");
                return usersData;
            }
            //if the file is a readable file (proper log file) then we will be using the lines inside.
            else if (file.exists() && file.isFile() && file.canRead()) {
                try {
                    FileReader file_Reader = new FileReader(file);
                    BufferedReader buffered_Reader = new BufferedReader(file_Reader);
                    String line = buffered_Reader.readLine();


                    while (line != null) {
                        userData.add(line);
                        line = buffered_Reader.readLine();
                    }

                    //for everything in the list of lines, we will be splitting each line by commas.
                    for (int z = 0; z < userData.size(); z++) {
                        String[] splitList = userData.get(z).split(",");  //This line needs to be an Array, since we are SPLITTING it by comma
                        ArrayList<String> splitListArray = new ArrayList<String>();
                        Main.globalCount++; //adding +1 to x so we dont cause confusion
                        //Adding everything from the ARRAY splitlist to splitListArray, so we can actually add the arraylist to the master arraylist of this class
                        Collections.addAll(splitListArray, splitList);
                        usersData.add(splitListArray);

                    }

                file_Reader.close();

                } catch (FileNotFoundException e) {
                    System.out.println("Error, file not found");
                    e.printStackTrace();
                    System.exit(0);
                } catch (IOException e) {
                    System.out.println("Error, IO exception");
                    e.printStackTrace();
                    System.exit(0);
                }
            }
            return usersData;
    }
}
