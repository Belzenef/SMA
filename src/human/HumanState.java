package human;

import BESA.Kernell.Agent.StateBESA;

public class HumanState extends  StateBESA{
    
    int sizeMap;
    int x;
    int y;

    public HumanState(int sizeMap) {
        this.sizeMap = sizeMap;
    }

    public int getSizeMap() {
        return sizeMap;
    }

    public void setSizeMap(int sizeMap) {
        this.sizeMap = sizeMap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}