package models;

import javafx.beans.property.*;
import javafx.scene.control.CheckBox;

public class Equipment extends EntityClass {
    private IntegerProperty count = new SimpleIntegerProperty();
    private CheckBox selected = new CheckBox();

    static public class TypeOfEquipments extends EntityClass {
        private StringProperty typeofequipment = new SimpleStringProperty();
        public TypeOfEquipments(){}
        public TypeOfEquipments(String TypeOfEquipment){
            this.typeofequipment.set(TypeOfEquipment);
        }

        public void setTypeOfEquipment(String typeofequipment) {
            this.typeofequipment.set(typeofequipment);
        }

        public String getTypeOfEquipment() {
            return typeofequipment.get();
        }

        public String toString() {
            return typeofequipment.get();
        }

        public StringProperty typeofequipmentProperty() {
            return typeofequipment;
        }

        public void setTypeofequipmentProperty(StringProperty typeofequipment) {
            this.typeofequipment = typeofequipment;
        }
    }

    private ObjectProperty<TypeOfEquipments> type = new SimpleObjectProperty<>();

    public Equipment(){
        this.count.set(0);
        this.type.set(new TypeOfEquipments(""));
    }

    public Equipment(TypeOfEquipments type, int count){
        this.type.set(type);
        this.count.set(count);
    }

    public void setTypeOfEquipment(TypeOfEquipments type){
        this.type.set(type);
    }

    public TypeOfEquipments getTypeOfEquipment(){
        return type.get();
    }

    public void setCountOfEquipment(int count){
        this.count.set(count);
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public ObjectProperty<TypeOfEquipments> typeProperty() {
        return type;
    }

    public int getCountOfEquipment(){
        return count.get();
    }

    public CheckBox getSelected() {
        return selected;
    }

    public void setSelected(CheckBox selected) {
        this.selected = selected;
    }

    public String toString(){
        return getTypeOfEquipment().toString()+", кол-во: "+getCountOfEquipment();
    }

    public StringProperty typeStringProperty(){
        return new SimpleStringProperty(toString());
    }

    /*public void print(){
        System.out.print("Кол-во оборудования: ");
        System.out.println(count);
        System.out.print("Тип оборудования: ");
        System.out.println(type.toString());
    }*/
}
