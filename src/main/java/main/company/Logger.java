package main.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Logger class, This class is responsible for printing the entire arraylist of array individually
 * to the file that has been chosen. If the argcheck is default ("") we will just be using the default file name.
 */
public class Logger {

    /**
     * This function is responsible for converting all data INTO the file
     * @param argCheck Passes an arg check into the logger action, which is a string (blank by default0
     * @param globalInfo Passes in the arraylist globalinformation.
     */
    public static void LoggerAction(String argCheck, ArrayList<ArrayList<String>> globalInfo){
        //declaring the file we're Saving to BY DEFAULT as being "Data.txt"
        try {
            FileWriter fileWriter = new FileWriter("Data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            //if we have an argument with a different data.txt name, we will be overrunning the previous file with whatever the user entered.
            if (!argCheck.equals("")) {
                fileWriter = new FileWriter(argCheck);
                System.out.println("THE ARGCHECK IS " + argCheck);
            }

            //printing each indibidual value (should consist of 7 in total
            for (int x = 0; x < globalInfo.size(); x++){

                fileWriter.write(String.valueOf(globalInfo.get(x).get(0)) + ",");
                fileWriter.write(String.valueOf(globalInfo.get(x).get(1)) + ",");
                fileWriter.write(String.valueOf(globalInfo.get(x).get(2)) + ",");
                fileWriter.write(String.valueOf(globalInfo.get(x).get(3)) + ",");
                fileWriter.write(String.valueOf(globalInfo.get(x).get(4)) + ",");
                fileWriter.write(String.valueOf(globalInfo.get(x).get(5)) + ",");
                fileWriter.write(String.valueOf(globalInfo.get(x).get(6)) + "\n");
                System.out.println("writing");
            }
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error with writing");
            e.printStackTrace();
        }
    }
}
