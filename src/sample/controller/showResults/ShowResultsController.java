package sample.controller.showResults;

import ir.behinehsazan.gasStation.model.station.StationLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.Station;
import sample.model.stationProperties.StationPropertice;

import java.io.IOException;

public class ShowResultsController {

    public TableView table;
    @FXML
    TextField textField = new TextField();
    @FXML
    public void initialize() throws IOException {
        TableColumn firstNameCol = new TableColumn("نام");
        TableColumn lastNameCol = new TableColumn("مقدار");


        table.getColumns().addAll(firstNameCol, lastNameCol);


    }

    public void okAction(ActionEvent actionEvent) {
        System.out.println(textField.getText());
    }

    public static void showResult(ShowResultsFrame showResultsFrame) {

        StationLogic stationLogic = Station.getInstance().getStationLogic();
        StationPropertice stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");



    }
}
