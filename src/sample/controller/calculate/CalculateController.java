package sample.controller.calculate;

import ir.behinehsazan.gasStation.model.gas.Gas;
import javafx.scene.control.Alert;
import sample.controller.base.BaseController;
import sample.model.Station;
import sample.model.heaters.Heaters;
import sample.model.pipeLine.PipeLine;
import sample.model.run.Runs;
import sample.model.stationProperties.StationPropertice;

public class CalculateController extends BaseController{
    public boolean calculate() {
        boolean state = false;

        Station station = Station.getInstance();
        Runs runs = (Runs) station.getList().get("Runs");
        StationPropertice stationPropertice = (StationPropertice) station.getList().get("stationPropertice");
        Heaters heaters = (Heaters) station.getList().get("Heaters");
        PipeLine afterHeaterPipeLine = (PipeLine) station.getList().get("afterHeaterPipeLine");
        PipeLine beforeHeaterPipeLine = (PipeLine) station.getList().get("beforeHeaterPipeLine");
        if(stationPropertice == null){
            showAlert("خطا","خطا در اطلاعات ورودی","اطلاعات ایستگاه تکمیل نشده است", Alert.AlertType.ERROR);
            return false;
        }
        else{
            Gas gas = new Gas();
            gas.calculate(stationPropertice.getInputPressure(),stationPropertice.getInputTemp(),stationPropertice.getComponent());


        }

        return state;





    }
}
