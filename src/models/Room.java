package models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import models.Equipment;

import java.util.List;

public class Room extends EntityClass {
    private BooleanProperty status = new SimpleBooleanProperty();
    private IntegerProperty NumberRoom = new SimpleIntegerProperty();
    private ObservableList<Equipment> equipments = new SimpleListProperty<>();

    public Room(){}

    public Room(int NumberRoom){
        this.NumberRoom.set(NumberRoom);
    }

    public Room(boolean status, int NumberRoom){
        this.status.set(status);
        this.NumberRoom.set(NumberRoom);
    }

    public Room(List equipments, int NumberRoom){
        this.equipments.setAll(equipments);
        this.NumberRoom.set(NumberRoom);
    }

    public Room(boolean status, List equipments, int NumberRoom){
        this.status.set(status);
        this.equipments.setAll(equipments);
        this.NumberRoom.set(NumberRoom);
    }

    public Room(boolean status, Equipment equipments, int NumberRoom){
        this.status.set(status);
        this.equipments.add(equipments);
        this.NumberRoom.set(NumberRoom);
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }

    public void setNumberRoom(int numberRoom) {
        NumberRoom.set(numberRoom);
    }

    public void setEquipments(List equipments) {
        this.equipments.setAll(equipments);
    }

    public void addEquipments(Equipment equipments){
        this.equipments.add(equipments);
    }

    public boolean getStatus(){
        return status.get();
    }

    public int getNumberRoom() {
        return NumberRoom.get();
    }

    public List getEquipments() {
        return equipments;
    }

    public boolean isStatus() {
        return status.get();
    }

    public BooleanProperty statusProperty() {
        return status;
    }

    public IntegerProperty numberRoomProperty() {
        return NumberRoom;
    }

    public void setEquipments(ObservableList<Equipment> equipments) {
        this.equipments = equipments;
    }

    public String toString(){
        return "Номер комнаты: "+getNumberRoom()+"\nСтатус: "+getStatus()+"\nСписок оборудования: "+getEquipments().toString();
    }
    /*public void print(){
        System.out.print("Статус: ");
        System.out.println(status);
        System.out.print("Номер комнаты: ");
        System.out.println(NumberRoom);
        System.out.print("Список оборудования: ");
        System.out.println(equipments.toString());
    }*/
}
