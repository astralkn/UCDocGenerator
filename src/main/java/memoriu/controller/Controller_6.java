package memoriu.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import memoriu.property.Property;
import memoriu.utr.*;

import java.util.HashMap;

public class Controller_6 extends Controller {
    public JFXListView listTerrains_6;
    public JFXRadioButton rbExistingUTR_6;
    public JFXRadioButton rbNewUTR_6;
    public JFXComboBox cb1CityUTR_6;
    public JFXComboBox cb2DetailedCityUTR_6;
    public JFXTextField tfNewUTRName_6;
    public JFXTextField tfNewUTRDescription_6;
    public JFXTextField tfNewUTRMaxFootprint_6;
    public JFXTextField tfNewUTRMaxBuildingArea_6;
    public JFXTextField tfNewUTRMaxHeight_6;
    public JFXButton buttContinue_6;

    private HashMap<Integer,Property> properties;


    @Override
    public void initialize() {
        properties = new HashMap<>();
        cb1CityUTR_6.setDisable(true);
        cb2DetailedCityUTR_6.setDisable(true);
        tfNewUTRName_6.setDisable(true);
        tfNewUTRDescription_6.setDisable(true);
        tfNewUTRMaxFootprint_6.setDisable(true);
        tfNewUTRMaxBuildingArea_6.setDisable(true);
        tfNewUTRMaxHeight_6.setDisable(true);
        buttContinue_6.setDisable(true);
    }

    public void load() {
        for (Property p : super.getProject().getProperties()
        ) {
            properties.put(properties.size(),p);
            listTerrains_6.getItems().add(p.getAddress().getStreetNumber()+" "+
                    p.getSurface());
        }
        cb1CityUTR_6.getItems().addAll("PUG Bucuresti","PUZ Sector 2","PUZ " +
                "Sector 3");

    }

    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void updateRadioButtons(ActionEvent actionEvent) {
        if (actionEvent.getSource()==rbExistingUTR_6){
            rbNewUTR_6.setSelected(false);
            setDisabledObjects(rbExistingUTR_6);
            rbNewUTR_6.setStyle(null);
            rbExistingUTR_6.setStyle(null);
        } else if (actionEvent.getSource()==rbNewUTR_6){
            rbExistingUTR_6.setSelected(false);
            setDisabledObjects(rbNewUTR_6);
            rbNewUTR_6.setStyle(null);
            rbExistingUTR_6.setStyle(null);
        }

    }

    public void updateCB2_6(ActionEvent actionEvent) {
        if (cb1CityUTR_6.getValue().equals("PUG Bucuresti")){
            cb2DetailedCityUTR_6.getItems().clear();
            cb2DetailedCityUTR_6.getItems().addAll(UTR_PUG_Bucuresti.values());
        } else if (cb1CityUTR_6.getValue().equals("PUZ Sector 2")){
            cb2DetailedCityUTR_6.getItems().clear();
            cb2DetailedCityUTR_6.getItems().addAll(UTR_PUZ_Sector_2.values());
        } else if (cb1CityUTR_6.getValue().equals("PUZ Sector 3")){
            cb2DetailedCityUTR_6.getItems().clear();
            cb2DetailedCityUTR_6.getItems().addAll(UTR_PUZ_Sector_3.values());
        }
    }

    public void addUTRToTerrain(ActionEvent actionEvent) {
        if (getSelectedPropertyFromPropertyList()== null){
            listTerrains_6.setStyle(invalidField);
        }else {
            if (rbExistingUTR_6.isSelected()) {
                getSelectedPropertyFromPropertyList().addUTR(getUTRfromComboBox());
                System.out.println(getSelectedPropertyFromPropertyList().getUTRS().toString());
                buttContinue_6.setDisable(false);
                listTerrains_6.setStyle(null);
            } else if (rbNewUTR_6.isSelected()) {
                getSelectedPropertyFromPropertyList().addUTR(getNewUTRFromTFData());
                System.out.println(getSelectedPropertyFromPropertyList().getUTRS().toString());
                buttContinue_6.setDisable(false);
                listTerrains_6.setStyle(null);
            } else {
                rbNewUTR_6.setStyle(invalidField);
                rbExistingUTR_6.setStyle(invalidField);
            }
        }
    }

    public void continue_6(ActionEvent actionEvent) {
        int totalUtrs = 0;
        boolean isValid = true;
        for (Property p:project.getProperties()){
            for (UTR r:p.getUTRS()){
                totalUtrs++;
            }
            if (p.getUTRS().size()==0){
                isValid = false;
            }
        }
        if (totalUtrs>0 && isValid){
            proceed(actionEvent,"7_NewUTR.fxml",this.project);
        } else {
            listTerrains_6.setStyle(invalidField);
        }
    }

    private void setDisabledObjects(JFXRadioButton rb){
        if (rb == rbExistingUTR_6){
            cb1CityUTR_6.setDisable(false);
            cb2DetailedCityUTR_6.setDisable(false);
            tfNewUTRName_6.setDisable(true);
            tfNewUTRDescription_6.setDisable(true);
            tfNewUTRMaxFootprint_6.setDisable(true);
            tfNewUTRMaxBuildingArea_6.setDisable(true);
            tfNewUTRMaxHeight_6.setDisable(true);
        } else if (rb == rbNewUTR_6){
            cb1CityUTR_6.setDisable(true);
            cb2DetailedCityUTR_6.setDisable(true);
            tfNewUTRName_6.setDisable(false);
            tfNewUTRDescription_6.setDisable(false);
            tfNewUTRMaxFootprint_6.setDisable(false);
            tfNewUTRMaxBuildingArea_6.setDisable(false);
            tfNewUTRMaxHeight_6.setDisable(false);
        }
    }

    private UTR getUTRfromComboBox(){
        if (cb1CityUTR_6.getSelectionModel().isSelected(0)){
            return UTR_PUG_Bucuresti.getUTRbyName(cb2DetailedCityUTR_6.getSelectionModel().getSelectedItem().toString());
        } else if (cb1CityUTR_6.getSelectionModel().isSelected(1)){
            return UTR_PUZ_Sector_2.getUTRbyName(cb2DetailedCityUTR_6.getSelectionModel().getSelectedItem().toString());
        }  else if (cb1CityUTR_6.getSelectionModel().isSelected(2)){
            return UTR_PUZ_Sector_3.getUTRbyName(cb2DetailedCityUTR_6.getSelectionModel().getSelectedItem().toString());
        } else {
            System.out.println("Nu recunoaste cb1s");
            return null;
        }
    }

    private Property getSelectedPropertyFromPropertyList(){
        return properties.get(listTerrains_6.getSelectionModel().getSelectedIndex());
    }

    private UTR getNewUTRFromTFData(){
        return new UTRCustom(tfNewUTRName_6.getText(),
                tfNewUTRDescription_6.getText(),
                tfNewUTRMaxFootprint_6.getText(),
                tfNewUTRMaxBuildingArea_6.getText(),
                tfNewUTRMaxHeight_6.getText());
    }
}
