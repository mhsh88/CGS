package ir.behinehsazan.gasStation.model.gas;

import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;

public class BaseGasTest {
    public static void main(String[] args) {
        BaseGas gas = new Gas();

        Double P = 5000.0;
        Double T = 300.0;
        Double[] component = {0.057, 0.076, 0.812, 0.043, 0.009, 0.0015, 0.0015, 0., 0., 0.
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        for(int i=0; i<component.length; i++){
            component[i] = component[i]/ MathCalculation.listSum(component);
        }


        gas.calculate(P, T, component);


    }
}
