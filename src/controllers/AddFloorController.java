package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.Floor;
import models.Room;

public class AddFloorController {
    private Floor floor;

    @FXML
    TextField numFloor;

    @FXML
    TableView<Room> roomTableView;

    @FXML
    TableColumn<Room,Integer> numRoom;

    @FXML
    TableColumn<Room, Boolean> addRoom;

    @FXML
    public void initialize(){
        //TODO : Загрузка таблицы
    }

    public void  setFloor(Floor floor){
        this.floor = floor;
        this.numFloor.setText(floor.getNumberStr());
        //this.numRoom.setCellValueFactory();
    }
}
