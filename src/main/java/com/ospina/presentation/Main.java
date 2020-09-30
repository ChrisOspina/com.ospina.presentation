/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.presentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ospina.buisness.Shift;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author cospina
 */
public class Main {
    public static void main(String args[]) throws FileNotFoundException
    {
        Shift s = new Shift();
        String injson = "";
        String outjson = "";
        System.out.printf("Shift UI\n");
        System.out.println("--------");
        System.out.println("1 - Read shift from file as JSON");
        System.out.println("2 - Write shift to file as JSON");
        System.out.println("3 - Show shift info on screen");
        System.out.println("4 -Exit");
        int choice = 0;
          GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
          Gson gson = builder.create();
        while(choice != 4)
        {
          switch(choice)
          {
              case 1: 
                  System.out.println(" Enter Shift JSON Input Filename");
                  System.in(injson);
                  FileReader fr = new FileReader(injson);
                  s = gson.fromJson(fr, Shift.class);
                  break;
              case 2:
                  System.out.println(" Enter Shift JSON Output Filename");
                  System.in(outjson);
                  PrintStream pr = new PrintStream(outjson);
                  break;
              case 3:
                  break;
              default:
                  System.out.println("Invaid choice, please try again");
                  break;
          }
              
        }
    }
    
}
