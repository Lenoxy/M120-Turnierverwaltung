package turnierverwaltung.controllers;


import javafx.collections.ObservableList;
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
import turnierverwaltung.models.Group;
import turnierverwaltung.models.Spiel;
import turnierverwaltung.models.Team;
import turnierverwaltung.models.Turnier;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class MainController implements Initializable {

     public static MainController instance;

     public MainController(){
         instance = this;
     }

    //Tabelle
    @FXML
    public TableView<Team> tableViewTabelle;
    @FXML
    TableColumn<Team, String> teamNameColumn, pointsColumn, groupColumn, victoriesColumn, lossesColumn, drawsColumn;

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
        tableViewTabelle.setItems(Turnier.getInstance().getTeams());
        tableViewTabelle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void setupTableSpielplan() {
        team1.setCellValueFactory(new PropertyValueFactory<Spiel, String>("team1"));
        team2.setCellValueFactory(new PropertyValueFactory<Spiel, String>("team2"));
        result.setCellValueFactory(new PropertyValueFactory<Spiel, String>("resultat"));
        time.setCellValueFactory(new PropertyValueFactory<Spiel, String>("time"));
        spielplanTableView.setItems(Turnier.getInstance().getSpiele());
        spielplanTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void setupTableTeamVerwalten() {
        teamTeamNameColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("teamName"));
        teamPointsColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("points"));
        teamGroupColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("group"));
        teamsTableView.setItems(Turnier.getInstance().getTeams());
        teamsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warnung");
        alert.setHeaderText("Möchten Sie das Turnier wirklich neustarten?");
        alert.setContentText("Alle erstellten Teams, Gruppen und gespielte Mätche werden unwiederruflich gelöscht.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Turnier.getInstance().getTeams().clear();
            Turnier.getInstance().getGroups().clear();
            Turnier.getInstance().getSpiele().clear();
        }

    }

    public void onRemoveSelectedTeam(Event e) {
        Team selected = teamsTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Turnier.getInstance().removeTeam(selected);
            spielplanTableView.refresh();
        } else {
            // Error Sound effect
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
            if(runnable != null){
                runnable.run();
            }
        }

    }

    public void onCreateTeam(Event e) throws IOException {
        TeamErstellenController controller = new TeamErstellenController(new Stage());
    }

    @FXML
    public void editGame(){
        Spiel game = spielplanTableView.getSelectionModel().getSelectedItem();
        if (game != null) {
            new SpieldetailsController(game);
            SpieldetailsController.tableView = spielplanTableView;
        } else {
            // Error Sound effect
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
            if(runnable != null){
                runnable.run();
            }
        }

    }

    public void reshuffleGroups(){


        Turnier.getInstance().getGroups().clear();
        Turnier.getInstance().getSpiele().clear();

        final char[] groupNames = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K'};
        double teamAmount = Turnier.getInstance().getTeams().size();
        double groupAmmount = Math.ceil(teamAmount / 5);
        System.out.println("Teams: " + teamAmount);
        System.out.println("Groups: " + groupAmmount);
        double teamsPerGroup = Math.floor(teamAmount / groupAmmount);
        System.out.println("Teams Per Group: " + teamsPerGroup);
        double teamsModulo = teamAmount % groupAmmount;
        System.out.println("Mod: " + teamsModulo);

        double overflowTeams = teamsModulo;
        int teamCounter = 0;
        for(int groupCounter = 1; groupCounter <= groupAmmount; groupCounter++){
            Group group = new Group(groupNames[groupCounter-1]);

            while(teamCounter < (groupCounter * teamsPerGroup) + overflowTeams){
                setTeamGroup(Turnier.getInstance().getTeams().get(teamCounter), group);
                teamCounter++;
            }
            if(groupCounter==0){
                overflowTeams=0;
            }
            Turnier.getInstance().getGroups().add(group);
        }
        this.generateGames();
    }

    private void setTeamGroup(Team team, Group group){
        team.setGroup(String.valueOf(group.getName()));
        group.addTeam(team);
        System.out.println(team.getTeamName() + "  :  " + group.getName());
    }

    private void generateGames(){
        for(Group group : Turnier.getInstance().getGroups()){
            for(int teamCounter = 0; teamCounter < group.getGroupSize()-1; teamCounter++){
                for(int innerCounter = teamCounter+1; innerCounter < group.getGroupSize() ; innerCounter++){
                    Turnier.getInstance().getSpiele().add(new Spiel(group.getTeamAt(teamCounter), group.getTeamAt(innerCounter)));
                    Collections.shuffle(Turnier.getInstance().getSpiele());
                    arrangeTime(Turnier.getInstance().getSpiele());
                }
            }
        }
        MainController.instance.tableViewTabelle.refresh();
    }

    private void arrangeTime(ObservableList<Spiel> spiele) {
       Calendar calendar = Calendar.getInstance();
       int i = 1;
        for (Spiel spiel: spiele) {
            i++;
            long time = calendar.getTimeInMillis();
            Date finalDate = new Date(time + (15 * 60000 * i));
            spiel.setTime(finalDate);
        }
    }


}
