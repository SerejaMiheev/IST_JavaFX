package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.Person;
import models.Room;

public class AddPersonController {
    @FXML
    TextField fioText;

    @FXML
    TextField idText;

    @FXML
    ChoiceBox<Room> numRoom;

    Person person;

    public void setPerson(Person person){
        this.person = person;
    }

    public void Add(){}

    public void Cancel(){}
}
