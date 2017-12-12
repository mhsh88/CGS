package ir.behinehsazan.gasStation.model.pipeLine.base;

import ir.behinehsazan.gasStation.model.base.GasConsumer;
import ir.behinehsazan.gasStation.model.gas.Gas;

public class BasePipe extends GasConsumer {
    double length;
    Gas gas;
    double outerDiameter;
    double interDiameter;
    double insulationThickness;
    double insulationFactor;


    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }

    public double getOuterDiameter() {
        return outerDiameter;
    }

    public void setOuterDiameter(double outerDiameter) {
        this.outerDiameter = outerDiameter;
    }

    public double getInterDiameter() {
        return interDiameter;
    }

    public void setInterDiameter(double interDiameter) {
        this.interDiameter = interDiameter;
    }

    public double getInsulationThickness() {
        return insulationThickness;
    }

    public void setInsulationThickness(double insulationThickness) {
        this.insulationThickness = insulationThickness;
    }

    public double getInsulationFactor() {
        return insulationFactor;
    }

    public void setInsulationFactor(double insulationFactor) {
        this.insulationFactor = insulationFactor;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void calculate() {

    }
}
