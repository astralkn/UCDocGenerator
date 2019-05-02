package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import memoriu.project.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_8 extends Controller {
    public JFXButton buttContinue_8;
    public JFXTextField tfPrjChiefDev_8;
    public JFXTextField tfPrjDev_8;
    public JFXTextField tfDocCreator_8;

    @Override
    public void initialize() {

    }


    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void continue_8(ActionEvent actionEvent) {
        if (checkTextFields()){
            project.setChiefDeveloper(tfPrjChiefDev_8.getText());
            project.setPrjDeveloper(tfPrjDev_8.getText());
            project.setDocCreator(tfDocCreator_8.getText());
            proceed(actionEvent,"9_final.fxml",this.project);
        }
    }

    private boolean checkTextFields(){
        boolean isValid = true;
        if (tfPrjChiefDev_8.getText().equals("")){
            isValid = false;
            tfPrjChiefDev_8.setStyle(invalidField);
        } else {
            tfPrjChiefDev_8.setStyle(null);
        }
        if (tfPrjDev_8.getText().equals("")){
            isValid = false;
            tfPrjDev_8.setStyle(invalidField);
        } else {
            tfPrjDev_8.setStyle(null);
        }
        if (tfDocCreator_8.getText().equals("")){
            isValid = false;
            tfDocCreator_8.setStyle(invalidField);
        } else {
            tfDocCreator_8.setStyle(null);
        }

        return isValid;
    }
}
