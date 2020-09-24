/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;

import java.io.FileReader;
import java.io.PrintStream;

/**
 *
 * @author cospina
 */
public class Shift {
    private MyDate date;
    private double HoursWorked;
    
    public Shift(){}
    
    public Shift(MyDate d, int hw){date = d; HoursWorked = hw;}
   
    public void setDate(MyDate d){date = d;}
    public void setHours(double hw){HoursWorked = hw;}
    public MyDate getDate(){return date;}
    public double getHours(){return HoursWorked;}
    
     
   void readJSON(FileReader fr){
     
   
   }
   
   void writeJSON(PrintStream ps){
    System.out.println(this.getDate());
    System.out.println(this.getHours());
   }
    
}
