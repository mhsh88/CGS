package main.java.ir.behinehsazan.gasStation.model.burner;

import main.java.ir.behinehsazan.gasStation.model.burner.base.BaseBurner;
import main.java.ir.behinehsazan.gasStation.model.gas.Gas;

public class Burner extends BaseBurner{


    public Burner(Gas gas, double oxygen,  double tamb, double tstack) {
        super(gas, oxygen,  tamb, tstack);
    }
}