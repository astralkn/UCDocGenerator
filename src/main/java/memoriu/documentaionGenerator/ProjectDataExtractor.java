package memoriu.documentaionGenerator;

import memoriu.building.Building;
import memoriu.person.Person;
import memoriu.project.Project;
import memoriu.project.ProjectSubType;
import memoriu.project.utilities.Utilities;
import memoriu.property.Property;
import memoriu.utr.UTR;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

public class ProjectDataExtractor {

    private Project project;

    public ProjectDataExtractor(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public String getBeneficiari() {
        StringBuilder sb = new StringBuilder();
        for (Person p : project.getInvestors()
        ) {
            sb.append(p.getName());
            sb.append(", ");
        }
        return sb.toString();
    }

    public String getProjectType() {
        StringBuilder projectSubtype = new StringBuilder();
        for (ProjectSubType p : project.getProjectSubType()) {
            projectSubtype.append(p.getName() + ", ");
        }
        try {
            projectSubtype.setLength(projectSubtype.length() - 2);
            return projectSubtype.toString();
        } catch (Exception e){
            return "";
        }
    }

    public String getProjectAddress() {
        StringBuilder projectAddress = new StringBuilder();
        for (Property p : project.getProperties()) {
            projectAddress.append(p.getAddress().toString() + "- ");
        }
        try {
            projectAddress.setLength(projectAddress.length() - 2);
            return projectAddress.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public Integer getProjectArea() {
        Integer totalArea = 0;
        for (Property p : project.getProperties()) {
            totalArea += Integer.parseInt(p.getSurface());
        }

        return totalArea;
    }

    public String getCadastralNumbers() {
        StringBuilder projectCadastralNumbers = new StringBuilder();
        for (Property p : project.getProperties()) {
            projectCadastralNumbers.append(p.getCadastralNumber() + ", ");
        }
        try {
            projectCadastralNumbers.setLength(projectCadastralNumbers.length() - 2);
            return projectCadastralNumbers.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean projectHasExistingBuildings() {
        for (Property p : project.getProperties()
        ) {
            if (p.getBuildings().size() > 0) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentUtilities() {
        HashSet<Utilities> utilities = new HashSet<>();
        for (Property p : project.getProperties()
        ) {
            for (Utilities u : p.getUtilities()
            ) {
                utilities.add(u);
            }
        }
        StringBuilder projectUtilities = new StringBuilder();
        for (Utilities u : utilities
        ) {
            projectUtilities.append(u.getName() + ", ");
        }
        try {
            projectUtilities.setLength(projectUtilities.length() - 2);
            return projectUtilities.toString();
        } catch (Exception e) {
            return "";
        }

    }

    public boolean projectHasUtilities(){
        for (Property p : project.getProperties()
        ) {
            if (p.getUtilities().size()>0){
                return true;
            }
        }
        return false;
    }


    public String getTitle() {
        return project.getTitle();
    }


    public String getGeneralAddress() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Property> properties = project.getProperties();
        for (int i = 0; i< properties.size(); i++){
            if (i==0){
                sb.append(properties.get(i).getAddress().toString());
            } else {
                sb.append("-"+ properties.get(i).getAddress().getStreetNumber());
            }
        }
        return sb.toString();
    }

    public ArrayList<Property> getProperties() {
        return project.getProperties();
    }

    public String getMainStreet() {
        return project.getProperties().get(0).getAddress().getStreet();
    }

    public String getDocCreator() {
        return project.getDocCreator();
    }

    public String getChiefDeveloper() {
        return project.getChiefDeveloper();
    }

    public Person getProjectDeveloper() {
        return project.getProjectDeveloper();
    }

    public String getPrjDeveloper() {
        return project.getPrjDeveloper();
    }

    public int getTotalProperies(){
        int noOfProperties =0;
        for (Property p: project.getProperties()
             ) {
            noOfProperties++;
        }
        return noOfProperties;
    }

    public ArrayList<Person> getInvestors() {
        return project.getInvestors();
    }

    public int getTotalBuildings(){
        int noOfBuildings =0;
        for (Property p: project.getProperties()
        ) {
            for (Building b: p.getBuildings()
                 ) {
                noOfBuildings++;
            }
        }
        return noOfBuildings;
    }
}
