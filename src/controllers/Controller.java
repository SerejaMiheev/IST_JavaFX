package controllers;

import main.Main;

import java.io.IOException;

public class Controller {

    private Main app;

    public void ClickGen(){

    }

    public void setApp(Main app){
        this.app = app;
    }

    public void ClickFloor() throws IOException {
        this.app.OpenFloorView();
    }
}
