package turnierverwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import turnierverwaltung.models.Turnier;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
        primaryStage.setTitle("Turnierverwaltung");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(475);
        primaryStage.setScene(new Scene(root, 800, 475));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
