/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.presentation;


import com.ospina.buisness.Timesheet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains main program code. This class generates
 * a Timesheet presentation for employees
 * @author cospina
 * @version 1.0
 * @since 10/20/20
 *
 */
public class Main {
    /**
     * This is the main method for the program 
     * @param args
     * @throws FileNotFoundException in case a file is not found
     */
    public static void main(String args[]) throws FileNotFoundException
    {
        //First we will declare a new instance of Timesheet
        Timesheet t = new Timesheet(); 
        //*******************************************
        //We will also need two instances of scanner
        //One to input the names of the JSON files
        //And another to input the user's menu choice
        //************************
        Scanner in = new Scanner(System.in);
        Scanner option = new Scanner(System.in);
        //These JSON string variables are placeholders for what the user inputs
        String injson;
        String outjson;
        //This variable will store the shift index for later
        int shiftindex = 0;
        //To create a menu we first have to hardcode the options into the screen
        System.out.printf("TimeSheet UI\n");
        System.out.println("-----------");
        System.out.println("1 - Read TimeSheet from file as JSON");
        System.out.println("2 - Write TimeSheet tofile as JSON");
        System.out.println("3 - Show Shift at index");
        System.out.println("4 - Show Shift with most hours");
        System.out.println("5 - Show TimeSheet report on Screen");
        System.out.println("6 - Show TimeSheet toString on Screen");
        System.out.println("7 - Exit");
        //***********************************************
        //Before we make a while loop we need an indicator variable for
        //The user's choice
        //*******************************
        int choice = 0;
       // While the user's choice is not equal to 7
        while(choice != 7)
        {            
            //The Scanner will allow the user to input their choice
            choice = option.nextInt();
            //We need a switch statement to determine what would happen
            switch(choice)
            {
                case 1: 
                    //Asking the user for a JSON filename
                    System.out.println(" Enter TimeSheet JSON Input Filename");
                    injson = in.nextLine();
                    //creating a new instance of FileReader to reader to JSON
                    FileReader fr = new FileReader(injson);
                    t.readJSON(fr);
                    break;
                case 2:
                    //*****************************************
                    //Same algorithim but we're writing to JSON and creating
                    //an instance of PrintStream
                    //***************************
                    System.out.println(" Enter TimeSheet JSON Output Filename");
                    outjson = in.nextLine();
                    PrintStream pr = new PrintStream(outjson);
                    t.writeJSON(pr);
                    break;
                case 3:
                    
                    try
                    {
                        //**********************************************
                        //Inside the try the user will input an index
                        //Which will signify which instance in the array 
                        //to return and print out
                        //***************************************88
                        System.out.println("Select an index 0-4");
                        shiftindex = in.nextInt();
                        System.out.println(t.getShiftAt(shiftindex));
                    }
                    catch(ArrayIndexOutOfBoundsException x)
                    {
                        //***********************************************
                        //In case the index is out of bounds it will print
                        //a message to the console to avoid an error.
                        //********************************************
                        System.err.println("The index is out of bounds");
                    }                         
                    break;
                case 4:
                    //Prints out the shift with the longest amount of hours
                    System.out.println(t.getMaxShift());
                    break;
                case 5:
                    //Prints the prewritten report to the screen
                    t.report(System.out);
                    break;
                case 6:
                    //Prints the prewritten ToString representation to the screen
                    System.out.println(t.toString());
                    break;
                case 7: 
                    break;
                default:
                    //Lets the user know that the choice is invalid
                    System.out.println("Invalid choice, please try again.");
            }
              
        }
    }
    
}
