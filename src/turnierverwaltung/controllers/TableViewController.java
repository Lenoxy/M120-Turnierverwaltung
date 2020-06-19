package turnierverwaltung.controllers;

import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import turnierverwaltung.models.TableRecord;
import turnierverwaltung.models.Turnier;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable{


    //Tabelle
    @FXML
    TableView<TableRecord> tableViewTabelle;
    @FXML
    TableColumn<TableRecord, String> teamNameColumn, pointsColumn, groupColumn, victoriesColumn, lossesColumn, drawsColumn, goalDifferentialColumn;

    // Spielplan

    // Teams verwalten
    @FXML
    TableView<TableRecord> teamsTableView;
    @FXML
    TableColumn<TableRecord, String> teamTeamNameColumn, teamPointsColumn, teamGroupColumn;

    // Einstellungen
    @FXML
    TextField pointsPerVictory, pointsPerDraw, pointsPerLoss;


    @Override
    public void initialize(URL location, ResourceBundle resources){
        // Tabelle
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("teamName"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("points"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("group"));
        victoriesColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("victories"));
        lossesColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("losses"));
        drawsColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("draws"));
        goalDifferentialColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("goalDifferential"));

        tableViewTabelle.setItems(Turnier.getInstance().getTeams());

        // Teams verwalten
        teamTeamNameColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("teamName"));
        teamPointsColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("points"));
        teamGroupColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("group"));

        teamsTableView.setItems(Turnier.getInstance().getTeams());


        pointsPerVictory.setText(String.valueOf(Turnier.getInstance().getPointsPerVictory()));
        pointsPerDraw.setText(String.valueOf(Turnier.getInstance().getPointsPerDraw()));
        pointsPerLoss.setText(String.valueOf(Turnier.getInstance().getPointsPerLoss()));


        pointsPerVictory.textProperty().addListener((observable, oldValue, newValue) -> {
            if(! newValue.matches("\\d*") || newValue.isEmpty()){
                pointsPerVictory.setText(newValue.replaceAll("[^\\d]", ""));
            }else{
                Turnier.getInstance().setPointsPerVictory(Integer.parseInt(newValue));
                System.out.println("Set pointsPerWin to " + newValue);
            }
        });
        pointsPerDraw.textProperty().addListener((observable, oldValue, newValue) -> {
            if(! newValue.matches("\\d*") || newValue.isEmpty()){
                pointsPerDraw.setText(newValue.replaceAll("[^\\d]", ""));
            }else{
                Turnier.getInstance().setPointsPerDraw(Integer.parseInt(newValue));
                System.out.println("Set pointsPerDraw to " + newValue);
            }
        });
        pointsPerLoss.textProperty().addListener((observable, oldValue, newValue) -> {
            if(! newValue.matches("\\d*") || newValue.isEmpty()){
                pointsPerLoss.setText(newValue.replaceAll("[^\\d]", ""));
            }else{
                Turnier.getInstance().setPointsPerLoss(Integer.parseInt(newValue));
                System.out.println("Set pointsPerLoss to " + newValue);
            }
        });
    }

    public void onTurnierNeustarten(){
        Turnier.restartTurnier();
    }

    public void onRemoveSelectedTeam(Event e){
        TableRecord selected = teamsTableView.getSelectionModel().getSelectedItem();
        if(selected != null){
            Turnier.getInstance().removeTeam(selected);
        }else{
            // Error Sound effect
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
            if (runnable != null) {
                runnable.run();
            }
        }

    }
}
