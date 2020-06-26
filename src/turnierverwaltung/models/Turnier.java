package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Comparator;

public class Turnier{
    private static Turnier instance;
    private ObservableList<Team> teams = FXCollections.observableArrayList();
    private ObservableList<Spiel> spiele = FXCollections.observableArrayList();
    private int pointsPerVictory = 3;
    private int pointsPerDraw = 1;
    private int pointsPerLoss = 0;

    public ObservableList<Group> getGroups(){
        return groups;
    }

    public void setGroups(ObservableList<Group> groups){
        this.groups = groups;
    }

    private ObservableList<Group> groups = FXCollections.observableArrayList();

    public Turnier(){
        System.out.println("Turnier erstellt");
        Team teamOne = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        Team teamTwo = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        Team teamThree = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        Team teamFour = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        Team teamFive = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        Team teamSix = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        Team teamSeven = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        Team teamEight = new Team("test1", 1, "a", 0, 1, 1,  "22:55", "Bucher");
        teams.add(teamOne);
        teams.add(teamTwo);
        teams.add(teamThree);
        teams.add(teamFive);
        teams.add(teamSix);
        teams.add(teamSeven);
        teams.add(teamEight);

        spiele.add(new Spiel(teamOne, teamTwo));
        spiele.add(new Spiel(teamThree, teamFour));
        spiele.add(new Spiel(teamFive, teamSix));
        spiele.add(new Spiel(teamSeven, teamEight));
    }

    public static void restartTurnier(){
        instance = new Turnier();
    }

    private void reshuffleGroups(){
        final char[] groupNames = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K'};
        double teamAmount = this.teams.size();
        double groupAmmount = Math.ceil(teamAmount / 5);
        System.out.println("Teams: " + teamAmount);
        System.out.println("Groups: " + groupAmmount);
        double teamsPerGroup = Math.floor(teamAmount / groupAmmount);
        System.out.println("Teams Per Group: " + teamsPerGroup);

        double teamsModulo = teamAmount % groupAmmount;
        System.out.println("Mod: " + teamsModulo);

        double overflowTeams = teamsModulo;
        int teamCounter = 0;
        for(int groupCounter = 1; groupCounter <= groupAmmount; groupCounter++){

            while(teamCounter < (groupCounter * teamsPerGroup) + overflowTeams){
                setTeamGroup(this.teams.get(teamCounter), String.valueOf(groupNames[groupCounter-1]));
                teamCounter++;
            }
            if(groupCounter==0){
                overflowTeams=0;
            }
        }
    }

    private void setTeamGroup(Team team, String group){
        team.setGroup(group);
        System.out.println(team.getTeamName() + "  :  " + group);

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
        Comparator<Spiel> comparator = Comparator.comparingLong(Spiel::getTimeAsLong);
        this.spiele.sort(comparator);
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
