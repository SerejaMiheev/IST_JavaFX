package models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.List;

public class Floor extends Section {
    private ObservableList<Room> roomonfloor = new SimpleListProperty<>();
    private IntegerProperty countRoom = new SimpleIntegerProperty();


    public Floor(){}

    public Floor(int number){
        this.number.set(number);
    }

    public Floor(List roomonfloor, int number){
        this.roomonfloor.setAll(roomonfloor);
        this.number.set(number);
        countRoom.set(this.roomonfloor.size());
        countCamera.set(this.cameras.size());
    }

    public Floor(List roomonfloor){
        this.roomonfloor.setAll(roomonfloor);
        countRoom.set(this.roomonfloor.size());
        countCamera.set(this.cameras.size());
    }

    public Floor(Room roomonfloor){
        this.roomonfloor.add(roomonfloor);
        countRoom.set(this.roomonfloor.size());
        countCamera.set(this.cameras.size());
    }

    public void setRoomonfloor(ObservableList<Room> roomonfloor) {
        this.roomonfloor = roomonfloor;
        countRoom.set(this.roomonfloor.size());
    }

    public void setRooms(List roomonfloor){
        this.roomonfloor.setAll(roomonfloor);
        countRoom.set(this.roomonfloor.size());
    }

    public void addRoom(Room roomonfloor){
        this.roomonfloor.add(roomonfloor);
        countRoom.set(this.roomonfloor.size());
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

    public IntegerProperty count(){
        countCamera.set(this.cameras.size());
        return countCamera;
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
