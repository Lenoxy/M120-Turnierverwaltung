package turnierverwaltung.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import turnierverwaltung.models.TableRecord;

import java.util.ArrayList;
import java.util.List;

public class TeamErstellenController{

    @FXML
    private TextField textFieldTeamName, textFieldCoach;

    public List<TableRecord> teams = new ArrayList<>();

    public void onSaveTeam () {
        TableRecord team = new TableRecord();
        team.setTeamName(textFieldTeamName.getText());
        //team.setTrainer(new SimpleStringProperty(textFieldCoach.getText()));
        this.teams.add(team);
    }
}
