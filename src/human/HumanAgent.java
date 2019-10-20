package human;

import java.util.Random;

import BESA.ExceptionBESA;
import BESA.Kernell.Agent.AgentBESA;
import BESA.Kernell.Agent.KernellAgentExceptionBESA;
import BESA.Kernell.Agent.StateBESA;
import BESA.Kernell.Agent.StructBESA;
import BESA.Kernell.Agent.Event.DataBESA;
import BESA.Kernell.Agent.Event.EventBESA;
import BESA.Kernell.System.Directory.AgHandlerBESA;
import BESA.Log.ReportBESA;
import human.HumanState;
import data.SubscribeData;
import world.SubscribeGuard;

public class HumanAgent extends AgentBESA {

    public HumanAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernellAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }
    
    @Override
    public void setupAgent() {
        ReportBESA.info("SETUP AGENT -> " + getAlias());
        HumanState hs = (HumanState)this.getState();
 
        DataBESA data = new SubscribeData(this.getAlias());
        EventBESA event = new EventBESA(SubscribeGuard.class.getName(), data);
        AgHandlerBESA ah;
        
        try {
            ah = this.getAdmLocal().getHandlerByAlias("WORLD");
            ah.sendEvent(event);
        } catch (ExceptionBESA e) {
            ReportBESA.error(e);
        }
    }

    @Override
    public void shutdownAgent() {
        ReportBESA.info("SHUTDOWN AGENT -> " + getAlias());
    }
    
}