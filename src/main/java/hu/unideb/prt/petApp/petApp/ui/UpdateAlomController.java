/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.ui;

import hu.unideb.prt.petApp.petApp.entity.AlomDAO;
import hu.unideb.prt.petApp.petApp.entity.AlomDAOFactory;
import hu.unideb.prt.petApp.petApp.entity.AlomDAOImpl;
import hu.unideb.prt.petApp.petApp.entity.AlomEntity;
import hu.unideb.prt.petApp.petApp.entity.TeEntity;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
public class UpdateAlomController implements Initializable {

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
    
    private AlomEntity alomEntity;

    private AlomDAOFactory daoFactory;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        daoFactory = AlomDAOFactory.getInstance();
    }    

    @FXML
    private void onDoneBt(ActionEvent event) {
        AlomDAO ad = daoFactory.createAlomDAO();
        // AlomEntity ae = new AlomEntity();
        
        alomEntity.setTe_id(Integer.parseInt(te_id.getText()));
        alomEntity.setAlomszam(Integer.parseInt(alomszam.getText()));
        System.out.println(Integer.parseInt(alomszam.getText()));
        alomEntity.setElhullas(Integer.parseInt(elhullas.getText()));
        alomEntity.setLeiras(leiras.getText());
        LocalDate date = datee.getValue();
        alomEntity.setDatee(date.toString());
        
        ad.createAlom(alomEntity);
        onCancleBt();
       // ad.UpdateAlom(alomEntity,Integer.parseInt(alomszam.getText()),Integer.parseInt(elhullas.getText()),leiras.getText(),date.toString());
        
    }

    @FXML
    private void onCancleBt() {
        Stage s = (Stage)cancleBt.getScene().getWindow();
        s.close();
        
    }

    public void setAlomEntity(AlomEntity alomEntity) {
        this.te_id.setText(String.valueOf(alomEntity.getTe_id()));
        this.alomszam.setText(String.valueOf(alomEntity.getAlomszam()));
        this.elhullas.setText(String.valueOf(alomEntity.getElhullas()));
        this.leiras.setText(alomEntity.getLeiras());
        LocalDate date = LocalDate.parse(alomEntity.getDatee());
        this.datee.setValue(date);
        this.alomEntity = alomEntity;
    }
    
    
    
    
}