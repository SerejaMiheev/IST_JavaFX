package models;

import javafx.beans.property.*;

public class Camera extends EntityClass {
    private IntegerProperty numbercam = new SimpleIntegerProperty();
    private StringProperty locrecord = new SimpleStringProperty();
    private ObjectProperty<Section> section = new SimpleObjectProperty<>();

    public Camera() {
        numbercam.set(0);
        locrecord.set("");
    }

    public Camera(int numbercam, String locrecord, Section section) {
        this.numbercam.set(numbercam);
        this.locrecord.set(locrecord);
        this.section.set(section);
    }

    public Camera(int numbercam, String locrecord) {
        this.numbercam.set(numbercam);
        this.locrecord.set(locrecord);
    }

    public void setSection(Section section) {
        this.section.set(section);
    }

    public void setLocrecord(String locrecord) {
        this.locrecord.set(locrecord);
    }

    public void setNumbercam(int numbercam) {
        this.numbercam.set(numbercam);
    }

    public Section getSection() {
        return section.get();
    }

    public int getNumbercam() {
        return numbercam.get();
    }

    public IntegerProperty numbercamProperty() {
        return numbercam;
    }

    public String getLocrecord() {
        return locrecord.get();
    }

    public StringProperty locrecordProperty() {
        return locrecord;
    }

    public ObjectProperty<Section> sectionProperty() {
        return section;
    }

    @Override
    public String toString() {
        return "Номер камеры: " + getNumbercam() + "\nПуть записи: " + getLocrecord() + "\nСекция в которой находится камера: " + getSection().getNumsection();
    }

    /*public void print(){
        System.out.print("Номер камеры: ");
        System.out.println(numbercam);
        System.out.print("Путь записи: ");
        System.out.println(locrecord);
        System.out.print("Секция в которой находится камера: ");
        System.out.println(section.toString());
    }*/
}
