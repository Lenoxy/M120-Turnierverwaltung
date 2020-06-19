package turnierverwaltung.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableRecord {

    public TableRecord(){}

    public String getTeamName() {
        return teamName.get();
    }

    public SimpleStringProperty teamNameProperty() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName.set(teamName);
    }

    public int getPoints() {
        return points.get();
    }

    public SimpleIntegerProperty pointsProperty() {
        return points;
    }

    public void setPoints(int points) {
        this.points.set(points);
    }

    public String getGroups() {
        return groups.get();
    }

    public SimpleStringProperty groupsProperty() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups.set(groups);
    }

    public int getVictories() {
        return victories.get();
    }

    public int victoriesProperty() {
        return victories.get();
    }

    public void setVictories(int victories) {
        this.victories.set(victories);
    }

    public int getLosses() {
        return losses.get();
    }

    public int lossesProperty() {
        return losses.get();
    }

    public void setLosses(int losses) {
        this.losses.set(losses);
    }

    public int getDraws() {
        return draws.get();
    }

    public int drawsProperty() {
        return draws.get();
    }

    public void setDraws(int draws) {
        this.draws.set(draws);
    }

    public String getGoalDifferential() {
        return goalDifferential.get();
    }

    public SimpleStringProperty goalDifferentialProperty() {
        return goalDifferential;
    }

    public void setGoalDifferential(String goalDifferential) {
        this.goalDifferential.set(goalDifferential);
    }

    private SimpleStringProperty teamName = new SimpleStringProperty();
    private SimpleIntegerProperty points = new SimpleIntegerProperty();
    private SimpleStringProperty groups = new SimpleStringProperty();
    private SimpleIntegerProperty victories = new SimpleIntegerProperty();
    private SimpleIntegerProperty losses = new SimpleIntegerProperty();
    private SimpleIntegerProperty draws = new SimpleIntegerProperty();
    private SimpleStringProperty goalDifferential = new SimpleStringProperty();

    public TableRecord (String teamName, int points, String groups, int victories, int losses, int draws, String goalDifferential) {
        this.setTeamName(teamName);
        this.setPoints(points);
        this.setGroups(groups);
        this.setVictories(victories);
        this.setLosses(losses);
        this.setDraws(draws);
        this.setGoalDifferential(goalDifferential);
    }


}
