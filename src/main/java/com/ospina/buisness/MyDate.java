/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author cospina
 */
public class MyDate {
    private int Month;
    private int Day;
    private int Year;
    //default constructor 
   public MyDate(){}
   public MyDate(int NewMonth, int NewDay,int NewYear)
   {
       Month = NewMonth;
       Day = NewDay;
       Year = NewYear;
   }
   
   void setMonth(int m) {Month = m;}
   
   void setDay(int d){Day = d;}
   
   void setYear(int y){Year = y;}
   
   int getYear(){return Year;}
   int getDay() {return Day;}
   
   int getMonth() {return Month;}
   
   void readJSON(Scanner fr){
   this.setMonth(fr.nextInt());
   this.setDay(fr.nextInt());
   this.setYear(fr.nextInt());
   }
   
   void writeJSON(PrintStream ps){
    System.out.println(this.getMonth());
    System.out.println(this.getDay());
    System.out.println(this.getMonth());
   }
   
}
