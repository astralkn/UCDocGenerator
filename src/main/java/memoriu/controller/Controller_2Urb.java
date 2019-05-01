package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import memoriu.project.Project;
import memoriu.project.ProjectSubType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_2Urb extends Controller {

    @Override
    public void initialize() {

    }

    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPUD(ActionEvent actionEvent) {
        ArrayList<ProjectSubType> projectSubTypes = new ArrayList<>();
        projectSubTypes.add(ProjectSubType.PUD);
        project.setProjectSubType(projectSubTypes);
        proceed(actionEvent, "3_projectDeveloper.fxml",project);
    }

    public void setPUZ(ActionEvent actionEvent) {
        ArrayList<ProjectSubType> projectSubTypes = new ArrayList<>();
        projectSubTypes.add(ProjectSubType.PUZ);
        project.setProjectSubType(projectSubTypes);
        proceed(actionEvent, "3_projectDeveloper.fxml",project);
    }

    public void setPUG(ActionEvent actionEvent) {
        ArrayList<ProjectSubType> projectSubTypes = new ArrayList<>();
        projectSubTypes.add(ProjectSubType.PUG);
        project.setProjectSubType(projectSubTypes);
        proceed(actionEvent, "3_projectDeveloper.fxml",project);
    }
}
