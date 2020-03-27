package models;

import javafx.beans.property.*;

public class Person extends EntityClass {
    private StringProperty fio = new SimpleStringProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty numRoom = new SimpleIntegerProperty();

    public Person(){
        fio.set("Unknown");
        id.set(0);
    }

    public  Person(String fio){
        this.fio.set(fio);
    }

    public Person(String fio, int id){
        this.fio.set(fio);
        this.id.set(id);
    }

    public Person(String fio, int id, int numRoom){
        this.fio.set(fio);
        this.id.set(id);
        this.numRoom.set(numRoom);
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public int getRoom() {
        return numRoom.get();
    }

    public IntegerProperty roomProperty() {
        return numRoom;
    }

    public void setRoom(int numRoom) {
        this.numRoom.set(numRoom);
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
        return "ФИО: "+getFio()+"\nID: "+getId() + "\nКомната: "+ getRoom();
    }

    /*public void print(){
        System.out.print("ФИО: ");
        System.out.println(fio);
        System.out.print("ID: ");
        System.out.println(id);
    }*/
}
