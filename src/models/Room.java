package models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import models.Equipment;

import java.util.List;

public class Room extends EntityClass {
    private IntegerProperty NumberRoom = new SimpleIntegerProperty();
    private ObservableList<Equipment> equipments = new SimpleListProperty<>();
    private CheckBox selected = new CheckBox();

    public Room(){}

    public Room(int NumberRoom){
        this.NumberRoom.set(NumberRoom);
    }

    public Room(List equipments, int NumberRoom){
        this.equipments.setAll(equipments);
        this.NumberRoom.set(NumberRoom);
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

    public int getNumberRoom() {
        return NumberRoom.get();
    }

    public List getEquipments() {
        return equipments;
    }

    public IntegerProperty numberRoomProperty() {
        return NumberRoom;
    }

    public void setEquipments(ObservableList<Equipment> equipments) {
        this.equipments = equipments;
    }

    public CheckBox getSelected() {
        return selected;
    }

    public void setSelected(CheckBox selected) {
        this.selected = selected;
    }

    public String toString(){
        return "Номер комнаты: "+getNumberRoom()+"\nСписок оборудования: "+getEquipments().toString();
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
