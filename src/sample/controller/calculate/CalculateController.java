package sample.controller.calculate;

import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import ir.behinehsazan.gasStation.model.station.StationLogic;
import javafx.scene.control.Alert;
import sample.controller.base.BaseController;
import sample.model.Station;
import sample.model.heaters.HeatersModel;
import sample.model.pipeLine.PipeLine;
import sample.model.run.Runs;
import sample.model.stationProperties.StationPropertice;

public class CalculateController extends BaseController{
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



            StationLogic stationLogic = new StationLogic();
            Gas gas = new Gas();
            gas.setComponent(stationPropertice.getComponent());
            stationLogic.setGas(gas);
            stationLogic.setTenv(stationPropertice.getEnvironmentTemp());
            stationLogic.setTin(stationPropertice.getInputTemp());
            stationLogic.setPin(stationPropertice.getInputPressure());
            stationLogic.setTout(stationPropertice.getOutputTemp());
            stationLogic.setPout(stationPropertice.getOutputPressure());

            stationLogic.setRegulator();

            stationLogic.setRuns(runs);
            stationLogic.setCollector(runs);

            stationLogic.setBeforeHeater(beforeHeaterPipeLine);


            stationLogic.setAfterHeater(afterHeaterPipeLine);

            stationLogic.setHeaters(heatersModel);

            station.setStationLogic(stationLogic);
            state = true;


        }


        return state;





    }
}
