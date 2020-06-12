package turnierverwaltung.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Team{
    private SimpleStringProperty name;
    private SimpleStringProperty trainer;
    private SimpleIntegerProperty punkte;
    private SimpleStringProperty gruppe;
    private SimpleIntegerProperty sieg;
    private SimpleIntegerProperty unentschieden;
    private SimpleIntegerProperty niederlage;
    private SimpleStringProperty torverhaeltnis;


    public Team(String name, String trainer, int punkte, String gruppe, int sieg, int unentschieden, int niederlage, String torverhaeltnis){
        this.setName(new SimpleStringProperty(name));
        this.setTrainer(new SimpleStringProperty(trainer));
        this.setPunkte(new SimpleIntegerProperty(punkte));
        this.setGruppe(new SimpleStringProperty(gruppe));
        this.setSieg(new SimpleIntegerProperty(sieg));
        this.setUnentschieden(new SimpleIntegerProperty(unentschieden));
        this.setNiederlage(new SimpleIntegerProperty(niederlage));
        this.setTorverhaeltnis(new SimpleStringProperty(torverhaeltnis));

    }

    public Team(){}

    public SimpleStringProperty getName(){
        return name;
    }

    public void setName(SimpleStringProperty name){
        this.name = name;
    }

    public SimpleStringProperty getTrainer(){
        return trainer;
    }

    public void setTrainer(SimpleStringProperty trainer){
        this.trainer = trainer;
    }

    public SimpleIntegerProperty getPunkte(){
        return punkte;
    }

    public void setPunkte(SimpleIntegerProperty punkte){
        this.punkte = punkte;
    }

    public SimpleStringProperty getGruppe(){
        return gruppe;
    }

    public void setGruppe(SimpleStringProperty gruppe){
        this.gruppe = gruppe;
    }

    public SimpleIntegerProperty getSieg(){
        return sieg;
    }

    public void setSieg(SimpleIntegerProperty sieg){
        this.sieg = sieg;
    }

    public SimpleIntegerProperty getUnentschieden(){
        return unentschieden;
    }

    public void setUnentschieden(SimpleIntegerProperty unentschieden){
        this.unentschieden = unentschieden;
    }

    public SimpleIntegerProperty getNiederlage(){
        return niederlage;
    }

    public void setNiederlage(SimpleIntegerProperty niederlage){
        this.niederlage = niederlage;
    }

    public SimpleStringProperty getTorverhaeltnis(){
        return torverhaeltnis;
    }

    public void setTorverhaeltnis(SimpleStringProperty torverhaeltnis){
        this.torverhaeltnis = torverhaeltnis;
    }
}
