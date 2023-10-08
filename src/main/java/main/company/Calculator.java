package main.company;

/**
 * This class is responsible for the production of the necessary calculations for the program.
 * When calling each function within this class (with necessary parameters) it will return the
 * proper calculation.
 * Author: Jiayi Teh
 * Date : 14 April 2021
 *
 */
public class Calculator extends Main {
        // create public methods for every calculation that we compute to display in the general output
        // methods will be static so we can access them in the main class without creating an instance of the class
        // method for calculating BMI

        /**
        * A method that returns bmi, which looks through the arraylist of arraylists of information
        *
        * @param nameChosen which is the id to the user that you choose to get info for.
        * @return bmi, which is a calculation of the bmi using weight and height
        */
        public static double BMI(int nameChosen){
            float weight = 0;
            float height = 0;
            double bmi = 0;
            for (int x = 0; x < globalInformation.size(); x++) { //for loop to check everything inside of the arraylist of arraylist to ensure that
                if (Integer.parseInt(((globalInformation.get(x)).get(0))) == (nameChosen)) { //messy section of code, checks to see if the users key name matches with the arraylist key
                    weight = Float.parseFloat((globalInformation.get(x)).get(4));
                    height = Float.parseFloat((globalInformation.get(x)).get(3));
                    bmi = (weight / (Math.pow(height, 2))); // bmi formula calculation
                }
            }
            return bmi;
        }

        // method for calculating netCalories
        /**
        * A method that returns netCalories, which looks through the arraylist of arraylists of information.
        *
        * @param nameChosen which is the id to the user that you choose to get info for.
        * @return netCalories, which is a rough estimate of the calories burnt when taking into account the ammount ran for the day, as well as calories eaten. (passive calories are not included)
        */
        public static double netCalories(int nameChosen){
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

        // method for calculating kilometres ran
         /**
        * //A method which adds all of the km ran.
        *
        * @param nameChosen which is the id to the user that you choose to get info for.
        * @return totalKM, which is the total km that ALL users have ran.
        */

        public static float totalKm(int nameChosen){
            float totalKM = 0;
            for (int x = 0; x < globalInformation.size(); x++) { //for loop to check everything inside of the arraylist of arraylist to ensure that
                totalKM += Float.parseFloat((globalInformation.get(x)).get(5)); //continously adds the km of ALL users untill for loop is done
            }
            return totalKM;
        }

        // method for getting the users above 18
        /**
        * A method which adds a count if a user is above 18 (loops through all users)
         * @param nameChosen which is the id to the user that you choose to get info for.
        * @return userAbove18, which is a count of users above 18.
         */
         public static  int userAbove18(int nameChosen) {
            int userAbove18 = 0;
            for (int x = 0; x < globalInformation.size(); x++) { //for loop to check everything inside of the arraylist of arraylist to ensure that
                if (Float.parseFloat((globalInformation.get(x)).get(2)) > 18) { //if the users age is higher than 18, we add a +1 to userAbove18.
                userAbove18++;
            }

        }
        return userAbove18;
    }

}
