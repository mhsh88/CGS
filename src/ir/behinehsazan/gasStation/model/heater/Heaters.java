package ir.behinehsazan.gasStation.model.heater;

import ir.behinehsazan.gasStation.model.base.GasConsumer;

import java.util.ArrayList;

public class Heaters extends GasConsumer{

    ArrayList<Heater> heaters = new ArrayList<Heater>();

    @Override
    public void calculate() {
        for(Heater h : heaters){
            h.calculate();
        }

    }
}
