package sample.controller.heaterController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class HeaterController {

    public TextField heaterNumberInput;
    public TabPane tabPane = new TabPane();
    public ComboBox heaterNumberComboBox;

    @FXML
    public void okAction(ActionEvent actionEvent) {
        tabPane.getTabs().clear();
        int heaterNumber = Integer.parseInt(heaterNumberInput.getText());
        String[] heaterList = new String[heaterNumber];
        for(int i = 1; i <= heaterNumber; i++){
            heaterList[i-1] = String.valueOf(i);
        }
        heaterNumberComboBox.getItems().clear();
        heaterNumberComboBox.getItems().removeAll();
        heaterNumberComboBox.getItems().addAll(heaterList);
        heaterNumberComboBox.getSelectionModel().select("1");

//        System.out.println(heaterNumberInput.getText());
//        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        for (int i = 1; i <= heaterNumber; i++) {
            Tab tab = new Tab();
//            tab.setGraphic(new Circle(0, 0, 10));
            tab.setText("گرم کن " + i);
            HBox hbox = new HBox();
            hbox.getChildren().add(new Label("گرم کن " + i));
            hbox.setAlignment(Pos.CENTER);
            tab.setContent(hbox);
            tabPane.getTabs().add(tab);
        }
        // bind to take available space

//        borderPane.setCenter(tabPane);

        System.out.println("this is in OK method");

    }
}
