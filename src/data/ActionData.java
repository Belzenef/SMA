package data;

import BESA.Kernell.Agent.Event.DataBESA;

public class ActionData extends DataBESA {
	
    String alias;
    String action;
    
    public ActionData(String alias, String action) {
        this.alias = alias;
        this.action = action;
    }
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
}
