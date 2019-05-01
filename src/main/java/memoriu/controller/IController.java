package memoriu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import memoriu.project.Project;

import java.io.IOException;

public interface IController {

    String invalidField = "-fx-background-color: #D08477;";

    void initData(Project project);
    void closeButtonAction(ActionEvent actionEvent);

    default void proceed(ActionEvent actionEvent, String fxmlScene, Project project) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource(
                    fxmlScene));
            Parent projectParent =loader.load();

            IController IController = loader.getController();
            IController.initData(project);
            Scene projectDeveloperScene = new Scene((projectParent));

            Stage window =
                    (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            window.setScene(projectDeveloperScene);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
