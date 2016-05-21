/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bali
 */
public class MainSceneController implements Initializable {

    @FXML
    private Button accBtn;
    
    @FXML
    private Button regBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAccBtn(ActionEvent event) throws IOException, InterruptedException {
        Stage stage;
        Parent root;
        stage = (Stage) accBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fxml/accountance.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
       
        stage.show();
        
        
    }
    
    
     @FXML
    private void handleRegBtn(ActionEvent event) throws IOException, InterruptedException {
        Stage stage;
        Parent root;
        stage = (Stage) accBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
       
        stage.show();
        
        
    }
    
}
