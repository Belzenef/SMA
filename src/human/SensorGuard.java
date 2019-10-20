package human;

import BESA.ExceptionBESA;
import BESA.Kernell.Agent.GuardBESA;
import BESA.Kernell.Agent.StateBESA;
import BESA.Kernell.Agent.Event.DataBESA;
import BESA.Kernell.Agent.Event.EventBESA;
import BESA.Kernell.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import human.HumanState;
import data.ActionData;
import data.SensorData;
import world.UpdateGuard;

public class SensorGuard extends GuardBESA{

    @Override
    public boolean funcEvalBool(StateBESA objEvalBool) {
        return true;
    }
    
    @Override
    public void funcExecGuard(EventBESA ebesa) {
        SensorData data = (SensorData) ebesa.getData();
        HumanState hs = (HumanState) this.getAgent().getState();
        
        DataBESA dataAction;
        dataAction = new ActionData(this.getAgent().getAlias(), "clean");
        EventBESA event = new EventBESA(UpdateGuard.class.getName(), dataAction);
        AgHandlerBESA ah;
        try {
            ah = getAgent().getAdmLocal().getHandlerByAlias("WORLD");
            ah.sendEvent(event);
        } catch (ExceptionBESA e) {
            ReportBESA.error(e);
        }
    }
    
}