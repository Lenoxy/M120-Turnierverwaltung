package turnierverwaltung.models;

import javafx.collections.ObservableList;

import java.util.Map;

public class Group {

    public Group(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public ObservableList<Team> getTeams() {
        return teams;
    }

    public void setTeams(Team teams) {
        this.teams.add(teams);
    }

    public int getGroupSize () {
        return getTeams().size();
    }
    private ObservableList<Team> teams;

}
