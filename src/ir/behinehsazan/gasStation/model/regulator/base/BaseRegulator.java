package ir.behinehsazan.gasStation.model.regulator.base;

import ir.behinehsazan.gasStation.model.base.GasConsumer;
import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.mathCalculation.FindRoot;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BisectionSolver;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;

public class BaseRegulator extends GasConsumer implements FindRoot {
    public BaseRegulator(){
        setEfficiency(1);
    }

    public BaseRegulator(double Pin, double T, double Pout, Gas gas, boolean inverse){
        this();
        setInverse(inverse);
        if(isInverse()){
            setTout(T);
        }else
        {
            setTin(T);
        }
        setPout(Pout);
        setPin(Pin);
        setGas(gas);

    }
    @Override
    public void calculate() {
        Gas g = getGas();
        double muuu = 1000.0;
        g.setMu(1.0);
        UnivariateFunction function = new MyFunction();
        final double relativeAccuracy = 1.0e-12;
        final double absoluteAccuracy = 1.0e-8;
        final int maxOrder = 5;
        UnivariateSolver nonBracketing = new BrentSolver(relativeAccuracy, absoluteAccuracy);


        BisectionSolver bSolver = new BisectionSolver(relativeAccuracy, absoluteAccuracy);
//        double res = bSolver.solve(100, function, 0.0, 1000000.0, 1.0);
        while( Math.abs((muuu - g.getMu()) / g.getMu()) > 10e-7) {
            if(isInverse()){
                setTin(nonBracketing.solve(100, function, 0.0, 1000000.0));
            }
            else{
                setTout(nonBracketing.solve(100, function, 0.0, 1000000.0));
            }
            muuu = (getTout() - getTin()) / (getPout() - getPin()) * 1000;
            g.calculate(getPin(), getTin());
        }

    }

    @Override
    public double function(double T2) {
        Gas g = getGas();
        double result;
        if(isInverse()){
            result = (getTout() - T2) / (getPout() - getPin()) * 1000 - g.getMu();
        }
        else
            result = (T2 - getTin()) / (getPout() - getPin()) * 1000 - g.getMu();

        return result;
    }

    class MyFunction implements UnivariateFunction {
        public double value(double x) {
            return function(x);
        }

    }
}
