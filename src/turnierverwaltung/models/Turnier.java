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

    public void evaluateGames () {
        resetTeamPoints();
        for (Spiel spiel: Turnier.getInstance().getSpiele()) {
            Resultat result = spiel.getResultAsObject();
            int teamOne = spiel.getTeam1AsObject().getPoints();
            int teamTwo = spiel.getTeam2AsObject().getPoints();
            if (spiel.getResultAsObject().isGamePlayed())  {
                if (result.getTeam1Punkte() > result.getTeam2Punkte()) {
                    spiel.getTeam1AsObject().setPoints(teamOne + Turnier.getInstance().getPointsPerVictory());
                    spiel.getTeam2AsObject().setPoints(teamTwo + Turnier.getInstance().getPointsPerLoss());
                    System.out.println(spiel.getTeam1AsObject().getPoints());
                    spiel.getTeam1AsObject().addVictory();
                    spiel.getTeam2AsObject().addLoss();
                    System.out.println("win");
                } else if (result.getTeam1Punkte() < result.getTeam2Punkte()) {
                    spiel.getTeam2AsObject().setPoints(teamTwo + Turnier.getInstance().getPointsPerVictory());
                    spiel.getTeam1AsObject().setPoints(teamOne + Turnier.getInstance().getPointsPerLoss());
                    spiel.getTeam2AsObject().addVictory();
                    spiel.getTeam1AsObject().addLoss();
                    System.out.println("loss");
                } else if (result.getTeam1Punkte() == result.getTeam2Punkte()) {
                    spiel.getTeam1AsObject().setPoints(teamOne + Turnier.getInstance().getPointsPerDraw());
                    spiel.getTeam2AsObject().setPoints(teamTwo + Turnier.getInstance().getPointsPerDraw());
                    spiel.getTeam1AsObject().addDraw();
                    spiel.getTeam2AsObject().addDraw();
                    System.out.println("draw");
                }
            }
        }
        Comparator<Team> comparator = Comparator.comparingInt(Team::getPoints);
        comparator = comparator.reversed();
        Turnier.getInstance().getTeams().sort(comparator);
    }

    private void resetTeamPoints () {
        for (Team team: this.getTeams()) {
            team.resetStats();
        }
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
