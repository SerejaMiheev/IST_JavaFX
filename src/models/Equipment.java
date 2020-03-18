package models;

import javafx.beans.property.*;

public class Equipment extends EntityClass {
    private IntegerProperty count = new SimpleIntegerProperty();

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
            return "Тип оборудования: "+typeofequipment;
        }

        public String getTypeofequipment() {
            return typeofequipment.get();
        }

        public StringProperty typeofequipmentProperty() {
            return typeofequipment;
        }

        public void setTypeofequipment(String typeofequipment) {
            this.typeofequipment.set(typeofequipment);
        }
    }

    private ObjectProperty<TypeOfEquipments> type = new SimpleObjectProperty<>();

    private Equipment(){}

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

    public int getCount() {
        return count.get();
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public TypeOfEquipments getType() {
        return type.get();
    }

    public ObjectProperty<TypeOfEquipments> typeProperty() {
        return type;
    }

    public void setType(TypeOfEquipments type) {
        this.type.set(type);
    }

    public int getCountOfEquipment(){
        return count.get();
    }

    public String toString(){
        return "Кол-во оборудования: "+getCount()+"\n"+getType().toString();
    }

    /*public void print(){
        System.out.print("Кол-во оборудования: ");
        System.out.println(count);
        System.out.print("Тип оборудования: ");
        System.out.println(type.toString());
    }*/
}
