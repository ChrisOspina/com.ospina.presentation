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
 * Contains code for the worker class. This class represents
 * a worker
 * @author cospina
 * @version 1.0
 * @since 9/22/20
 */
public class Worker {
    @SerializedName("first")
    private String first;
    @SerializedName("last")
    private String last;
    @SerializedName("id")
    private int id;
    @SerializedName("payRate")
    private double payrate;
    /**
     * This method is the default constructor for the 
     * Worker class
     */
    public Worker(){}
    /**
     * This method is the constructor for the Worker class.
     * Unlike the default constructor, the user sets his own values
     * 
     * @param newfirst represents a new first name a user could input
     * @param newlast  represents a new last name a user could input
     * @param newid    represents a new worker id a user could input
     * @param newpayrate represents a new payrate a user could input
     */
    public Worker(String newfirst, String newlast, int newid, double newpayrate)
    {
        first = newfirst;
        last = newlast;
        id = newid;
        payrate = newpayrate;
    }
    
    /**
     * This is the set method for 
     * the "first" member variable.
     * 
     * @param f a placeholder for a new "first" value
     */
    public void setFirst(String f){first =f;}
    
    /**
     * This is the set method for 
     * the "last" member variable.
     * @param l a placeholder for a new "last" value
     */
    public void setLast(String l){last = l;}
    
    /**
     * This is the set method for 
     * the "id" member variable.
     * @param i a placeholder for a new "id" value
     */
    public void setId(int i){id =i;}
    
    /**
     * This is the set method for 
     * the "payrate" member variable
     * 
     * @param pr a placeholder for a new "payrate" value
     */
    public void setRate(double pr){payrate = pr;}
    
    /**
     * This is the get method for 
     * the "first" member variable.
     * 
     * @return the current "first" value
     */
    public String getFirst(){return first;}
    
    /**
     * This is the get method for 
     * the "last" member variable.
     * 
     * @return the current "last" value
     */
    public String getLast(){return last;}
    
    /**
     * This is the get method for 
     * the "id" member variable.
     * 
     * @return the current "id" value
     */
    public int getId(){return id;}
    
    /**
     * This is the get method for 
     * the "payrate" member variable.
     * 
     * @return the current "payrate value
     */
    public double getRate(){return payrate;}
    
    /**
     * Reads the contents of all member variables from the given
     * instance of FileReader as JSON. 
     * 
     * @param fr the FileReader instance that performs the reading
     * of the values as JSON
     */
   public void readJSON(FileReader fr){
       //***********************
       //In order to read to JSON we need a new instance
       //of GSONBuilder. We also need to call the setPrettyPrinting
       //and create methods while we are at it
       //********************************************
       GsonBuilder builder = new GsonBuilder();
       builder.setPrettyPrinting();
       Gson gson = builder.create();
       //******************************************
       //We then must create an instance of Worker in order to use as
       //a refrence for the JSON file to read
       //****************************************
       Worker w = gson.fromJson(fr, Worker.class);
       //Finally we will set each member variable to the returned values from get
       this.setFirst(w.getFirst());
       this.setLast(w.getLast());
       this.setId(w.getId());
       this.setRate(w.getRate());
   
   } 
   
   /**
    * Writes the member variables in JSON format to the given
    * PrintStream
    * 
    * @param ps the FileReader instance that performs the writing
    * of the values to JSON
    */
   public void writeJSON(PrintStream ps){
       //The same setup as above but we are writing to a JSON file
       GsonBuilder builder = new GsonBuilder();
       builder.setPrettyPrinting();
       Gson gson = builder.create();
       String jsonString = gson.toJson(this);
       ps.println(jsonString);
   }
   
   /**
    * Creates a string representation of the 
    * worker object with descriptive text
    * 
    * @return the result of the toString method
    */
    @Override
    public String toString() {
        //**************************************************
        //The way this would is by conactinating the first and last name into
        //one line while printing out the workerID andpayrate member variables
        //into another
        //******************************************
        String s = this.first + " " + this.last + "\n" + "ID:" + this.id + " "
        + "Payrate:" + this.payrate;
        return s;
   }
}
