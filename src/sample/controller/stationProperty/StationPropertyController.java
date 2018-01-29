package sample.controller.stationProperty;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.base.BaseController;
import sample.model.Station;
import sample.model.base.BaseModel;
import sample.model.stationProperties.StationPropertice;

import java.io.IOException;
import java.util.Map;

public class StationPropertyController extends BaseController {
    public GridPane mainGridPane = new GridPane();
    Stage stage;
    private StationPropertice stationPropertice = new StationPropertice();


    public ComboBox inputGasTempComboBox = new ComboBox();
    public ComboBox inputGasPressureComboBox= new ComboBox();
    public ComboBox outputGasTempComboBox= new ComboBox();
    public ComboBox outputGasPressureComboBox= new ComboBox();
    public ComboBox environmentTempComboBox= new ComboBox();


    // TODO it must check for inputs of double and numbers



    public JFXTextField carbonDioxideTextField = new JFXTextField();
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
    private Double[] component = new Double[21];
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
        inputGasPressureComboBox.getItems().addAll("kPa", "MPa","Psi");
        inputGasPressureComboBox.getSelectionModel().select("kPa");
        outputGasTempComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        outputGasTempComboBox.getItems().addAll("°C", "°F");
        outputGasTempComboBox.getSelectionModel().select("°C");
        outputGasPressureComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        outputGasPressureComboBox.getItems().addAll("kPa","MPa", "Psi");
        outputGasPressureComboBox.getSelectionModel().select("kPa");
        environmentTempComboBox.getItems().removeAll(inputGasTempComboBox.getItems());
        environmentTempComboBox.getItems().addAll("°C", "°F");
        environmentTempComboBox.getSelectionModel().select("°C");
        methanTextField.setText("100");
        nitrogenTextField.setText("0");
        carbonDioxideTextField.setText("0");
        ethaneTextField.setText("0");
        propaneTextField.setText("0");
        nButaneTextField.setText("0");
        isoButaneTextField.setText("0");
        nPentaneTextField.setText("0");
        isoPentaneTextField.setText("0");
        hexaneTextField.setText("0");
        heptaneTextField.setText("0");
        octaneTextField.setText("0");
        nonaneTextField.setText("0");
        decaneTextField.setText("0");
        hydrogenTextField.setText("0");
        oxygenTextField.setText("0");
        carbonMonoxideTextField.setText("0");
        waterTextField.setText("0");
        hydrogenSulfideTextField.setText("0");
        heliumTextField.setText("0");
        argonTextField.setText("0");
        inputGasTempTextField.setText("15");
        inputGasPressureTextField.setText("8000");
        outputGasPressureTextField.setText("3000");
        outputGasTempTextField.setText("8");
        environmentTempTextField.setText("30");
        windSpeedTextField.setText("10");
        stationDebiTextField.setText("40000");

        RequiredFieldValidator validator = new RequiredFieldValidator();
        carbonDioxideTextField.getValidators().add(validator);
        validator.setMessage("no input");

        carbonDioxideTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                    carbonDioxideTextField.validate();
                }
            }
        });


//        nitrogenTextField.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable,
//                                String oldValue, String newValue) {
//                try {
//                    Integer.parseInt(newValue);
//                    if (newValue.endsWith("f") || newValue.endsWith("d")) {
//                        carbonDioxideTextField.setText(newValue.substring(0, newValue.length()-1));
//                    }
//                }
//                catch (Exception e) {
//                    nitrogenTextField.setText(oldValue);
//                }
//            }
//        });





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

//          stage = (Stage) mainGridPane.getScene().getWindow();


//        setOnStart();
    }
    @Override
    public void setOnShow() {
        StationPropertice stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");
        if(stationPropertice != null){
            Double[] component = stationPropertice.getComponent();
            methanTextField.setText(String.valueOf(component[0]));
            nitrogenTextField.setText(String.valueOf(component[1]));
            carbonDioxideTextField.setText(String.valueOf(component[2]));
            ethaneTextField.setText(String.valueOf(component[3]));
            propaneTextField.setText(String.valueOf(component[4]));
            nButaneTextField.setText(String.valueOf(component[5]));
            isoButaneTextField.setText(String.valueOf(component[6]));
            nPentaneTextField.setText(String.valueOf(component[7]));
            isoPentaneTextField.setText(String.valueOf(component[8]));
            hexaneTextField.setText(String.valueOf(component[9]));
            heptaneTextField.setText(String.valueOf(component[10]));
            octaneTextField.setText(String.valueOf(component[11]));
            nonaneTextField.setText(String.valueOf(component[12]));
            decaneTextField.setText(String.valueOf(component[13]));
            hydrogenTextField.setText(String.valueOf(component[14]));
            oxygenTextField.setText(String.valueOf(component[15]));
            carbonMonoxideTextField.setText(String.valueOf(component[16]));
            waterTextField.setText(String.valueOf(component[17]));
            hydrogenSulfideTextField.setText(String.valueOf(component[18]));
            heliumTextField.setText(String.valueOf(component[19]));
            argonTextField.setText(String.valueOf(component[20]));
            inputGasTempTextField.setText(String.valueOf(stationPropertice.getInputTemp() - 273.15));
            inputGasPressureTextField.setText(String.valueOf(Math.round(stationPropertice.getInputPressure() - 101.235)));
            outputGasPressureTextField.setText(String.valueOf(Math.round(stationPropertice.getOutputPressure() - 101.235)));
            outputGasTempTextField.setText(String.valueOf(stationPropertice.getOutputTemp() - 273.15));
            environmentTempTextField.setText(String.valueOf(stationPropertice.getEnvironmentTemp() - 273.15));
            windSpeedTextField.setText(String.valueOf(stationPropertice.getWindVelocity()));
            stationDebiTextField.setText(String.valueOf(stationPropertice.getDebi()));
            provinceTextField.setText(stationPropertice.getProvince());
            cityTextField.setText(stationPropertice.getCity());
            areaTextField.setText(stationPropertice.getArea());
            nominalCapacityTextField.setText(stationPropertice.getNominalCapacity());
            addressTextArea.setText(stationPropertice.getAddress());


        }
        else{
            return;
        }
    }


    public void okButton(ActionEvent actionEvent) {
        // TODO it must check whether text is ok or not
        component[0] = Double.parseDouble(nitrogenTextField.getText());
        component[1] = Double.parseDouble(carbonDioxideTextField.getText());
        component[2] = Double.parseDouble(methanTextField.getText());
        component[3] = Double.parseDouble(ethaneTextField.getText());
        component[4] = Double.parseDouble(propaneTextField.getText());
        component[5] = Double.parseDouble(nButaneTextField.getText());
        component[6] = Double.parseDouble(isoButaneTextField.getText());
        component[7] = Double.parseDouble(nPentaneTextField.getText());
        component[8] = Double.parseDouble(isoPentaneTextField.getText());
        component[9] = Double.parseDouble(hexaneTextField.getText());
        component[10] = Double.parseDouble(heptaneTextField.getText());
        component[11] = Double.parseDouble(octaneTextField.getText());
        component[12] = Double.parseDouble(nonaneTextField.getText());
        component[13] = Double.parseDouble(decaneTextField.getText());
        component[14] = Double.parseDouble(hydrogenTextField.getText());
        component[15] = Double.parseDouble(oxygenTextField.getText());
        component[16] = Double.parseDouble(carbonMonoxideTextField.getText());
        component[17] = Double.parseDouble(waterTextField.getText());
        component[18] = Double.parseDouble(hydrogenSulfideTextField.getText());
        component[19] = Double.parseDouble(heliumTextField.getText());
        component[20] = Double.parseDouble(argonTextField.getText());
        component = MathCalculation.normal(component);

        Double[] M_i = {28.0135
                , 44.01
                , 16.043
                , 30.07
                , 44.097
                , 58.123
                , 58.123
                , 72.15
                , 72.15
                , 86.177
                , 100.204
                , 114.231
                , 128.258
                , 142.285
                , 2.0159
                , 31.9988
                , 28.01
                , 18.0153
                , 34.082
                , 4.0026
                , 39.948};
        if(gasPercentType.getValue().toString().equals("درصد جرمی")){


            component =   MathCalculation.normal(MathCalculation.matrixDevide(MathCalculation.pointToPointDivistion(component, M_i), MathCalculation.dotProduct(component, M_i)));
        }

        stationPropertice.setComponent(component);


        stationPropertice.setProvince(provinceTextField.getText());
        stationPropertice.setCity(cityTextField.getText());
        stationPropertice.setArea(areaTextField.getText());
        stationPropertice.setNominalCapacity(nominalCapacityTextField.getText());
        stationPropertice.setAddress(addressTextArea.getText());

        stationPropertice.setInputTemp(Double.parseDouble(inputGasTempTextField.getText()));
        stationPropertice.setInputPressure(Double.parseDouble(inputGasPressureTextField.getText()));
        stationPropertice.setOutputPressure(Double.parseDouble(outputGasPressureTextField.getText()));
        stationPropertice.setOutputTemp(Double.parseDouble(outputGasTempTextField.getText()));
        stationPropertice.setEnvironmentTemp(Double.parseDouble(environmentTempTextField.getText()));
        stationPropertice.setWindVelocity(Double.parseDouble(windSpeedTextField.getText()));
        stationPropertice.setDebi(Double.parseDouble(stationDebiTextField.getText()));


        Station station = Station.getInstance();
        Map<String, BaseModel> tempMap = station.getList();
        tempMap.put("stationPropertice",stationPropertice);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


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