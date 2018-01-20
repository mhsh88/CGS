package ir.behinehsazan.gasStation.model.regulator.base;

import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;

public class BaseRegulatorTest {

    public static void main(String[] args) {

        Gas gas = new Gas();

        Double P = 5000.0;
        Double T = 300.0;
        Double[] component = {0.057, 0.076, 0.812, 0.043, 0.009, 0.0015, 0.0015, 0., 0., 0.
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        for (int i = 0; i < component.length; i++) {
            component[i] = component[i] / MathCalculation.listSum(component);
        }


        gas.calculate(P, T, component);


        BaseRegulator baseRegulator = new BaseRegulator(7000.0, 273.15+15,2000.0, gas,true);
        baseRegulator.calculate();

        System.out.println(baseRegulator.getTin());

        System.out.println(baseRegulator.getTout());

        BaseRegulator baseRegulator1 = new BaseRegulator(7000.0, baseRegulator.getTin(),2000.0, gas,false);
        baseRegulator1.calculate();

        System.out.println(baseRegulator1.getTout());

        System.out.println(baseRegulator.getEfficiency());
        System.out.println(baseRegulator.getConsumption());


    }
}



