package turnierverwaltung.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Resultat{
    private IntegerProperty team1Punkte = new SimpleIntegerProperty();
    private IntegerProperty team2Punkte = new SimpleIntegerProperty();

    public boolean isGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(boolean gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    private boolean gamePlayed = false;

    public Resultat() {}

    public Resultat(int scoreTeamOne, int scoreTeamTwo) {
        this.setTeam1Punkte(scoreTeamOne);
        this.setTeam2Punkte(scoreTeamTwo);
    }

    public int getTeam1Punkte(){
        return team1Punkte.get();
    }

    public void setTeam1Punkte(int team1Punkte){
        this.setGamePlayed(true);
        this.team1Punkte.set(team1Punkte);
    }

    public int getTeam2Punkte(){
        return team2Punkte.get();
    }

    public void setTeam2Punkte(int team2Punkte){
        this.setGamePlayed(true);
        this.team2Punkte.set(team2Punkte);
    }
}
