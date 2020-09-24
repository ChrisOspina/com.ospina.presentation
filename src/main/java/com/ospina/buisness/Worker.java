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
public class Worker {
    private String first;
    private String last;
    private int id;
    private double payrate;
    
    public Worker(){}
    public Worker(String newfirst, String newlast, int newid, double newpayrate)
    {
        first = newfirst;
        last = newlast;
        id = newid;
        payrate = newpayrate;
    }
    void setFirst(String f){first =f;}
    void setLast(String l){last = l;}
    void setId(int i){id =i;}
    void setRate(double pr){payrate = pr;}
    String getFirst(){return first;}
    String getLast(){return last;}
    int getId(){return id;}
    double getRate(){return payrate;}
    
   void readJSON(Scanner fr){
   this.setFirst(fr.nextLine());
   this.setLast(fr.nextLine());
   this.setId(fr.nextInt());
   this.setRate(fr.nextFloat());
   
   }
   
   void writeJSON(PrintStream ps){
    System.out.println(this.getFirst());
    System.out.println(this.getLast());
    System.out.println(this.getId());
    System.out.println(this.getRate());
   }
   
    
}
