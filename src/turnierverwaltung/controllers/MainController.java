package turnierverwaltung.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import turnierverwaltung.models.Turnier;

public class MainController{



    public Button teamHinzufuegen;

    public TableView<turnierverwaltung.models.Team> tabelleTableView;

    public Turnier turnier = new Turnier();

    @FXML
    public void initialize() {
        tabelleTableView.setItems(turnier.getTeams());
    }

    public void onTeamHinzufuegen(ActionEvent e){

        System.out.println("test");
    }
}
