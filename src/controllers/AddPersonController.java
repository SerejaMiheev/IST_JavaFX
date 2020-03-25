package controllers;

import exceptions.EntityNotFound;
import gw.PersonGateway;
import gw.RoomGateway;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Person;
import models.Room;
import registry.GWRegistry;

public class AddPersonController {
    @FXML
    TextField fioText;

    @FXML
    TextField idText;

    @FXML
    ComboBox<Room> numRoom;

    private RoomGateway roomGateway = GWRegistry.getInstance().getRoomGateway();
    private PersonGateway personGateway = GWRegistry.getInstance().getPersonGateway();
    Person person;

    public void setPerson(Person person){
        this.person = person;
        this.fioText.setText(person.getFio());
        this.idText.setText(person.idProperty().toString());
        /*if (person.getRoom() != 0){
            this.numRoom.setSelectionModel(this.roomGateway.all().contains());
        }*/
    }

    public void initialize(){
        this.numRoom.setItems(FXCollections.observableArrayList(this.roomGateway.all()));
        idText.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (newValue.matches("\\d*")) {
                    int value = Integer.parseInt(newValue);
                } else {
                    idText.setText(oldValue);
                }
            }
        });
    }

    public void Add() throws EntityNotFound {
        if ((this.fioText.getText() != null) & (this.idText.getText() != null)) {
            String fio = this.fioText.getText();
            int id = Integer.parseInt(this.idText.getText());
            int num;
            if ((!this.numRoom.getSelectionModel().isEmpty())){
                num = this.numRoom.getValue().getNumberRoom();
            }
            else{
                num = 0;
            }
            this.person.setFio(fio);
            this.person.setId(id);
            this.person.setRoom(num);

            if (this.person.isSaved()) {
                this.personGateway.update(this.person);
            } else {
                this.personGateway.insert(this.person);
            }

            Stage stage = (Stage)this.fioText.getScene().getWindow();
            stage.close();
        }
    }

    public void Cancel(){
        Stage stage = (Stage)this.fioText.getScene().getWindow();
        stage.close();
    }
}
