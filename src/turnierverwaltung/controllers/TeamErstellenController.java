package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import turnierverwaltung.models.Turnier;
import javafx.stage.Stage;
import turnierverwaltung.models.Team;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeamErstellenController implements Initializable {

    @FXML
    public TextField textFieldCoach;
    public Button buttonTeamSave;
    @FXML
    private TextField textFieldTeamName;

    public TeamErstellenController() {

    }

    public  TeamErstellenController(Stage newStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/teamErstellen.fxml"));
        Parent root = fxmlLoader.load();
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    public void onSaveTeam () {
        Team team = new Team();
        team.setTeamName(textFieldTeamName.getText());
        team.setTrainer(textFieldCoach.getText());
        Turnier.getInstance().addTeam(team);
        this.closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) buttonTeamSave.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
