package ir.behinehsazan.gasStation.model.gas;

public class BaseGasTest {
    public static void main(String[] args){
        BaseGas gas = new BaseGas();

        Double P = 5000.0;
        Double T = 300.0;
        Double[] component = new Double[21];
        for(int i=0; i<component.length; i++){
            component[i] = 1.1;
            if(i==2){
                component[i] = Double.valueOf(90);
            }
        }



        gas.calculate(P, T, component);


    }
}
