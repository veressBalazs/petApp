/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.ui;

import hu.unideb.prt.petApp.petApp.entity.TeDAO;
import hu.unideb.prt.petApp.petApp.entity.TeDAOFactory;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javassist.Loader;

/**
 * FXML Controller class
 *
 * @author Bali
 */
public class RegisterController implements Initializable {
    
    
    
    @FXML
    private TableView<TeEntity> regTable;
    @FXML
    private TableColumn<TeEntity, Integer> ID;
    @FXML
    private TableColumn<TeEntity, String> TYPE;
    @FXML
    private TableColumn<TeEntity, String> DESCRIPTION;
    @FXML
    private TableColumn<TeEntity, String> DATE;
    @FXML
    private Button addBt;
    @FXML
    private Button updateBt;
    @FXML
    private Button deleteBt;
    @FXML
    private Button backBtn;
    @FXML
    private Button moreBtn;
    @FXML
    private ComboBox<String> cb;
    @FXML private AlomController ac;
    @FXML
    Label warnLabel;
    @FXML
    Label warnLabel1;
    private TeDAOFactory daoFactory;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        daoFactory = TeDAOFactory.getInstance();
        TeDAO td = daoFactory.createTeDAO();
        List<TeEntity> lista = td.readAllTe();
        refreshData(lista);
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("Törpenyúl");
        items.add("Nyúl");
        items.add("Csincsilla");
        items.add("Hörcsög");
        items.add("Degu");
        items.add("Tengerimalac");
        cb.setItems(items);
       
    }    

    @FXML
    private void onAddBt(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        VBox mainPane = (VBox) FXMLLoader.load(getClass().getResource("/fxml/addNewTe.fxml"));
        
        Scene scene = new Scene(mainPane);
        stage.setTitle("Add Te");
        stage.setScene(scene);
        disablemenu(true);
        stage.showAndWait();
        disablemenu(false);
        refreshData(filter(cb.getValue()));
        
    }

    @FXML
    private void onUpdateBt(ActionEvent event) throws IOException {
        TeEntity teEntity = regTable.getSelectionModel().getSelectedItem();
        if (teEntity==null){
            warnLabel.setText("Nincsen elem kiválasztva!");
            warnLabel1.setText(" ");
        }else{
            warnLabel.setText(" ");
            warnLabel1.setText(" ");
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/addNewTe.fxml"));
        VBox mainPane = (VBox) loader.load();
        
        Scene scene = new Scene(mainPane);
        stage.setTitle("Update Te");
        stage.setScene(scene);
        AddNewTeController addNewTeController = loader.getController();
        addNewTeController.setTe(teEntity);
        
        disablemenu(true);
        stage.showAndWait();
        disablemenu(false);
        refreshData(filter(cb.getValue()));
        }
    }

    @FXML
    private void onDeleteBt(ActionEvent event) {
        TeDAO td = daoFactory.createTeDAO();
        TeEntity te = regTable.getSelectionModel().getSelectedItem();
        if(te == null){
            warnLabel1.setText("Nincs elem kiválasztva!");
            warnLabel.setText(" ");
            return;
        }
        warnLabel1.setText(" ");
        warnLabel.setText(" ");
        td.removeTe(te);
        refreshData(filter(cb.getValue()));
    }

     @FXML
    private void handleBackBtn() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) backBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fxml/mainScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }
    
    @FXML
    private void onFilterBtn(){
        
        
        
        refreshData(filter(cb.getValue()));
    
    }
    
    @FXML
    private void onAllBtn(){
        TeDAO td = daoFactory.createTeDAO();
        List<TeEntity> lista = td.readAllTe();
        refreshData(lista);
    
    }
    
    @FXML
    private void onMoreBtn() throws IOException{
        
        TeEntity te = regTable.getSelectionModel().getSelectedItem();
        Stage stage;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/alom.fxml"));
        stage = (Stage) moreBtn.getScene().getWindow();
        root = (Parent) loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        AlomController alomController = loader.<AlomController>getController();
        alomController.setTeEntity(te);
        stage.show();
        
        
    
    }
    
    private void refreshData(List<TeEntity> lista){
         //List<TeEntity> lista = TeDAO.readAllTe();
         regTable.getColumns().get(0).setVisible(false);
         regTable.getColumns().get(0).setVisible(true);
         ID.setCellValueFactory(new PropertyValueFactory<>("id"));
         TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
         DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("description"));
         DATE.setCellValueFactory(new PropertyValueFactory<>("datee"));
         ObservableList<TeEntity> olist = FXCollections.observableArrayList(lista);
         regTable.setItems(olist);
         
         warnLabel.setText(" ");
         warnLabel1.setText(" ");
    
    }
    
    private void disablemenu(boolean b) {
        addBt.setDisable(b);
        updateBt.setDisable(b);
        deleteBt.setDisable(b);
        regTable.setDisable(b);
    }
    
    private List<TeEntity> filter(String tipus){
        TeDAO td = daoFactory.createTeDAO();
        List<TeEntity> lista = td.readAllTe();
        List<TeEntity> l = new ArrayList<>();
        if(tipus==null){
            return lista;
        }
        else{
        for (TeEntity teEntity : lista) {
            if(teEntity.getType().equals(tipus))
                l.add(teEntity);
        }
        return l;
        }
    }
    
}
