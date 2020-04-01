package models;

import javafx.beans.property.*;

public class Person extends EntityClass {
    private StringProperty fio = new SimpleStringProperty();
    private ObjectProperty<Room> room = new SimpleObjectProperty<>();

    public Person(){
        fio.set("");
        room.set(new Room());
    }

    public  Person(String fio){
        this.fio.set(fio);
        room.set(new Room());
    }


    public Person(String fio, Room room){
        this.fio.set(fio);
        this.room.set(room);
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public Room getRoom() {
        return room.get();
    }

    public ObjectProperty<Room> roomProperty() {
        return room;
    }

    public void setRoom(Room room) {
        this.room.set(room);
    }

    public StringProperty fioProperty() {
        return fio;
    }


    public String getFio() {
        return fio.get();
    }

    public String toString(){
        return "ФИО: "+getFio()+"\nКомната: "+ getRoom();
    }

    /*public void print(){
        System.out.print("ФИО: ");
        System.out.println(fio);
        System.out.print("ID: ");
        System.out.println(id);
    }*/
}
