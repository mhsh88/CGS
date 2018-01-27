package sample.controller.showResults;

import ir.behinehsazan.gasStation.model.burner.Burner;
import ir.behinehsazan.gasStation.model.heater.Heater;
import ir.behinehsazan.gasStation.model.heater.Heaters;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import ir.behinehsazan.gasStation.model.regulator.Regulator;
import ir.behinehsazan.gasStation.model.run.Runs;
import ir.behinehsazan.gasStation.model.run.base.BaseRun;
import ir.behinehsazan.gasStation.model.station.StationLogic;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import sample.model.Station;
import sample.model.showResultEntity.Table;
import sample.model.stationProperties.StationPropertice;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

public class ShowResultsController implements Initializable{


    public TextField textField2;
    public GridPane gridPane;
    @FXML
    TableView<Table> tableID;
    @FXML
    TableColumn<Table, String> name;
    @FXML
    TableColumn<Table, String> value;

//    public TableView table;
    @FXML
    TextField textField = new TextField();


    public static ObservableList<Table> getData() {
        return data;
    }

    static final ObservableList<Table> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        name.setCellValueFactory(new PropertyValueFactory<Table, String>("name"));
        value.setCellValueFactory(new PropertyValueFactory<Table, String>("value"));
//        showResult();
        tableID.setItems(data);
        tableID.setColumnResizePolicy((param) -> true );
        Platform.runLater(() -> customResize(tableID));
        name.prefWidthProperty().bind(tableID.widthProperty().divide(2));
        value.prefWidthProperty().bind(tableID.widthProperty().divide(2));
//        showResult();

    }



//    @FXML
//    public void initialize() throws IOException{
//        try {
//
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }



//    @FXML
//    public void initialize() throws IOException {
//
//
//
//    }

    public void okAction(ActionEvent actionEvent) {
        data.add(new Table(textField.getText(), textField2.getText()));
        System.out.println(textField.getText());
    }

    public static void showResult() {
        data.clear();

        StationLogic stationLogic = Station.getInstance().getStationLogic();
        StationPropertice stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");
        if(stationPropertice != null) {
            data.add(new Table("استان", stationPropertice.getProvince()));
            data.add(new Table("شهر", stationPropertice.getCity()));
            data.add(new Table( "منطقه", stationPropertice.getArea()));
            data.add(new Table( "آدرس", stationPropertice.getAddress()));
            data.add(new Table( "ظرفیت نامی", stationPropertice.getNominalCapacity()));
            data.add(new Table( "دمای محیط", String.valueOf(stationPropertice.getEnvironmentTemp())));
            data.add(new Table( "سرعت باد", String.valueOf(stationPropertice.getWindVelocity())));
            data.add(new Table( "دمای گاز ورودی به ایستگاه", String.valueOf(stationPropertice.getInputTemp())));
            data.add(new Table( "فشار گاز ورودی به ایستگاه", String.valueOf(stationPropertice.getInputPressure())));
            data.add(new Table( "دمای گاز خروجی از ایستگاه", String.valueOf(stationPropertice.getOutputTemp())));
            data.add(new Table( "فشار گاز خروجی از ایستگاه", String.valueOf(stationPropertice.getOutputPressure())));
            data.add(new Table( "دبی عبوری از ایستگاه", String.valueOf(stationPropertice.getDebi())));
            data.add(new Table( "نیتروژن", String.valueOf(stationPropertice.getComponent()[0])));
            data.add(new Table( "دی اکسید کربن", String.valueOf(stationPropertice.getComponent()[1])));
            data.add(new Table( "متان", String.valueOf(stationPropertice.getComponent()[2])));
            data.add(new Table( "اتان", String.valueOf(stationPropertice.getComponent()[3])));
            data.add(new Table( "پروپان", String.valueOf(stationPropertice.getComponent()[4])));
            data.add(new Table( "نرمال بوتان", String.valueOf(stationPropertice.getComponent()[5])));
            data.add(new Table( "ایزو بوتان", String.valueOf(stationPropertice.getComponent()[6])));
            data.add(new Table( "نرمال پنتان", String.valueOf(stationPropertice.getComponent()[7])));
            data.add(new Table( "ایزو پنتان", String.valueOf(stationPropertice.getComponent()[8])));
            data.add(new Table( "هگزان", String.valueOf(stationPropertice.getComponent()[9])));
            data.add(new Table( "هپتان", String.valueOf(stationPropertice.getComponent()[10])));
            data.add(new Table( "اکتان", String.valueOf(stationPropertice.getComponent()[11])));
            data.add(new Table( "نونان", String.valueOf(stationPropertice.getComponent()[12])));
            data.add(new Table( "دکان", String.valueOf(stationPropertice.getComponent()[13])));
            data.add(new Table( "هیدروژن", String.valueOf(stationPropertice.getComponent()[14])));
            data.add(new Table( "اکسیژن", String.valueOf(stationPropertice.getComponent()[15])));
            data.add(new Table( "کربن منواکسید", String.valueOf(stationPropertice.getComponent()[16])));
            data.add(new Table( "آب", String.valueOf(stationPropertice.getComponent()[17])));
            data.add(new Table( "هیدروژن سولفید", String.valueOf(stationPropertice.getComponent()[18])));
            data.add(new Table( "هلیوم", String.valueOf(stationPropertice.getComponent()[19])));
            data.add(new Table( "آرگون", String.valueOf(stationPropertice.getComponent()[20])));
        }
        if(stationLogic != null) {
            if(stationLogic.getBeforeHeater() != null) {

                BasePipe beforeHeater = stationLogic.getBeforeHeater();
                data.add(new Table("خط لوله قبل از گرم کن", ""));

                data.add(new Table( "دمای گاز ورودی", String.valueOf(beforeHeater.getTin())));
                data.add(new Table( "فشار گاز ورودی", String.valueOf(beforeHeater.getPin())));
                data.add(new Table( "دمای گاز خروجی", String.valueOf(beforeHeater.getTout())));
                data.add(new Table( "فشار گاز خروجی", String.valueOf(beforeHeater.getPout())));
                data.add(new Table( "اختلاف دما", String.valueOf(beforeHeater.getTin() - beforeHeater.getTout())));
                data.add(new Table( "تلفات حرارتی", String.valueOf(beforeHeater.getConsumption())));

            }
        }

        if(stationLogic != null) {
            if(stationLogic.getHeaters() != null) {

                Heaters heaters = stationLogic.getHeaters();
                List<Heater> heater = heaters.getHeaters();
                data.add(new Table("اطلاعات گرم کن ","" ));
                int temp = 1;
                for (Heater h : heater) {

                    data.add(new Table("گرم کن " + temp,"" ));
                    data.add(new Table("راندمان گرم کن " + temp,String.valueOf(h.getEfficiency())));

                    List<Burner> burners = h.getBurners();
                    int temp2 = 1;
                    for (Burner b : burners) {
                        data.add(new Table("دمای دودکش مشعل " + temp2, String.valueOf( b.getTstack())));
                        data.add(new Table("درصد اکسیژن مشعل " + temp2, String.valueOf(b.getOxygen())));
                        data.add(new Table("راندمان مشعل " + temp2, String.valueOf(b.getEfficiency())));
                        double tem = b.getConsumption();
                        data.add(new Table("مصرف مشعل " + temp2, String.valueOf(b.getConsumption())));

                        temp2++;
                    }
                    temp++;
                }
                data.add(new Table("مصرف گرمکن‌ها", String.valueOf(heaters.getConsumption())));
            }
        }

        if(stationLogic != null) {
            if (stationLogic.getAfterHeater() != null) {

                BasePipe afterHeater = stationLogic.getAfterHeater();
                data.add(new Table("خط لوله بعد از گرم کن", ""));
                data.add(new Table( "دمای گاز ورودی", String.valueOf(afterHeater.getTin())));

                data.add(new Table( "فشار گاز ورودی", String.valueOf(afterHeater.getPin())));
                data.add(new Table( "دمای گاز خروجی", String.valueOf(afterHeater.getTout())));
                data.add(new Table( "فشار گاز خروجی", String.valueOf(afterHeater.getPout())));
                data.add(new Table( "اختلاف دما", String.valueOf(afterHeater.getTin() - afterHeater.getTout())));
                data.add(new Table( "تلفات حرارتی", String.valueOf(afterHeater.getConsumption())));
            }
        }

        if(stationLogic != null) {
            if (stationLogic.getCollector() != null) {

                BasePipe collector = stationLogic.getCollector();
                data.add(new Table("اطلاعات کلکتور", ""));
                data.add(new Table( "دمای گاز ورودی", String.valueOf(collector.getTin())));

                data.add(new Table( "فشار گاز ورودی", String.valueOf(collector.getPin())));
                data.add(new Table( "دمای گاز خروجی", String.valueOf(collector.getTout())));
                data.add(new Table( "فشار گاز خروجی", String.valueOf(collector.getPout())));
                data.add(new Table( "اختلاف دما", String.valueOf(collector.getTin() - collector.getTout())));
                data.add(new Table( "تلفات حرارتی", String.valueOf(collector.getConsumption())));
            }
        }
        if(stationLogic != null) {
            if (stationLogic.getRuns() != null) {
                data.add(new Table("اطلاعات ران ها", ""));

                Runs runs = stationLogic.getRuns();
                List<BaseRun> run = runs.getRuns();
                int i = 1;
                for (BaseRun r : run) {
                    data.add(new Table( "ران " + i, String.valueOf(r.getPin())));

                    data.add(new Table( "فشار گاز ورودی", String.valueOf(r.getPin())));
                    data.add(new Table( "دمای گاز خروجی", String.valueOf(r.getTout())));
                    data.add(new Table( "فشار گاز خروجی", String.valueOf(r.getPout())));
                    data.add(new Table( "اختلاف دما", String.valueOf(r.getTin() - r.getTout())));
                    data.add(new Table( "تلفات حرارتی", String.valueOf(r.getConsumption())));
                    i++;
                }
            }
        }

        if(stationLogic != null) {
            if (stationLogic.getRegulator() != null) {
                Regulator regulator = stationLogic.getRegulator();
                data.add(new Table("رگولاتور",""));
                data.add(new Table("دمای گاز ورودی", String.valueOf(regulator.getTin())));
                data.add(new Table( "فشار گاز ورودی", String.valueOf(regulator.getPin())));
                data.add(new Table( "دمای گاز خروجی", String.valueOf(regulator.getTout())));
                data.add(new Table( "فشار گاز خروجی", String.valueOf(regulator.getPout())));
            }
        }












    }
    public void customResize(TableView<?> view) {

        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth()+((tableWidth-width.get())/view.getColumns().size()));
            });
        }
    }



}
