package sample.model.showResultEntity;

import javafx.beans.property.SimpleStringProperty;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Table {

    private final SimpleStringProperty name;
    private final SimpleStringProperty value;


    DecimalFormat df = new DecimalFormat("#.###");

    public Table(String name, String value) {
        df.setRoundingMode(RoundingMode.CEILING);
        try{
            value = String.valueOf(df.format(Double.parseDouble(value)));
        }
        catch (Exception e){

        }
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleStringProperty(value);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getValue() {
        return value.get();
    }

    public void setValue(String value) {
        this.value.set(value);
    }
}
