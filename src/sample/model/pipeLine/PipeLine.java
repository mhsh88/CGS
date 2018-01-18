package sample.model.pipeLine;

import sample.controller.afterHeater.AfterHeaterController;
import sample.model.base.BaseModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PipeLine extends BaseModel{
    private final static Map<String, PipeSize> sizeSelection = new HashMap<String, PipeSize>() {
        {

            put("2", new PipeSize(3.9, 60.3));

            put("3", new PipeSize(5.5, 88.9));

            put("4", new PipeSize(6.02, 114.3));
            put("6", new PipeSize(7.11, 168.30));
            put("8", new PipeSize(8.18, 219.10));
            put("10", new PipeSize(9.27, 273.10));
            put("12", new PipeSize(9.53, 323.90));
            put("16", new PipeSize(9.53, 406.40));
            put("20", new PipeSize(9.53, 508));
            put("24", new PipeSize(9.53, 610));
            put("30", new PipeSize(9.53, 762));


        }
    };

    Double OD;
    Double ID;
    Double length;
    Double lineThickness;
    Double insulationThickness;
    Double insulationFactor;
    String size;
    private PipeSize pipeSize;
    public PipeLine(String size, double length){
        this.size = size;
        this.length = length;
        this.insulationFactor = 0.0;
        this.insulationThickness = 0.0;
        this.pipeSize = sizeSelection.get(getSize());

    }


    public PipeLine(Double OD, Double ID, Double lineThickness, Double insulationThickness, Double insulationFactor) {
        this.OD = OD;
        this.ID = ID;
        this.lineThickness = lineThickness;
        this.insulationThickness = insulationThickness;
        this.insulationFactor = insulationFactor;
    }

    public static Map<String, PipeSize> getSizeSelection() {
        return sizeSelection;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getOD() {
        return OD;
    }

    public void setOD(Double OD) {
        this.OD = OD;
    }

    public Double getID() {
        return ID;
    }

    public void setID(Double ID) {
        this.ID = ID;
    }

    public Double getLineThickness() {
        return lineThickness;
    }

    public void setLineThickness(Double lineThickness) {
        this.lineThickness = lineThickness;
    }

    public Double getInsulationThickness() {
        return insulationThickness;
    }

    public void setInsulationThickness(Double insulationThickness) {
        this.insulationThickness = insulationThickness;
    }

    public Double getInsulationFactor() {
        return insulationFactor;
    }

    public void setInsulationFactor(Double insulationFactor) {
        this.insulationFactor = insulationFactor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PipeLine)) return false;
        PipeLine pipeLine = (PipeLine) o;
        return Objects.equals(getOD(), pipeLine.getOD()) &&
                Objects.equals(getID(), pipeLine.getID()) &&
                Objects.equals(getLineThickness(), pipeLine.getLineThickness()) &&
                Objects.equals(getInsulationThickness(), pipeLine.getInsulationThickness()) &&
                Objects.equals(getInsulationFactor(), pipeLine.getInsulationFactor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOD(), getID(), getLineThickness(), getInsulationThickness(), getInsulationFactor());
    }
}
