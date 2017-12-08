package ir.behinehsazan.gasStation.model.base;

public class Consumption {
    protected double constumption;
    protected double efficiency;
    protected double debi;

    public double getDebi() {
        return debi;
    }

    public void setDebi(double debi) {
        this.debi = debi;
    }



    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }


    public double getConstumption() {
        return constumption * getEfficiency();
    }

    public void setConstumption(double constumption) {
        this.constumption = constumption ;
    }



}
