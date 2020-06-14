package turnierverwaltung.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import turnierverwaltung.models.TableRecord;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    TableView<TableRecord> tableViewTabelle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableViewTabelle.getItems().setAll(parseRecords());
    }

    private List<TableRecord> parseRecords() {
        List<TableRecord> tableValues = new ArrayList<>();

        // get all values and add to list

        TableRecord record = new TableRecord("1", 1, "1", "1", "1", "1", "1");
        tableValues.add(record);
        return tableValues;
    }
}
