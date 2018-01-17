package sample.model.heater;

import sample.model.base.BaseModel;
import sample.model.burner.Burner;

import java.util.ArrayList;

public class Heater extends BaseModel{
    private double efficiency = 0.8;
    private ArrayList<Burner> burners = new ArrayList<Burner>();



    public Heater(ArrayList<Burner> burners) {
        this.burners = burners;
    }

    public Heater(double efficiency, ArrayList<Burner> burners) {
        this.efficiency = efficiency;
        this.burners = burners;
    }

    public ArrayList<Burner> getBurners() {
        return burners;
    }

    public void setBurners(ArrayList<Burner> burners) {
        this.burners = burners;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
}
