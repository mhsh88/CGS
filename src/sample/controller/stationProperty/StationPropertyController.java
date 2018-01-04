package sample.controller.stationProperty;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class StationPropertyController {
    @FXML
    public TextField nitrogenTextField = new TextField();
    @FXML
    ComboBox gasPercentType = new ComboBox();
    @FXML
    TextField textField = new TextField();
    @FXML
    public void initialize() {
        gasPercentType.getItems().removeAll(gasPercentType.getItems());
        gasPercentType.getItems().addAll("درصد مولی", "درصد جرمی");
        gasPercentType.getSelectionModel().select("درصد مولی");

//        nitrogenTextField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
//            if (!newValue) { //when focus lost
//                if(!nitrogenTextField.getText().matches("^(0|[1-9][0-9]*)$")){
//                    //when it not matches the pattern (1.0 - 6.0)
//                    //set the textField empty
//                    System.out.println("inside if");
//                    nitrogenTextField.setText("");
//                    nitrogenTextField.clear();
//                }
//            }
//
//        });
    }




    public void okAction(ActionEvent actionEvent) {
        System.out.println(textField.getText());


    }

}
