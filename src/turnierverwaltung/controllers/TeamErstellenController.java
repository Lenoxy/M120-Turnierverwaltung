package turnierverwaltung.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import turnierverwaltung.models.Group;
import turnierverwaltung.models.TableRecord;
import turnierverwaltung.models.Turnier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TeamErstellenController{

    @FXML
    private TextField textFieldTeamName;

    public List<TableRecord> teams = new ArrayList<>();
    private static int counter;

    public void onSaveTeam () {
        TableRecord team = new TableRecord();
        team.setTeamName(textFieldTeamName.getText());
        this.teams.add(team);
        this.addTeamToGroup(team);
    }

    private void addTeamToGroup(TableRecord team) {
        Turnier tournament = Turnier.getInstance();
        ObservableList<Group> groups = tournament.getGroups();

        //TODO: remove this section of code
        ////////TEST
        tournament.getGroups().add(new Group("A"));
        tournament.getGroups().add(new Group("B"));
        tournament.getGroups().add(new Group("C"));
        tournament.getGroups().add(new Group("D"));
        /////

        for (:
             ) {
            
        }
        
        
    }
}
