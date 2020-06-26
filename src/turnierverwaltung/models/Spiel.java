package turnierverwaltung.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Spiel{
    private Team team1;
    private Team team2;
    private Resultat resultat = new Resultat(0,0);
    private Date time = new Date();

    public long getTimeAsLong() {
        return this.time.getTime();
    }


    public String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        return format.format(this.time);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Spiel(Team team1, Team team2){
        this.setTeam1(team1);
        this.setTeam2(team2);
    }

    public String getTeam1(){
        return team1.getTeamName();
    }

    public void setTeam1(Team team1){
        this.team1 = team1;
    }

    public String getTeam2(){
        return team2.getTeamName();
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

    public String getResultat(){
        return this.resultat.getTeam1Punkte() + ":" + this.resultat.getTeam2Punkte();
    }

    public void setResultat(Resultat resultat){
        this.resultat = resultat;
    }
}
