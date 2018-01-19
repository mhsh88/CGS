package sample.controller.showResults;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ShowResultsController {

    public TableView table;
    @FXML
    TextField textField = new TextField();
    @FXML
    public void initialize() throws IOException {
        TableColumn firstNameCol = new TableColumn("نام");
        TableColumn lastNameCol = new TableColumn("مقدار");

        table.getColumns().addAll(firstNameCol, lastNameCol);


    }

    public void okAction(ActionEvent actionEvent) {
        System.out.println(textField.getText());
    }

}
