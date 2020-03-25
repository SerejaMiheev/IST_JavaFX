package controllers;

import exceptions.EntityNotFound;
import gw.FloorGateway;
import gw.RoomGateway;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    TableColumn<Room, CheckBox> addRoom;

    private Floor floor;
    private RoomGateway roomGateway = GWRegistry.getInstance().getRoomGateway();
    private FloorGateway floorGateway = GWRegistry.getInstance().getFloorGateway();
    private ObservableList<Room> rooms = FXCollections.observableArrayList(roomGateway.all());

    public void  setFloor(Floor floor){
        this.floor = floor;
        this.numFloor.setText(floor.getNumber());
        ObservableList roomObservableList = FXCollections.observableArrayList(floor.getRoomonfloor());
        for(Room current : rooms)
        {
            CheckBox checkBox = new CheckBox();
            if(roomObservableList.contains(current)){
                checkBox.setSelected(true);
                current.setSelected(checkBox);
            }
            else {
                checkBox.setSelected(false);
                current.setSelected(checkBox);
            }
        }
    }

    @FXML
    public void initialize(){
        numFloor.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("\\d*")) {
                    int value = Integer.parseInt(newValue);
                } else {
                    numFloor.setText(oldValue);
                }
            }
        });

        roomTableView.setItems(rooms);
        numRoom.setCellValueFactory(item -> item.getValue().numberRoomProperty());
        addRoom.setCellValueFactory(
                new PropertyValueFactory<>("selected")
        );
    }

    public void addFloor() throws EntityNotFound {
        if (this.numFloor.getText() != null) {
            String num = this.numFloor.getText();
            ObservableList<Room> roomList = FXCollections.observableArrayList();
            for(Room current : rooms)
            {
                if(current.getSelected().isSelected()){
                    roomList.add(current);
                }
            }
            this.floor.setNumber(num);
            this.floor.setRoomonfloor(roomList);

            if (this.floor.isSaved()) {
                this.floorGateway.update(this.floor);
            } else {
                this.floorGateway.insert(this.floor);
            }

            Stage stage = (Stage) this.numFloor.getScene().getWindow();
            stage.close();
        }
    }

    public void Cancel(){
        Stage stage = (Stage)this.numFloor.getScene().getWindow();
        stage.close();
    }
}
