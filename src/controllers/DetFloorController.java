package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Floor;
import models.Room;


public class DetFloorController {
    @FXML
    Label numberLabel;

    @FXML
    ListView<Room> roomListView;


    public void setFloor(Floor floor){
        numberLabel.setText(floor.getNumber());
        roomListView.setItems(floor.getRooms());
    }

    public void Cancel(){
        Stage stage = (Stage) numberLabel.getScene().getWindow();
        stage.close();
    }
}
