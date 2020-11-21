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
    
     public void writeJSON(PrintStream ps)
    {
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
   
