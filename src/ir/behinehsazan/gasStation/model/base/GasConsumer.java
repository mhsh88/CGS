package ir.behinehsazan.gasStation.model.base;

import ir.behinehsazan.gasStation.model.gas.Gas;

public abstract class GasConsumer extends EntityBase {
    double Tin;
    double Tout;
    double Pin;
    double Pout;
    boolean Inverse = false;
    Gas gas;

    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }

    public double getPin() {
        double P;
        if(Math.abs(Pin - 0.001) < 0.01){
            P  = Pout;}
        else{
            P =  Pin;}

            return P;
    }

    public void setPin(double pin) {
        Pin = pin;
    }

    public double getPout() {
        return Pout;
    }

    public void setPout(double pout) {
        Pout = pout;
    }

    public double getTin() {
        double T;
        if(Math.abs(Tin - 0.001) < 0.01){
            T  = Tout;}
        else{
            T =  Tin;}

        return T;
    }

    public void setTin(double tin) {
        Tin = tin;
    }

    public double getTout() {
        return Tout;
    }

    public void setTout(double tout) {
        Tout = tout;
    }

    public boolean isInverse() {
        return Inverse;
    }

    public void setInverse(boolean inverse) {
        Inverse = inverse;
    }

    public double getQdot(){
        Gas g = getGas();
        
        g.calculate(g.getP_theta(), g.getT_theta());

        double P2 = g.getP();
        double Z2 = g.getZ();
        double T2 = g.getT();

        g.calculate(getPin(), getTin());
        double P1 = g.getP();
        double Z1 = g.getZ();
        double T1 = g.getT();

        double Qdot = (getDebi() / 3600) * (P2 * Z1 * T1) / (P1 * Z2 * T2);
        return Qdot;

    }
}
