package ir.behinehsazan.gasStation.model.burner;

import ir.behinehsazan.gasStation.model.burner.Burner;
import ir.behinehsazan.gasStation.model.gas.BaseGas;
import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;

public class BurnerTest {
    public static void main(String[] args){
//        Burner burner = new Burner();
//        System.out.println(burner.Cp_H2O.value(200));
//        System.out.println(burner.Cp_Co2.value(200));
//        System.out.println(burner.Cp_N2.value(200));
//        System.out.println(burner.Cp_O2.value(200));
        BaseGas gas = new Gas();

        Double P = 5000.0;
        Double T = 300.0;
        Double[] component = {.0, .0, 1.0, .0, .0, .0, .0, 0., 0., 0.
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        for(int i=0; i<component.length; i++){
            component[i] = component[i]/ MathCalculation.listSum(component);
        }


        gas.calculate(P, T, component);
        Burner.setTenv(30.0);

        Burner burner = new Burner((Gas) gas, 2.0, Burner.getTenv(), 300);
        burner.calculate();
        System.out.println(burner.getEfficiency());
    }
}
