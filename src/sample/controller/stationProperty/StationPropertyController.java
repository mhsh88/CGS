package sample.controller.stationProperty;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.controller.stationController.StationController;
import sample.view.stationProperty.StationPropertyFrame;

import java.io.IOException;

public class StationPropertyController {
    StationController stationController;
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/stationProperty/stationProperty.fxml"));
    @FXML
    public TextField nitrogenTextField = new TextField();
    public ComboBox inputGasTempComboBox = new ComboBox();
    public ComboBox inputGasPressureComboBox= new ComboBox();
    public ComboBox outputGasTempComboBox= new ComboBox();
    public ComboBox outputGasPressureComboBox= new ComboBox();
    public ComboBox environmentTempComboBox= new ComboBox();
    @FXML
    ComboBox gasPercentType = new ComboBox();
    @FXML
    TextField textField = new TextField();

    public StationPropertyController() throws IOException {
    }

    @FXML
    public void initialize() {
        gasPercentType.getItems().removeAll(gasPercentType.getItems());
        gasPercentType.getItems().addAll("درصد مولی", "درصد جرمی");
        gasPercentType.getSelectionModel().select("درصد مولی");
        inputGasTempComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        inputGasTempComboBox.getItems().addAll("°C", "°F");
        inputGasTempComboBox.getSelectionModel().select("°C");
        inputGasPressureComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        inputGasPressureComboBox.getItems().addAll("kPa", "Psi");
        inputGasPressureComboBox.getSelectionModel().select("kPa");
        outputGasTempComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        outputGasTempComboBox.getItems().addAll("°C", "°F");
        outputGasTempComboBox.getSelectionModel().select("°C");
        outputGasPressureComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        outputGasPressureComboBox.getItems().addAll("kPa", "Psi");
        outputGasPressureComboBox.getSelectionModel().select("kPa");
        environmentTempComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        environmentTempComboBox.getItems().addAll("°C", "°F");
        environmentTempComboBox.getSelectionModel().select("°C");




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


    public void okButton(ActionEvent actionEvent) {

    }

    public void clearButton(ActionEvent actionEvent) {
    }

    public void cancelButton(ActionEvent actionEvent) throws IOException {
        stationController = fxmlLoader.<StationController>getController();
        StationPropertyFrame stationPropertyFrame = stationController.getStationPropertyFrame();
        stationPropertyFrame.close();
    }
}