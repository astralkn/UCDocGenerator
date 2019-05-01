package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import memoriu.project.Project;
import memoriu.project.ProjectSubType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_2Arc extends Controller {

    public JFXCheckBox cbDTAC_2;
    public JFXCheckBox cbDTAD_2;


    @Override
    public void initialize() {

    }

    public JFXButton closeButton;
    @Override
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void continue_2(ActionEvent actionEvent) {
        ArrayList<ProjectSubType> projectSubTypes = new ArrayList<>();
        if (cbDTAD_2.isSelected() || cbDTAC_2.isSelected()) {
            if (cbDTAD_2.isSelected() || cbDTAC_2.isSelected()) {
                projectSubTypes.add(ProjectSubType.DTAC);
                projectSubTypes.add(ProjectSubType.DTAD);
                project.setProjectSubType(projectSubTypes);
            } else if (cbDTAD_2.isSelected()) {
                projectSubTypes.add(ProjectSubType.DTAD);
                project.setProjectSubType(projectSubTypes);
            } else if (cbDTAC_2.isSelected()){
                projectSubTypes.add(ProjectSubType.DTAC);
                project.setProjectSubType(projectSubTypes);
            }
            proceed(actionEvent, "3_projectDeveloper.fxml",project);
        } else {
            cbDTAC_2.setStyle(invalidField);
            cbDTAD_2.setStyle(invalidField);
        }


    }
}
