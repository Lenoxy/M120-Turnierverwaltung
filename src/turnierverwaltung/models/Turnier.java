package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Turnier{
    private static Turnier instance;
    private ObservableList<Team> teams = FXCollections.observableArrayList();
    private ObservableList<Spiel> spiele = FXCollections.observableArrayList();
    private int pointsPerVictory = 3;
    private int pointsPerDraw = 1;
    private int pointsPerLoss = 0;

    public Turnier(){
        System.out.println("Turnier erstellt");
        teams.add(new Team("test", 1, "a", 0, 1, 1, "22:55", "Bucher"));
    }

    public static void restartTurnier(){
        instance = new Turnier();
    }

    private void reshuffleGroups(){
        final char[] groupNames = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K'};
        double teamAmount = this.teams.size();
        double groupAmmount = Math.ceil(teamAmount/5);
        System.out.println("Teams: " + teamAmount);
        System.out.println("Groups: " + groupAmmount);
        double teamsPerGroup = Math.floor(teamAmount/groupAmmount);
        System.out.println("Teams Per Group: " + teamsPerGroup);

        double teamsModulo = teamAmount%groupAmmount;
        System.out.println("Mod: " + teamsModulo);

        double overflowTeams = teamsModulo;
        int teamCounter = 0;
        for(int groupCounter = 0; groupCounter < groupAmmount; groupCounter++){
            while(teamCounter < (groupCounter + 1) * teamsPerGroup){
                setTeamGroup(this.teams.get(teamCounter), String.valueOf(groupNames[groupCounter]));
                System.out.println(this.teams.get(teamCounter).getTeamName() + "  :  " + groupNames[groupCounter]);

                teamCounter++;
            }
        }


    }

    private void setTeamGroup(Team team, String group){
        team.setGroup(group);
    }

    public static Turnier getInstance(){
        if(instance == null) instance = new Turnier();
        return instance;
    }

    public ObservableList<Team> getTeams(){
        return this.teams;
    }

    public ObservableList<Spiel> getSpiele(){
        return this.spiele;
    }

    public void addTeam(Team newTeam){
        this.teams.add(newTeam);
        this.reshuffleGroups();
    }

    public void removeTeam(Team team){
        this.teams.remove(team);
        this.reshuffleGroups();
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
