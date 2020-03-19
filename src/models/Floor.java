package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class Floor extends EntityClass {
    private IntegerProperty number = new SimpleIntegerProperty();
    private ObservableList<Room> roomonfloor = new SimpleListProperty<>();
    private IntegerProperty countRoom = new SimpleIntegerProperty();

    public Floor(){}

    public Floor(int number){
        this.number.set(number);
    }

    public Floor(List roomonfloor, int number){
        this.roomonfloor.setAll(roomonfloor);
        this.number.set(number);
    }

    private void countRoom(){
        roomonfloor.size();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public int getCountRoom() {
        countRoom();
        return countRoom.get();
    }

    public IntegerProperty countRoomProperty() {
        countRoom();
        return countRoom;
    }

    public int getCount() {
        return countRoom.get();
    }
    public void setCountRoom(int countRoom) {
        this.countRoom.set(countRoom);
    }

    public void setRoomonfloor(ObservableList<Room> roomonfloor) {
        this.roomonfloor = roomonfloor;
    }

    public Floor(List roomonfloor){
        this.roomonfloor.setAll(roomonfloor);
    }

    public Floor(Room roomonfloor){
        this.roomonfloor.add(roomonfloor);
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public void setRooms(List roomonfloor){
        this.roomonfloor.setAll(roomonfloor);
    }

    public void addRoom(Room roomonfloor){
        this.roomonfloor.add(roomonfloor);
    }

    public List getRoomonfloor(){
        return roomonfloor;
    }

    public int getNumber(){
        return number.get();
    }

    public String getNumberStr(){
        StringBuilder result = new StringBuilder("");
        result.append(number.get());
        return result.toString();
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
