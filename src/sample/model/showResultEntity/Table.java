package sample.model.showResultEntity;

import javafx.beans.property.SimpleStringProperty;

public class Table {

    private final SimpleStringProperty name;
    private final SimpleStringProperty value;

    public Table(SimpleStringProperty name, SimpleStringProperty value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }
}
