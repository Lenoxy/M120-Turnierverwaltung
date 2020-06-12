package turnierverwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Spieldetails extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/spieldetails.fxml"));
        stage.setTitle("Spieldetails");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 300, 175));
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
