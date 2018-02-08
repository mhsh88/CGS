package main.java.ir.behinehsazan.gasStation.model.heater;

import main.java.ir.behinehsazan.gasStation.model.base.GasConsumer;
import main.java.ir.behinehsazan.gasStation.model.burner.Burner;

import java.util.ArrayList;

public class Heater extends GasConsumer {
    private ArrayList<Burner> burners = new ArrayList<>();


    public Heater(){
        setEfficiency(0.8);
    }



    public ArrayList<Burner> getBurners() {
        return burners;
    }
    public ArrayList<Burner> getBurner(){
        return burners;
    }

    public void setBurners(Burner burner) {
        this.burners.add(burner);
    }





    @Override
    public void calculate() {
        for(Burner burner : burners){
            burner.calculate();
        }

    }
}
