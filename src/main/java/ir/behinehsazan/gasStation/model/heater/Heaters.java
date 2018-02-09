package ir.behinehsazan.gasStation.model.heater;

import ir.behinehsazan.gasStation.model.base.GasConsumer;

import java.util.ArrayList;

public class Heaters extends GasConsumer {

    public Heaters(){
        setEfficiency(1.0);
    }

    ArrayList<Heater> heaters = new ArrayList<Heater>();

    public ArrayList<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(ArrayList<Heater> heaters) {
        this.heaters = heaters;
    }

    @Override
    public void calculate() {
        for(int i = 0; i < heaters.size(); i++){
            heaters.get(i).calculate();
        }

    }


    public void componentConsumptionCal(){
        setConsumption();
        double heaterConsumption  = 0;
        double burnerConsumption = 0;
        if(heaters.size() > 0) {
            heaterConsumption = getConsumption() / heaters.size();
        }

        for(int i = 0; i < heaters.size(); i++){
            if(heaters.get(i).getBurners().size() > 0 && heaterConsumption > 0) {
                burnerConsumption = heaterConsumption / heaters.get(i).getBurners().size();
            }
            heaters.get(i).setConsumption(heaterConsumption);
            for(int j = 0; j < heaters.get(i).getBurners().size(); j++){
                heaters.get(i).getBurners().get(j).setConsumption(burnerConsumption);
                double tem = heaters.get(i).getBurners().get(j).getConsumption();
            }
        }
    }
    public double getConsumption(){
        double cons = 0;
        for(int i = 0; i < heaters.size(); i++){
            for(int j = 0; j < heaters.get(i).getBurners().size(); j++){
                cons += heaters.get(i).getBurners().get(j).getConsumption();
            }
        }
        if(cons == 0){
          cons = super.getConsumption();
        }
        return cons;
    }
}
