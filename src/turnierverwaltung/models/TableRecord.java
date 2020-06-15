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

    public String getVictories() {
        return victories.get();
    }

    public SimpleStringProperty victoriesProperty() {
        return victories;
    }

    public void setVictories(String victories) {
        this.victories.set(victories);
    }

    public String getLosses() {
        return losses.get();
    }

    public SimpleStringProperty lossesProperty() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses.set(losses);
    }

    public String getDraws() {
        return draws.get();
    }

    public SimpleStringProperty drawsProperty() {
        return draws;
    }

    public void setDraws(String draws) {
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

    private final SimpleStringProperty teamName = new SimpleStringProperty();
    private final SimpleIntegerProperty points = new SimpleIntegerProperty();
    private final SimpleStringProperty groups = new SimpleStringProperty();
    private final SimpleStringProperty victories = new SimpleStringProperty();
    private final SimpleStringProperty losses = new SimpleStringProperty();
    private final SimpleStringProperty draws = new SimpleStringProperty();
    private final SimpleStringProperty goalDifferential = new SimpleStringProperty();

    public TableRecord (String teamName, int points, String groups, String victories, String losses, String draws, String goalDifferential) {
        this.setTeamName(teamName);
        this.setPoints(points);
        this.setGroups(groups);
        this.setVictories(victories);
        this.setLosses(losses);
        this.setDraws(draws);
        this.setGoalDifferential(goalDifferential);
    }


}
