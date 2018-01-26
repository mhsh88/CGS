package ir.behinehsazan.gasStation.model.regulator.base;

import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;
import ir.behinehsazan.gasStation.model.regulator.Regulator;
import ir.behinehsazan.gasStation.model.station.StationLogic;
import sample.model.Station;
import sample.model.base.BaseModel;
import sample.model.stationProperties.StationPropertice;

import java.util.Map;

public class BaseRegulatorTest {

    static Child child = new Child();
    public static void main(String[] args) {

        child.toDo();


    }

    static class Child{

        private StationPropertice stationPropertice = new StationPropertice();

    public void toDo(){

        Gas gas = new Gas();
//        Double P = 3000.0;
//        Double T = 273.15 + 8;
//        Double[] component = {0.057, 0.076, 0.812, 0.043, 0.009, 0.0015, 0.0015, 0., 0., 0.
//                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
//                , 0.};
        Double[] component = {0., 0., 100.0, 0., 0., 0., 0., 0., 0., 0.
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        for (int i = 0; i < component.length; i++) {
            component[i] = component[i] / MathCalculation.listSum(component);

        }



        stationPropertice.setComponent(component);




        stationPropertice.setInputTemp(15.0);
        stationPropertice.setInputPressure(8000.0);
        stationPropertice.setOutputPressure(3000.0);
        stationPropertice.setOutputTemp(8.0);


        Station station = Station.getInstance();
        Map<String, BaseModel> tempMap = station.getList();
        tempMap.put("stationPropertice",stationPropertice);
        stationPropertice = (StationPropertice) Station.getInstance().getList().get("stationPropertice");
        StationLogic stationLogic = new StationLogic();
        gas.setComponent(component);
        stationLogic.setGas(gas);
        System.out.println(stationPropertice.getInputTemp() + " " + stationPropertice.getInputPressure()
                + " " + stationPropertice.getOutputTemp() + " " + stationPropertice.getOutputPressure());
        System.out.println("===================================================================================");
        stationLogic.setTin(stationPropertice.getInputTemp());
        stationLogic.setPin(stationPropertice.getInputPressure());
        stationLogic.setTout(stationPropertice.getOutputTemp());
        stationLogic.setPout(stationPropertice.getOutputPressure());


        stationLogic.setRegulator();

        Regulator regulator = stationLogic.getRegulator();
        System.out.println(regulator.getTout());
        System.out.println(regulator.getTin());
        System.out.println(regulator.getPin());
        System.out.println(regulator.getPout());

        System.out.println("---------------------------------------------------------------------------");



//        gas.calculate(P, T, component);


        Regulator baseRegulator = new Regulator(8101.325, 281.15,3101.325, gas,true);
        baseRegulator.calculate();

        System.out.println(baseRegulator.getTout());

        System.out.println(baseRegulator.getTin());



//        BaseRegulator baseRegulator1 = new BaseRegulator(7000.0, baseRegulator.getTin(),2000.0, gas,false);
//        baseRegulator1.calculate();
//
//        System.out.println(baseRegulator1.getTout());
//
//        System.out.println(baseRegulator.getEfficiency());
//        System.out.println(baseRegulator.getConsumption());


    }
    }
}



