/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ospina.presentation;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class holds the data for the Application that would
 * be presented to the user.
 * @author cospina
 * @since 11/18/20
 */
public class TimeSheetApplication extends Application {

    /**
     * This method sets up the primary stage and links the application
     * to the FXML file. Should build fail, then the console should print the 
     * stack trace to help future developers debug the code.
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        Scene scene = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
     // Put the root containing the FXML into the scene
        scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
