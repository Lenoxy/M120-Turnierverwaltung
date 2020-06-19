package turnierverwaltung.models;

public class Spiel{
    private TableRecord team1;
    private TableRecord team2;
    private Resultat resultat;

    public Spiel(TableRecord team1, TableRecord team2){
        this.setTeam1(team1);
        this.setTeam2(team2);
    }

    public TableRecord getTeam1(){
        return team1;
    }

    public void setTeam1(TableRecord team1){
        this.team1 = team1;
    }

    public TableRecord getTeam2(){
        return team2;
    }

    public void setTeam2(TableRecord team2){
        this.team2 = team2;
    }

    public Resultat getResultat(){
        return resultat;
    }

    public void setResultat(Resultat resultat){
        this.resultat = resultat;
    }
}
