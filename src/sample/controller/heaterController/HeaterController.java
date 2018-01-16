package sample.controller.heaterController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HeaterController {

    public TextField heaterNumberInput;
    @FXML
    public void okAction(ActionEvent actionEvent) {
        System.out.println(heaterNumberInput.getText());
    }
}
