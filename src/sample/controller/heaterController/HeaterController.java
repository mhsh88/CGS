package sample.controller.heaterController;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.model.Station;
import sample.model.burner.Burner;
import sample.model.heater.Heater;
import sample.model.heaters.Heaters;

import java.io.IOException;
import java.util.ArrayList;

public class HeaterController {

    public TextField heaterNumberInput;
    public TabPane tabPane = new TabPane();

    @FXML
    public void initialize() throws IOException {
        tabPane.getTabs().clear();
        tabPane.setMinSize(400,200);

    }

    @FXML
    public void okAction(ActionEvent actionEvent) {
        Heaters stationHeaters = new Heaters();
        ArrayList<Heater> heaters = new ArrayList<Heater>();

        ObservableList<Tab> Tabs = tabPane.getTabs();
        int heaterNumber = Tabs.size();
//        System.out.println(Tabs);
        for(Tab t: Tabs) {
            VBox vbox = (VBox) t.getContent();
//            TabPane tPane = (TabPane) hBoxes.getChildren();
            ObservableList<Node> hboxobj = vbox.getChildren();
            HBox hbox1 = (HBox) hboxobj.get(0);
            ObservableList<Node> onjInHBox1 = hbox1.getChildren();
            TextField heaterRandeman = (TextField) onjInHBox1.get(0);
            System.out.println(heaterRandeman.getText());
            HBox hbox = (HBox) hboxobj.get(1);
            ObservableList<Node> obj = hbox.getChildren();
            TabPane childTabPane = (TabPane) obj.get(0);
            ObservableList<Tab> childTabs = childTabPane.getTabs();

            ArrayList<Burner> burners = null;
            for (Tab tt : childTabs) {
                burners = new ArrayList<Burner>();
                HBox childhbox = (HBox) tt.getContent();
                ObservableList<Node> gridList = childhbox.getChildren();
                GridPane gridPane = (GridPane) gridList.get(0);
                ObservableList<Node> gridPaneChildren = gridPane.getChildren();
                TextField oxygenTextField = (TextField) gridPaneChildren.get(1);
                TextField flueGasTempTextField = (TextField) gridPaneChildren.get(3);
                System.out.println(oxygenTextField.getText());
                System.out.println(flueGasTempTextField.getText());


                burners.add(new Burner(Double.parseDouble(oxygenTextField.getText()), Double.parseDouble(flueGasTempTextField.getText())));

            }
            heaters.add(new Heater(Double.parseDouble(heaterRandeman.getText()), burners));


        }
        stationHeaters.setHeaters(heaters);

        Station.getInstance().getList().put("Heaters", stationHeaters);
        System.out.println(Station.getInstance().getList().get("Heaters"));

//        StationLogic station = StationLogic.getInstance();
//        station.getList().put();


    }
    @FXML
    private void textInput(KeyEvent keyEvent) {
        tabPane.getTabs().clear();
//        tabPane.setMinSize(300,200);
        if(heaterNumberInput.getText().equals("")) return;
        int heaterNumber = Integer.parseInt(heaterNumberInput.getText());
        if(heaterNumber>20){
            heaterNumberInput.setText("20");
            heaterNumber = 20;

        }
        else if(heaterNumber<0){
            heaterNumberInput.setText("0");
            heaterNumber = 0;
        }
        String[] heaterList = new String[heaterNumber];
        for(int i = 1; i <= heaterNumber; i++){
            heaterList[i-1] = String.valueOf(i);
        }
//        System.out.println(heaterNumberInput.getText());
//        TabPane tabPane = new TabPane();
//        BorderPane borderPane = new BorderPane();
        for (int i = 1; i <= heaterNumber; i++) {
            Tab tab = new Tab();
//            tab.setGraphic(new Circle(0, 0, 10));
            tab.setText("گرم کن " + i);
            TabPane burnerTabPane = new TabPane();
            VBox childVBox = new VBox();
            Label randemanLabel = new Label("راندمان حرارتی گرم کن");
            TextField randemanTextField = new TextField();
            HBox randemanHbox = new HBox();
            randemanHbox.getChildren().add(randemanTextField);
            randemanHbox.getChildren().add(randemanLabel);

            randemanHbox.setAlignment(Pos.CENTER);

            childVBox.getChildren().add(randemanHbox);


            for(int j = 1; j <= 3; j++){
                Tab burnerTab = new Tab();




                HBox childHBox = new HBox();

                burnerTab.setText("مشعل " + j);
                GridPane burnerContainer = new GridPane();
                burnerContainer.add(new Label("درصد اکسیژن ٪"), 1, 0);
                burnerContainer.add(new TextField(), 0, 0);
                burnerContainer.add(new Label("دمای دودکش "), 1, 1);
                burnerContainer.add(new TextField(), 0, 1);
                childHBox.getChildren().add(burnerContainer);
                childHBox.setAlignment(Pos.CENTER);
                burnerTab.setContent(childHBox);
                burnerTabPane.getTabs().add(burnerTab);
                burnerTabPane.setMinSize(300, 200);
                burnerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

            }
            HBox hbox = new HBox();
//            hbox.getChildren().add(new Label("گرم کن " + i));
            hbox.getChildren().add(burnerTabPane);
            hbox.setAlignment(Pos.CENTER);
            childVBox.getChildren().add(hbox);
            childVBox.setAlignment(Pos.CENTER);

            tab.setContent(childVBox);
            tabPane.getTabs().add(tab);
        }

    }

    public void cancelButton(ActionEvent actionEvent) {

        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void clearButton(ActionEvent actionEvent) {
        heaterNumberInput.clear();
        tabPane.getTabs().clear();
    }
}
