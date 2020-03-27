package main;

import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Equipment;
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
        viewfloor.showAndWait();
    }

    public boolean OpenFloorAdd(Floor floor) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/floor_add_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage addfloor = new Stage();
        addfloor.setScene(new Scene(root));
        addfloor.setTitle("Этаж");
        addfloor.setResizable(false);
        AddFloorController addFloorController = loader.getController();
        addfloor.setOnCloseRequest(windowEvent -> {
            addFloorController.setCancel(true);
        });
        addFloorController.setFloor(floor);
        addfloor.showAndWait();
        return addFloorController.retCancel();
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
        viewPerson.showAndWait();
    }

    public boolean OpenPersonAdd(Person person) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/person_add_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage viewAddPerson = new Stage();
        viewAddPerson.setScene(new Scene(root));
        viewAddPerson.setTitle("Человек");
        viewAddPerson.setResizable(false);
        AddPersonController addPersonController = loader.getController();
        viewAddPerson.setOnCloseRequest(windowEvent -> {
            addPersonController.setCancel(true);
        });
        addPersonController.setPerson(person);
        viewAddPerson.showAndWait();
        return addPersonController.retCancel();
    }

    public void OpenTOEView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/type_equp_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage viewTOE = new Stage();
        viewTOE.setScene(new Scene(root));
        viewTOE.setTitle("Тип");
        viewTOE.setResizable(false);
        TOEController toeController = loader.getController();
        toeController.setApp(this);
        viewTOE.showAndWait();
    }

    public boolean OpenTOEAdd(Equipment.TypeOfEquipments typeOfEquipments) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/type_add_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage viewAddType = new Stage();
        viewAddType.setScene(new Scene(root));
        viewAddType.setTitle("Тип оборудования");
        viewAddType.setResizable(false);
        AddTypeController addTypeController = loader.getController();
        viewAddType.setOnCloseRequest(windowEvent -> {
            addTypeController.setCancel(true);
        });
        addTypeController.setTypeOfEquipments(typeOfEquipments);
        viewAddType.showAndWait();
        return addTypeController.retCancel();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
