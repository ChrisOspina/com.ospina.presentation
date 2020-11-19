/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.presentation;


import com.ospina.buisness.Timesheet;
import javafx.application.Application;


/**
 * Contains main program code. This class generates
 * a Timesheet presentation for employees
 * @author cospina
 * @version 1.0
 * @since 10/20/20
 *
 */
public class Main {
    /**
     * This is the main method for the program 
     * @param args
     * 
     */
    public static void main(String args[])
    {
        Timesheet t = new Timesheet();
        
        Application.launch(TimeSheetApplication.class,args);
    }
    
}
