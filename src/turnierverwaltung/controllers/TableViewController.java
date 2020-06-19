package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.html.HTMLTableElement;
import turnierverwaltung.models.TableRecord;
import turnierverwaltung.models.Turnier;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    TableView<TableRecord> tableViewTabelle;

    @FXML
    TableColumn<TableRecord, String> teamNameColumn, pointsColumn, groupColumn, victoriesColumn, lossesColumn, drawsColumn, goalDifferentialColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("teamName"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("points"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("group"));
        victoriesColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("victories"));
        lossesColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("losses"));
        drawsColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("draws"));
        goalDifferentialColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("goalDifferential"));

        tableViewTabelle.setItems(Turnier.getInstance().getTeams());
    }
}
