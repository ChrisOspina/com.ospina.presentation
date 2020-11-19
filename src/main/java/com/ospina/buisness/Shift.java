/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;
/**
 * Contains code for the shift class. This class represents
 * a worker's shift and borrows from the MyDate class
 * @author cospina
 * @version 1.0
 * @since 9/22/20
 */
public class Shift { 
    private MyDate date;
    private double HoursWorked;
    
    /**
     * This method is the default constructor for 
     * the shift class
     */
    public Shift(){
        date = new MyDate();
        HoursWorked = 0;
    }
    
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
}
