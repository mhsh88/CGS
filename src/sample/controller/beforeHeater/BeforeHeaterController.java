package sample.controller.beforeHeater;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class BeforeHeaterController {
    public Button okButton;
    public Button clearButton;
    public Button cancelButton;
    public TextField insulationFactorTextField;
    public ComboBox insulationThicknessComboBox;
    public TextField insulationThicknessTextField;
    public RadioButton insulationRadioButton;
    public ComboBox mmOrInchComboBox;
    public ComboBox nominalDiameterComboBox;
    public ComboBox outerDiameterComboBox;
    public ComboBox wallThicknessComboBox;
    public TextField lineLengthTextField;
    public ComboBox lineLengthComboBox;
    @FXML
    TextField textField = new TextField();
    public void okAction(ActionEvent actionEvent) {
        System.out.println(textField.getText());
    }

    public void clearButton(ActionEvent actionEvent) {
    }

    public void cancelButton(ActionEvent actionEvent) {
    }
}
