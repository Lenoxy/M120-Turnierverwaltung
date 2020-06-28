package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import turnierverwaltung.models.Resultat;
import turnierverwaltung.models.Spiel;
import turnierverwaltung.models.Team;
import turnierverwaltung.models.Turnier;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class SpieldetailsController implements Initializable{
    @FXML
    TextField textFieldTeamOne, textFieldTeamTwo;
    @FXML
    Label team1Name, team2Name;

    static Spiel GAME;
    static Stage STAGE;
    public static TableView<Spiel>  tableView;

    public SpieldetailsController() {

    }


    public SpieldetailsController(Spiel game){
        GAME = game;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/spieldetails.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Spieldetails");
            newStage.setScene(new Scene(root));
            newStage.show();
            STAGE = newStage;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public void initialize(URL location, ResourceBundle resources){
        System.out.println("test: " + team1Name.getText());
        System.out.println(GAME);
    }

    public void saveScore() {
        int scoreTeamOne = Integer.parseInt(textFieldTeamOne.getText());
        int scoreTeamTwo = Integer.parseInt(textFieldTeamTwo.getText());

        GAME.setResultat(new Resultat(scoreTeamOne, scoreTeamTwo));
        evaluateGames();
        tableView.refresh();
        STAGE.close();


        // game.setResultat(new Resultat(scoreTeamOne, scoreTeamTwo));
        //  this.stage.close();


    }

    private void evaluateGames () {
        resetTeamPoints();
        for (Spiel spiel: Turnier.getInstance().getSpiele()) {
            Resultat result = spiel.getResultAsObject();
            int teamOne = spiel.getTeam1AsObject().getPoints();
            int teamTwo = spiel.getTeam2AsObject().getPoints();
            if (spiel.getResultAsObject().isGamePlayed())  {
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
        Comparator<Team> comparator = Comparator.comparingInt(Team::getPoints);
        comparator = comparator.reversed();
        Turnier.getInstance().getTeams().sort(comparator);
    }

    private void resetTeamPoints () {
        for (Team team: Turnier.getInstance().getTeams()) {
            team.resetStats();
        }
    }
}
