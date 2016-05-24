/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.ui;

import static hu.unideb.prt.petApp.petApp.AlomStatistics.alomszamAtlag;

import static hu.unideb.prt.petApp.petApp.AlomStatistics.legnagyobbAlom;
import static hu.unideb.prt.petApp.petApp.AlomStatistics.osszesSzaporulat;
import hu.unideb.prt.petApp.petApp.entity.AlomDAO;
import hu.unideb.prt.petApp.petApp.entity.AlomDAOFactory;
import hu.unideb.prt.petApp.petApp.entity.AlomDAOImpl;
import hu.unideb.prt.petApp.petApp.entity.AlomEntity;
import hu.unideb.prt.petApp.petApp.entity.TeDAOImpl;
import hu.unideb.prt.petApp.petApp.entity.TeEntity;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bali
 */
public class AlomController implements Initializable {

    @FXML
    Label teId;
    @FXML
    Label teType;
    @FXML
    Label teDescription;
    @FXML
    Label teSetDate;

    @FXML
    private TableView<AlomEntity> alomTable;
    @FXML
    private TableColumn<AlomEntity, Integer> ID;
    @FXML
    private TableColumn<AlomEntity, Integer> TEID;
    @FXML
    private TableColumn<AlomEntity, Integer> ALOMSZAM;
    @FXML
    private TableColumn<AlomEntity, Integer> ELHULLAS;
    @FXML
    private TableColumn<AlomEntity, String> LEIRAS;
    @FXML
    private TableColumn<AlomEntity, String> DATEE;
    @FXML
    private Button addBt;
    @FXML
    private Button updateBt;
    @FXML
    private Button deleteBt;
    @FXML
    private Label bigst;
    @FXML
    private Label all;
    @FXML
    private Label avr;
    @FXML
    private Label deathRate;
    @FXML
    private Label warn1;
    @FXML
    private Label warn2;
    @FXML
    private Button backBtn;
    private AlomDAOFactory daoFactory;
    private TeEntity teEntity;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        daoFactory = AlomDAOFactory.getInstance();
        AlomDAO ad = daoFactory.createAlomDAO();
        List<AlomEntity> lista = ad.readAllAlom();
        refreshData(lista);
        System.out.println(teId.getText());

    }

    @FXML
    private void onAddBt(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/addNewAlom.fxml"));
        VBox mainPane = (VBox) loader.load();

        Scene scene = new Scene(mainPane);
        stage.setTitle("Add Entry");
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);

        AddNewAlomController addNewAlomController = loader.getController();
        addNewAlomController.setTeEntity(teEntity);
        disablemenu(true);
        stage.showAndWait();
        disablemenu(false);
        System.out.println("alma: " + teId.getText());
        refreshData(filter(Integer.parseInt(teId.getText())));

    }

    @FXML
    private void onUpdateBt(ActionEvent event) throws IOException {
        AlomEntity alomEntity = alomTable.getSelectionModel().getSelectedItem();
        if (alomEntity == null) {
            warn1.setText("Nincs elem kiválasztva!");
            warn1.setTextFill(Color.web("#ee0000"));
            warn2.setText(" ");

        } else {
            warn1.setText(" ");
            warn2.setText(" ");
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/updateAlom.fxml"));
            VBox mainPane = (VBox) loader.load();

            Scene scene = new Scene(mainPane);
            stage.setTitle("Add Entry");
            stage.setScene(scene);
            //stage.initStyle(StageStyle.UNDECORATED);

            UpdateAlomController addNewAlomController = loader.getController();
            addNewAlomController.setAlomEntity(alomTable.getSelectionModel().getSelectedItem());
            disablemenu(true);
            stage.showAndWait();
            disablemenu(false);
            
            refreshDataUpdate();
            System.out.println("alma: " + teId.getText());
        }
    }

    @FXML
    private void onDeleteBt(ActionEvent event) {
        AlomEntity alomEntity = alomTable.getSelectionModel().getSelectedItem();
        if (alomEntity == null) {
            warn2.setText("Nincs elem kiválasztva!");
            warn2.setTextFill(Color.web("#ee0000"));
            warn1.setText(" ");

        } else {
            warn2.setText(" ");
            warn1.setText(" ");
            AlomDAO ad = daoFactory.createAlomDAO();
            AlomEntity ae = alomTable.getSelectionModel().getSelectedItem();
            if (ae == null) {
                return;
            }

            ad.removeAlom(ae);
            System.out.println(teEntity);
            refreshData(filter(Integer.parseInt(teId.getText())));
        }
    }

    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        stage = (Stage) backBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    private void refreshData(List<AlomEntity> lista) {
        
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TEID.setCellValueFactory(new PropertyValueFactory<>("te_id"));
        ALOMSZAM.setCellValueFactory(new PropertyValueFactory<>("alomszam"));
        ELHULLAS.setCellValueFactory(new PropertyValueFactory<>("elhullas"));
        LEIRAS.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        DATEE.setCellValueFactory(new PropertyValueFactory<>("datee"));
        ObservableList<AlomEntity> olist = FXCollections.observableArrayList(lista);
        alomTable.setItems(olist);

        try {
//            int id;
//            if (teEntity != null) {
//                id = teEntity.getId();
//            }
            AlomDAO ad = daoFactory.createAlomDAO();
            List ll = ad.ReadAlomByTeId(teEntity.getId());
            avr.setText(alomszamAtlag(ll).toString());
            all.setText(osszesSzaporulat(ll).toString());
            bigst.setText(legnagyobbAlom(ll).toString());

        } catch (Exception e) {
            System.out.println("valami nem jó itten :D " + e);
        }

    }
    
    private void refreshDataUpdate() {
        AlomDAO ad = daoFactory.createAlomDAO();
        List<AlomEntity> li = ad.readAllAlom();
        List<AlomEntity> lista1 = filter(teEntity.getId(),li);
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TEID.setCellValueFactory(new PropertyValueFactory<>("te_id"));
        ALOMSZAM.setCellValueFactory(new PropertyValueFactory<>("alomszam"));
        ELHULLAS.setCellValueFactory(new PropertyValueFactory<>("elhullas"));
        LEIRAS.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        DATEE.setCellValueFactory(new PropertyValueFactory<>("datee"));
        ObservableList<AlomEntity> olistt = FXCollections.observableArrayList(lista1);
        alomTable.setItems(olistt);

        try {
//            int id;
//            if (teEntity != null) {
//                id = teEntity.getId();
//            }
            ad = daoFactory.createAlomDAO();
            List ll = ad.ReadAlomByTeId(teEntity.getId());
            avr.setText(alomszamAtlag(ll).toString());
            all.setText(osszesSzaporulat(ll).toString());
            bigst.setText(legnagyobbAlom(ll).toString());

        } catch (Exception e) {
            System.out.println("valami nem jó itten :D " + e);
        }

    }

    public void setTeEntity(TeEntity teEntity) {
        Integer id = teEntity.getId();
        //
        teId.setText(id.toString());
        teType.setText(teEntity.getType());
        teDescription.setText(teEntity.getDescription());
        teSetDate.setText(teEntity.getDatee());
        this.teEntity = teEntity;

        refreshData(filter(id));

    }

    public TeEntity getTeEntity() {
        return teEntity;
    }

    private List<AlomEntity> filter(int id) { 
        AlomDAO ad = daoFactory.createAlomDAO();
        List<AlomEntity> l = new ArrayList<>();
        List<AlomEntity> lista = ad.readAllAlom();
        if (id == 0) {
            return lista;
        } else {
            for (AlomEntity alomEntity : lista) {
                if (alomEntity.getTe_id() == id) {
                    l.add(alomEntity);
                }
            }

            return l;
        }
    }
    
    private List<AlomEntity> filter(int id,List<AlomEntity> lista){
        List<AlomEntity> l = new ArrayList<>();
        //List<AlomEntity> lista = ad.readAllAlom();
        if (id == 0) {
            return lista;
        } else {
            for (AlomEntity alomEntity : lista) {
                if (alomEntity.getTe_id() == id) {
                    l.add(alomEntity);
                }
            }

            return l;
        }
    
    
    }

    private void disablemenu(boolean b) {
        addBt.setDisable(b);
        updateBt.setDisable(b);
        deleteBt.setDisable(b);
        alomTable.setVisible(!b);
    }

}
