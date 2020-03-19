package controllers;

import gw.RoomGateway;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import models.Floor;
import models.Room;
import registry.GWRegistry;

public class AddFloorController {
    @FXML
    TextField numFloor;

    @FXML
    TableView<Room> roomTableView;

    @FXML
    TableColumn<Room,Number> numRoom;

    @FXML
    TableColumn<Room, Boolean> addRoom;

    private Floor floor;
    private RoomGateway roomGateway = GWRegistry.getInstance().getRoomGateway();
    ObservableList<Room> rooms = FXCollections.observableArrayList(roomGateway.all());

    @FXML
    public void initialize(){
        roomTableView.setItems(rooms);
        numRoom.setCellValueFactory(item -> item.getValue().numberRoomProperty());
        addRoom.setCellFactory(
                CheckBoxTableCell.forTableColumn(addRoom)
        );
        BooleanProperty chck = new SimpleBooleanProperty();
        if (floor != null) {
            addRoom.setCellValueFactory(cellDate -> {
                chck.set(floor.getRoomonfloor().contains(cellDate.getValue()));
                return chck;
            });
        }
        else {
            chck.set(false);
            addRoom.setCellValueFactory(cellDate -> chck);
        }
    }

    public void  setFloor(Floor floor){
        this.floor = floor;
        this.numFloor.setText(floor.getNumberStr());
    }
}
