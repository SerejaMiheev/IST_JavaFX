package main;

import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Floor;
import models.Person;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("../views/sample.fxml"));
        //primaryStage.setTitle("PACS");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/sample.fxml"));
        VBox root = (VBox) loader.load();

        primaryStage.setScene(new Scene(root, 205, 371));
        primaryStage.setResizable(false);
        Controller controller = loader.getController();
        controller.setApp(this);
        primaryStage.show();
    }

    public void OpenFloorView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/floor_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage viewfloor = new Stage();
        viewfloor.setScene(new Scene(root));
        viewfloor.setTitle("Этажи");
        viewfloor.setResizable(false);
        FloorController floorController = loader.getController();
        floorController.setApp(this);
        viewfloor.show();
    }

    public void OpenFloorAdd(Floor floor) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/floor_add_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage addfloor = new Stage();
        addfloor.setScene(new Scene(root));
        addfloor.setTitle("Добавить этаж");
        addfloor.setResizable(false);
        AddFloorController addFloorController = loader.getController();
        addFloorController.setFloor(floor);
        addfloor.show();
    }

    public void OpenFloorEdit(Floor floor) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/floor_add_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage addfloor = new Stage();
        addfloor.setScene(new Scene(root));
        addfloor.setTitle("Редактирование этажа");
        addfloor.setResizable(false);
        AddFloorController addFloorController = loader.getController();
        addFloorController.setFloor(floor);
        addfloor.show();
    }

    public void OpenFloorDetView(Floor floor) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/floor_det_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage detfloor = new Stage();
        detfloor.setScene(new Scene(root));
        detfloor.setTitle("Просмотр этажа");
        detfloor.setResizable(false);
        DetFloorController detFloorController = loader.getController();
        detFloorController.setFloor(floor);
        detfloor.show();
    }

    public void OpenPersonView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/person_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage viewPerson = new Stage();
        viewPerson.setScene(new Scene(root));
        viewPerson.setTitle("Люди");
        viewPerson.setResizable(false);
        PersonController personController = loader.getController();
        personController.setApp(this);
        viewPerson.show();
    }

    public void OpenPersonAdd(Person person) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/person_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage viewAddPerson = new Stage();
        viewAddPerson.setScene(new Scene(root));
        viewAddPerson.setTitle("Добавить человека");
        viewAddPerson.setResizable(false);
        AddPersonController addPersonController = loader.getController();
        addPersonController.setPerson(person);
        viewAddPerson.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
