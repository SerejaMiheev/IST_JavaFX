package main;

import controllers.AddFloorController;
import controllers.Controller;
import controllers.FloorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

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

    public void OpenFloorAdd() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("../views/floor_add_view.fxml"));

        VBox root = (VBox)loader.load();
        Stage addfloor = new Stage();
        addfloor.setScene(new Scene(root));
        addfloor.setTitle("Добаить этаж");
        addfloor.setResizable(false);
        AddFloorController addFloorController = loader.getController();
        addfloor.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}