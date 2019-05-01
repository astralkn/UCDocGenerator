package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import memoriu.project.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_8 extends Controller {
    public JFXButton buttContinue_8;

    @Override
    public void initialize() {

    }


    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void continue_8(ActionEvent actionEvent) {
        proceed(actionEvent,"9_final.fxml",this.project);
    }
}
