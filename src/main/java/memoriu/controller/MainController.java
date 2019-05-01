package memoriu.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import memoriu.address.Address;
import memoriu.building.Building;
import memoriu.person.LegalPerson;
import memoriu.person.Person;
import memoriu.person.PrivatePerson;
import memoriu.project.Project;
import memoriu.project.utilities.Utilities;
import memoriu.property.Property;
import org.controlsfx.control.CheckListView;

import java.io.IOException;
import java.util.HashMap;

public class MainController {


    public JFXButton closeButton;

    /*
    investor.fxml objects
     */

    /*
    numberOfTerrains.fxml objects
     */

    /*
    terrain.fxml
     */




    /*
    ExistingUTR.fxml objects
     */
    public Label lbTerrain_9;
    public JFXRadioButton rbExistingUTR_9, rbNewUTR_9;
    public JFXComboBox cb1CityUTR_9, cb2DetailedCityUTR_9;
    public JFXTextField tfNewUTRName_9, tfNewUTRDescription_9,
            tfNewUTRMaxFootprint_9, tfNewUTRMaxBuildingArea_9,
            tfNewUTRMaxHeight_9;

    /*
    NewUTR.fxml objects
     */
    public Label lbTerrain_10;
    public JFXRadioButton rbExistingUTR_10, rbNewUTR_10;
    public JFXComboBox cb1CityUTR_10, cb2DetailedCityUTR_10;
    public JFXTextField tfNewUTRName_10, tfNewUTRDescription_10,
            tfNewUTRMaxFootprint_10, tfNewUTRMaxBuildingArea_10,
            tfNewUTRMaxHeight_10;




    /*
    Project objects
     */
    Project project = new Project();

    String invalidField = "-fx-background-color: #D08477;";


    private void proceed(ActionEvent actionEvent, String fxmlScene) {
        try {
            Parent projectType =
                    FXMLLoader.load(getClass().getClassLoader().getResource(
                            fxmlScene));
            Scene projectDeveloperScene = new Scene((projectType));
            Stage window =
                    (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            window.setScene(projectDeveloperScene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
















    public void updateCB2_9(ActionEvent actionEvent) {
    }

    public void continue_9(ActionEvent actionEvent) {
        proceed(actionEvent, "NewUTR.fxml");

    }

    public void updateCB2_10(ActionEvent actionEvent) {
    }

    public void continue_10(ActionEvent actionEvent) {
        proceed(actionEvent, "confirmGeneration.fxml");
    }

    public void continue_11(ActionEvent actionEvent) {
        proceed(actionEvent, "final.fxml");
    }



}
