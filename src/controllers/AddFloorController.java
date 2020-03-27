package controllers;

import exceptions.EntityNotFound;
import gw.CameraGateway;
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
import models.Camera;
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

    @FXML
    TableView<Camera> cameraTableView;

    @FXML
    TableColumn<Camera, Number> numCamera;

    @FXML
    TableColumn<Camera, CheckBox> addCamera;

    private Floor floor;
    private RoomGateway roomGateway = GWRegistry.getInstance().getRoomGateway();
    private FloorGateway floorGateway = GWRegistry.getInstance().getFloorGateway();
    private ObservableList<Room> rooms = FXCollections.observableArrayList(roomGateway.all());
    private CameraGateway cameraGateway = GWRegistry.getInstance().getCameraGateway();
    private ObservableList<Camera> cameras = FXCollections.observableArrayList(cameraGateway.all());
    private boolean isCancel;

    public void setCancel(boolean isCancel){
        this.isCancel = isCancel;
    }

    public boolean retCancel(){
        return isCancel;
    }

    public void  setFloor(Floor floor){
        this.floor = floor;

        this.numFloor.setText(String.valueOf(floor.getNumber()));
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

        ObservableList cameraObservableList = FXCollections.observableArrayList(floor.getCameras());
        for(Camera current : cameras)
        {
            CheckBox checkBox = new CheckBox();
            if(cameraObservableList.contains(current)){
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
                    numFloor.setText(newValue);
                } else {
                    numFloor.setText(oldValue);
                }
            }
        });

        roomTableView.setItems(rooms);
        numRoom.setCellValueFactory(item -> item.getValue().numberProperty());
        addRoom.setCellValueFactory(
                new PropertyValueFactory<>("selected")
        );
        cameraTableView.setItems(cameras);
        numCamera.setCellValueFactory(item -> item.getValue().numbercamProperty());
        addCamera.setCellValueFactory(
                new PropertyValueFactory<>("selected")
        );
    }

    public void addFloor() throws EntityNotFound {
        if (this.numFloor.getText() != null) {
            int num = Integer.parseInt(this.numFloor.getText());
            ObservableList<Room> roomList = FXCollections.observableArrayList();
            for(Room current : rooms)
            {
                if(current.getSelected().isSelected()){
                    roomList.add(current);
                }
            }
            ObservableList<Camera> cameraList = FXCollections.observableArrayList();
            for(Camera current : cameras)
            {
                if(current.getSelected().isSelected()){
                    cameraList.add(current);
                }
            }
            this.floor.setNumber(num);
            this.floor.setRoomonfloor(roomList);
            this.floor.setCameras(cameraList);

            if (this.floor.isSaved()) {
                this.floorGateway.update(this.floor);
            } else {
                this.floorGateway.insert(this.floor);
            }
            isCancel = false;

            Stage stage = (Stage) this.numFloor.getScene().getWindow();
            stage.close();
        }
    }

    public void Cancel(){
        isCancel = true;
        Stage stage = (Stage)this.numFloor.getScene().getWindow();
        stage.close();
    }
}
