package sample.model.heaters;

import sample.model.base.BaseModel;
import sample.model.heater.Heater;

import java.util.ArrayList;

public class Heaters extends BaseModel{
    ArrayList<Heater> heaters = new ArrayList<Heater>();

    public ArrayList<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(ArrayList<Heater> heaters) {
        this.heaters = heaters;
    }

    @Override
    public String toString() {
        return "Heaters{" +
                "heaters=" + heaters +
                '}';
    }
}
