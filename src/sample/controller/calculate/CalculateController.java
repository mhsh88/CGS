package sample.controller.calculate;

import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import ir.behinehsazan.gasStation.model.station.StationLogic;
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
            StationLogic stationLogic = new StationLogic();
            Gas gas = new Gas();
            gas.setComponent(stationPropertice.getComponent());
            stationLogic.setGas(gas);

            if(afterHeaterPipeLine != null){
                BasePipe afterHeaterPipeLineLogic = new BasePipe(stationPropertice.getInputTemp(),
                        stationPropertice.getInputPressure(),
                        gas, afterHeaterPipeLine.getOD(), afterHeaterPipeLine.getID(), afterHeaterPipeLine.getLength(),
                        stationPropertice.getDebi(), afterHeaterPipeLine.getInsulationThickness(),
                        afterHeaterPipeLine.getInsulationFactor(), false);
                afterHeaterPipeLineLogic.calculate();




            }


        }


        return state;





    }
}
