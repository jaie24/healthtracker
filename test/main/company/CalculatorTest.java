package main.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static main.company.Main.globalInformation;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that is responsible for each button press and action.
 * A certain action/calculation with be promted when a user clicks or inputs something, and
 * as a result, this information is located here, and changed accordingly.
 * @version 1.0
 */
class CalculatorTest {
    /**
     * Test to check if its out of range
     * crete an arraylist filed with user information to access certain values to calculate the bmi
     */
    @Test
    void BMI() {
        globalInformation.clear();
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("Bob");
        list.add("18");
        list.add("161");
        list.add("45");
        list.add("3.2");
        list.add("900");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("Joe");
        list2.add("20");
        list2.add("2");
        list2.add("56");
        list2.add("5.4");
        list2.add("1000");
        globalInformation.add(list);
        globalInformation.add(list2);
        int nameChosen = 1;
        assertEquals(0.0017360441340997647, Calculator.BMI(nameChosen));
        globalInformation.clear();

    }

    /**
     * Test to see if netCalories falls out of range
     * created an arraylist filled with information to obtain certain values to calculate the net calories
     */
    @Test
    void netCalories() {
        globalInformation.clear();
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("Alice");
        list.add("18");
        list.add("161");
        list.add("45");
        list.add("10");
        list.add("900");
        globalInformation.add(list);
        int nameChosen = 1;
        assertEquals(-300.0, Calculator.netCalories(1));
        globalInformation.clear();
    }

    /**
     * Test to see if netCalories falls out of range
     * created an arraylist filled with information to obtain certain values to calculate the net calories
     */
    @Test
    void netCalories_2() {
        globalInformation.clear();
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("Alice");
        list.add("18");
        list.add("161");
        list.add("45");
        list.add("10");
        list.add("1250");
        globalInformation.add(list);
        int nameChosen = 1;
        assertEquals(-650.0, Calculator.netCalories(1));
        globalInformation.clear();
    }

    /**
     * Test to see if totalK add up correctly
     * created an arraylist filled wit user information to test the total kilometres ran by an individual
     */
    @Test
    void totalKm() {
        globalInformation.clear();
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("Alice");
        list.add("18");
        list.add("161");
        list.add("45");
        list.add("3.2");
        list.add("900");
        globalInformation.add(list);
        ArrayList<String> list2 = new ArrayList<String>();
        list.add("2");
        list.add("B");
        list.add("18");
        list.add("161");
        list.add("45");
        list.add("3.2");
        list.add("900");
        globalInformation.add(list);
        ArrayList<String> list3 = new ArrayList<String>();
        list.add("3");
        list.add("C");
        list.add("18");
        list.add("161");
        list.add("45");
        list.add("3.2");
        list.add("900");
        globalInformation.add(list);

        int nameChosen = 1;
        assertEquals(9.600000381469727, Calculator.totalKm(0));
        globalInformation.clear();

    }

    /**
     * Test to see if userAbove18 falls out of range.
     * created an arraylist filled with user information to access and test the age of user
     */
    @Test
    void userAbove18() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Alice");
        list.add("18");
        list.add("161");
        list.add("45");
        list.add("3.2");
        list.add("900");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("David");
        list2.add("20");
        list2.add("183");
        list.add("56");
        list.add("5.4");
        list.add("1000");
        ArrayList<ArrayList<String>> globalInformaiton = new ArrayList<ArrayList<String>>();
        globalInformaiton.add(list);
        globalInformaiton.add(list2);
        String sAge = (globalInformaiton.get(1).get(1));
        Integer iAge = Integer.parseInt(sAge);
        assertEquals(20, iAge);
        globalInformation.clear();
    }

}