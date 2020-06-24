package turnierverwaltung.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Team{

    private SimpleStringProperty teamName;
    private SimpleIntegerProperty points;
    private SimpleStringProperty group;
    private SimpleIntegerProperty victories;
    private SimpleIntegerProperty losses;
    private SimpleIntegerProperty draws;
    private SimpleStringProperty goalDifferential;

    public Team(){
        this.teamName = new SimpleStringProperty();
        this.points = new SimpleIntegerProperty();
        this.group = new SimpleStringProperty();
        this.victories = new SimpleIntegerProperty();
        this.losses = new SimpleIntegerProperty();
        this.draws = new SimpleIntegerProperty();
        this.goalDifferential = new SimpleStringProperty();
    }

    public Team(String teamName, int points, String group, int victories, int losses, int draws, String goalDifferential) {

        this.teamName = new SimpleStringProperty(teamName);
        this.points = new SimpleIntegerProperty(points);
        this.group = new SimpleStringProperty(group);
        this.victories = new SimpleIntegerProperty(victories);
        this.losses = new SimpleIntegerProperty(losses);
        this.draws = new SimpleIntegerProperty(draws);
        this.goalDifferential = new SimpleStringProperty(goalDifferential);
    }

    public String getTeamName() {
        return teamName.get();
    }

    public SimpleStringProperty teamNameProperty() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        System.out.println(teamName);
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

    public String getGroup() {
        return group.get();
    }

    public SimpleStringProperty groupProperty() {
        return group;
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public int getVictories() {
        return victories.get();
    }

    public SimpleIntegerProperty victoriesProperty() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories.set(victories);
    }

    public int getLosses() {
        return losses.get();
    }

    public SimpleIntegerProperty lossesProperty() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses.set(losses);
    }

    public int getDraws() {
        return draws.get();
    }

    public SimpleIntegerProperty drawsProperty() {
        return draws;
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
}
