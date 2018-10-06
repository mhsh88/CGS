package ir.behinehsazan.gasStation.model.heater;

import ir.behinehsazan.gasStation.model.base.GasConsumer;
import ir.behinehsazan.gasStation.model.burner.Burner;

import java.util.ArrayList;

public class Heaters extends GasConsumer{

    public Heaters(){
        setEfficiency(1.0);
    }

    ArrayList<Heater> heaters = new ArrayList<Heater>();

    public ArrayList<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(ArrayList<Heater> heaters) {
        this.heaters = heaters;
    }

    @Override
    public void calculate() {
        for(int i = 0; i < heaters.size(); i++){
            heaters.get(i).calculate();
        }

    }


    public void componentConsumptionCal(){
        setConsumption();
        double heaterConsumption  = 0;
        double burnerConsumption = 0;
        if(heaters.size() > 0) {
            heaterConsumption = super.getConsumption() / heaters.size();
        }

        Double heaterConsum = null;
        Double burnerTempComsum = null;
        for(Heater heater : heaters){
            for(Burner burner : heater.getBurners()){
                burnerConsumption = heaterConsumption / heater.getBurners().size() / heater.getEfficiency();
                burner.setConsumption(burnerConsumption);
                burnerTempComsum = burnerTempComsum!=null?burnerTempComsum + burner.getConsumption() : new Double(burner.getConsumption());
            }
            heater.setConsumption(heaterConsumption);
            heaterConsum = heaterConsum!=null? heaterConsum + heater.getConsumption(): new Double(heater.getConsumption());

        }

        this.setConsumption(burnerTempComsum!=null?burnerTempComsum:heaterConsum!=null?heaterConsum:super.getConsumption());
    }
//    public double getConsumption(){
//        double cons = 0;
//        double totalcons = 0;
//        for(Heater heater: heaters){
//            for(Burner burner:heater.getBurners()){
//                cons += burner.getConsumption();
//            }
//            heater.setConsumption(cons);
//            totalcons += cons;
//            cons = 0;
//        }
//        if(totalcons == 0){
//         return super.getConsumption();
//        }
//        return totalcons / getEfficiency();

//    }
}
