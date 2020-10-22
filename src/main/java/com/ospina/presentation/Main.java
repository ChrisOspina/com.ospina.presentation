/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.presentation;

import com.ospina.buisness.Shift;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains main program code. This class generates
 * a shift presentation for employees
 * @author cospina
 * @version 1.0
 * @since 9/20/20
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
        //First we will declare a new instance of Shift and Scannrer
        Shift s = new Shift();
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
       
        //To create a menu we first have to hardcode the options into the screen
        System.out.printf("Shift UI\n");
        System.out.println("--------");
        System.out.println("1 - Read shift from file as JSON");
        System.out.println("2 - Write shift to file as JSON");
        System.out.println("3 - Show shift info on screen");
        System.out.println("4 - Exit");
        //***********************************************
        //Before we make a while loop we need an indicator variable for
        //The user's choice
        //*******************************
        int choice = 0;
        //While the user's choice is note equal to 4
        while(choice != 4)
        {
            //The Scanner will allow the user to input their choice
            choice = option.nextInt();
            //We need a switch statement to determine what would happen
          switch(choice)
          {
              case 1: 
                  //*******************************************
                  //First it will ask the user for a string
                  //signifying the name of the input JSON file via scanner
                  //**************************************************         
                  System.out.println(" Enter Shift JSON Input Filename");
                  injson = in.nextLine();
                  //*******************************
                  //After taking in the file name it will call the
                  //FileReader class to read it
                  //*******************************
                  FileReader fr = new FileReader(injson);
                  s.readJSON(fr);
                  break;
              case 2:
                  //************************************
                  //The same thing will happen as in the first option
                  //but only, we are wrtiing to a JSON file
                  //*****************************************
                  System.out.println(" Enter Shift JSON Output Filename");
                  outjson = in.nextLine();
                  PrintStream pr = new PrintStream(outjson);
                  s.writeJSON(pr);
                  break;
              case 3:
                  //******************************
                  //This option will print out the ToString representation
                  //of the "s" instance of shift by printing out the
                  //date and hoursworked
                  //*********************************
                  System.out.println(s.toString());
                  break;
              case 4:
                  //This option ends the program
                  break;
              default:
                  //***************************************************
                  //To avoid a runtime error we will let the user know
                  //that any other number is invalid
                  //******************************************
                  System.out.println("Invaid choice, please try again");
                  break;
          }
              
        }
    }
    
}
