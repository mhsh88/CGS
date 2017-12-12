package ir.behinehsazan.gasStation.model.heater;

import ir.behinehsazan.gasStation.model.base.GasConsumer;
import ir.behinehsazan.gasStation.model.burner.Burner;

public class Heater extends GasConsumer{
    private Burner[] burners = new Burner[3];


    public Heater(){
        setEfficiency(0.8);
    }



    public Burner[] getBurners() {
        return burners;
    }
    public Burner getBurner(int index){
        return burners[index];
    }

    public void setBurners(Burner burner, int i) {
        this.burners[i] = burner;
    }





    @Override
    public void calculate() {

    }
}
