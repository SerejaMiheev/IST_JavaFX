package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class Section extends EntityClass {
    protected IntegerProperty number = new SimpleIntegerProperty();
    protected ObservableList<Camera> cameras = new SimpleListProperty<>();
    protected IntegerProperty countCamera = new SimpleIntegerProperty();

    public void setCameras(List cameras) {
        this.cameras.addAll(cameras);
        countCamera.set(this.cameras.size());
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public void addCamera(Camera camera){
        cameras.add(camera);
        countCamera.set(this.cameras.size());
    }

    public int getNumber() {
        return number.get();
    }

    public List getCameras() {
        return cameras;
    }

    public ObservableList<Camera> getCamerasOList(){
        return cameras;
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setCameras(ObservableList<Camera> cameras) {
        this.cameras = cameras;
        countCamera.set(this.cameras.size());
    }

    public IntegerProperty count(){
        countCamera.set(this.cameras.size());
        return countCamera;
    }

    /*public void print(){
        System.out.print("Номер секции: ");
        System.out.println(numsection);
        System.out.print("Список этажей: ");
        System.out.println(floors.toString());
        System.out.print("Список камер: ");
        //System.out.println(cameras.toString());
        System.out.print("Список комнат не на этаже: ");
        System.out.println(roomnoonfloor.toString());
    }*/
}
