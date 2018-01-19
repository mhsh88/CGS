package ir.behinehsazan.gasStation.model.station;

import ir.behinehsazan.gasStation.model.base.GasConsumer;
import ir.behinehsazan.gasStation.model.heater.Heaters;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;
import ir.behinehsazan.gasStation.model.regulator.Regulator;
import ir.behinehsazan.gasStation.model.run.Runs;

import java.util.ArrayList;

public class StationLogic extends GasConsumer {


    double stationConsumption;
    private BasePipe beforeHeater;
    private Heaters heaters;
    private BasePipe afterHeater;
    private BasePipe collector;
    private Runs runs;
    private Regulator regulator;

    ArrayList<GasConsumer> allComponent = new ArrayList<GasConsumer>();

    public void setStationConsumption(double stationConsumption) {
        this.stationConsumption = stationConsumption;
    }

    public double getStationConsumption(){
        stationConsumption = 0;
        for(GasConsumer gasConsumer: allComponent){
            stationConsumption += gasConsumer.getConsumption();
        }
        return stationConsumption;
    }
    public BasePipe getBeforeHeater() {
        return beforeHeater;
    }

    public void setBeforeHeater(BasePipe beforeHeater) {
        this.beforeHeater = beforeHeater;
    }

    public Heaters getHeaters() {
        return heaters;
    }

    public void setHeaters(Heaters heaters) {
        this.heaters = heaters;
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

    public Runs getRuns() {
        return runs;
    }

    public void setRuns(Runs runs) {
        this.runs = runs;
    }

    public Regulator getRegulator() {
        return regulator;
    }

    public void setRegulator(Regulator regulator) {
        this.regulator = regulator;
    }
    //    private ArrayList<EntityBase> allComponent = new ArrayList<EntityBase>(){{
//        add(beforeHeater);
//        add(heater);
//        add(afterHeater);
//        add(collector);
//        add(runs);
//        add(regulators);
//
//    }};



    @Override
    public void calculate() {
        if(getBeforeHeater() != null){
            getBeforeHeater().calculate();

        }else

            for(GasConsumer gasConsumer : allComponent){
                gasConsumer.calculate();
            }







    }
}
