package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import memoriu.address.Address;
import memoriu.building.Building;
import memoriu.person.Person;
import memoriu.project.utilities.Utilities;
import memoriu.property.Property;
import org.controlsfx.control.CheckListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller_5 extends Controller {


    public JFXTextField tfTerrainSurface_5, tfCity_5,
            tfDistrict_5, tfCounty_5, tfStreet_5, tfStreetNum_5, tfCadastralNum_5;
    public JFXCheckBox cbWater_5, cbSewage_5, cbGas_5, cbElectricity_5;
    public JFXTextField tfBuildingFootPrint_5;
    public JFXTextField tfBuildingTotalArea_5;
    public CheckListView listInvestors_5;
    public JFXButton buttAddBuilding_5;
    public ListView listBuildings_5;
    public JFXTextField tfBuildingMaterial_5;
    public JFXTextField tfBuildingState_5;
    public JFXButton closeButton;
    public ListView listTerrains_6;
    public JFXButton buttContinue_6;
    /*
    Utilities
     */
    private HashMap<String, Building> buildingHashMap = new HashMap<>();
    private HashMap<String, Person> investorHashMap = new HashMap<>();

    @Override
    public void load() {
        for (Person p : super.getProject().getInvestors()
        ) {
            investorHashMap.put(p.getName(), p);
            listInvestors_5.getItems().add(p.getName());
        }
        listInvestors_5.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                System.out.println(listInvestors_5.getCheckModel().getCheckedItems());
            }
        });
        buttContinue_6.setDisable(true);
    }


    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void addTerrain_5(ActionEvent actionEvent) {

        if (checkTerrainIsValid() & checkOwnerIsSelected()) {
            Property property = new Property();
            Address propertyAddress = new Address();
            propertyAddress.setCounty(tfCounty_5.getText());
            propertyAddress.setCity(tfCity_5.getText());
            propertyAddress.setDistrict(tfDistrict_5.getText());
            propertyAddress.setStreet(tfStreet_5.getText());
            propertyAddress.setStreetNumber(tfStreetNum_5.getText());
            property.setAddress(propertyAddress);
            property.setSurface(tfTerrainSurface_5.getText());
            property.setCadastralNumber(tfCadastralNum_5.getText());
            if (cbWater_5.isSelected()) {
                property.addUtilitie(Utilities.WATER);
            }
            if (cbSewage_5.isSelected()) {
                property.addUtilitie(Utilities.SEWAGE);
            }
            if (cbGas_5.isSelected()) {
                property.addUtilitie(Utilities.GAS);
            }
            if (cbElectricity_5.isSelected()) {
                property.addUtilitie(Utilities.ELECTICITY);
            }
            property.setOwners(getSelectedOwners());
            property.setBuildings(getBuildings());
            project.addProperty(property);
            listTerrains_6.getItems().add(property);
            resetFields();
            buttContinue_6.setDisable(false);
        }
    }

    private void resetFields() {
        listBuildings_5.getItems().clear();
        updateBuildingsField();
        tfCounty_5.setText("");
        tfCity_5.setText("");
        tfDistrict_5.setText("");
        tfStreet_5.setText("");
        tfStreetNum_5.setText("");
        tfCadastralNum_5.setText("");
        tfTerrainSurface_5.setText("");
    }

    private boolean checkTerrainIsValid() {
        boolean isValid = true;
        if (tfCounty_5.getText().equals("")) {
            if (tfDistrict_5.getText().equals("")) {
                tfCounty_5.setStyle(invalidField);
                tfDistrict_5.setStyle(invalidField);
                isValid = false;
            }
        } else {
            tfCounty_5.setStyle(null);
            tfDistrict_5.setStyle(null);
        }
        if (tfCity_5.getText().equals("")) {
            tfCity_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfCity_5.setStyle(null);
        }
        if (tfDistrict_5.getText().equals("")) {
            if (tfCounty_5.getText().equals("")) {
                tfDistrict_5.setStyle(invalidField);
                tfCounty_5.setStyle(invalidField);
                isValid = false;
            }
        } else {
            tfCounty_5.setStyle(null);
            tfDistrict_5.setStyle(null);
        }
        if (tfStreet_5.getText().equals("")) {
            tfStreet_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfStreet_5.setStyle(null);
        }
        if (tfStreetNum_5.getText().equals("")) {
            tfStreetNum_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfStreetNum_5.setStyle(null);
        }
        if (tfCadastralNum_5.getText().equals("")) {
            tfCadastralNum_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfCadastralNum_5.setStyle(null);
        }
        if (tfTerrainSurface_5.getText().equals("")) {
            tfTerrainSurface_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfTerrainSurface_5.setStyle(null);
        }
        return isValid;
    }

    private boolean checkOwnerIsSelected() {
        boolean isValid = true;
        if (listInvestors_5.getCheckModel().getCheckedItems().size() == 0) {
            listInvestors_5.setStyle(invalidField);
            isValid = false;
        } else {
            listInvestors_5.setStyle(null);
        }
        return isValid;
    }

    private ArrayList<Person> getSelectedOwners() {
        ArrayList<Person> result = new ArrayList<>();
        for (Object s : listInvestors_5.getCheckModel().getCheckedItems()) {
            result.add(investorHashMap.get(String.valueOf(s)));
        }
        return result;
    }

    private ArrayList<Building> getBuildings() {
        ArrayList<Building> result = new ArrayList<>();
        for (Map.Entry<String, Building> entry : buildingHashMap.entrySet()
        ) {
            result.add(entry.getValue());
        }
        return result;
    }

    private void updateBuildingsField() {
        tfBuildingFootPrint_5.clear();
        tfBuildingFootPrint_5.setStyle(null);

        tfBuildingTotalArea_5.clear();
        tfBuildingTotalArea_5.setStyle(null);

        tfBuildingMaterial_5.clear();
        tfBuildingMaterial_5.setStyle(null);

        tfBuildingState_5.clear();
        tfBuildingState_5.setStyle(null);
    }

    public void addBuilding_5(ActionEvent actionEvent) {
        if (checkBuildingIsValid()) {
            Building building = new Building();
            building.setFootprint(tfBuildingFootPrint_5.getText());
            building.setTotalArea(tfBuildingTotalArea_5.getText());
            building.setBuildingMaterial(tfBuildingMaterial_5.getText());
            building.setBuildingCurrentState(tfBuildingState_5.getText());
            indexBuilding(building);
            updateBuildingsField();
        }

    }

    private boolean checkBuildingIsValid() {
        boolean isValid = true;
        if (tfBuildingFootPrint_5.getText().equals("")) {
            tfBuildingFootPrint_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfBuildingFootPrint_5.setStyle(null);
        }
        if (tfBuildingTotalArea_5.getText().equals("")) {
            tfBuildingTotalArea_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfBuildingTotalArea_5.setStyle(null);
        }
        if (tfBuildingMaterial_5.getText().equals("")) {
            tfBuildingMaterial_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfBuildingMaterial_5.setStyle(null);
        }
        if (tfBuildingState_5.getText().equals("")) {
            tfBuildingState_5.setStyle(invalidField);
            isValid = false;
        } else {
            tfBuildingState_5.setStyle(null);
        }
        return isValid;
    }

    public void continue_5(ActionEvent actionEvent) {
        if (this.project.getProperties().size() > 0) {
            proceed(actionEvent, "6_ExistingUTR.fxml", this.project);
        } else {
            listTerrains_6.setStyle(invalidField);
        }
    }


    private void indexBuilding(Building building) {
        buildingHashMap.put("Cladirea " + (buildingHashMap.size() + 1), building);
        listBuildings_5.getItems().add("Cladirea " + (buildingHashMap.size()));
    }
}
