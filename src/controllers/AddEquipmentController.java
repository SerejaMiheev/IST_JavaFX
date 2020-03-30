package controllers;

import exceptions.EntityNotFound;
import gw.EquipmentGateway;
import gw.TypeGateway;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Equipment;
import registry.GWRegistry;


public class AddEquipmentController {
    @FXML
    TextField countText;

    @FXML
    ComboBox<Equipment.TypeOfEquipments> typeEquip;

    private TypeGateway typeGateway = GWRegistry.getInstance().getTypeGateway();
    private EquipmentGateway equipmentGateway = GWRegistry.getInstance().getEquipmentGateway();
    private Equipment equipment;
    private boolean isCancel;

    public void setCancel(boolean isCancel) {
        this.isCancel = isCancel;
    }

    public boolean retCancel() {
        return isCancel;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        if (!equipment.getTypeOfEquipment().getTypeOfEquipment().isEmpty()){
            this.countText.setText(equipment.getTypeOfEquipment().getTypeOfEquipment());
        }
    }

    public void initialize() {
        this.typeEquip.setItems(FXCollections.observableArrayList(this.typeGateway.all()));
    }

    public void addEquip() throws EntityNotFound {
        if ((!this.countText.getText().isEmpty()) & (!this.typeEquip.getSelectionModel().isEmpty())) {
            int count = Integer.parseInt(countText.getText());
            Equipment.TypeOfEquipments type = this.typeEquip.getSelectionModel().getSelectedItem();

            this.equipment.setCountOfEquipment(count);
            this.equipment.setTypeOfEquipment(type);

            if (this.equipment.isSaved()) {
                this.equipmentGateway.update(this.equipment);
            } else {
                this.equipmentGateway.insert(this.equipment);
            }
            isCancel = false;

            Stage stage = (Stage) this.typeEquip.getScene().getWindow();
            stage.close();
        }
    }

    public void cancel() {
        isCancel = true;
        Stage stage = (Stage) this.typeEquip.getScene().getWindow();
        stage.close();
    }
}
