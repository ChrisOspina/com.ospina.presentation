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
public class Timesheet {
    @SerializedName("worker")
    private Worker Worker;
    @SerializedName("shifts")
    private Shift Shifts[];
    public Timesheet()
    {
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
    
    public void setWorker(Worker w){Worker = w;}
    public Worker getWorker(){return Worker;}
    public Shift getMaxShift()
    {
       Shift MaxShift = new Shift();
       for(int i=0; i< Shifts.length; i++)
       {
           if(Shifts[i].getHours()>Shifts[i-1].getHours())
           {
               MaxShift.setHours(Shifts[i].getHours());
               MaxShift.setDate(Shifts[i].getDate());
           }
       }
        return MaxShift;
    }
    public Shift getShiftAt(int index) throws ArrayIndexOutOfBoundsException
    {
        return Shifts[index];
    }
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
           ps.printf("%d %2d %2d %2.2f\n",Shifts[i].getDate().getMonth(),
                  Shifts[i].getDate().getDay(), Shifts[i].getDate().getYear(),
                  Shifts[i].getHours(),pay);
           totalhrs = Shifts[i].getHours()+ Shifts[i-1].getHours();
           totalpay += pay;
       }
       
       ps.println("-----  ---  ----  ----- ------  ---");
       ps.printf("Total %20.2f %2.2f",totalhrs,totalpay);
    }
    
    public void writeJSON(PrintStream ps)
    {
       GsonBuilder builder = new GsonBuilder();
       builder.setPrettyPrinting();
       Gson gson = builder.create();
       String jsonString = gson.toJson(this);
       ps.println(jsonString);
    }
    
    public void readJSON(FileReader fr)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Timesheet t = gson.fromJson(fr, Timesheet.class);
        this.setWorker(t.getWorker());
        for (int i =0; i<Shifts.length;i++)
        {
           Shifts[i].readJSON(fr);
        }
    }
            
    
}
