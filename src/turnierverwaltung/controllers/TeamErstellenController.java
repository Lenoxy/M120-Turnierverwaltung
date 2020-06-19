package turnierverwaltung.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import turnierverwaltung.models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamErstellenController{

    @FXML
    private TextField textFieldTeamName, textFieldCoach;

    public List<Team> teams = new ArrayList<>();

    public void onSaveTeam () {
        Team team = new Team();
        team.setName(new SimpleStringProperty(textFieldTeamName.getText()));
        team.setTrainer(new SimpleStringProperty(textFieldCoach.getText()));
        this.teams.add(team);
    }
}
