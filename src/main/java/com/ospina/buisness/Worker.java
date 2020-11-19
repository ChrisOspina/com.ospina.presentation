/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.buisness;

/**
 * Contains code for the worker class. This class represents
 * a worker
 * @author cospina
 * @version 1.0
 * @since 9/22/20
 */
public class Worker {
    private String first;
    private String last;
    private int id;
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
}
