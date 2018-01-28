package ir.behinehsazan.gasStation.model.gas;

import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;

public class BaseGasTest {
    public static void main(String[] args) {
        Double[] component = {0.057, 0.076, 0.812, 0.043, 0.009, 0.0015, 0.0015, 0., 0., 0.
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        double sum = MathCalculation.listSum(component);
        for (int i = 0; i < component.length; i++) {
            component[i] = component[i] / sum;
        }

        for(int j = 0; j<250; j++) {
            BaseGas gas = new Gas();
            Double P = j * 6.89476 + 101.235;
            Double T = 273.15 + 8;



            gas.calculate(P, T, component);
            System.out.println(j + "   " + Math.round(P - 101.235) +  "   " + gas.getT_h());
        }


    }
}
