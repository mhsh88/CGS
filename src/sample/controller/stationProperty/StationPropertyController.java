package sample.controller.stationProperty;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StationPropertyController {

    @FXML
    TextField textField = new TextField();
    public void okAction(ActionEvent actionEvent) {
        System.out.println(textField.getText());
    }
}
