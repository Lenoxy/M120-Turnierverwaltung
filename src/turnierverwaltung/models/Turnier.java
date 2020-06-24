package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Turnier{
    private static Turnier instance;
    private ObservableList<TableRecord> teams = FXCollections.observableArrayList();
    private ObservableList<Spiel> spiele = FXCollections.observableArrayList();

    public ObservableList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ObservableList<Group> groups) {
        this.groups = groups;
    }

    private ObservableList<Group> groups = FXCollections.observableArrayList();

    public Turnier(){
        // Testdata
        teams.add(new TableRecord("test", 1, "a", 0, 1, 1,  "22:55"));

    }

    public static Turnier getInstance(){
        if(instance == null){
            instance = new Turnier();
        }
        return instance;
    }

    public ObservableList<TableRecord> getTeams(){
        return this.teams;
    }

    public ObservableList<Spiel> getSpiele(){
        return this.spiele;
    }

    public void addTeam(TableRecord newTeam){
        this.teams.add(newTeam);
    }

    public void removeTeam(TableRecord team){
        this.teams.remove(team);
    }

    public void removeSpiel(Spiel spiel){
        this.spiele.remove(spiel);
    }

    public void setSpiel(Spiel spiel){
        this.spiele.add(spiel);
    }
}
