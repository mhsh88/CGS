package ir.behinehsazan.gasStation.model.pipeLine;

import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;

public class BasePipeTest {

    public static void main(String[] args){

        Gas gas = new Gas();

        Double P = 5000.0;
        Double T = 300.0;
        Double[] component = {0.057, 0.076, 0.812, 0.043, 0.009, 0.0015, 0.0015, 0., 0., 0.
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        for(int i=0; i<component.length; i++){
            component[i] = component[i]/ MathCalculation.listSum(component);
        }


        gas.calculate(P, T, component);

        BasePipe pipe = new BasePipe();
        pipe.setTenv(30 + 273.15);
        pipe.setVair(10.0);

        pipe.setTout(273.15 + 20);
        pipe.setPout(7000.0);
        pipe.setGas(gas);
        pipe.setOuterDiameter(.4);
        pipe.setInterDiameter(0.38);
        pipe.setDebi(4000.0);
        pipe.setLength(20);
        pipe.setInsulationThickness(.05);
        pipe.setInsulationFactor(100);
        pipe.setInverse(true);
        pipe.calculate();


        System.out.println(pipe.getTout());


    }
}
