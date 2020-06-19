package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.html.HTMLTableElement;
import turnierverwaltung.models.TableRecord;
import turnierverwaltung.models.Turnier;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewController implements Initializable{

    @FXML
    TableView<TableRecord> tableViewTabelle;

    @FXML
    TextField pointsPerVictory, pointsPerDraw, pointsPerLoss;

    @FXML
    TableColumn<TableRecord, String> teamNameColumn, pointsColumn, groupColumn, victoriesColumn, lossesColumn, drawsColumn, goalDifferentialColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("teamName"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("points"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("group"));
        victoriesColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("victories"));
        lossesColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("losses"));
        drawsColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("draws"));
        goalDifferentialColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("goalDifferential"));

        tableViewTabelle.setItems(Turnier.getInstance().getTeams());

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
}
