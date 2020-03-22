package controllers;

import gw.FloorGateway;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
    TableColumn<Floor,String> floorColumn;
    @FXML
    TableColumn<Floor,Number> countFloor;

    private FloorGateway floorGateway = GWRegistry.getInstance().getFloorGateway();
    ObservableList<Floor> floors = FXCollections.observableArrayList(floorGateway.all());
    private Main app;

    @FXML
    public void initialize(){
        floorTable.setItems(floors);
        floorColumn.setCellValueFactory(item -> item.getValue().getNumberProperty());
        countFloor.setCellValueFactory(cellDate -> cellDate.getValue().countRoomProperty());
    }

    public void setApp(Main app){
        this.app = app;
    }

    public void Add() throws IOException {
        Floor floor = new Floor();
        this.app.OpenFloorAdd(floor);
        this.floors.add(floor);
        //TODO Пустой item, при нажатии отмены
    }

    public void Del(){
        Floor floor = this.floorTable.getSelectionModel().getSelectedItem();
        if (floor != null) {
            this.floorGateway.delete(floor.getId());
            this.floors.remove(floor);
        }
    }

    public void Edit() throws IOException {
        Floor floor = this.floorTable.getSelectionModel().getSelectedItem();
        if (floor != null) {
            this.app.OpenFloorEdit(floor);
        }
    }

    public void View() throws IOException {
        Floor floor = this.floorTable.getSelectionModel().getSelectedItem();
        if (floor != null) {
            this.app.OpenFloorDetView(floor);
        }
    }
}
