package controllers;

import gw.FloorGateway;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;
import models.Floor;
import registry.GWRegistry;

import java.io.IOException;

public class FloorController {

    @FXML
    TableView<Floor> floorTable;
    @FXML
    TableColumn<Floor,Number> floorColumn;
    @FXML
    TableColumn<Floor,Number> countFloor;

    private FloorGateway floorGateway = GWRegistry.getInstance().getFloorGateway();
    ObservableList<Floor> floors = FXCollections.observableArrayList(floorGateway.all());
    private Main app;

    @FXML
    public void initialize(){
        floorTable.setItems(floors);
        floorColumn.setCellValueFactory(item -> item.getValue().numberProperty());
        countFloor.setCellValueFactory(cellDate -> cellDate.getValue().countRoomProperty());
    }

    public void setApp(Main app){
        this.app = app;
    }

    public void Add() throws IOException {
        Floor floor = new Floor();
        this.app.OpenFloorAdd();
    }

    public void Del(){}

    public void Edit(){}

    public void View(){}
}
