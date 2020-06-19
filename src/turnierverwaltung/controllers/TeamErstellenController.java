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
    private TextField textFieldTeamName;

    public List<TableRecord> teams = new ArrayList<>();

    public void onSaveTeam () {
        TableRecord team = new TableRecord();
        System.out.println(textFieldTeamName.getText());
        team.setTeamName(textFieldTeamName.getText());
        this.teams.add(team);
    }
}
