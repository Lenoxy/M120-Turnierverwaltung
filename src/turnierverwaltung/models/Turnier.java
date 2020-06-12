package turnierverwaltung.models;

import java.util.ArrayList;
import java.util.List;

public class Turnier{
    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Spiel> spiele = new ArrayList<Spiel>();

    public List<Team> getTeams(){
        return teams;
    }

    public void addTeam(Team newTeam){
        this.teams.add(newTeam);
    }

    public void removeTeam(Team team){
        this.teams.remove(team);
    }

    public void removeSpiel(Spiel spiel){
        this.spiele.remove(spiel);
    }

    public void setSpiel (Spiel spiel){
        this.spiele.add(spiel);
    }
}
