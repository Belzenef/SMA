import BESA.ExceptionBESA;
import BESA.Kernell.Agent.PeriodicGuardBESA;
import BESA.Kernell.Agent.StructBESA;
import BESA.Kernell.Agent.Event.EventBESA;
import BESA.Kernell.System.AdmBESA;
import BESA.Kernell.System.Directory.AgHandlerBESA;
import BESA.Util.PeriodicDataBESA;
import human.HumanAgent;
import human.HumanState;
import human.SensorGuard;
import world.GameGuard;
import world.SubscribeGuard;
import world.UpdateGuard;
import world.WorldAgent;
import world.WorldState;

public class Run {

    public static int GAME_PERIODIC_TIME = 1000;
    public static int GAME_PERIODIC_DELAY_TIME = 100;
    
    public static void main(String[] args) throws ExceptionBESA {
        
        
        AdmBESA admLocal = AdmBESA.getInstance();
        
        
        WorldState ws = new WorldState(11, 11);
        StructBESA wrlStruct = new StructBESA();
        wrlStruct.addBehavior("WorldBehavior");
        wrlStruct.bindGuard("WorldBehavior", GameGuard.class);
        wrlStruct.addBehavior("ChangeBehavior");
        wrlStruct.bindGuard("ChangeBehavior", SubscribeGuard.class);
        wrlStruct.bindGuard("ChangeBehavior", UpdateGuard.class);
        WorldAgent wa = new WorldAgent("WORLD", ws, wrlStruct, 0.91);
        wa.start();
        
        
        
        HumanState c1State =a new HumanState(11);
        StructBESA c1Struct = new StructBESA();
        c1Struct.addBehavior("playerPerception");
        c1Struct.bindGuard("playerPerception", SensorGuard.class);
        HumanAgent Human1 = new HumanAgent("C1", c1State, c1Struct, 0.91);
        Human1.start();
        
        HumanState c2State = new HumanState(11);
        StructBESA c2Struct = new StructBESA();
        c2Struct.addBehavior("playerPerception");
        c2Struct.bindGuard("playerPerception", SensorGuard.class);
        HumanAgent Human2 = new HumanAgent("C2", c2State, c2Struct, 0.91);
        Human2.start();
        
        
        
        PeriodicDataBESA data  = new PeriodicDataBESA(GAME_PERIODIC_TIME, GAME_PERIODIC_DELAY_TIME, PeriodicGuardBESA.START_PERIODIC_CALL);
        EventBESA startPeriodicEv = new EventBESA(GameGuard.class.getName(), data);
        AgHandlerBESA ah = admLocal.getHandlerByAlias("WORLD");
        ah.sendEvent(startPeriodicEv);
        
        
    }

}