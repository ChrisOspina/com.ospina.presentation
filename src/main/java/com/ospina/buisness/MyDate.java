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
public class MyDate {
    @SerializedName("month:")
    private int Month;
    @SerializedName("day:")
    private int Day;
    @SerializedName("year:")
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
   
   void readJSON(FileReader fr){
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    
    MyDate md = gson.fromJson(fr, MyDate.class);
    this.setMonth(md.getMonth());
    this.setDay(md.getDay());
    this.setYear(md.getYear());
   }
   
   void writeJSON(PrintStream ps){
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    String jsonString = gson.toJson(this);
    ps.println(jsonString);
   }
   
}
