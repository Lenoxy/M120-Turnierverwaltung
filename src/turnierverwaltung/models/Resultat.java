package turnierverwaltung.models;

public class Resultat{
    private int team1Punkte = 0;
    private int team2Punkte = 0;

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
        return team1Punkte;
    }

    public void setTeam1Punkte(int team1Punkte){
        this.setGamePlayed(true);
        this.team1Punkte = team1Punkte;
    }

    public int getTeam2Punkte(){
        return team2Punkte;
    }

    public void setTeam2Punkte(int team2Punkte){
        this.setGamePlayed(true);
        this.team2Punkte = team2Punkte;
    }
}
