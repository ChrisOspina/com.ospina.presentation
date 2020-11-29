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
 * Contains code for the TimeSheetClass. This class represents
 * A Worker's Time sheet that documents their weekly shifts.
 * The shifts are represented through an array
 * @author cospina
 * @version 1.0
 * @since 10/21/20
 */
public class Timesheet {
    @SerializedName("worker")
    private Worker Worker;
    @SerializedName("shifts")
    private Shift Shifts[];
    /**
     * This method is the default constructor for the
     * Timesheet class
     */
    public Timesheet()
    {
        //********************************************************
        //The default cosntructor will create a new instance of worker and 
        //allocate the array of Shfits while seeting it to 4
        //****************************************************
        Worker = new Worker();
        Shifts = new Shift[4];
        for(int i =0; i< Shifts.length;i++)
        {
            Shifts[i] = new Shift();
        }
    }
    
    /**
     * This is the set method
     * for the worker member variable.
     * @param w the placeholder variable for worker
     */
    public void setWorker(Worker w){Worker = w;}
    /**
     * This is the get method for the worker member variable
     * @return the current instance of Worker
     */
    public Worker getWorker(){return Worker;}

    /**
     * This method returns the length of the shift.
     * It is necessary because it would allow the controller to access
     * the length of the shifts array.
     * @return the length of the shifts array
     */
    public int getShiftLen()
    {
        return Shifts.length;
    }
    /**
     * This method reads time sheet data from a JSON file
     * @param fr 
     */
    public void readJSON(FileReader fr)
    {
        //*************************************************
        //In order to read to JSON we need a new instance
        //of GSONBuilder. We also need to call the setPrettyPrinting
        //and create methods while we are at it
        //********************************************
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        //******************************************
        //We then must create an instance of Timesheet
        //in order to use as
        //a refrence for the JSON file to read
        //****************************************
        Timesheet t = gson.fromJson(fr, Timesheet.class);
        //***********************************************
        //This will set the current instance's member variables to 
        //those of the JSON file
        //*****************************************
        this.setWorker(t.getWorker());
        this.Shifts= t.Shifts;      
    } 
     /**
     * This method writes the time sheet to a JSON file
     *
     * @param ps
     */
    public void writeJSON(PrintStream ps) {
        //The same setup as above but we are writing to a JSON file
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        //*****************************************
        //We also need to confirm that we're writing the curent instance 
        //to the file and printing it
        //**************************************       
        String jsonString = gson.toJson(this);
        ps.println(jsonString);
    }
    public void report(PrintStream ps) {
    
        //****************************************
        //Same setup as the first assignment.
        //First we print the worker data as well as
        //hardcoding its respective labels
        //**************************************
        ps.println("Payroll Report");
        ps.println("---------------");
        ps.printf("First: %s\n", this.getWorker().getFirst());
        ps.printf("Last: %s\n", this.getWorker().getLast());
        ps.printf("Id: %d\n", this.getWorker().getId());
        ps.printf("Pay rate: %.2f\n", this.getWorker().getRate());
        ps.println(" ");
        ps.println("Month  Day  Year  Hours Worked  Pay");
        ps.println("-----  ---  ----  ----- ------  ---");
        //Creating a variable to hold the total hours and pay values
        double totalhrs = 0;
        double totalpay = 0;
        //This for loop will iterate through the Shifts array and print its data
        for (int i = 0; i < Shifts.length; i++) {
            //*************************************************************
            //Because pay is not a member variable, we need to calculate it 
            //by multiplying the worker's hourly rate with the hours that
            //the worker has taken their shift on.
            //***********************************************************888
            double pay = this.Worker.getRate() * Shifts[i].getHours();
            //Printing each instance from the array
            ps.printf("%3d %5d %6d %10.2f %10.2f\n", Shifts[i].getDate().getMonth(),
                    Shifts[i].getDate().getDay(), Shifts[i].getDate().getYear(),
                    Shifts[i].getHours(), pay);
            //Incrementing the total variables
            totalhrs += Shifts[i].getHours();
            totalpay += pay;
    }
    //After the loop we can print out the total values 
        ps.println(
                "-----  ---  ----  ------------  ---");
        ps.printf(
                "Total %20.2f %9.2f\n", totalhrs, totalpay);
    }
    
      /**
     * @param index represents which shift the user wants to
     * 
     * This method gives the user the nth instance of shift that they
     * input.
     * @return the nth instance of shift
     * @throws ArrayIndexOutOfBoundsException 
     */
    public Shift getShiftAt(int index) throws ArrayIndexOutOfBoundsException
    {
        //The index is not between 0 and 4
        if(index < 0 || index > Shifts.length)
        {
            //An Out of bounds exception will be thrown
            ArrayIndexOutOfBoundsException x;
            x = new ArrayIndexOutOfBoundsException();
            throw x;
        }
        //Otherwise it will function properly
        else
        {
            return Shifts[index];  
        }
    }

    /**
     * This method converts the object data into a string 
     * @return the String representation of the class
     */
    @Override
    public String toString()
    {
        //First we need to take the Worker's first and last name
        String s = Worker.getFirst() + " " + Worker.getLast() + "\n";
        //***********************************************************
        //Next this for loop will include the prewritten toString 
        //representations of each instance of the shifts array
        //*********************************************************
        for(int i =0; i<Shifts.length;i++)
        {  
          s += Shifts[i].toString()+"\n";
        }
        //Finally we can return the concactenated string 
        return s;       
    }
            
}      
   
