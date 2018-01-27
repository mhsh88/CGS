package ir.behinehsazan.gasStation.model.heater;

import ir.behinehsazan.gasStation.model.base.GasConsumer;

import java.util.ArrayList;

public class Heaters extends GasConsumer{

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
        for(Heater h : heaters){
            h.calculate();
        }

    }
}
