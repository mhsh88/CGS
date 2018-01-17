package sample.controller.run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class RunController {

    public TextField runNumberInput;
    public TextField runLengthInput;
    public TextField runColectorLengthInput;
    public TabPane runTapPane;
    public ComboBox collectorComboBox;

    @FXML
    public void initialize() throws IOException {
        collectorComboBox.getItems().removeAll();
        collectorComboBox.getItems().addAll( "2","4","6","8","10","12","16","20","24","30");
        collectorComboBox.getSelectionModel().select("8");
    }


    public void okAction(ActionEvent actionEvent) {
    }

    public void runNumInput(KeyEvent keyEvent) {
        runTapPane.getTabs().clear();
        if(runNumberInput.getText().equals("")) return;
        int runNumber = Integer.parseInt(runNumberInput.getText());
        if(runNumber>10){
            runNumberInput.setText("10");
            runNumber = 20;

        }
        else if(runNumber<0){
            runNumberInput.setText("0");
            runNumber = 0;
        }
        for (int i = 1; i <= runNumber; i++) {

            Tab tab = new Tab();




            HBox childHBox = new HBox();

            tab.setText("ران  " + i);
            GridPane runContainer = new GridPane();
            runContainer.add(new Label("دبی گاز عبوری "), 1, 0);
            runContainer.add(new TextField(), 0, 0);
            runContainer.add(new Label("سایز "), 1, 1);
            ComboBox comboBox = new ComboBox();
            comboBox.getItems().removeAll();
            comboBox.getItems().addAll( "2","4","6","8","10","12","16","20","24","30");
            comboBox.getSelectionModel().select("8");
            runContainer.add(comboBox, 0, 1);

            childHBox.getChildren().add(runContainer);
            childHBox.setAlignment(Pos.CENTER);
            tab.setContent(childHBox);
            runTapPane.getTabs().add(tab);
            runTapPane.setMinSize(200,100);
            runTapPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);




        }



    }
}
