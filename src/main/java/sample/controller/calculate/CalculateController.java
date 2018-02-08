package main.java.sample.controller.calculate;

import main.java.ir.behinehsazan.gasStation.model.burner.Burner;
import main.java.ir.behinehsazan.gasStation.model.gas.Gas;
import main.java.ir.behinehsazan.gasStation.model.heater.Heater;
import main.java.ir.behinehsazan.gasStation.model.heater.Heaters;
import main.java.ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import main.java.ir.behinehsazan.gasStation.model.regulator.Regulator;
import main.java.ir.behinehsazan.gasStation.model.run.base.BaseRun;
import main.java.ir.behinehsazan.gasStation.model.station.StationLogic;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import main.java.sample.controller.showResults.ShowResultsController;
import main.java.sample.model.heaters.HeatersModel;
import main.java.sample.model.pipeLine.PipeLine;
import main.java.sample.model.run.Runs;
import main.java.sample.controller.base.BaseController;
import main.java.sample.model.Station;
import main.java.sample.model.showResultEntity.Table;
import main.java.sample.model.stationProperties.StationPropertice;

import java.util.List;
import java.util.Optional;

public class CalculateController extends BaseController{
    final static String celciusDegree = " (C°)";
    final static String percent = " (٪)";
    final static String pressureDegree = " (kPa)";
    final static String cubicMeter = " (متر مکعب بر ساعت) ";
    final static String windSpeed = " (m/s) ";
    public boolean calculate() {
        boolean state;

        Station station = Station.getInstance();
        Runs runs = (Runs) station.getList().get("Runs");
        StationPropertice stationPropertice = (StationPropertice) station.getList().get("stationPropertice");
        HeatersModel heatersModel = (HeatersModel) station.getList().get("HeatersModel");
        PipeLine afterHeaterPipeLine = (PipeLine) station.getList().get("afterHeaterPipeLine");
        PipeLine beforeHeaterPipeLine = (PipeLine) station.getList().get("beforeHeaterPipeLine");
        if(stationPropertice == null){
            showAlert("خطا","خطا در اطلاعات ورودی","اطلاعات ایستگاه تکمیل نشده است", Alert.AlertType.ERROR);
            return false;
        }
        else{

            if(runs != null){
                double tempDebi = 0;
                for(int i = 0 ; i < runs.getRuns().size(); i++){
                    tempDebi += runs.getRuns().get(i).getDebi();

                }
                if(stationPropertice.getDebi() < tempDebi){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("توجه");
                    alert.setHeaderText("مجموع دبی عبوری تعیین شده برای ران‌ها بیش از مقدار مشخص شده برای ایستگاه است.");
                    alert.setContentText("آیا مایل به اصلاح میزان دبی عبوری ایستگاه هستید؟");
                    ButtonType okButton = new ButtonType("بله", ButtonBar.ButtonData.YES);
                    ButtonType noButton = new ButtonType("خیر", ButtonBar.ButtonData.NO);
//                    ButtonType cancelButton = new ButtonType("خروج", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(okButton, noButton);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == okButton){
                        stationPropertice.setDebi(tempDebi);
                        // ... user chose "One"
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }
//                    double finalTempDebi = tempDebi;
//                    alert.showAndWait().ifPresent(type -> {
//                        if (type == ButtonType.YES) {
//                            stationPropertice.setDebi(finalTempDebi);
//                            System.out.println("Yes");
//                        } else if (type == ButtonType.NO) {
//
//                            System.out.println("NO");
//
//                        } else if(type == ButtonType.CANCEL) {
//                            System.out.println("Cancel Button Hit");
//                        }
//                        else if(type == ButtonType.CANCEL){
//                            System.out.println("Close Button Hit");
//                        }
//                    });
                }

            }



            StationLogic stationLogic = new StationLogic();
            Gas gas = new Gas();
            Double[] component = stationPropertice.getComponent();
            gas.setComponent(component);
            stationLogic.setGas(gas);
            stationLogic.setTenv(stationPropertice.getEnvironmentTemp());
            stationLogic.setVair(stationPropertice.getWindVelocity());
            stationLogic.setDebi(stationPropertice.getDebi());
            stationLogic.setTin(stationPropertice.getInputTemp());
            stationLogic.setPin(stationPropertice.getInputPressure());
            stationLogic.setTout(stationPropertice.getOutputTemp());
            stationLogic.setPout(stationPropertice.getOutputPressure());

            station.getList().put("beforeHeaterPipeLine", stationLogic.setBeforeHeater(beforeHeaterPipeLine));

            stationLogic.setRegulator();


            stationLogic.setRuns(runs);

            stationLogic.setCollector(runs);




            station.getList().put("afterHeaterPipeLine", stationLogic.setAfterHeater(afterHeaterPipeLine));


            stationLogic.setHeaters(heatersModel);
//
            station.setStationLogic(stationLogic);
            state = true;


        }

        saveUserTempInputResults();
        calculateHydrateResults();
        return state;





    }

    private boolean calculateHydrateResults() {
        boolean state;

        Station station = Station.getInstance();
        Runs runs = (Runs) station.getList().get("Runs");
        StationPropertice stationPropertice = (StationPropertice) station.getList().get("stationPropertice");
        HeatersModel heatersModel = (HeatersModel) station.getList().get("HeatersModel");
        PipeLine afterHeaterPipeLine = (PipeLine) station.getList().get("afterHeaterPipeLine");
        PipeLine beforeHeaterPipeLine = (PipeLine) station.getList().get("beforeHeaterPipeLine");
        if(stationPropertice == null){
            showAlert("خطا","خطا در اطلاعات ورودی","اطلاعات ایستگاه تکمیل نشده است", Alert.AlertType.ERROR);
            return false;
        }
        else{



            StationLogic stationLogic = new StationLogic();
            Gas gas = new Gas();
            Double[] component = stationPropertice.getComponent();
            gas.setComponent(component);
            gas.calculate(stationPropertice.getOutputPressure(), stationPropertice.getOutputTemp(),component);
            stationLogic.setGas(gas);
            stationLogic.setTenv(stationPropertice.getEnvironmentTemp());
            stationLogic.setVair(stationPropertice.getWindVelocity());
            stationLogic.setDebi(stationPropertice.getDebi());
            stationLogic.setTin(stationPropertice.getInputTemp());
            stationLogic.setPin(stationPropertice.getInputPressure());
            if(gas.getT_h()>50){
                ObservableList<Table> data = ShowResultsController.getHydrateData();
                data.clear();
                data.add(new Table("خطا","دمای هیدرات برای شرایط زیر قابل محاسبه نیست"));
                return false;
            }
            stationLogic.setTout(gas.getT_h() + 273.15);
            stationLogic.setPout(stationPropertice.getOutputPressure());

            station.getList().put("beforeHeaterPipeLine", stationLogic.setBeforeHeater(beforeHeaterPipeLine));

            stationLogic.setRegulator();


            stationLogic.setRuns(runs);

            stationLogic.setCollector(runs);




            station.getList().put("afterHeaterPipeLine", stationLogic.setAfterHeater(afterHeaterPipeLine));


            stationLogic.setHeaters(heatersModel);
//
            station.setStationLogic(stationLogic);
            state = true;


        }

        saveHydrateResults();
        return state;

    }

    private void saveHydrateResults() {
        ObservableList<Table> data = ShowResultsController.getHydrateData();
        data.clear();

        StationLogic stationLogic = Station.getInstance().getStationLogic();
        StationPropertice stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");
        if (stationPropertice == null) {
            return;

        }
        else{
            data.add(new Table("محاسبات بر اساس دمای هیدرات", ""));
        }
        if (stationLogic != null) {
            if (stationLogic.getBeforeHeater() != null) {


//                    BasePipe beforeHeater = stationLogic.getBeforeHeater();
//                    data.add(new Table("خط لوله قبل از گرم کن", ""));
//
//                    data.add(new Table("دمای گاز ورودی", String.valueOf(beforeHeater.getTin() - 273.15)));
//                    data.add(new Table("فشار گاز ورودی", String.valueOf(beforeHeater.getPin())));
//                    data.add(new Table("دمای گاز خروجی", String.valueOf(beforeHeater.getTout() - 273.15)));
//                    data.add(new Table("فشار گاز خروجی", String.valueOf(beforeHeater.getPout())));
//                    data.add(new Table("اختلاف دما", String.valueOf(beforeHeater.getTin() - 273.15 - beforeHeater.getTout() - 273.15)));
//                    data.add(new Table("تلفات حرارتی", String.valueOf(beforeHeater.getConsumption())));
                if(Station.getInstance().getList().get("beforeHeaterPipeLine") !=null) {
                    PipeLine beforeHeaterSampleModel = (PipeLine) Station.getInstance().getList().get("beforeHeaterPipeLine");
                    data.add(new Table("خط لوله قبل از گرم کن", ""));

                    data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(beforeHeaterSampleModel.getTin() - 273.15)));
                    data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(beforeHeaterSampleModel.getPin())));
                    data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(beforeHeaterSampleModel.getTout() - 273.15)));
                    data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(beforeHeaterSampleModel.getPout())));
                    data.add(new Table("اختلاف دما" + celciusDegree, String.valueOf(beforeHeaterSampleModel.getTin() - 273.15 - beforeHeaterSampleModel.getTout() - 273.15)));
                    data.add(new Table(   "تلفات حرارتی با عایق حرارتی" + cubicMeter, String.valueOf(beforeHeaterSampleModel.getWithInsulationConsumption())));
                    data.add(new Table("تلفات حرارتی بدون عایق حرارتی" + cubicMeter, String.valueOf(beforeHeaterSampleModel.getNotIsulationConsumption())));



                }

            }
        }

        if (stationLogic != null) {
            if (stationLogic.getHeaters() != null) {

                Heaters heaters = stationLogic.getHeaters();
                List<Heater> heater = heaters.getHeaters();
                data.add(new Table("اطلاعات گرم کن ", ""));
                int temp = 1;
                for (Heater h : heater) {

                    data.add(new Table("گرم کن " + temp, ""));
                    data.add(new Table("راندمان گرم کن " + temp, String.valueOf(h.getEfficiency())));

                    List<Burner> burners = h.getBurners();
                    int temp2 = 1;
                    for (Burner b : burners) {
                        data.add(new Table("دمای دودکش مشعل " + temp2  + celciusDegree , String.valueOf(b.getTstack())));
                        data.add(new Table("درصد اکسیژن مشعل " + temp2 + percent, String.valueOf(b.getOxygen())));
                        data.add(new Table("راندمان مشعل " + temp2, String.valueOf(b.getEfficiency())));
                        double tem = b.getConsumption();
                        data.add(new Table("مصرف مشعل " + temp2 + cubicMeter, String.valueOf(b.getConsumption())));

                        temp2++;
                    }
                    temp++;
                }
                data.add(new Table("مصرف گرمکن‌ها" + cubicMeter, String.valueOf(heaters.getConsumption())));
            }
        }

        if (stationLogic != null) {
            if (stationLogic.getAfterHeater() != null) {

//                BasePipe afterHeater = stationLogic.getAfterHeater();
//                data.add(new Table("خط لوله بعد از گرم کن", ""));
//                data.add(new Table("دمای گاز ورودی", String.valueOf(afterHeater.getTin() - 273.15)));
//
//                data.add(new Table("فشار گاز ورودی", String.valueOf(afterHeater.getPin())));
//                data.add(new Table("دمای گاز خروجی", String.valueOf(afterHeater.getTout() - 273.15)));
//                data.add(new Table("فشار گاز خروجی", String.valueOf(afterHeater.getPout())));
//                data.add(new Table("اختلاف دما", String.valueOf(afterHeater.getTin() - 273.15 - afterHeater.getTout() - 273.15)));
//                data.add(new Table("تلفات حرارتی", String.valueOf(afterHeater.getConsumption())));

                if(Station.getInstance().getList().get("afterHeaterPipeLine") !=null) {
                    PipeLine afterHeaterSampleModel = (PipeLine) Station.getInstance().getList().get("afterHeaterPipeLine");
                    data.add(new Table("خط لوله بعد از گرم کن", ""));

                    data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(afterHeaterSampleModel.getTin() - 273.15)));
                    data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(afterHeaterSampleModel.getPin())));
                    data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(afterHeaterSampleModel.getTout() - 273.15)));
                    data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(afterHeaterSampleModel.getPout())));
//                    data.add(new Table("اختلاف دما", String.valueOf(afterHeaterSampleModel.getTin()  - afterHeaterSampleModel.getTout() )));
                    data.add(new Table("تلفات حرارتی با عایق حرارتی" + cubicMeter, String.valueOf(afterHeaterSampleModel.getWithInsulationConsumption())));
                    data.add(new Table("تلفات حرارتی بدون عایق حرارتی" + cubicMeter, String.valueOf(afterHeaterSampleModel.getNotIsulationConsumption())));



                }


            }
        }

        if (stationLogic != null) {
            if (stationLogic.getCollector() != null) {

                BasePipe collector = stationLogic.getCollector();
                data.add(new Table("اطلاعات کلکتور", ""));
                data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(collector.getTin() - 273.15)));

                data.add(new Table( "فشار گاز ورودی" + pressureDegree, String.valueOf(collector.getPin())));
                data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(collector.getTout() - 273.15)));
                data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(collector.getPout())));
//                data.add(new Table("اختلاف دما", String.valueOf(collector.getTin() - 273.15 - collector.getTout() - 273.15)));
                data.add(new Table("تلفات حرارتی" + cubicMeter, String.valueOf(collector.getConsumption())));
            }
        }
        if (stationLogic != null) {
            if (stationLogic.getRuns() != null) {
                data.add(new Table("اطلاعات ران ها", ""));

                main.java.ir.behinehsazan.gasStation.model.run.Runs runs = stationLogic.getRuns();
                List<BaseRun> run = runs.getRuns();
                int i = 1;
                for (BaseRun r : run) {
                    data.add(new Table("ران " + i, String.valueOf(r.getPin())));

                    data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(r.getTin() - 273.15)));
                    data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(r.getPin())));
                    data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(r.getTout() - 273.15)));
                    data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(r.getPout())));
//                    data.add(new Table("اختلاف دما", String.valueOf(r.getTin() - 273.15 - r.getTout() - 273.15)));
                    data.add(new Table("تلفات حرارتی" + cubicMeter, String.valueOf(r.getConsumption())));
                    i++;
                }
            }
        }

        if (stationLogic != null) {
            if (stationLogic.getRegulator() != null) {
                Regulator regulator = stationLogic.getRegulator();
                data.add(new Table("رگولاتور", ""));
                data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(regulator.getTin() - 273.15)));
                data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(regulator.getPin())));
                data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(regulator.getTout() - 273.15)));
                data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(regulator.getPout())));
            }
        }


    }

    public static void saveUserTempInputResults() {
        ObservableList<Table> data = ShowResultsController.getData();
        data.clear();

        StationLogic stationLogic = Station.getInstance().getStationLogic();
        StationPropertice stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");
        if (stationPropertice != null) {
            data.add(new Table("استان", stationPropertice.getProvince()));
            data.add(new Table("شهر", stationPropertice.getCity()));
            data.add(new Table("منطقه", stationPropertice.getArea()));
            data.add(new Table("آدرس", stationPropertice.getAddress()));
            data.add(new Table("ظرفیت نامی" + cubicMeter, stationPropertice.getNominalCapacity()));
            if(stationPropertice.getEnvironmentTemp()!=null) {
                data.add(new Table("دمای محیط" + celciusDegree, String.valueOf(stationPropertice.getEnvironmentTemp() - 273.15)));
            }
            data.add(new Table("سرعت باد" + windSpeed, String.valueOf(stationPropertice.getWindVelocity())));
            data.add(new Table("دمای گاز ورودی به ایستگاه" + celciusDegree, String.valueOf(stationPropertice.getInputTemp() - 273.15)));
            data.add(new Table("فشار گاز ورودی به ایستگاه" + pressureDegree, String.valueOf(stationPropertice.getInputPressure())));
            data.add(new Table("دمای گاز خروجی از ایستگاه" + celciusDegree, String.valueOf(stationPropertice.getOutputTemp() - 273.15)));
            data.add(new Table("فشار گاز خروجی از ایستگاه" + pressureDegree, String.valueOf(stationPropertice.getOutputPressure())));
            data.add(new Table("دبی عبوری از ایستگاه" + cubicMeter, String.valueOf(stationPropertice.getDebi())));
            data.add(new Table("نیتروژن", String.valueOf(stationPropertice.getComponent()[0])));
            data.add(new Table("دی اکسید کربن", String.valueOf(stationPropertice.getComponent()[1])));
            data.add(new Table("متان", String.valueOf(stationPropertice.getComponent()[2])));
            data.add(new Table("اتان", String.valueOf(stationPropertice.getComponent()[3])));
            data.add(new Table("پروپان", String.valueOf(stationPropertice.getComponent()[4])));
            data.add(new Table("نرمال بوتان", String.valueOf(stationPropertice.getComponent()[5])));
            data.add(new Table("ایزو بوتان", String.valueOf(stationPropertice.getComponent()[6])));
            data.add(new Table("نرمال پنتان", String.valueOf(stationPropertice.getComponent()[7])));
            data.add(new Table("ایزو پنتان", String.valueOf(stationPropertice.getComponent()[8])));
            data.add(new Table("هگزان", String.valueOf(stationPropertice.getComponent()[9])));
            data.add(new Table("هپتان", String.valueOf(stationPropertice.getComponent()[10])));
            data.add(new Table("اکتان", String.valueOf(stationPropertice.getComponent()[11])));
            data.add(new Table("نونان", String.valueOf(stationPropertice.getComponent()[12])));
            data.add(new Table("دکان", String.valueOf(stationPropertice.getComponent()[13])));
            data.add(new Table("هیدروژن", String.valueOf(stationPropertice.getComponent()[14])));
            data.add(new Table("اکسیژن", String.valueOf(stationPropertice.getComponent()[15])));
            data.add(new Table("کربن منواکسید", String.valueOf(stationPropertice.getComponent()[16])));
            data.add(new Table("آب", String.valueOf(stationPropertice.getComponent()[17])));
            data.add(new Table("هیدروژن سولفید", String.valueOf(stationPropertice.getComponent()[18])));
            data.add(new Table("هلیوم", String.valueOf(stationPropertice.getComponent()[19])));
            data.add(new Table("آرگون", String.valueOf(stationPropertice.getComponent()[20])));
        }
        if (stationLogic != null) {
            if (stationLogic.getBeforeHeater() != null) {


//                    BasePipe beforeHeater = stationLogic.getBeforeHeater();
//                    data.add(new Table("خط لوله قبل از گرم کن", ""));
//
//                    data.add(new Table("دمای گاز ورودی", String.valueOf(beforeHeater.getTin() - 273.15)));
//                    data.add(new Table("فشار گاز ورودی", String.valueOf(beforeHeater.getPin())));
//                    data.add(new Table("دمای گاز خروجی", String.valueOf(beforeHeater.getTout() - 273.15)));
//                    data.add(new Table("فشار گاز خروجی", String.valueOf(beforeHeater.getPout())));
//                    data.add(new Table("اختلاف دما", String.valueOf(beforeHeater.getTin() - 273.15 - beforeHeater.getTout() - 273.15)));
//                    data.add(new Table("تلفات حرارتی", String.valueOf(beforeHeater.getConsumption())));
                if(Station.getInstance().getList().get("beforeHeaterPipeLine") !=null) {
                    PipeLine beforeHeaterSampleModel = (PipeLine) Station.getInstance().getList().get("beforeHeaterPipeLine");
                    data.add(new Table("خط لوله قبل از گرم کن", ""));

                    data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(beforeHeaterSampleModel.getTin() - 273.15)));
                    data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(beforeHeaterSampleModel.getPin())));
                    data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(beforeHeaterSampleModel.getTout() - 273.15)));
                    data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(beforeHeaterSampleModel.getPout())));
//                    data.add(new Table("اختلاف دما", String.valueOf(beforeHeaterSampleModel.getTin() - 273.15 - beforeHeaterSampleModel.getTout() - 273.15)));
                    data.add(new Table("تلفات حرارتی با عایق حرارتی" + cubicMeter, String.valueOf(beforeHeaterSampleModel.getWithInsulationConsumption())));
                    data.add(new Table("تلفات حرارتی بدون عایق حرارتی" + cubicMeter, String.valueOf(beforeHeaterSampleModel.getNotIsulationConsumption())));



                }

            }
        }

        if (stationLogic != null) {
            if (stationLogic.getHeaters() != null) {

                Heaters heaters = stationLogic.getHeaters();
                List<Heater> heater = heaters.getHeaters();
                data.add(new Table("اطلاعات گرم کن ", ""));
                int temp = 1;
                for (Heater h : heater) {

                    data.add(new Table("گرم کن " + temp, ""));
                    data.add(new Table("راندمان گرم کن " + temp, String.valueOf(h.getEfficiency())));

                    List<Burner> burners = h.getBurners();
                    int temp2 = 1;
                    for (Burner b : burners) {
                        data.add(new Table("دمای دودکش مشعل " + temp2 + celciusDegree, String.valueOf(b.getTstack())));
                        data.add(new Table("درصد اکسیژن مشعل " + temp2 + percent, String.valueOf(b.getOxygen())));
                        data.add(new Table("راندمان مشعل " + temp2, String.valueOf(b.getEfficiency())));
                        double tem = b.getConsumption();
                        data.add(new Table("مصرف مشعل " + temp2 + cubicMeter, String.valueOf(b.getConsumption())));

                        temp2++;
                    }
                    temp++;
                }
                data.add(new Table("مصرف گرمکن‌ها" + cubicMeter, String.valueOf(heaters.getConsumption())));
            }
        }

        if (stationLogic != null) {
            if (stationLogic.getAfterHeater() != null) {

//                BasePipe afterHeater = stationLogic.getAfterHeater();
//                data.add(new Table("خط لوله بعد از گرم کن", ""));
//                data.add(new Table("دمای گاز ورودی", String.valueOf(afterHeater.getTin() - 273.15)));
//
//                data.add(new Table("فشار گاز ورودی", String.valueOf(afterHeater.getPin())));
//                data.add(new Table("دمای گاز خروجی", String.valueOf(afterHeater.getTout() - 273.15)));
//                data.add(new Table("فشار گاز خروجی", String.valueOf(afterHeater.getPout())));
//                data.add(new Table("اختلاف دما", String.valueOf(afterHeater.getTin() - 273.15 - afterHeater.getTout() - 273.15)));
//                data.add(new Table("تلفات حرارتی", String.valueOf(afterHeater.getConsumption())));

                if(Station.getInstance().getList().get("afterHeaterPipeLine") !=null) {
                    PipeLine afterHeaterSampleModel = (PipeLine) Station.getInstance().getList().get("afterHeaterPipeLine");
                    data.add(new Table("خط لوله بعد از گرم کن", ""));

                    data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(afterHeaterSampleModel.getTin() - 273.15)));
                    data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(afterHeaterSampleModel.getPin())));
                    data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(afterHeaterSampleModel.getTout() - 273.15)));
                    data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(afterHeaterSampleModel.getPout())));
//                    data.add(new Table("اختلاف دما", String.valueOf(afterHeaterSampleModel.getTin() - 273.15 - afterHeaterSampleModel.getTout() - 273.15)));
                    data.add(new Table("تلفات حرارتی با عایق حرارتی" + cubicMeter, String.valueOf(afterHeaterSampleModel.getWithInsulationConsumption())));
                    data.add(new Table("تلفات حرارتی بدون عایق حرارتی" + cubicMeter, String.valueOf(afterHeaterSampleModel.getNotIsulationConsumption())));



                }


            }
        }

        if (stationLogic != null) {
            if (stationLogic.getCollector() != null) {

                BasePipe collector = stationLogic.getCollector();
                data.add(new Table("اطلاعات کلکتور", ""));
                data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(collector.getTin() - 273.15)));

                data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(collector.getPin())));
                data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(collector.getTout() - 273.15)));
                data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(collector.getPout())));
//                data.add(new Table("اختلاف دما", String.valueOf(collector.getTin() - 273.15 - collector.getTout() - 273.15)));
                data.add(new Table("تلفات حرارتی" + cubicMeter, String.valueOf(collector.getConsumption())));
            }
        }
        if (stationLogic != null) {
            if (stationLogic.getRuns() != null) {
                data.add(new Table("اطلاعات ران ها", ""));

                main.java.ir.behinehsazan.gasStation.model.run.Runs runs = stationLogic.getRuns();
                List<BaseRun> run = runs.getRuns();
                int i = 1;
                for (BaseRun r : run) {
                    data.add(new Table("ران " + i, String.valueOf(r.getPin())));


                    data.add(new Table("دمای گاز ورودی " + celciusDegree, String.valueOf(r.getTin() - 273.15)));

                    data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(r.getPin())));
                    data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(r.getTout() - 273.15)));
                    data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(r.getPout())));
//                    data.add(new Table("اختلاف دما", String.valueOf(r.getTin() - 273.15 - r.getTout() - 273.15)));
                    data.add(new Table("تلفات حرارتی" + cubicMeter, String.valueOf(r.getConsumption())));
                    i++;
                }
            }
        }

        if (stationLogic != null) {
            if (stationLogic.getRegulator() != null) {
                Regulator regulator = stationLogic.getRegulator();
                data.add(new Table("رگولاتور", ""));
                data.add(new Table("دمای گاز ورودی" + celciusDegree, String.valueOf(regulator.getTin() - 273.15)));
                data.add(new Table("فشار گاز ورودی" + pressureDegree, String.valueOf(regulator.getPin())));
                data.add(new Table("دمای گاز خروجی" + celciusDegree, String.valueOf(regulator.getTout() - 273.15)));
                data.add(new Table("فشار گاز خروجی" + pressureDegree, String.valueOf(regulator.getPout())));
            }
        }


    }

    @Override
    public void setOnShow() {

    }
}
