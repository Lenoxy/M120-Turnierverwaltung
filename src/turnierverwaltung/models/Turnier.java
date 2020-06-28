package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import turnierverwaltung.controllers.MainController;

import java.util.Comparator;

public class Turnier{
    private static Turnier instance;
    private ObservableList<Team> teams = FXCollections.observableArrayList();
    private ObservableList<Spiel> spiele = FXCollections.observableArrayList();
    private ObservableList<Group> groups = FXCollections.observableArrayList();
    private int pointsPerVictory = 3;
    private int pointsPerDraw = 1;
    private int pointsPerLoss = 0;

    public ObservableList<Group> getGroups(){
        return groups;
    }

    public Turnier(){
    }

    public static Turnier getInstance(){
        if(instance == null) instance = new Turnier();
        return instance;
    }

    public ObservableList<Team> getTeams(){
        return this.teams;
    }

    public ObservableList<Spiel> getSpiele(){
        Comparator<Spiel> comparator = Comparator.comparingLong(Spiel::getTimeAsLong);
        this.spiele.sort(comparator);
        return this.spiele;
    }

    public void addTeam(Team newTeam){
        this.teams.add(newTeam);
        MainController.instance.reshuffleGroups();
    }

    public void removeTeam(Team team){
        this.teams.remove(team);
        MainController.instance.reshuffleGroups();
    }

    public int getPointsPerVictory(){
        return pointsPerVictory;
    }

    public void setPointsPerVictory(int pointsPerVictory){
        this.pointsPerVictory = pointsPerVictory;
    }

    public int getPointsPerDraw(){
        return pointsPerDraw;
    }

    public void setPointsPerDraw(int pointsPerDraw){
        this.pointsPerDraw = pointsPerDraw;
    }

    public int getPointsPerLoss(){
        return pointsPerLoss;
    }

    public void setPointsPerLoss(int pointsPerLoss){
        this.pointsPerLoss = pointsPerLoss;
    }
}
