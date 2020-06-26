package turnierverwaltung.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import turnierverwaltung.models.Spiel;
import turnierverwaltung.models.Team;
import turnierverwaltung.models.Turnier;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {


    //Tabelle
    @FXML
    TableView<Team> tableViewTabelle;
    @FXML
    TableColumn<Team, String> teamNameColumn, pointsColumn, groupColumn, victoriesColumn, lossesColumn, drawsColumn, goalDifferentialColumn;

    // Spielplan
    @FXML
    TableView<Spiel> spielplanTableView;

    @FXML
    TableColumn<Spiel, String> team1, team2, result, time;

    // Teams verwalten
    @FXML
    TableView<Team> teamsTableView;

    @FXML
    TableColumn<Team, String> teamTeamNameColumn, teamPointsColumn, teamGroupColumn;

    // Einstellungen
    @FXML
    TextField pointsPerVictory, pointsPerDraw, pointsPerLoss;

    List<TextField> pointsSettings = new ArrayList<>();

    private void setupTableTabelle() {
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("teamName"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("points"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("group"));
        victoriesColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("victories"));
        lossesColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("losses"));
        drawsColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("draws"));
        goalDifferentialColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("goalDifferential"));
        tableViewTabelle.setItems(Turnier.getInstance().getTeams());
    }

<<<<<<< HEAD
    private void setupTableSpielplan() {
=======
        System.out.println(team1);
        System.out.println(teamNameColumn);


        // Spielplan
>>>>>>> 3731697271c6ffacc0477218b476157edaa51e3b
        team1.setCellValueFactory(new PropertyValueFactory<Spiel, String>("team1"));
        team2.setCellValueFactory(new PropertyValueFactory<Spiel, String>("team2"));
        result.setCellValueFactory(new PropertyValueFactory<Spiel, String>("resultat"));
        time.setCellValueFactory(new PropertyValueFactory<Spiel, String>("time"));
        spielplanTableView.setItems(Turnier.getInstance().getSpiele());
    }

    private void setupTableTeamVerwalten() {
        teamTeamNameColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("teamName"));
        teamPointsColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("points"));
        teamGroupColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("group"));
        teamsTableView.setItems(Turnier.getInstance().getTeams());
    }

    private void setupSettingsTab() {
        pointsPerVictory.setText(String.valueOf(Turnier.getInstance().getPointsPerVictory()));
        pointsPerDraw.setText(String.valueOf(Turnier.getInstance().getPointsPerDraw()));
        pointsPerLoss.setText(String.valueOf(Turnier.getInstance().getPointsPerLoss()));
    }

    private void settingsTabConstraints() {
        pointsPerVictory.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*") || newValue.isEmpty()) {
                pointsPerVictory.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                Turnier.getInstance().setPointsPerVictory(Integer.parseInt(newValue));
                System.out.println("Set pointsPerWin to " + newValue);
            }
        });

        pointsPerDraw.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*") || newValue.isEmpty()) {
                pointsPerDraw.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                Turnier.getInstance().setPointsPerDraw(Integer.parseInt(newValue));
                System.out.println("Set pointsPerDraw to " + newValue);
            }
        });
        pointsPerLoss.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*") || newValue.isEmpty()) {
                pointsPerLoss.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                Turnier.getInstance().setPointsPerLoss(Integer.parseInt(newValue));
                System.out.println("Set pointsPerLoss to " + newValue);
            }
        });
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTableTabelle();
        setupTableSpielplan();
        setupTableTeamVerwalten();
        setupSettingsTab();
        pointsSettings.add(pointsPerDraw);
        pointsSettings.add(pointsPerLoss);
        pointsSettings.add(pointsPerVictory);
        settingsTabConstraints();
    }

    public void onTurnierNeustarten() {
        Turnier.restartTurnier();
    }

    public void onRemoveSelectedTeam(Event e) {
        Team selected = teamsTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Turnier.getInstance().removeTeam(selected);
        } else {
            // Error Sound effect
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
            if(runnable != null){
                runnable.run();
            }
        }

    }

    public void onCreateTeam(Event e) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../views/teamErstellen.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Team Erstellen");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 300, 175));
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    public void editGame() throws Exception{
        Spiel game = spielplanTableView.getSelectionModel().getSelectedItem();

        SpieldetailsController controller = new SpieldetailsController(game);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/spieldetails.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Spieldetails");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 300, 175));
        stage.show();
        spielplanTableView.refresh();
    }

}
