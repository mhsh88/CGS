package ir.behinehsazan.gasStation.model.heater;

import ir.behinehsazan.gasStation.model.base.Base;
import ir.behinehsazan.gasStation.model.base.Consumption;
import ir.behinehsazan.gasStation.model.burner.Burner;

public class Heater extends Consumption implements Base{
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
