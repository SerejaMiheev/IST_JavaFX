package controllers;

import gw.PersonGateway;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import main.Main;
import models.Person;
import registry.GWRegistry;

import java.io.IOException;

public class PersonController {
    @FXML
    TableView<Person> personTable;

    @FXML
    TableColumn<Person, Number> idColumn;

    @FXML
    TableColumn<Person, String> fioColumn;

    @FXML
    TableColumn<Person, Number> roomColumn;

    private PersonGateway personGateway = GWRegistry.getInstance().getPersonGateway();
    ObservableList<Person> persons = FXCollections.observableArrayList(personGateway.all());
    private Main app;

    public void initialize(){
        personTable.setItems(persons);
        idColumn.setCellValueFactory(item -> item.getValue().idProperty());
        fioColumn.setCellValueFactory(item -> item.getValue().fioProperty());
        roomColumn.setCellValueFactory(item -> item.getValue().roomProperty());
    }

    public void setApp(Main app){
        this.app = app;
    }

    public void add() throws IOException {
        Person person = new Person();
        this.app.OpenPersonAdd(person);
        this.persons.add(person);
    }

    public void edit(){
        Person person = this.personTable.getSelectionModel().getSelectedItem();
        if(person != null){
            //TODO this.app.OpenPersonEdit(person);
        }
    }

    public void del(){
        Person person = this.personTable.getSelectionModel().getSelectedItem();
        if (person != null){
            this.personGateway.delete(person.getId());
            this.persons.remove(person);
        }
    }

    public void cancel(){
        Stage stage = (Stage) personTable.getScene().getWindow();
        stage.close();
    }
}
