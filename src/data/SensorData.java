package data;

import java.util.ArrayList;
import java.util.List;

import BESA.Kernell.Agent.Event.DataBESA;
import model.WorldObject;

public class SensorData extends DataBESA{
    private List<WorldObject> dust;

    public SensorData() {
        dust = new ArrayList<>();
    }

    public SensorData(List<WorldObject> dust) {
        this.dust = dust;
    }

    public List<WorldObject> getDust() {
        return dust;
    }

    public void setDust(List<WorldObject> dust) {
        this.dust = dust;
    }
    
}