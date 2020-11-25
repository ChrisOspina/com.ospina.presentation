/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.presentation;

import com.ospina.buisness.Timesheet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import java.util.Scanner;


/**
 *
 * @author cospina
 */
public class TimeSheetController
{
   private Timesheet t;
    
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
       Scanner in = new Scanner(System.in);
       
       System.out.println("Enter a file name");
       String filename = in.nextLine();
       FileReader fr = new FileReader(filename);
       t.readJSON(fr);
       
       
   }
   
   
   @FXML
   protected void handleExitAction()
   {
       System.exit(0);
   }
}
