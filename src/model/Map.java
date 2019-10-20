package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Case;

public class Map extends JPanel{
	
	private int size;
	private int width;
	private int height;
	private List<Case> cases;
	private List<WorldObject> humans;
	
	public static void main(String[] args) {
		Map map = new Map(20,30);
		Map.openInJFrame(map,400,600);
	}
	
	public Map(int casesX, int casesY) {
		this.width=casesX;
		this.height=casesY;
		this.size=casesX*casesY;
		this.humans = new ArrayList<>();
		this.cases = new ArrayList<>();
		for (int i = 0; i < casesX; i++) {
			for (int j = 0; j < casesY; j++) {
				Case c = new Case(i,j);
				cases.add(c);
			}
		}
		for (int i = 0; i < 50; i++) {
			Random r = new Random();
			int index = r.nextInt(size);
			cases.get(index).setSeat(true);
		}
		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			int index = r.nextInt(size);
			if(!cases.get(index).getSeat()) {
				cases.get(index).setHuman("elise");
			}
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<size; i++){
        	g.setColor(Color.black);
        	g.drawLine(20*i, 0, 20*i, getHeight());
        	g.drawLine(0, 20*i, getWidth(), 20*i);
        	Case c=cases.get(i);
        	if(c.getSeat()) {g.setColor(Color.black);}
        	else if(c.getFire()) {g.setColor(Color.red);}
        	else if(c.getSmoke()) {g.setColor(Color.gray);}
        	else {g.setColor(Color.white);}
        	g.fillRect(c.getX()*20+1, c.getY()*20+1 ,19, 19);
        	if(!c.getHuman().equals("")) {
        		g.setColor(Color.green);
        		g.fillOval(c.getX()*20+5, c.getY()*20+5 ,10, 10);
        	}
        }
    }
	
	/**public void addHuman(String alias, int x, int y) {
        humans.add(new WorldObject(x, y, alias));
        Rectangle rec = new Rectangle(x*20 + (20/2), y*20 , 20/2, 20/2 );
        paintHuman.add(rec);
    }
	
    public void move(String alias, int x, int y) {
        int index = find(this.humans, alias);
        humans.get(index).setXpos(x);
        humans.get(index).setYpos(y);
        if(index!=-1){
            Rectangle rec = new Rectangle(x*20 + (20/2), y*20 , 20/2, 20/2 );
            paintHuman.set(index, rec);
            repaint();
        }        
    }
    

    private int find(List<WorldObject> humans, String alias) {
        for (int i = 0; i < humans.size(); i++) {
            if(humans.get(i).getAlias().equals(alias)){
                return i;
            }
        }
        return -1;
    }*/
    public static BufferedImage getBufferedImage(String imageFile, Component c) {
        Image image = c.getToolkit().getImage(imageFile);
        waitForImage(image, c);
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(c), image.getHeight(c), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, c);
        return(bufferedImage);
    }
    
    public static boolean waitForImage(Image image, Component c) {
        MediaTracker tracker = new MediaTracker(c);
        tracker.addImage(image, 0);
        try {
        tracker.waitForAll();
        } catch(InterruptedException ie) {}
        return(!tracker.isErrorAny());
    }
    
    public static JFrame openInJFrame(Container content, int width, int height) {
        return(openInJFrame(content, width, height, content.getClass().getName(), Color.white));
    }
    
    public static JFrame openInJFrame(Container content, int width, int height, String title, Color bgColor) {
        JFrame frame = new JFrame(title);
        frame.setBackground(bgColor);
        content.setBackground(bgColor);
        frame.setSize(width, height);
        frame.setContentPane(content);
        frame.addWindowListener(new ExitListener());
        frame.setVisible(true);
        return(frame);
    }
    
	public static class ExitListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }
    }
	
	public List<WorldObject> getBots() {
        return humans;
    }

    public void setBots(List<WorldObject> humans) {
        this.humans = humans;
    }
	

}
