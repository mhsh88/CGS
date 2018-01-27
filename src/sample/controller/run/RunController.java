package sample.controller.run;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sample.model.Station;
import sample.model.run.Collector;
import sample.model.run.Run;
import sample.model.run.Runs;

import java.io.IOException;
import java.util.ArrayList;

public class RunController {

    public TextField runNumberInput;
    public TextField runLengthInput;
    public TextField runColectorLengthInput;
    public TabPane runTapPane;
    public ComboBox collectorComboBox;
    public Button okButton;
    public Button clearButton;
    public Button cancelButton;

    @FXML
    public void initialize() throws IOException {
        collectorComboBox.getItems().removeAll();
        collectorComboBox.getItems().addAll( "2","4","6","8","10","12","16","20","24","30");
        collectorComboBox.getSelectionModel().select("8");
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
            runContainer.add(new Label("سایز (اینچ) "), 1, 1);
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


    public void ok(ActionEvent actionEvent) {
        if(runNumberInput.getText().equals("") ||
                runColectorLengthInput.getText().equals("") ||
                runLengthInput.getText().equals("")){return;}

        int runNumber = Integer.parseInt(runNumberInput.getText());
        ArrayList<Run> runs = new ArrayList<Run>();
        Collector collector = new Collector(collectorComboBox.getValue().toString().toString(),
                Double.parseDouble(runColectorLengthInput.getText()));

        double runLength = Double.parseDouble(runLengthInput.getText());

        ObservableList<Tab> tabs = runTapPane.getTabs();
        for(Tab t : tabs){
            HBox hBox = (HBox) t.getContent();
            ObservableList<Node> obj = hBox.getChildren();
//            System.out.println(obj.get(0));
            GridPane gridPane = (GridPane) obj.get(0);

            ObservableList<Node> tabObject = gridPane.getChildren();

            TextField rundebi = (TextField) tabObject.get(1);
            ComboBox runsize = (ComboBox) tabObject.get(3);


//            System.out.println(rundebi.getText() + " " + runsize.getValue().toString());
            runs.add(new Run(runsize.getValue().toString(),runLength, Double.parseDouble(rundebi.getText()) ));


        }

        Runs allRun = new Runs(runs, collector);
        Station.getInstance().getList().put("Runs", allRun);
//        System.out.println(StationLogic.getInstance().getList().get("Runs"));
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();

    }

    public void clear(ActionEvent actionEvent) {
        runNumberInput.clear();
        runColectorLengthInput.clear();
        runLengthInput.clear();
        runTapPane.getTabs().clear();

    }

    public void cancel(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
}
