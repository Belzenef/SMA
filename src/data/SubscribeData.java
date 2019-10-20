package data;

import BESA.Kernell.Agent.Event.DataBESA;

public class SubscribeData extends DataBESA{
    
    private String alias;
    
    public SubscribeData(String alias) {
        this.alias = alias;
    }
    
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
}
