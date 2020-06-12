package turnierverwaltung.model;

import java.util.List;

public class Turnier{
    private List<Team> teams;

    public List<Team> getTeams(){
        return teams;
    }

    public void setTeams(List<Team> teams){
        this.teams = teams;
    }
}
