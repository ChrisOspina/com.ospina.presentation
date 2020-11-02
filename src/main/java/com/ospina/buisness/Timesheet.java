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
        Worker = new Worker();
        Shifts = new Shift[4];
        MyDate d = new MyDate();
        d.setDay(0);
        d.setMonth(0);
        d.setYear(0);
        for(int i =0; i< Shifts.length;i++)
        {
            Shifts[i] = new Shift();
            this.Shifts[i].setHours(0.00);
            this.Shifts[i].setDate(d);
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
     * This method returns the shift with the 
     * maximum hours
     * 
     * In order to do this we must compare the current shift with the ]
     * previous one. If the current one has a shift with longer hours
     * the max shift variable will be updated.
     * 
     * @return the shift with the maximum hours. 
     */
    public Shift getMaxShift()
    {
       Shift MaxShift = new Shift();
       for(int i=0; i< Shifts.length; i++)
       {
           if(Shifts[i].getHours()>MaxShift.getHours())
           {
               MaxShift.setHours(Shifts[i].getHours());
               MaxShift.setDate(Shifts[i].getDate());
           }
       }
        return MaxShift;
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
      if(index< 0 || index > Shifts.length)
        {
           ArrayIndexOutOfBoundsException x;
           x = new ArrayIndexOutOfBoundsException();
           throw x;
        }
      else
      {
         return Shifts[index];  
      }
    }
    /**
     * This method prints a shift report to a given printstream.
     * @param ps 
     */
    public void report(PrintStream ps)
    {
       ps.println("Payroll Report");
       ps.println("---------------");
       ps.printf("First: %s\n", this.getWorker().getFirst());
       ps.printf("Last: %s\n", this.getWorker().getLast());
       ps.printf("Id: %d\n", this.getWorker().getId());
       ps.printf("Pay rate: %.2f\n",this.getWorker().getRate());
       ps.println(" ");
       ps.println("Month  Day  Year  Hours Worked  Pay");
       ps.println("-----  ---  ----  ----- ------  ---");
       
       double totalhrs = 0;
       double totalpay = 0;
       
       for(int i = 0; i<Shifts.length;i++)
       {
           double pay = this.Worker.getRate()* Shifts[i].getHours();
           ps.printf("%3d %5d %4d %10.2f %10.2f\n",Shifts[i].getDate().getMonth(),
                  Shifts[i].getDate().getDay(), Shifts[i].getDate().getYear(),
                  Shifts[i].getHours(),pay);
            totalhrs += Shifts[i].getHours();   
            totalpay += pay;
       }
       ps.println("-----  ---  ----  ------------  ---");
       ps.printf("Total %20.2f %9.2f\n",totalhrs,totalpay);
    }
    /**
     * This method writes the time sheet to a JSON file
     * @param ps 
     */
    public void writeJSON(PrintStream ps)
    {
       GsonBuilder builder = new GsonBuilder();
       builder.setPrettyPrinting();
       Gson gson = builder.create();
       String jsonString = gson.toJson(this);
       ps.println(jsonString);
    }
    /**
     * This method reads time sheet data from a JSON file
     * @param fr 
     */
    public void readJSON(FileReader fr)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Timesheet t = gson.fromJson(fr, Timesheet.class);
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
        String s = Worker.getFirst() + " " + Worker.getLast() + "\n";
        for(int i =0; i<Shifts.length;i++)
        {  
          s += Shifts[i].toString()+" hrs"+"\n";
        }         
       return s;       
    }
            
    
}
