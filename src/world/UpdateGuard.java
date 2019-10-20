package world;

import BESA.Kernell.Agent.GuardBESA;
import BESA.Kernell.Agent.Event.EventBESA;
import data.ActionData;
import world.WorldState;

public class UpdateGuard extends GuardBESA{

    
    @Override
    public void funcExecGuard(EventBESA ebesa) {
        ActionData data = (ActionData) ebesa.getData();
        WorldState state = (WorldState)this.getAgent().getState();
        switch (data.getAction()) {
            case "clean":
                state.clean(data.getAlias());
                break;
            case "move":
                state.move(data.getAlias(), data.getX(), data.getY());
                break;
        }
    }
    
}