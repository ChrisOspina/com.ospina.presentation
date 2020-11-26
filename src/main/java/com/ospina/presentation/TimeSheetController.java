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
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;



/**
 *
 * @author cospina
 */
public class TimeSheetController
{
   private Timesheet t = new Timesheet();
    
   @FXML
   private Menu filemenu;
   
   @FXML
   private TabPane tabpane;
   
   @FXML
   private ListView shiftslistview;
   
   @FXML
   private TextField first_name;
   
   @FXML
   private TextField last_name;
   
   @FXML
   private TextField worker_id;
   
   @FXML
   private TextField payrate;
   
 
   @FXML
   protected void openfileAction() throws FileNotFoundException
   {
       FileChooser fileChooser = new FileChooser();
       fileChooser.setTitle("Open Resource File");
       
       File file = fileChooser.showOpenDialog(null);
       FileReader fr = new FileReader(file);
       t.readJSON(fr);
       
       System.out.println(t.getShiftLen());
       
       first_name.setText(t.getWorker().getFirst());
       last_name.setText(t.getWorker().getLast());
       String idtext = Integer.toString(t.getWorker().getId());
       worker_id.setText(idtext);
       String payrtetxt = Double.toString(t.getWorker().getRate());
       payrate.setText(payrtetxt);
       

       
       
       
       
   }
   
   
   @FXML
   protected void handleExitAction()
   {
       System.exit(0);
   }
   
   @FXML
   protected void SaveAsAction()
   {
       
   }
   
   @FXML
   protected void saveaction()
   {
       
   }

}
