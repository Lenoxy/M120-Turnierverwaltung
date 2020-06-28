package turnierverwaltung.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import turnierverwaltung.controllers.TableViewController;

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

    public void setGroups(ObservableList<Group> groups){
        this.groups = groups;
    }


    public Turnier(){
        System.out.println("Turnier erstellt");
        Team teamOne = new Team("test1", 0, "a", 0, 0, 0, "Bucher");
        Team teamTwo = new Team("test2", 0, "a", 0, 0, 0, "Bucher");
        Team teamThree = new Team("test3", 0, "a", 0, 0, 0, "Bucher");
        Team teamFour = new Team("test4", 0, "a", 0, 0, 0, "Bucher");
        Team teamFive = new Team("test5", 0, "a", 0, 0, 0, "Bucher");
        Team teamSix = new Team("test6", 0, "a", 0, 0, 0, "Bucher");
        Team teamSeven = new Team("test7", 0, "a", 0, 0, 0, "Bucher");
        Team teamEight = new Team("test8", 0, "a", 0, 0, 0, "Bucher");
        teams.add(teamOne);
        teams.add(teamTwo);
        teams.add(teamThree);
        teams.add(teamFour);
        teams.add(teamFive);
        teams.add(teamSix);
        teams.add(teamSeven);
        teams.add(teamEight);

        spiele.add(new Spiel(teamOne, teamTwo));
        spiele.add(new Spiel(teamThree, teamFour));
        spiele.add(new Spiel(teamFive, teamSix));
        spiele.add(new Spiel(teamSeven, teamEight));

        System.out.println("Turnier erstellt");
    }

    public static void restartTurnier(){
        instance = new Turnier();
    }

    private void reshuffleGroups(){
        this.groups = FXCollections.observableArrayList();
        this.spiele = FXCollections.observableArrayList();


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
            Group group = new Group(groupNames[groupCounter-1]);

            while(teamCounter < (groupCounter * teamsPerGroup) + overflowTeams){
                setTeamGroup(this.teams.get(teamCounter), group);
                teamCounter++;
            }
            if(groupCounter==0){
                overflowTeams=0;
            }
            this.groups.add(group);
        }
        this.generateGames();
    }

    private void setTeamGroup(Team team, Group group){
        team.setGroup(String.valueOf(group.getName()));
        group.addTeam(team);
        System.out.println(team.getTeamName() + "  :  " + group.getName());
    }

    private void generateGames(){
        this.spiele = FXCollections.observableArrayList();
        for(Group group : this.groups){
            for(int teamCounter = 0; teamCounter < group.getGroupSize()-1; teamCounter++){
                for(int innerCounter = teamCounter+1; innerCounter < group.getGroupSize() ; innerCounter++){
                    this.spiele.add(new Spiel(group.getTeamAt(teamCounter), group.getTeamAt(innerCounter)));
                }
            }
        }
        TableViewController.instance.tableViewTabelle.refresh();
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
