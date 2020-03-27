package controllers;

import gw.TypeGateway;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import main.Main;
import models.Equipment;
import registry.GWRegistry;

import java.io.IOException;

public class TOEController {
    @FXML
    TableView<Equipment.TypeOfEquipments> typeTable;

    @FXML
    TableColumn<Equipment.TypeOfEquipments, String> typeColumn;


    private Main app;
    private TypeGateway typeGateway = GWRegistry.getInstance().getTypeGateway();
    private ObservableList<Equipment.TypeOfEquipments> types = FXCollections.observableArrayList(typeGateway.all());

    public void setApp(Main app){
        this.app = app;
    }

    public void initialize(){
        typeTable.setItems(types);
        typeColumn.setCellValueFactory(item -> item.getValue().typeofequipmentProperty());
    }

    public void addType() throws IOException {
        Equipment.TypeOfEquipments typeOfEquipments = new Equipment.TypeOfEquipments();
        if(!this.app.OpenTOEAdd(typeOfEquipments)){
            this.types.add(typeOfEquipments);
        }
    }

    public void delType(){
        Equipment.TypeOfEquipments typeOfEquipments = this.typeTable.getSelectionModel().getSelectedItem();
        if (typeOfEquipments != null) {
            this.typeGateway.delete(typeOfEquipments.getId());
            this.types.remove(typeOfEquipments);
        }
    }

    public void edit() throws IOException {
        Equipment.TypeOfEquipments typeOfEquipments = this.typeTable.getSelectionModel().getSelectedItem();
        if (typeOfEquipments != null){
            this.app.OpenTOEAdd(typeOfEquipments);
        }
    }

    public void cancel(){
        Stage stage = (Stage)this.typeTable.getScene().getWindow();
        stage.close();
    }
}
