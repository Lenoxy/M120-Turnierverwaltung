package turnierverwaltung.model;

import java.util.List;

public class Team{
    private String name;
    private String trainer;
    private List<Spiel> spiele;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTrainer(){
        return trainer;
    }

    public void setTrainer(String trainer){
        this.trainer = trainer;
    }

    public List<Spiel> getSpiele(){
        return spiele;
    }

    public void setSpiele(List<Spiel> spiele){
        this.spiele = spiele;
    }
}
