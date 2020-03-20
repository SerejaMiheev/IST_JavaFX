package main;

import controllers.AddFloorController;
import controllers.Controller;
import controllers.FloorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Floor;

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

    public static void main(String[] args) {
        launch(args);
    }
}
