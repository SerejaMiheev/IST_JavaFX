package models;

import javafx.beans.property.*;

public class Person extends EntityClass {
    private StringProperty fio = new SimpleStringProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<Room> room = new SimpleObjectProperty<>();

    public Person(){
        fio.set("Unknown");
        id.set(0);
    }

    public Person(String fio, int id){
        this.fio.set(fio);
        this.id.set(id);
    }

    public Person(String fio, int id, Room room){
        this.fio.set(fio);
        this.id.set(id);
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

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getId() {
        return id.get();
    }

    public String getFio() {
        return fio.get();
    }

    public String toString(){
        return "ФИО: "+getFio()+"\nID: "+getId() + "\nКомната: "+ getRoom().toString();
    }

    /*public void print(){
        System.out.print("ФИО: ");
        System.out.println(fio);
        System.out.print("ID: ");
        System.out.println(id);
    }*/
}
