package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import memoriu.documentaionGenerator.DocumetationGenerator;
import memoriu.documentaionGenerator.TableOfContentGenerator;
import memoriu.project.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_9 extends Controller {

    DocumetationGenerator documetationGenerator;
    TableOfContentGenerator tableOfContentGenerator;

    @Override
    public void initialize() {

    }

    public void load(){
        documetationGenerator = new DocumetationGenerator(this.project);
        tableOfContentGenerator = new TableOfContentGenerator(this.project);
        documetationGenerator.genereazaMemoriu();
        tableOfContentGenerator.generateTableOfContent();
    }


    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
