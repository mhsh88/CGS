package sample.controller.beforeHeater;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class BeforeHeaterController {
    public Button okButton;
    public Button clearButton;
    public Button cancelButton;
    public TextField insulationFactorTextField = new TextField();
    public ComboBox insulationThicknessComboBox;
    public TextField insulationThicknessTextField;
    public RadioButton insulationRadioButton;
    public ComboBox mmOrInchComboBox;
    public ComboBox nominalDiameterComboBox;
    public ComboBox outerDiameterComboBox;
    public ComboBox wallThicknessComboBox;
    public TextField lineLengthTextField;
    public ComboBox lineLengthComboBox;
    public Label insulationFactorLabel;
    public Label insulationFactorDimensionLabel;
    public Label insulationThicknessLabel;

    public final static Map<String, PipeSize> sizeSelection = new HashMap<String, PipeSize>() {
        {
            put("½", new PipeSize(2.8, 21.3));
            put("¾", new PipeSize(2.9, 27.6));
            put("1", new PipeSize(2.9, 33.4));

            put("1 ½", new PipeSize(3.7, 48.3));
            put("2", new PipeSize(3.9, 60.3));

            put("3", new PipeSize(5.5, 88.9));

            put("4", new PipeSize(6.0, 114.3));
        }
    };

    @FXML
    TextField textField = new TextField();


    @FXML
    public void initialize() throws IOException {
        insulationThicknessComboBox.getItems().removeAll(wallThicknessComboBox.getItems());
        insulationThicknessComboBox.getItems().addAll("متر (m)", "اینچ (inch)");
        insulationThicknessComboBox.getSelectionModel().select("متر (m)");


        mmOrInchComboBox.getItems().removeAll(wallThicknessComboBox.getItems());
        mmOrInchComboBox.getItems().addAll("1/8", "¼", "3/8", "½", "¾", "1", "1 ¼", "1 ½", "2", "2 ½", "3", "3 ½", "4", "5", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40"
                , "42", "44", "46", "48");
        mmOrInchComboBox.getSelectionModel().select("1/8");

        //        {"1/8","¼","3/8","½","¾","1","1 ¼","1 ½","2","2 ½","3","3 ½","4","5","6","8","10","12","14","16","18","20","22","24","26","28","30","32","34","36","38","40"
//                ,"42","44","46","48"}


//        insulationFactorTextField.editableProperty().bind(insulationRadioButton.selectedProperty());


        insulationRadioButton.setOnAction(actionEvent -> {
            if (insulationRadioButton.isSelected()) {
                insulationThicknessLabel.setDisable(false);
                insulationThicknessTextField.setDisable(false);
                insulationThicknessComboBox.setDisable(false);
                insulationThicknessTextField.setDisable(false);
                insulationFactorLabel.setDisable(false);
                insulationFactorTextField.setDisable(false);
                insulationFactorDimensionLabel.setDisable(false);

            } else if (!insulationRadioButton.isSelected()) {
                insulationThicknessLabel.setDisable(true);
                insulationThicknessTextField.setDisable(true);
                insulationThicknessComboBox.setDisable(true);
                insulationThicknessTextField.setDisable(true);
                insulationThicknessTextField.clear();
                insulationFactorLabel.setDisable(true);
                insulationFactorTextField.setDisable(true);
                insulationFactorDimensionLabel.setDisable(true);
                insulationFactorTextField.clear();
            }
        });

    }

    public void okAction(ActionEvent actionEvent) {
        double insulationThickness;
        double insulationFactor;
        if(!lineLengthTextField.getText().equals("")) {
            double pipelineLength = Double.parseDouble(lineLengthTextField.getText());
        }
        else{
            showAlert("خطا","لطفا اطلاعات درست وارد کنید", "طول خط لوله به درستی وارد نشده است");

            return;
        }
        PipeSize pipesize = sizeSelection.get(mmOrInchComboBox.getValue().toString());
        System.out.println(pipesize);
        double outerDiameter = pipesize.getOuterDiameter();
        double wallthickness = pipesize.getWallThickness();
        if (insulationRadioButton.isSelected()) {
            if(!insulationThicknessTextField.getAlignment().equals("")) {
                insulationThickness = Double.parseDouble(insulationThicknessTextField.getText());
            }
            else{
                return;
            }

            if(!insulationFactorTextField.getText().equals("")) {
                insulationFactor = Double.parseDouble(insulationFactorTextField.getText());
            }
            else{

                return;
            }
        }

    }


    public void clearButton(ActionEvent actionEvent) {
        lineLengthTextField.clear();
        insulationThicknessTextField.clear();
        insulationFactorTextField.clear();
    }

    public void cancelButton(ActionEvent actionEvent) {

        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void showAlert(String title, String info, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(info);
        alert.setContentText(message);
        alert.showAndWait();
    }


    static class PipeSize {
        double wallThickness;
        double outerDiameter;

        @Override
        public String toString() {
            return "PipeSize{" +
                    "wallThickness=" + wallThickness +
                    ", outerDiameter=" + outerDiameter +
                    ", innerDiameter=" + getInnerDiameter() +
                    '}';
        }

        public PipeSize(double wallThickness, double outerDiameter) {
            this.wallThickness = wallThickness;
            this.outerDiameter = outerDiameter;
        }

        public double getWallThickness() {
            return wallThickness;
        }

        public double getOuterDiameter() {
            return outerDiameter;
        }
        public double getInnerDiameter(){

            return outerDiameter - 2 * wallThickness;
        }
    }
}
