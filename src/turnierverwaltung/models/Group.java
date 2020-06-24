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

    public ObservableList<TableRecord> getTeams() {
        return teams;
    }

    public void setTeams(TableRecord teams) {
        this.teams.add(teams);
    }

    public int getGroupSize () {
        return getTeams().size();
    }
    private ObservableList<TableRecord> teams;

}
