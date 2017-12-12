package ir.behinehsazan.gasStation.model.station;

import ir.behinehsazan.gasStation.model.base.GasConsumer;
import ir.behinehsazan.gasStation.model.gas.Gas;

public class Station extends GasConsumer {
    private Gas gas;

    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }

    @Override
    public void calculate() {

    }
}
