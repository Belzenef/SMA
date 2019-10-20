package model;


public class Case {
	
	private int x;
	private int y;
	private boolean smoke;
	private boolean fire;
	private boolean seat;
	private String human;
	
	public Case(int x, int y) {
		this.fire=false;
		this.smoke=false;
		this.seat=false;
		this.human="";
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getSmoke() {
		return smoke;
	}
	
	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	} 
	
	public boolean getFire() {
		return fire;
	}
	
	public void setFire(boolean fire) {
		this.fire = fire;
	} 
	
	public boolean getSeat() {
		return seat;
	}
	
	public void setSeat(boolean seat) {
		this.seat = seat;
	}
	
	public String getHuman() {
		return human;
	}
	
	public void setHuman(String human) {
		this.human = human;
	} 

}
