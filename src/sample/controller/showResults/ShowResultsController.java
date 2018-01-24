package sample.controller.showResults;

import ir.behinehsazan.gasStation.model.burner.Burner;
import ir.behinehsazan.gasStation.model.heater.Heater;
import ir.behinehsazan.gasStation.model.heater.Heaters;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import ir.behinehsazan.gasStation.model.regulator.Regulator;
import ir.behinehsazan.gasStation.model.run.Runs;
import ir.behinehsazan.gasStation.model.run.base.BaseRun;
import ir.behinehsazan.gasStation.model.station.StationLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Station;
import sample.model.showResultEntity.Table;
import sample.model.stationProperties.StationPropertice;

import java.io.IOException;
import java.util.List;

public class ShowResultsController {


    @FXML
    TableView<Table> tableID;
    @FXML
    TableColumn<Table, String> name;
    @FXML
    TableColumn<Table, String> value;

    public TableView table;
    @FXML
    TextField textField = new TextField();


    final ObservableList<Table> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws IOException{

        name.setCellValueFactory(new PropertyValueFactory<Table, String>("نام متغیر"));
        value.setCellValueFactory(new PropertyValueFactory<Table, String>("مقدار"));

        tableID.setItems(data);
    }



//    @FXML
//    public void initialize() throws IOException {
//
//
//
//    }

    public void okAction(ActionEvent actionEvent) {
        System.out.println(textField.getText());
    }

    public static void showResult(ShowResultsFrame showResultsFrame) {

        StationLogic stationLogic = Station.getInstance().getStationLogic();
        StationPropertice stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");
        stationPropertice.getProvince();
        stationPropertice.getCity();
        stationPropertice.getArea();
        stationPropertice.getAddress();
        stationPropertice.getNominalCapacity();
        stationPropertice.getEnvironmentTemp();
        stationPropertice.getWindVelocity();
        stationPropertice.getInputTemp();
        stationPropertice.getInputPressure();
        stationPropertice.getOutputTemp();
        stationPropertice.getOutputPressure();
        stationPropertice.getDebi();
        stationPropertice.getComponent();

        BasePipe beforeHeater = stationLogic.getBeforeHeater();
        beforeHeater.getConsumption();
        beforeHeater.getTin();
        beforeHeater.getTout();
        beforeHeater.getPin();
        beforeHeater.getPout();

        Heaters heaters = stationLogic.getHeaters();
        List<Heater> heater = heaters.getHeaters();
        for(Heater h : heater){
            List<Burner> burners = h.getBurners();
            for(Burner b : burners){
                b.getEfficiency();
                b.getTstack();
                b.getConsumption();
            }
        }

        BasePipe afterHeater = stationLogic.getAfterHeater();
        afterHeater.getConsumption();
        afterHeater.getTout();
        afterHeater.getTin();
        afterHeater.getPin();
        afterHeater.getTin();

        BasePipe collector = stationLogic.getCollector();
        collector.getTin();
        collector.getPin();
        collector.getPout();
        collector.getTout();
        collector.getConsumption();

        Runs runs = stationLogic.getRuns();
        List<BaseRun> run = runs.getRuns();
        for(BaseRun r: run){
            r.getConsumption();
            r.getTin();
            r.getPin();
            r.getTout();
            r.getPout();
        }

        Regulator regulator = stationLogic.getRegulator();
        regulator.getPin();
        regulator.getPout();
        regulator.getTin();
        regulator.getTout();












    }


}
