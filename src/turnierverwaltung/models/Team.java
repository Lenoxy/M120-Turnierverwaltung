package turnierverwaltung.models;

import java.util.List;

public class Team{
    private String name;
    private String trainer;


    public Team(String name, String trainer){
        this.setName(name);
        this.setTrainer(trainer);
    }

    public Team(){}

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
}
