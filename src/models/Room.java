package models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import models.Equipment;

import java.util.List;

public class Room extends Section {
    private ObservableList<Equipment> equipments = new SimpleListProperty<>();
    private CheckBox selected = new CheckBox();

    public Room(){}

    public Room(int number){
        this.number.set(number);
    }

    public Room(List equipments, int number){
        this.equipments.setAll(equipments);
        this.number.set(number);
    }

    public void setEquipments(List equipments) {
        this.equipments.setAll(equipments);
    }

    public void addEquipments(Equipment equipments){
        this.equipments.add(equipments);
    }

    public List getEquipments() {
        return equipments;
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
        if (getEquipments().size() > 0){
            return "Номер комнаты: "+getNumber()+"\nСписок оборудования: "+getEquipments().toString();
        }
        else {
            return "Номер комнаты: "+getNumber();
        }
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
