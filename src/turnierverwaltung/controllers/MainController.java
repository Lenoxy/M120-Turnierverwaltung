package turnierverwaltung.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
<<<<<<< HEAD
import turnierverwaltung.models.Turnier;
=======

>>>>>>> 5058af493adbe3838d19e1b21c8d7eab8d0c1473

public class MainController{



    public Button teamHinzufuegen;

<<<<<<< HEAD
    public TableView<turnierverwaltung.models.Team> tabelleTableView;

    public Turnier turnier = new Turnier();

    @FXML
    public void initialize() {
        tabelleTableView.setItems(turnier.getTeams());
=======
    public MainController () {

>>>>>>> 5058af493adbe3838d19e1b21c8d7eab8d0c1473
    }

    public void onTeamHinzufuegen(ActionEvent e){

        System.out.println("test");



    }
}
