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
import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
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
   private Timesheet t = new Timesheet();
    
   @FXML
   private ListView <String> shiftslistview = new ListView<>();;
   
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
       FileChooser fileChooser = new FileChooser();
       fileChooser.setTitle("Open TimeSheet File");
       
       File file = fileChooser.showOpenDialog(null);
       fr = new FileReader(file);
       t.readJSON(fr);
       
       System.out.println(t.getShiftLen());
       
       first_name.setText(t.getWorker().getFirst());
       last_name.setText(t.getWorker().getLast());
       worker_id.setText(String.valueOf(t.getWorker().getId()));
       payrate.setText(String.valueOf(t.getWorker().getRate()));
       
       for (int i = 0; i<t.getShiftLen();i++)
       {
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
        FileChooser fileChooser = new FileChooser();
       fileChooser.setTitle("Save as TimeSheet");
       File file = fileChooser.showOpenDialog(null);
       PrintStream ps = new PrintStream(file);
       t.report(ps);
   }

}
