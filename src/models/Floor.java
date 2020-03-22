package models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.List;

public class Floor extends EntityClass {
    private StringProperty number = new SimpleStringProperty();
    private ObservableList<Room> roomonfloor = new SimpleListProperty<>();
    private IntegerProperty countRoom = new SimpleIntegerProperty();

    public Floor(){}

    public Floor(String number){
        this.number.set(number);
    }

    public Floor(List roomonfloor, String number){
        this.roomonfloor.setAll(roomonfloor);
        this.number.set(number);
        countRoom.set(this.roomonfloor.size());
    }

    public Floor(List roomonfloor){
        this.roomonfloor.setAll(roomonfloor);
        countRoom.set(this.roomonfloor.size());
    }

    public Floor(Room roomonfloor){
        this.roomonfloor.add(roomonfloor);
        countRoom.set(this.roomonfloor.size());
    }

    public void setRoomonfloor(ObservableList<Room> roomonfloor) {
        this.roomonfloor = roomonfloor;
        countRoom.set(this.roomonfloor.size());
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public void setRooms(List roomonfloor){
        this.roomonfloor.setAll(roomonfloor);
        countRoom.set(this.roomonfloor.size());
    }

    public void addRoom(Room roomonfloor){
        this.roomonfloor.add(roomonfloor);
        countRoom.set(this.roomonfloor.size());
    }

    public StringProperty numberProperty() {
        return number;
    }

    public int getCountRoom() {
        countRoom.set(this.roomonfloor.size());
        return countRoom.get();
    }

    public IntegerProperty countRoomProperty() {
        countRoom.set(this.roomonfloor.size());
        return countRoom;
    }

    public ObservableList<Room> getRooms(){
        return roomonfloor;
    }

    public List getRoomonfloor(){
        return roomonfloor;
    }

    public String getNumber(){
        return number.get();
    }

    public StringProperty getNumberProperty() {
        return number;
    }

    public String toString(){
        return "Номер этажа: "+getNumber()+"\nКомнаты на этаже: "+getRoomonfloor().toString();
    }

    /*public void print(){
        System.out.print("Номер этажа: ");
        System.out.println(number);
        System.out.print("Комнаты на этаже: ");
        //System.out.println(roomonfloor.toString());
    }*/
}
