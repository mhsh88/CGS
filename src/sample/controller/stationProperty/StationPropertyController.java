package sample.controller.stationProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class StationPropertyController {

    public TextField nitrogenTextField = new TextField();
    @FXML
    ComboBox gasPercentType = new ComboBox(FXCollections.observableArrayList(
            "Option 1",
            "Option 2",
            "Option 3"
    ));
    @FXML
    TextField textField = new TextField();
    @FXML
    public void initialize() {
        gasPercentType.getItems().removeAll(gasPercentType.getItems());
        gasPercentType.getItems().addAll("درصد مولی", "درصد جرمی");
        gasPercentType.getSelectionModel().select("درصد مولی");

        nitrogenTextField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!nitrogenTextField.getText().matches("[1-5]\\.[0-9]|6\\.0")){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    nitrogenTextField.setText("");
                    nitrogenTextField.clear();
                }
            }

        });
    }




    public void okAction(ActionEvent actionEvent) {
        System.out.println(textField.getText());


    }

}
