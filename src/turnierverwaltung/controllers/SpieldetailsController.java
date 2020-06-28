package turnierverwaltung.controllers;

import javafx.event.Event;
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

import java.awt.*;
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
        System.out.println(GAME);
        team1Name.setText(GAME.getTeam1());
        team2Name.setText(GAME.getTeam2());

        textFieldTeamOne.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*") || newValue.isEmpty()) {
                textFieldTeamOne.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        textFieldTeamTwo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*") || newValue.isEmpty()) {
                textFieldTeamTwo.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public void saveScore() {
        if(!textFieldTeamOne.getText().equals("") && !textFieldTeamTwo.getText().equals("")){
            int scoreTeamOne = Integer.parseInt(textFieldTeamOne.getText());
            int scoreTeamTwo = Integer.parseInt(textFieldTeamTwo.getText());

            GAME.setResultat(new Resultat(scoreTeamOne, scoreTeamTwo));
            Turnier.getInstance().evaluateGames();
            tableView.refresh();
            STAGE.close();
        }else{
            // Error Sound effect
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
            if(runnable != null){
                runnable.run();
            }
        }

    }
}
