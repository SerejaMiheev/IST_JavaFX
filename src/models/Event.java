package models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Event extends EntityClass {
    private ObjectProperty<Date> date = new SimpleObjectProperty<>();
    private ObjectProperty<Camera> camera = new SimpleObjectProperty<>();
    private ObjectProperty<Person> person = new SimpleObjectProperty<>();
    private StringProperty record = new SimpleStringProperty();

    public Event(){
        date.set(new Date());
    }

    public Event(Camera camera, Person person){
        date.set(new Date());
        this.camera.set(camera);
        this.person.set(person);
    }

    public Event(Camera camera){
        date.set(new Date());;
        this.camera.set(camera);
    }

    public void setRecord(String record) {
            this.record.set(record);
        }

    public Camera getCamera() {
            return camera.get();
        }

    public ObjectProperty<Date> getDateProperty() {
        return date;
    }


    public Date getDate() {
            return date.get();
        }

    public String getRecord() {
            return record.get();
        }

    public ObjectProperty<Camera> cameraProperty() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera.set(camera);
    }

    public ObjectProperty<Person> personProperty() {
        return person;
    }

    public void setPerson(Person person) {
        this.person.set(person);
    }

    public StringProperty recordProperty() {
        return record;
    }

    public Person getPerson() {
            return person.get();
        }

    public String toString() {
        if(!person.get().getFio().isBlank()) {
            return "Человек: " + getPerson().toString() + getCamera().toString();
        }
        else {
            return getCamera().toString();
        }
    }

    public StringProperty stringProperty(){
        return new SimpleStringProperty(toString());
    }
    /*public void print(){
        System.out.print("Дата и время наступления события: ");
        System.out.println(date);
        System.out.print("Человек: ");
        System.out.println(person.toString());
        System.out.print("Камера: ");
        System.out.println(camera);
        System.out.print("Запись события: ");
        System.out.println(record);
    }*/
}
