package memoriu.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import memoriu.project.ProjectSubType;
import memoriu.property.Property;
import memoriu.utr.*;

import java.util.HashMap;

public class Controller_7 extends Controller {
    public JFXListView listTerrains_7;
    public JFXRadioButton rbExistingUTR_7;
    public JFXRadioButton rbNewUTR_7;
    public JFXComboBox cb1CityUTR_7;
    public JFXComboBox cb2DetailedCityUTR_7;
    public JFXTextField tfNewUTRName_7;
    public JFXTextField tfNewUTRDescription_7;
    public JFXTextField tfNewUTRMaxFootprint_7;
    public JFXTextField tfNewUTRMaxBuildingArea_7;
    public JFXTextField tfNewUTRMaxHeight_7;

    private HashMap<Integer,Property> properties;


    @Override
    public void initialize() {
        properties = new HashMap<>();
        cb1CityUTR_7.setDisable(true);
        cb2DetailedCityUTR_7.setDisable(true);
        tfNewUTRName_7.setDisable(true);
        tfNewUTRDescription_7.setDisable(true);
        tfNewUTRMaxFootprint_7.setDisable(true);
        tfNewUTRMaxBuildingArea_7.setDisable(true);
        tfNewUTRMaxHeight_7.setDisable(true);
    }

    public void load() {
        for (Property p : super.getProject().getProperties()
        ) {
            properties.put(properties.size(),p);
            listTerrains_7.getItems().add(p.getAddress().getStreetNumber()+" "+
                    p.getSurface());
        }
        cb1CityUTR_7.getItems().addAll("PUG Bucuresti","PUZ Sector 2","PUZ " +
                "Sector 3");

    }

    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void updateRadioButtons(ActionEvent actionEvent) {
        if (actionEvent.getSource()== rbExistingUTR_7){
            rbNewUTR_7.setSelected(false);
            setDisabledObjects(rbExistingUTR_7);
            rbNewUTR_7.setStyle(null);
            rbExistingUTR_7.setStyle(null);
        } else if (actionEvent.getSource()== rbNewUTR_7){
            rbExistingUTR_7.setSelected(false);
            setDisabledObjects(rbNewUTR_7);
            rbNewUTR_7.setStyle(null);
            rbExistingUTR_7.setStyle(null);
        }

    }

    public void updateCB2_6(ActionEvent actionEvent) {
        if (cb1CityUTR_7.getValue().equals("PUG Bucuresti")){
            cb2DetailedCityUTR_7.getItems().clear();
            cb2DetailedCityUTR_7.getItems().addAll(UTR_PUG_Bucuresti.values());
        } else if (cb1CityUTR_7.getValue().equals("PUZ Sector 2")){
            cb2DetailedCityUTR_7.getItems().clear();
            cb2DetailedCityUTR_7.getItems().addAll(UTR_PUZ_Sector_2.values());
        } else if (cb1CityUTR_7.getValue().equals("PUZ Sector 3")){
            cb2DetailedCityUTR_7.getItems().clear();
            cb2DetailedCityUTR_7.getItems().addAll(UTR_PUZ_Sector_3.values());
        }
    }

    public void addUTRToTerrain(ActionEvent actionEvent) {
        if (getSelectedPropertyFromPropertyList()== null){
            listTerrains_7.setStyle(invalidField);
        }else {
            if (rbExistingUTR_7.isSelected()) {
                getSelectedPropertyFromPropertyList().addNewUTR(getUTRfromComboBox());
                System.out.println(getSelectedPropertyFromPropertyList().getNewUTRS().toString());
                listTerrains_7.setStyle(null);
            } else if (rbNewUTR_7.isSelected()) {
                getSelectedPropertyFromPropertyList().addNewUTR(getNewUTRFromTFData());
                System.out.println(getSelectedPropertyFromPropertyList().getNewUTRS().toString());
                listTerrains_7.setStyle(null);
            } else {
                rbNewUTR_7.setStyle(invalidField);
                rbExistingUTR_7.setStyle(invalidField);
            }
        }
    }

    public void continue_6(ActionEvent actionEvent) {
        int totalUtrs = 0;
        boolean isValid = true;
        for (Property p:project.getProperties()){
            for (UTR r :p.getNewUTRS()){
                totalUtrs++;
            }
            if (p.getNewUTRS().size()==0){
                isValid = false;
            }
        }
        if (totalUtrs>0 && isValid){
            proceed(actionEvent,"8_confirmGeneration.fxml",this.project);
        } else {
            listTerrains_7.setStyle(invalidField);
        }
    }

    private void setDisabledObjects(JFXRadioButton rb){
        if (rb == rbExistingUTR_7){
            cb1CityUTR_7.setDisable(false);
            cb2DetailedCityUTR_7.setDisable(false);
            tfNewUTRName_7.setDisable(true);
            tfNewUTRDescription_7.setDisable(true);
            tfNewUTRMaxFootprint_7.setDisable(true);
            tfNewUTRMaxBuildingArea_7.setDisable(true);
            tfNewUTRMaxHeight_7.setDisable(true);
        } else if (rb == rbNewUTR_7){
            cb1CityUTR_7.setDisable(true);
            cb2DetailedCityUTR_7.setDisable(true);
            tfNewUTRName_7.setDisable(false);
            tfNewUTRDescription_7.setDisable(false);
            tfNewUTRMaxFootprint_7.setDisable(false);
            tfNewUTRMaxBuildingArea_7.setDisable(false);
            tfNewUTRMaxHeight_7.setDisable(false);
        }
    }

    private UTR getUTRfromComboBox(){
        if (cb1CityUTR_7.getSelectionModel().isSelected(0)){
            return UTR_PUG_Bucuresti.getUTRbyName(cb2DetailedCityUTR_7.getSelectionModel().getSelectedItem().toString());
        } else if (cb1CityUTR_7.getSelectionModel().isSelected(1)){
            return UTR_PUZ_Sector_2.getUTRbyName(cb2DetailedCityUTR_7.getSelectionModel().getSelectedItem().toString());
        }  else if (cb1CityUTR_7.getSelectionModel().isSelected(2)){
            return UTR_PUZ_Sector_3.getUTRbyName(cb2DetailedCityUTR_7.getSelectionModel().getSelectedItem().toString());
        } else {
            System.out.println("Nu recunoaste cb1s");
            return null;
        }
    }

    private Property getSelectedPropertyFromPropertyList(){
        return properties.get(listTerrains_7.getSelectionModel().getSelectedIndex());
    }

    private UTR getNewUTRFromTFData(){
        return new UTRCustom(tfNewUTRName_7.getText(),
                tfNewUTRDescription_7.getText(),
                tfNewUTRMaxFootprint_7.getText(),
                tfNewUTRMaxBuildingArea_7.getText(),
                tfNewUTRMaxHeight_7.getText());
    }
}
