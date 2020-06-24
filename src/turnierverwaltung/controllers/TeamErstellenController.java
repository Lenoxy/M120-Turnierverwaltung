package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import turnierverwaltung.models.Team;
import turnierverwaltung.models.Turnier;

import java.util.ArrayList;
import java.util.List;

public class TeamErstellenController{

    @FXML
    public TextField textFieldCoach;
    @FXML
    private TextField textFieldTeamName;

    public List<Team> teams = new ArrayList<>();

    public void onSaveTeam () {
        Team team = new Team();
        System.out.println(textFieldTeamName.getText());
        team.setTeamName(textFieldTeamName.getText());
        Turnier.getInstance().addTeam(team);
    }
}
