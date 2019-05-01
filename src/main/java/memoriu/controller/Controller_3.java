package memoriu.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import memoriu.address.Address;
import memoriu.person.LegalPerson;
import memoriu.project.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_3 extends Controller {


    @Override
    public void initialize() {

    }


    public JFXButton closeButton;
    public void closeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setUPC_3(ActionEvent actionEvent) {
        Address address = new Address("Ilfov", "Bragadiru", "", "Solidaritatii",
                "17-19");
        project.setProjectDeveloper(
                new LegalPerson("S.C. Urban Plan Concept S.R.L.", "35253014",
                        "J23/4152/2015", address)
        );
        proceed(actionEvent, "4_investor.fxml",project);
    }

    public void setADC_3(ActionEvent actionEvent) {
        Address address = new Address("", "Bucuresti", "Sector 3",
                "Calea Dudesti", "188", "C", "", "7", "60", "");
        project.setProjectDeveloper(
                new LegalPerson("S.C. Arion Development Capital S.R.L.",
                        "24860231",
                        "J40/1584/2012", address)
        );
        proceed(actionEvent, "4_investor.fxml",project);
    }

    public void setACD_3(ActionEvent actionEvent) {
        Address address = new Address("", "Bucuresti", "Sector 3",
                "Calea Dudesti", "188", "C", "", "7", "60", "");
        project.setProjectDeveloper(
                new LegalPerson("S.C. Arua Create Design S.R.L.",
                        "26055409",
                        "J40/9735/2009", address)
        );
        proceed(actionEvent, "4_investor.fxml",project);
    }
}
