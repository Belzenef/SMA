package world;

import java.util.ArrayList;
import java.util.List;

import BESA.Kernell.Agent.StateBESA;
import model.Map;

public class WorldState extends StateBESA{
	
	private Map map;
    private List<String> humanAlias;
    
    public WorldState(int size, int numOfDust) {
        map = new Map(size, fire);
        botsAlias = new ArrayList<>();
        Map.openInJFrame(map, 618, 618);
    }
    
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<String> getBotsAlias() {
        return botsAlias;
    }

    public void setBotsAlias(List<String> botsAlias) {
        this.botsAlias = botsAlias;
    }

    public void clean(String alias) {
        map.clean(alias);
    }

    public void move(String alias, int x, int y) {
        map.move(alias,x,y);
    }

}
