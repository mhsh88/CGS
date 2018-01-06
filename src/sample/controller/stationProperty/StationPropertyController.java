package sample.controller.stationProperty;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StationPropertyController {
    public ComboBox inputGasTempComboBox = new ComboBox();
    public ComboBox inputGasPressureComboBox= new ComboBox();
    public ComboBox outputGasTempComboBox= new ComboBox();
    public ComboBox outputGasPressureComboBox= new ComboBox();
    public ComboBox environmentTempComboBox= new ComboBox();
    public TextField carbonDioxideTextField = new TextField();
    public TextField methanTextField = new TextField();
    public TextField ethaneTextField = new TextField();
    public TextField propaneTextField = new TextField();
    public TextField nButaneTextField = new TextField();
    public TextField isoButaneTextField = new TextField();
    public TextField nPentaneTextField = new TextField();
    public TextField isoPentaneTextField = new TextField();
    public TextField hexaneTextField = new TextField();
    public TextField heptaneTextField = new TextField();
    public TextField octaneTextField = new TextField();
    public TextField nonaneTextField = new TextField();
    public TextField decaneTextField = new TextField();
    public TextField hydrogenTextField = new TextField();
    public TextField oxygenTextField = new TextField();
    public TextField carbonMonoxideTextField = new TextField();
    public TextField waterTextField = new TextField();
    public TextField hydrogenSulfideTextField = new TextField();
    public TextField heliumTextField = new TextField();
    public TextField argonTextField = new TextField();
    public TextField provinceTextField = new TextField();
    public TextField cityTextField = new TextField();
    public TextField areaTextField = new TextField();
    public TextField nominalCapacityTextField = new TextField();
    public TextArea addressTextArea = new TextArea();
    public TextField inputGasTempTextField = new TextField();
    public TextField inputGasPressureTextField = new TextField();
    public TextField outputGasTempTextField = new TextField();
    public TextField outputGasPressureTextField = new TextField();
    public TextField environmentTempTextField = new TextField();
    public TextField windSpeedTextField = new TextField();
    public TextField stationDebiTextField = new TextField();
    public Button clearButton = new Button();
    public Button okButton  = new Button();
    @FXML
    ComboBox gasPercentType = new ComboBox();
    @FXML
    TextField textField = new TextField();
    @FXML
    private Button cancelButton = new Button();
    @FXML
    TextField nitrogenTextField = new TextField();
    
    

    public StationPropertyController() {
    }

    @FXML
    public void initialize() throws IOException {
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

        nitrogenTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                try {
                    Integer.parseInt(newValue);
                    if (newValue.endsWith("f") || newValue.endsWith("d")) {
                        carbonDioxideTextField.setText(newValue.substring(0, newValue.length()-1));
                    }
                }
                catch (Exception e) {
                    nitrogenTextField.setText(oldValue);
                }
            }
        });





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
        nitrogenTextField.getText();
        carbonDioxideTextField.getText();
        methanTextField.getText();
        ethaneTextField.getText();
        propaneTextField.getText();
        nButaneTextField.getText();
        isoButaneTextField.getText();
        nPentaneTextField.getText();
        isoPentaneTextField.getText();
        hexaneTextField.getText();
        heptaneTextField.getText();
        octaneTextField.getText();
        nonaneTextField.getText();
        decaneTextField.getText();
        hydrogenTextField.getText();
        oxygenTextField.getText();
        carbonMonoxideTextField.getText();
        waterTextField.getText();
        hydrogenSulfideTextField.getText();
        heliumTextField.getText();
        argonTextField.getText();
        provinceTextField.getText();
        cityTextField.getText();
        areaTextField.getText();
        nominalCapacityTextField.getText();
        addressTextArea.getText();
        inputGasTempTextField.getText();
        inputGasPressureTextField.getText();
        outputGasTempTextField.getText();
        outputGasPressureTextField.getText();
        environmentTempTextField.getText();
        windSpeedTextField.getText();
        stationDebiTextField.getText();


    }

    public void clearButton(ActionEvent actionEvent) {

        nitrogenTextField.clear();
        carbonDioxideTextField.clear();
        methanTextField.clear();
        ethaneTextField.clear();
        propaneTextField.clear();
        nButaneTextField.clear();
        isoButaneTextField.clear();
        nPentaneTextField.clear();
        isoPentaneTextField.clear();
        hexaneTextField.clear();
        heptaneTextField.clear();
        octaneTextField.clear();
        nonaneTextField.clear();
        decaneTextField.clear();
        hydrogenTextField.clear();
        oxygenTextField.clear();
        carbonMonoxideTextField.clear();
        waterTextField.clear();
        hydrogenSulfideTextField.clear();
        heliumTextField.clear();
        argonTextField.clear();
        provinceTextField.clear();
        cityTextField.clear();
        areaTextField.clear();
        nominalCapacityTextField.clear();
        addressTextArea.clear();
        inputGasTempTextField.clear();
        inputGasPressureTextField.clear();
        outputGasTempTextField.clear();
        outputGasPressureTextField.clear();
        environmentTempTextField.clear();
        windSpeedTextField.clear();
        stationDebiTextField.clear();






    }
    @FXML
    private void cancelButton(ActionEvent actionEvent)  {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
//        Platform.exit();
        // get a handle to the stage
//        System.exit(0);
//        Stage stage = (Stage) cancelButton.getScene().getWindow();
////        // do what you have to do
//        stage.close();

    }

}