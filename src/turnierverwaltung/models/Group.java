package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;

public class Group {

    private char name;
    private ObservableList<Team> teams = FXCollections.observableArrayList();

    public Group(char name) {
        this.setName(name);
    }


    public int getGroupSize () {
        return getTeams().size();
    }


    public Team getTeamAt(int i){
        return teams.get(i);
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ObservableList<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team teams) {
        this.teams.add(teams);
    }



}
