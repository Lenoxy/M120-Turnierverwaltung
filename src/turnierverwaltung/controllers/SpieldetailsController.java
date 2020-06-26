package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import turnierverwaltung.models.Resultat;
import turnierverwaltung.models.Spiel;
import turnierverwaltung.models.Team;
import turnierverwaltung.models.Turnier;

import java.net.URL;
import java.util.ResourceBundle;

public class SpieldetailsController implements Initializable{
    @FXML
    TextField textFieldTeamOne, textFieldTeamTwo;
    @FXML
    Label team1Name, team2Name;

    Spiel game;
    public static TableView<Spiel>  tableView;


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

        game.setResultat(new Resultat(scoreTeamOne, scoreTeamTwo));
        evaluateGames();
        tableView.refresh();


        // game.setResultat(new Resultat(scoreTeamOne, scoreTeamTwo));
        //  this.stage.close();


    }

    private void evaluateGames () {
        resetTeamPoints();
        for (Spiel spiel: Turnier.getInstance().getSpiele()) {
            Resultat result = spiel.getResultAsObject();
            int teamOne = spiel.getTeam1AsObject().getPoints();
            int teamTwo = spiel.getTeam2AsObject().getPoints();


            if (result.getTeam1Punkte() > result.getTeam2Punkte()) {
                spiel.getTeam1AsObject().setPoints(teamOne + Turnier.getInstance().getPointsPerVictory());
                spiel.getTeam2AsObject().setPoints(teamTwo + Turnier.getInstance().getPointsPerLoss());
                System.out.println(spiel.getTeam1AsObject().getPoints());
                spiel.getTeam1AsObject().addVictory();
                spiel.getTeam2AsObject().addLoss();
                System.out.println("win");
            } else if (result.getTeam1Punkte() < result.getTeam2Punkte()) {
                spiel.getTeam2AsObject().setPoints(teamTwo + Turnier.getInstance().getPointsPerVictory());
                spiel.getTeam1AsObject().setPoints(teamOne + Turnier.getInstance().getPointsPerLoss());
                spiel.getTeam2AsObject().addVictory();
                spiel.getTeam1AsObject().addLoss();
                System.out.println("loss");
            } else if (result.getTeam1Punkte() == result.getTeam2Punkte()) {
                spiel.getTeam1AsObject().setPoints(teamOne + Turnier.getInstance().getPointsPerDraw());
                spiel.getTeam2AsObject().setPoints(teamTwo + Turnier.getInstance().getPointsPerDraw());
                spiel.getTeam1AsObject().addDraw();
                spiel.getTeam2AsObject().addDraw();
                System.out.println("draw");
            }
        }
    }

    private void resetTeamPoints () {
        for (Team team: Turnier.getInstance().getTeams()) {
            team.resetStats();
        }
    }
}
