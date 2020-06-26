package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import turnierverwaltung.models.Spiel;

import java.net.URL;
import java.util.ResourceBundle;

public class SpieldetailsController implements Initializable{
    @FXML
    TextField textFieldTeamOne, textFieldTeamTwo;
    @FXML
    Label team1Name, team2Name;

    Spiel game;

    public SpieldetailsController(Spiel game){
        this.game = game;
    }


    public void initialize(URL location, ResourceBundle resources){
        team1Name.setText(game.getTeam1());
        team2Name.setText(game.getTeam2());
    }

    public void saveScore() {
        int scoreTeamOne = Integer.parseInt(textFieldTeamOne.getText());
        int scoreTeamTwo = Integer.parseInt(textFieldTeamTwo.getText());
        // game.setResultat(new Resultat(scoreTeamOne, scoreTeamTwo));
        //  this.stage.close();


    }
}
