/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * Contains code for the shift class. This class represents
 * a worker's shift and borrows from the MyDate class
 * @author cospina
 * @version 1.0
 * @since 9/22/20
 */
public class Shift {
    @SerializedName("date") 
    private MyDate date;
    @SerializedName("hoursworked")
    private double HoursWorked;
    
    /**
     * This method is the default constructor for 
     * the shift class
     */
    
    public Shift(){}
    
    /**
     * This method is the constructor for the Shift class
     * which includes the member variables inherited from MyDate
     * @param hw represents a new value for the HoursWorked variable that a 
     * user could input
     * @param m represents a new Month value inherited from the 
     * instance of MyDate that users could input
     * @param y represents a new year value inherited from the instance of 
     * MyDate that users could input.
     * @param d 
     */
    public Shift(int hw, int m, int y, int d){
        HoursWorked = hw;
        date = new MyDate(m,d,y);
    }
   
    /**
     * This is the set method for 
     * the "HoursWorked" member variable.
     * 
     * @param hw a placeholder for any value that the user inputs
     */
    public void setHours(double hw){HoursWorked = hw;}
    
    /**
     * This is the get method for the "HoursWorked"
     * member variable
     * 
     * @return the current value of HoursWorked
     */
    public double getHours(){return HoursWorked;}
    
    /**
     * This is the set method for the "date" member variable 
     * In order to execute, we must set the member variables within it
     * because it's an instance of MyDate
     * @param d a placeholder instance "date"
     */
    public void setDate(MyDate d){
      date = d;
    }
    /**
     * The get method for the "date" instance of
     * MyDate
     * @return all values in the instance of MyDate
     */
    public MyDate getDate(){return date;}
     
    /**
     * Reads the contents of all member variables from the given
     * instance of FileReader as JSON. 
     * 
     * @param fr the FileReader instance that performs the reading
     * of the values as JSON
     * 
     */
    public void readJSON(FileReader fr){
       //***********************
       //In order to read to JSON we need a new instance
       //of GSONBuilder. We also need to call the setPrettyPrinting
       //and create methods while we are at it
       //********************************************
       GsonBuilder builder = new GsonBuilder();
       builder.setPrettyPrinting();
       Gson gson = builder.create();
       //******************************************
       //We then must create an instance of Shift in order to use as
       //a refrence for the JSON file to read
       //****************************************
       Shift s = gson.fromJson(fr, Shift.class);
       //Finally we will set each member variable to the returned values from get
       this.setHours(s.getHours());
       this.setDate(s.getDate());
   
    } 
   
    /**
     * Writes the member variables in JSON format to the given
     * PrintStream
     * 
     * @param ps the FileReader instance that performs the writing
     * of the values to JSON
     */
    public void writeJSON(PrintStream ps){
       //The same setup as above but we are writing to a JSON file
       GsonBuilder builder = new GsonBuilder();
       builder.setPrettyPrinting();
       Gson gson = builder.create();
       String jsonString = gson.toJson(this);
       ps.println(jsonString);
    }
   
   /**
    * Creates a string representation of the 
    * Shift object by concatenating the pre-written toString method
    * for the MyDate class and a printed number of "hoursworked"
    * 
    * @return the result of the toString method
    */ 
    @Override
    public String toString()
    {
        //****************************************************
        //The way this will be represented is through conactination
        //of the prewritten toString version of the "date" instance
        //and the the hoursWorked member variable
        //*******************************************
        String s = this.date.toString() + "," + " " + this.HoursWorked;
        return s;
    }
}
