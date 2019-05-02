package memoriu.project;

import memoriu.person.LegalPerson;
import memoriu.person.Person;
import memoriu.property.Property;
import memoriu.utr.UTR;

import java.util.ArrayList;
import java.util.Arrays;

public class Project {
    private String title;
    private String chiefDeveloper;
    private String prjDeveloper;
    private String docCreator;
    private ProjectType projectType;
    private ArrayList<ProjectSubType> projectSubType;
    private LegalPerson projectDeveloper;
    private ArrayList<Person> investors;
    private ArrayList<Property> properties;

    public Project() {
        investors = new ArrayList<Person>();
        properties = new ArrayList<Property>();
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public ArrayList<ProjectSubType> getProjectSubType() {
        return projectSubType;
    }

    public void setProjectSubType(ArrayList<ProjectSubType> projectSubType) {
        this.projectSubType = projectSubType;
    }

    public LegalPerson getProjectDeveloper() {
        return projectDeveloper;
    }

    public void setProjectDeveloper(LegalPerson projectDeveloper) {
        this.projectDeveloper = projectDeveloper;
    }

    public ArrayList<Person> getInvestors() {
        return investors;
    }

    public void setInvestors(ArrayList<Person> investors) {
        this.investors = investors;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }


    public void addInvestor(Person investor) {
        investors.add(investor);
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectType=" + projectType +
                ", projectDeveloper=" + projectDeveloper +
                ", investors=" + investors +
                ", properties=" + properties +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChiefDeveloper() {
        return chiefDeveloper;
    }

    public void setChiefDeveloper(String chiefDeveloper) {
        this.chiefDeveloper = chiefDeveloper;
    }

    public String getPrjDeveloper() {
        return prjDeveloper;
    }

    public void setPrjDeveloper(String prjDeveloper) {
        this.prjDeveloper = prjDeveloper;
    }

    public String getDocCreator() {
        return docCreator;
    }

    public void setDocCreator(String docCreator) {
        this.docCreator = docCreator;
    }
}
