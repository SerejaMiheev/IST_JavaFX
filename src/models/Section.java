package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class Section extends EntityClass {
    private IntegerProperty numsection = new SimpleIntegerProperty();
    private ObservableList<Floor> floors = new SimpleListProperty<>();
    private ObservableList<Room> roomnoonfloor = new SimpleListProperty<>();
    private ObservableList<Camera> cameras = new SimpleListProperty<>();

    public Section(){}

    public Section(List roomnoonfloor, List cameras, List floors){
        this.roomnoonfloor.addAll(roomnoonfloor);
        this.cameras.addAll(cameras);
        this.floors.addAll(floors);
    }

    public Section(List cameras, List floors){
        this.cameras.addAll(cameras);
        this.floors.addAll(floors);
    }

    public Section(Floor floors, Room roomnoonfloor, Camera cameras){
        this.floors.add(floors);
        this.roomnoonfloor.add(roomnoonfloor);
        this.cameras.add(cameras);
    }

    public Section(Room roomnoonfloor, Camera cameras) {
        this.roomnoonfloor.add(roomnoonfloor);
        this.cameras.add(cameras);
    }

    public Section(Floor floors, Camera cameras){
        this.floors.add(floors);
        this.cameras.add(cameras);
    }

    public Section(Floor floors, Room roomnoonfloor){
        this.floors.add(floors);
        this.roomnoonfloor.add(roomnoonfloor);
    }

    public void setRoomnoonfloor(List roomnoonfloor){
        this.roomnoonfloor.addAll(roomnoonfloor);
    }

    public void setCameras(List cameras) {
        this.cameras.addAll(cameras);
    }

    public void setFloors(List floors) {
        this.floors.addAll(floors);
    }

    public void setNumsection(int numsection) {
        this.numsection.set(numsection);
    }

    public void addRoomnoonfloor(Room room){
        roomnoonfloor.add(room);
    }

    public void addCamera(Camera camera){
        cameras.add(camera);
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public int getNumsection() {
        return numsection.get();
    }

    public List getCameras() {
        return cameras;
    }

    public IntegerProperty numsectionProperty() {
        return numsection;
    }

    public void setFloors(ObservableList<Floor> floors) {
        this.floors = floors;
    }

    public void setRoomnoonfloor(ObservableList<Room> roomnoonfloor) {
        this.roomnoonfloor = roomnoonfloor;
    }

    public void setCameras(ObservableList<Camera> cameras) {
        this.cameras = cameras;
    }

    public List getFloors() {
        return floors;
    }

    public List getRoomnoonfloor() {
        return roomnoonfloor;
    }

    public String toString(){
        return "Номер секции: "+numsection.get()+"\nСписок этажей: "+getFloors().toString()+"\nСписок камер: "+getCameras().toString()+"\nСписок комнат не на этаже: "+getRoomnoonfloor().toString();
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
