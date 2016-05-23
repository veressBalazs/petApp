/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.ui;

import hu.unideb.prt.petApp.petApp.entity.AlomDAO;
import hu.unideb.prt.petApp.petApp.entity.AlomEntity;
import hu.unideb.prt.petApp.petApp.entity.TeEntity;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bali
 */
public class AddNewAlomController implements Initializable {

    @FXML
    private Button doneBt;
    @FXML
    private Button cancleBt;
    @FXML
    private TextField te_id;
    @FXML
    private TextField alomszam;
    @FXML
    private TextField elhullas;
    @FXML
    private TextField leiras;
    @FXML
    private DatePicker datee;
    
    TeEntity teEntity;

    

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onDoneBt(ActionEvent event) {
        AlomEntity ae = new AlomEntity();
        
        ae.setTe_id(Integer.parseInt(te_id.getText()));
        ae.setAlomszam(Integer.parseInt(alomszam.getText()));
        ae.setElhullas(Integer.parseInt(elhullas.getText()));
        ae.setLeiras(leiras.getText());
        LocalDate date = datee.getValue();
        ae.setDatee(date.toString());
        
        AlomDAO.createAlom(ae);
        onCancleBt();
    }

    @FXML
    private void onCancleBt() {
        Stage s = (Stage)cancleBt.getScene().getWindow();
        s.close();
        
    }
    
    public void setTeEntity(TeEntity teEntity) {
        te_id.setText(String.valueOf(teEntity.getId()));
        this.teEntity = teEntity;
        
    }
    
    
}
