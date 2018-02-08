package main.java.sample.model.heaters;

import main.java.sample.model.base.BaseModel;
import main.java.sample.model.heater.HeaterModel;

import java.util.ArrayList;

public class HeatersModel extends BaseModel {
    ArrayList<HeaterModel> heaterModels = new ArrayList<HeaterModel>();

    public ArrayList<HeaterModel> getHeaterModels() {
        return heaterModels;
    }

    public void setHeaterModels(ArrayList<HeaterModel> heaterModels) {
        this.heaterModels = heaterModels;
    }

    @Override
    public String toString() {
        return "HeatersModel{" +
                "heaterModels=" + heaterModels +
                '}';
    }
}
