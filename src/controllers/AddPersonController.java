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
    ComboBox<Room> numRoom;

    private RoomGateway roomGateway = GWRegistry.getInstance().getRoomGateway();
    private PersonGateway personGateway = GWRegistry.getInstance().getPersonGateway();
    private Person person;
    private boolean isCancel;

    public void setCancel(boolean isCancel){
        this.isCancel = isCancel;
    }

    public void setPerson(Person person){
        this.person = person;
        this.fioText.setText(person.getFio());
    }

    public void initialize(){
        this.numRoom.setItems(FXCollections.observableArrayList(this.roomGateway.all()));
    }

    public void Add() throws EntityNotFound {
        if ((this.fioText.getText() != null)) {
            String fio = this.fioText.getText();
            int num;
            if ((!this.numRoom.getSelectionModel().isEmpty())){
                num = this.numRoom.getValue().getNumber();
            }
            else{
                num = 0;
            }
            this.person.setFio(fio);
            this.person.setRoom(num);

            if (this.person.isSaved()) {
                this.personGateway.update(this.person);
            } else {
                this.personGateway.insert(this.person);
            }
            isCancel = false;

            Stage stage = (Stage)this.fioText.getScene().getWindow();
            stage.close();
        }
    }

    public boolean retCancel(){
        return isCancel;
    }

    public void Cancel(){
        isCancel = true;
        Stage stage = (Stage)this.fioText.getScene().getWindow();
        stage.close();

    }
}
