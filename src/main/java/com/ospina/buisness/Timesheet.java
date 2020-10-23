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
public class Timesheet {
    private Worker Worker;
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
    
    
}
