/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;

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
   
   void setMonth(int m)
   {
       Month = m;
   }
    void setDay(int d)
   {
       Day = d;
   }
     void setYear(int y)
   {
       Year = y;
   }
   int getYear()
   {
       return Year;
   }
   int getDay()
   {
       return Day;
   }
   int getMonth()
   {
       return Month;
   }
   
}
