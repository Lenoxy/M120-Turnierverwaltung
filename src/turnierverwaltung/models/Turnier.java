package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class Turnier{
    private static Turnier instance;
    private ObservableList<Team> teams = FXCollections.observableArrayList();
    private ObservableList<Spiel> spiele = FXCollections.observableArrayList();
    private int pointsPerVictory = 3;
    private int pointsPerDraw = 1;
    private int pointsPerLoss = 0;

    public ObservableList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ObservableList<Group> groups) {
        this.groups = groups;
    }

    private ObservableList<Group> groups = FXCollections.observableArrayList();

    public Turnier(){
        System.out.println("Turnier erstellt");
        teams.add(new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher"));
        teams.add(new Team("test2", 2, "a", 0, 1, 1,  "22:55", "Bucher"));
        teams.add(new Team("test3", 4, "a", 0, 1, 1,  "22:55", "Bucher"));
        teams.add(new Team("test4", 3, "a", 0, 1, 1,  "22:55", "Bucher"));
        teams.add(new Team("test5", 8, "a", 0, 1, 1,  "22:55", "Bucher"));
        teams.add(new Team("test6", 6, "a", 0, 1, 1,  "22:55", "Bucher"));
        teams.add(new Team("test7", 4, "a", 0, 1, 1,  "22:55", "Bucher"));
    }

    public static void restartTurnier(){
        instance = new Turnier();
    }

    public static Turnier getInstance(){
        if(instance == null) instance = new Turnier();
        return instance;
    }

    public ObservableList<Team> getTeams(){
        Comparator<Team> comparator = Comparator.comparingInt(Team::getPoints);
        comparator = comparator.reversed();
        this.teams.sort(comparator);
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

    public void setSpiel(Spiel spiel){
        this.spiele.add(spiel);
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
