package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import memoriu.address.Address;
import memoriu.person.LegalPerson;
import memoriu.person.Person;
import memoriu.person.PrivatePerson;
import memoriu.project.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_4 extends Controller {


    public JFXRadioButton rbPrivatePerson, rbLegalPerson;
    public JFXTextField tfName_4, tfUniqueID_4, tfRegistrationID_4, tfCounty_4,
            tfCity_4, tfDistrict_4, tfStreet_4, tfStreetNumber_4, tfBlock_4,
            tfStair_4, tfStorey_4, tfApartment_4;
    public JFXListView listInvestors_4;
    public JFXButton buttContinue_4;

    @Override
    public void initialize() {

    }

    public void load() {
        disableTextFields();
        buttContinue_4.setDisable(true);
    }

    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPrivatePerson_4(ActionEvent actionEvent) {
        tfRegistrationID_4.setDisable(true);
        rbLegalPerson.setSelected(false);
        tfUniqueID_4.setPromptText("CNP...");
        enableTextFields();
    }

    public void setLegalPerson_4(ActionEvent actionEvent) {
        tfRegistrationID_4.setDisable(false);
        rbPrivatePerson.setSelected(false);
        tfUniqueID_4.setPromptText("CUI...");
        enableTextFields();
    }

    public void addInv_4(ActionEvent actionEvent) {


        if (rbPrivatePerson.isSelected()) {
            PrivatePerson investor = new PrivatePerson();
            if (!(tfName_4.getText() == null)) {
                investor.setName(tfName_4.getText());
            }
            if (!(tfUniqueID_4.getText() == null)) {
                investor.setUniqueID(tfUniqueID_4.getText());
            }
            investor.setAddress(getInvestorAddress());
            project.addInvestor(investor);
            System.out.println("Investor added");
            resetTextFields_4();
            updateInvestorList();
            buttContinue_4.setDisable(false);
        } else if (rbLegalPerson.isSelected()) {
            LegalPerson investor = new LegalPerson();
            if (!(tfName_4.getText() == null)) {
                investor.setName(tfName_4.getText());
            }
            if (!(tfUniqueID_4.getText() == null)) {
                investor.setUniqueID(tfUniqueID_4.getText());
            }
            if (!(tfRegistrationID_4.getText() == null)) {
                investor.setRegistrationID(tfRegistrationID_4.getText());
            }
            investor.setAddress(getInvestorAddress());
            project.addInvestor(investor);
            System.out.println("Investor added");
            resetTextFields_4();
            updateInvestorList();
            buttContinue_4.setDisable(false);
        } else {
            rbLegalPerson.setStyle(invalidField);
            rbPrivatePerson.setStyle(invalidField);
        }

    }

    private void updateInvestorList() {
        listInvestors_4.getItems().clear();
        for (Person p : project.getInvestors()) {
            listInvestors_4.getItems().add(p.getName());
        }

    }

    private void resetTextFields_4() {
        tfName_4.clear();
        tfUniqueID_4.clear();
        tfRegistrationID_4.clear();
        tfCounty_4.clear();
        tfCity_4.clear();
        tfDistrict_4.clear();
        tfStreet_4.clear();
        tfStreetNumber_4.clear();
        tfBlock_4.clear();
        tfStair_4.clear();
        tfStorey_4.clear();
        tfApartment_4.clear();
    }

    private void disableTextFields(){
        tfName_4.setDisable(true);
        tfUniqueID_4.setDisable(true);
        tfRegistrationID_4.setDisable(true);
        tfCounty_4.setDisable(true);
        tfCity_4.setDisable(true);
        tfDistrict_4.setDisable(true);
        tfStreet_4.setDisable(true);
        tfStreetNumber_4.setDisable(true);
        tfBlock_4.setDisable(true);
        tfStair_4.setDisable(true);
        tfStorey_4.setDisable(true);
        tfApartment_4.setDisable(true);
    }

    private void enableTextFields(){
        tfName_4.setDisable(false);
        tfUniqueID_4.setDisable(false);
        tfCounty_4.setDisable(false);
        tfCity_4.setDisable(false);
        tfDistrict_4.setDisable(false);
        tfStreet_4.setDisable(false);
        tfStreetNumber_4.setDisable(false);
        tfBlock_4.setDisable(false);
        tfStair_4.setDisable(false);
        tfStorey_4.setDisable(false);
        tfApartment_4.setDisable(false);
    }

    public Address getInvestorAddress() {
        Address investorAddress = new Address();
        if (!(tfCounty_4.getText() == null)) {
            investorAddress.setCounty(tfCounty_4.getText());
        }
        if (!(tfCity_4.getText() == null)) {
            investorAddress.setCity(tfCity_4.getText());
        }
        if (!(tfDistrict_4.getText() == null)) {
            investorAddress.setDistrict(tfDistrict_4.getText());
        }
        if (!(tfStreet_4.getText() == null)) {
            investorAddress.setStreet(tfStreet_4.getText());
        }
        if (!(tfStreetNumber_4.getText() == null)) {
            investorAddress.setStreetNumber(tfStreetNumber_4.getText());
        }
        if (!(tfBlock_4.getText() == null)) {
            investorAddress.setBlock(tfBlock_4.getText());
        }
        if (!(tfStair_4.getText() == null)) {
            investorAddress.setStairNumber(tfStair_4.getText());
        }
        if (!(tfStorey_4.getText() == null)) {
            investorAddress.setStory(tfStorey_4.getText());
        }
        if (!(tfApartment_4.getText() == null)) {
            investorAddress.setApartment(tfApartment_4.getText());
        }
        return investorAddress;
    }

    public void continue_4(ActionEvent actionEvent) {
        if (this.project.getInvestors().size() > 0 ){
            System.out.println(project.toString());
            proceed(actionEvent, "5_terrain.fxml",this.project);
        } else {
            listInvestors_4.setStyle(invalidField);
        }


    }
}
