package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import memoriu.project.Project;
import memoriu.project.ProjectType;

public class Controller_1 extends Controller {


    public JFXTextField tfTitle_1;
    public JFXButton closeButton;

    @Override
    public void initialize() {
        project = new Project();
    }

    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    public void startUrb(ActionEvent actionEvent) {
        if (tfIsValid()) {
            project.setTitle(tfTitle_1.getText());
            project.setProjectType(ProjectType.URBANISM);
            proceed(actionEvent, "2_projectTypeUrb.fxml", project);
        } else {
            tfTitle_1.setStyle(invalidField);
        }
    }

    public void startArh(ActionEvent actionEvent) {
        if (tfIsValid()) {
            project.setTitle(tfTitle_1.getText());
            project.setProjectType(ProjectType.ARCHITECTURE);
            proceed(actionEvent, "2_projectTypeArc.fxml", project);
        } else {
            tfTitle_1.setStyle(invalidField);
        }
    }

    private boolean tfIsValid() {
        if (tfTitle_1.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
