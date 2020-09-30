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
 *
 * @author cospina
 */
public class Shift {
    @SerializedName("date") 
    private MyDate date;
    @SerializedName("Hours worked")
    private double HoursWorked;
    
    public Shift(){}
    
    public Shift(int hw, int m, int y, int d){
        HoursWorked = hw;
        date = new MyDate(m,d,y);
    }
   
    public void setHours(double hw){HoursWorked = hw;}
    public double getHours(){return HoursWorked;}
    public void setDate(int m, int y, int d){
      date.setMonth(m);
      date.setDay(d);
      date.setYear(y);
    }
    public MyDate getDate(){return date;}
     
   void readJSON(FileReader fr){
     GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    Shift s = gson.fromJson(fr, Shift.class);
    this.setHours(s.getHours());
    this.date.setMonth(s.date.getMonth());
    this.date.setDay(s.date.getMonth());
    this.date.setYear(s.date.getYear());
   
   }
   
   void writeJSON(PrintStream ps){
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    String jsonString = gson.toJson(this);
    ps.println(jsonString);
   }
    
}
