package main.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    // creating  class user
    private String name;
    private int age;
    private float height;
    private float weight;
    private float totalKm;
    private double netCalories;
    private static HashMap<Integer, String> Names = new HashMap<Integer, String>();

    // creating a constructor called User
    public User(String name, int age, int height, int weight, int numberOfKilometres, int totalCalories) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.totalKm = numberOfKilometres;
        this.netCalories = totalCalories;
    }

    public static HashMap<Integer, String> getNames() {
        return Names;
    }

    public static void setNames(HashMap<Integer, String> names) {
        Names = names;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(float totalKm) {
        this.totalKm = totalKm;
    }

    public double getNetCalories() {
        return netCalories;
    }

    public void setNetCalories(double netCalories) {
        this.netCalories = netCalories;
    }

    @Override
    // instance method that default prints for the object
    public String toString(){
        return "User:" + name +
                "\nAge:" + age +
                "\nHeight:" + height  +
                "\nWeight:" + weight +
                "\nTotal kilometres ran:" + totalKm +
                "\nTotal calories consumed:" + netCalories;
    }

    // method for choice 1 "Adding a name"

    /**
     * method that adds a user and id to the hashmap
     * @return the hashmap of names, containing (id, name)
     */
    public static HashMap<Integer, String> NameDefine() {
        Scanner scanner = new Scanner(System.in);

        boolean loopControl = false;
        while (loopControl != true) { //Placed inside of a loop, so that the user is able to continuously add new names if they choose so.
            Main.globalCount = Main.globalCount + 1; //continuously increases by 1 for the global variable, in order to attach future names to this value
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            User.Names.put(Main.globalCount, name); //Adding the users name, as well as a number to associate with the name
            System.out.println("Enter another name?");
            System.out.println("Enter = Yes");
            System.out.println("Any other key = No");
            String loopBreaker = scanner.nextLine();
            if (!(loopBreaker.equals(""))) {
                loopControl = true;
            }

        }

        return Names;
    }

    // method for adding the user data
    /**
     * A simple quick method which adds arraylists to an arraylist, and returns it
     * @param userInformation, an independant arraylist of all information for ONE specific user
     * @return globalInformaition. This returns the now UPDATED global arraylist of arraylist of information
     */
    public static ArrayList<ArrayList<String>> AddUserInfo(ArrayList<String> userInformation) {
        //function that is specifically for adding user independant information to the global Information of all users
        for(int testrepeat = 0; testrepeat<Main.globalInformation.size();testrepeat++){
            if (Integer.parseInt(Main.globalInformation.get(testrepeat).get(0)) == Integer.parseInt(userInformation.get(0))){
                Main.globalInformation.set(testrepeat,userInformation);
                return Main.globalInformation;
            }
        }
        Main.globalInformation.add(userInformation);
        return Main.globalInformation;
    }


}
