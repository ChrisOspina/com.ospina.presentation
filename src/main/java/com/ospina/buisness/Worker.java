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
public class Worker {
    @SerializedName("first")
    private String first;
    @SerializedName("last")
    private String last;
    @SerializedName("id")
    private int id;
    @SerializedName("payrate")
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
    
   void readJSON(FileReader fr){
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    Worker w = gson.fromJson(fr, Worker.class);
    this.setFirst(w.getFirst());
    this.setLast(w.getLast());
    this.setId(w.getId());
    this.setRate(w.getRate());
   
   } 
   void writeJSON(PrintStream ps){
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    String jsonString = gson.toJson(this);
    ps.println(jsonString);
   }
   
    
}
