package ir.behinehsazan.gasStation.model.station;

import ir.behinehsazan.gasStation.model.base.EntityBase;
import ir.behinehsazan.gasStation.model.base.GasConsumer;
import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.heater.Heater;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import ir.behinehsazan.gasStation.model.regulator.Regulator;
import ir.behinehsazan.gasStation.model.run.base.BaseRun;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Station extends GasConsumer {
    public double getStationConsumption() {
        return stationConsumption;
    }

    double stationConsumption;
    private Gas gas;
    private BasePipe beforeHeater;
    private Heater[] heater;
    private BasePipe afterHeater;
    private BasePipe collector;
    private ArrayList<BaseRun> runs;
    private ArrayList<Regulator> regulators;

//    private ArrayList<EntityBase> allComponent = new ArrayList<EntityBase>(){{
//        add(beforeHeater);
//        add(heater);
//        add(afterHeater);
//        add(collector);
//        add(runs);
//        add(regulators);
//
//    }};


    public BasePipe getBeforeHeater() {
        return beforeHeater;
    }

    public void setBeforeHeater(BasePipe beforeHeater) {
        this.beforeHeater = beforeHeater;
    }

    public Heater[] getHeater() {
        return heater;
    }

    public void setHeater(Heater[] heater) {
        this.heater = heater;
    }

    public BasePipe getAfterHeater() {
        return afterHeater;
    }

    public void setAfterHeater(BasePipe afterHeater) {
        this.afterHeater = afterHeater;
    }

    public BasePipe getCollector() {
        return collector;
    }

    public void setCollector(BasePipe collector) {
        this.collector = collector;
    }

    public ArrayList<BaseRun> getRuns() {
        return runs;
    }

    public void setRuns(ArrayList<BaseRun> runs) {
        this.runs = runs;
    }

    public ArrayList<Regulator> getRegulators() {
        return regulators;
    }

    public void setRegulators(ArrayList<Regulator> regulators) {
        this.regulators = regulators;
    }

    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }

    @Override
    public void calculate() {
//        beforeHeater.calculate();
//        stationConsumption += beforeHeater.getConstumption();
//        for(int i = 0; i<heater.length; i++){
//            heater[i].calculate();
//            stationConsumption += heater[i].getConstumption();
//        }
//        afterHeater.calculate();
//
//        stationConsumption += afterHeater.getConstumption();
//
//        collector.calculate();
//        stationConsumption += collector.getConstumption();
//
//        for(BaseRun r:runs){
//            r.calculate();
//            stationConsumption += r.getConstumption();
//        }
//
//        for(Object e : allComponent){
//             e.calculate();
//            stationConsumption += e.getConstumption();
//        }







    }
}
