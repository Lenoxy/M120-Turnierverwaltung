package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Turnier{
    private ObservableList<Team> teams = FXCollections.observableArrayList();
    private ObservableList<Spiel> spiele = FXCollections.observableArrayList();

    public Turnier(){
        // Testdata
        teams.add(new Team("test", "test", 0, "A", 1, 1, 1, "22:55"));
    }

    public ObservableList<Team> getTeams(){
        return this.teams;
    }

    public ObservableList<Spiel> getSpiele(){
        return this.spiele;
    }

    public void addTeam(Team newTeam){
        this.teams.add(newTeam);
    }

    public void removeTeam(Team team){
        this.teams.remove(team);
    }

    public void removeSpiel(Spiel spiel){
        this.spiele.remove(spiel);
    }

    public void setSpiel (Spiel spiel){
        this.spiele.add(spiel);
    }
}
