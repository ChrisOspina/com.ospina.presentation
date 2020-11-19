/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;

/**
 * Contains code for the TimeSheetClass. This class represents
 * A Worker's Time sheet that documents their weekly shifts.
 * The shifts are represented through an array
 * @author cospina
 * @version 1.0
 * @since 10/21/20
 */
public class Timesheet {
    private Worker Worker;
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
    
}      
   
