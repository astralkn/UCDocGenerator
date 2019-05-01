package memoriu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import memoriu.project.Project;

public abstract class Controller implements IController{
    protected Project project;


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void initialize(){}

    public void load(){

    }

    @Override
    public void initData(Project project) {
        this.project = project;
        load();
    }
}
