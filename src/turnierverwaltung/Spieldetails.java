package turnierverwaltung;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import turnierverwaltung.models.Spiel;

public class Spieldetails extends Application{
    public static Spiel game;

    @FXML
    private Label teamOne, team2Name;

    @FXML
    private TextField textFieldTeamOne, textFieldTeamTwo;

    private static Stage stage;


    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/spieldetails.fxml"));
        stage.setTitle("Spieldetails");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 300, 175));
        this.stage = stage;
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }


}
