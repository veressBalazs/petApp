/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.ui;

import hu.unideb.prt.petApp.petApp.entity.TeDAO;
import hu.unideb.prt.petApp.petApp.entity.TeEntity;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bali
 */
public class AddNewTeController implements Initializable {

    @FXML
    private Button doneBt;
    @FXML
    private Button cancleBt;
    @FXML
    private TextField id;
    @FXML
    private TextField description;
    @FXML
    private ComboBox<String> type;
    @FXML
    private DatePicker datee;
    @FXML
    Label warningLabel;
    @FXML
    Label azonosito;
    @FXML
    Label fajta;
    @FXML
    Label datum;

    private TeEntity te;

    Boolean edit = Boolean.FALSE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("Törpenyúl");
        items.add("Nyúl");
        items.add("Csincsilla");
        items.add("Hörcsög");
        items.add("Degu");
        items.add("Tengerimalac");
        type.setItems(items);
        //csillagoz(false);
    }

    @FXML
    private void onDoneBt(ActionEvent event) {
        LocalDate dat = datee.getValue();
        if (id.getText().isEmpty() || type.getSelectionModel().getSelectedItem().isEmpty() || dat.toString().isEmpty()) {
            warningLabel.setText("A * -al jelölt mezők kitöltése kötelező!");
            warningLabel.setTextFill(Color.web("#ee0000"));
            csillagoz(true);
            
        } else {
            if (!edit) {
                te = new TeEntity();
            }
            te.setId(Integer.parseInt(id.getText()));
            te.setType(type.getValue());
            te.setDescription(description.getText());
            LocalDate date = datee.getValue();
            te.setDatee(date.toString());
            TeDAO.createTe(te);
            onCancleBt();
            //csillagoz(false);
        }
    }

    @FXML
    private void onCancleBt() {

        Stage s = (Stage) cancleBt.getScene().getWindow();
        s.close();
    }

    public void setTe(TeEntity te) {
        id.setText(String.valueOf(te.getId()));
        description.setText(te.getDescription());
        type.getSelectionModel().select(te.getType());
        LocalDate date = LocalDate.parse(te.getDatee());
        datee.setValue(date);
        edit = Boolean.TRUE;
        this.te = te;
    }
    private void csillagoz(boolean b) {
        if(b){
            azonosito.setText("Azolosító *");
            azonosito.setTextFill(Color.web("#ee0000"));
            fajta.setText("Fajta *");
            fajta.setTextFill(Color.web("#ee0000"));
            datum.setText("BeállításDátuma *");
            datum.setTextFill(Color.web("#ee0000"));
        
        }
        else{
        azonosito.setText("Azolosító");
            azonosito.setTextFill(Color.web("#000000"));
            fajta.setText("Fajta");
            fajta.setTextFill(Color.web("#000000"));
            datum.setText("BeállításDátuma");
            datum.setTextFill(Color.web("#000000"));
        }
    
    }

}
