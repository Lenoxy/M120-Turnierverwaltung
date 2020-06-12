package turnierverwaltung.models;

public class Spiel{
    private Team team1;
    private Team team2;
    private Resultat resultat;

    public Team getTeam1(){
        return team1;
    }

    public void setTeam1(Team team1){
        this.team1 = team1;
    }

    public Team getTeam2(){
        return team2;
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

    public Resultat getResultat(){
        return resultat;
    }

    public void setResultat(Resultat resultat){
        this.resultat = resultat;
    }
}
