package sample.model.pipeLine;

import java.util.Objects;

public class PipeLine {

    Double OD;
    Double ID;
    Double lineThickness;
    Double insulationThickness;
    Double insulationFactor;

    public PipeLine(Double OD, Double ID, Double lineThickness, Double insulationThickness, Double insulationFactor) {
        this.OD = OD;
        this.ID = ID;
        this.lineThickness = lineThickness;
        this.insulationThickness = insulationThickness;
        this.insulationFactor = insulationFactor;
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
