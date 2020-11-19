/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;

import java.io.FileReader;
import java.io.PrintStream;

/**
 * Contains code for the MyDate class. This class
 * represents a date in which a workers has taken a shift
 * the code will be reused in the Shift class through composition 
 * @author cospina
 * @since 9/22/20
 */
public class MyDate {
    private int Month;
    private int Day;
    private int Year;
    
  /**
   * This method is the 
   * Default constructor for the MyDate class
   * 
   */
   public MyDate(){}
   
   /**
    * This method is the constructor for the MyDate class.
    * Unlike the default constructor, the user sets his own values
    * @param NewMonth represents a new month value that the user inputs
    * @param NewDay represents a new day value that the user inputs
    * @param NewYear represents a new year value that the user inputs
    */
   public MyDate(int NewMonth, int NewDay,int NewYear)
   {
       Month = NewMonth;
       Day = NewDay;
       Year = NewYear;
   }
   
   /**
    * This is the set method for 
    * the "Month" member variable.
    * @param m a placeholder for a new month value
    */
   public void setMonth(int m) {Month = m;}
   
   /**
    * This is the set method for the
    * "Day" member variable
    * @param d a placeholder for a new day value
    */
   public void setDay(int d){Day = d;}
   
   /**
    * This is the set method for the
    * "Year" member variable
    * 
    * @param y a placeholder for a new year value
    */
   public void setYear(int y){Year = y;}
   
   /**
    * This is the get method for the 
    * "Year" member variable
    * 
    * @return the current value of "Year" 
    */
   public int getYear(){return Year;}
   
   /**
    * This is the get method for the 
    * "Day" member variable
    * 
    * @return the current value of "Day"
    */
   public int getDay() {return Day;}
   
   /**
    * This is the get method for the 
    * "Month" member variable
    * 
    * @return the current value of "Month"
    */
   public int getMonth() {return Month;}
   
}