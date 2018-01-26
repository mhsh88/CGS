package ir.behinehsazan.gasStation.model.pipeLine;

import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;
import ir.behinehsazan.gasStation.model.pipeLine.base.BasePipe;

public class BasePipeTest {

    public static void main(String[] args){

        Gas gas = new Gas();

        Double P = 5000.0;
        Double T = 300.0;
        Double[] component = {0., 0., 1.0,  0., 0., 0., 0., 0., 0., 0.
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        for(int i=0; i<component.length; i++){
            component[i] = component[i]/ MathCalculation.listSum(component);
        }


        gas.calculate(P, T, component);

        BasePipe pipe = new BasePipe();
        pipe.setTenv(20 + 273.15);
        pipe.setVair(10.0);

//        pipe.setTout(273.15 + 20);
//        pipe.setPout(7000.0);
        pipe.setTin(273.15 + 15);
        pipe.setPin(8101.235);
        pipe.setGas(gas);
        pipe.setOuterDiameter(.21);
        pipe.setInterDiameter(0.20);
        pipe.setDebi(40000.0);
        pipe.setLength(45);
        pipe.setInsulationThickness(.05);
        pipe.setInsulationFactor(5);
        pipe.setInverse(false);
        pipe.calculate();

        System.out.println(pipe.getTin());
        System.out.println(pipe.getTout());
        System.out.println(pipe.getPin());
        System.out.println(pipe.getPout());
        System.out.println(pipe.getConsumption());


    }
}
