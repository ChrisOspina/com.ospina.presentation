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
 * Contains code for the MyDate class. This class represents a date in which a
 * workers has taken a shift the code will be reused in the Shift class through
 * composition
 *
 * @author cospina
 * @since 9/22/20
 */
public class MyDate {

    @SerializedName("month")
    private int Month;
    @SerializedName("day")
    private int Day;
    @SerializedName("year")
    private int Year;

    /**
     * This method is the Default constructor for the MyDate class
     *
     */
    public MyDate() {
    }

    /**
     * This method is the constructor for the MyDate class. Unlike the default
     * constructor, the user sets his own values
     *
     * @param NewMonth represents a new month value that the user inputs
     * @param NewDay represents a new day value that the user inputs
     * @param NewYear represents a new year value that the user inputs
     */
    public MyDate(int NewMonth, int NewDay, int NewYear) {
        Month = NewMonth;
        Day = NewDay;
        Year = NewYear;
    }

    /**
     * This is the set method for the "Month" member variable.
     *
     * @param m a placeholder for a new month value
     */
    public void setMonth(int m) {
        Month = m;
    }

    /**
     * This is the set method for the "Day" member variable
     *
     * @param d a placeholder for a new day value
     */
    public void setDay(int d) {
        Day = d;
    }

    /**
     * This is the set method for the "Year" member variable
     *
     * @param y a placeholder for a new year value
     */
    public void setYear(int y) {
        Year = y;
    }

    /**
     * This is the get method for the "Year" member variable
     *
     * @return the current value of "Year"
     */
    public int getYear() {
        return Year;
    }

    /**
     * This is the get method for the "Day" member variable
     *
     * @return the current value of "Day"
     */
    public int getDay() {
        return Day;
    }

    /**
     * This is the get method for the "Month" member variable
     *
     * @return the current value of "Month"
     */
    public int getMonth() {
        return Month;
    }

    /**
     * Reads the contents of all member variables from the given instance of
     * FileReader as JSON.
     *
     * @param fr the FileReader instance that performs the reading of the values
     * as JSON
     *
     */
    public void readJSON(FileReader fr) {
        //***********************
        //In order to read to JSON we need a new instance
        //of GSONBuilder. We also need to call the setPrettyPrinting
        //and create methods while we are at it
        //********************************************
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        //******************************************
        //We then must create an instance of MyDate in order to use as
        //a refrence for the JSON file to read
        //****************************************
        MyDate md = gson.fromJson(fr, MyDate.class);
        //Finally we will set each member variable to the returned values from get
        this.setMonth(md.getMonth());
        this.setDay(md.getDay());
        this.setYear(md.getYear());
    }

    /**
     * This method creates a string representation of the MyDate object in
     * proper date format
     *
     * @return the result of the ToString method
     */
    @Override
    public String toString() {
        //**********************************************************
        //To create the string representation we must concatenate
        //all member values of this class into proper date format
        //**********************************************************
        String s = this.Month + "/" + this.Day + "/" + this.Year;
        return s;
    }
}
