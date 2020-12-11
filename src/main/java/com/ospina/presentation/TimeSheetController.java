/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.presentation;

import com.ospina.buisness.Timesheet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;



/**
 * This class is the controller for all methods in the application.
 * The controller also assigns these methods to different controls
 * of the interface.
 * @author cospina
 * @since 11/17/20
 */
public class TimeSheetController
{
    //First we need to declare and allocate an instance of Timesheet
   private Timesheet t = new Timesheet();
   
   //***************************************************8
   //These attributes are necessary to allow us to connect to the 
   //FXML file
   //*************************************
   @FXML
   private ListView <String> shiftslistview;
   
   private FileReader fr;
   
   @FXML
   private TextField first_name;
   
   @FXML
   private TextField last_name;
   
   @FXML
   private TextField worker_id;
   
   @FXML
   private TextField payrate;
   
   
    /**
     * This method handles what would happen when the user clicks 
     * "Open" in the File Menu. It reads an instance from JSON and 
     * sets the text fields to the values present
     * @throws FileNotFoundException
     */
   @FXML
   protected void openfileAction() throws FileNotFoundException
   {
       //First we need to declare a new instance of FileChooser
       FileChooser fileChooser = new FileChooser();
       fileChooser.setTitle("Open TimeSheet File");
       //********************************************************
       //This lets the computer know that whatever file the user selects 
       //is the one that the system will read in
       //**************************************************
       File file = fileChooser.showOpenDialog(null);
       fr = new FileReader(file);
       t.readJSON(fr);
       
       //Changing the value in the textfields to the values from JSON
       first_name.setText(t.getWorker().getFirst());
       last_name.setText(t.getWorker().getLast());
       worker_id.setText(String.valueOf(t.getWorker().getId()));
       payrate.setText(String.valueOf(t.getWorker().getRate()));
       
       //**********************************************************
       //For the list view we need a for loop that will access the shifts array
       //To that we need to call getShfitLen and getShiftAt because the member
       //variables are private
       //*****************************************************
       for (int i = 0; i<t.getShiftLen();i++)
       {
           //This will add the shift data to the listview
           shiftslistview.getItems().add(t.getShiftAt(i).toString());
       }
   }   
   /**
    * This method handles when the user presses "Exit"
    * With the value of "0"
    */
   @FXML
   protected void handleExitAction()
   {
       //Extis the form with a value of 0
       System.exit(0);
   }
   /**
    * This method handles what happens when the user presses
    * "Save As" in the file menu. This method writes to a JSON File
    * @throws FileNotFoundException 
    */
   @FXML
   protected void SaveAsAction() throws FileNotFoundException
   {
       //******************************************
       //Same setup as Open but we are writing to a file
       // and not displaying values
       //***********************************
       FileChooser fileChooser = new FileChooser();
       fileChooser.setTitle("Save as TimeSheet");
       File file = fileChooser.showOpenDialog(null);
       PrintStream ps = new PrintStream(file);
       t.writeJSON(ps);
   }
   /**
    * This method handles what happens when the user presses
    * "Save" in the file menu. This method prints to a TXT File
    * @throws FileNotFoundException 
    */
   @FXML
   protected void saveaction() throws FileNotFoundException
   {
       //Same setup but only we are printing to a TXT file
       FileChooser fileChooser = new FileChooser();
       fileChooser.setTitle("Save as TimeSheet");
       File file = fileChooser.showOpenDialog(null);
       PrintStream ps = new PrintStream(file);
       t.report(ps);
   }

}
