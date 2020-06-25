package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import turnierverwaltung.models.Turnier;
import javafx.stage.Stage;
import turnierverwaltung.models.Team;

import java.util.ArrayList;

import java.util.List;

public class TeamErstellenController{

    @FXML
    public TextField textFieldCoach;
    public Button buttonTeamSave;
    @FXML
    private TextField textFieldTeamName;



    public void onSaveTeam () {
        Team team = new Team();
        team.setTeamName(textFieldTeamName.getText());
        team.setTrainer(textFieldCoach.getText());
        Turnier.getInstance().addTeam(team);
        this.closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) buttonTeamSave.getScene().getWindow();
        stage.close();
    }
}
