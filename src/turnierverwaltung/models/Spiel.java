package turnierverwaltung.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.TimeZone;

public class Spiel{
    private Team team1;
    private Team team2;
    private Resultat resultat = new Resultat();
    private LocalDateTime time = LocalDateTime.now();

    public long getTimeAsLong() {
        return this.time.getLong(ChronoField.MINUTE_OF_DAY);
    }

    public Resultat getResultAsObject () {
        return this.resultat;
    }


    public String getTime() {
        return this.time.format(DateTimeFormatter.ofPattern("dd.M.yyyy HH:mm:ss"));
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Spiel(Team team1, Team team2){
        this.setTeam1(team1);
        this.setTeam2(team2);
    }

    public String getTeam1(){
        return team1.getTeamName();
    }

    public Team getTeam1AsObject () {
        return this.team1;
    }

    public Team getTeam2AsObject () {
        return this.team2;
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
