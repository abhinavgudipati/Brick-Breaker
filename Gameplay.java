import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.javafx.geom.Rectangle;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	private boolean play = false; // we are writing false because, once the game starts, the game must never play by itself
	private int score = 0;
	
	private int totalBricks = 21; 
	 
	private Timer timer; //this is with respect to how fast the ball should move
	private int delay = 8; // the delay is 8 seconds. there is delay with respect to how fast the ball must move 
	
	private int playerX = 310;
	
	private int ballposX = 120 ;
	private int ballposY = 350 ;
	private int ballXdir = -1 ;
	private int ballYdir = -2;
	
	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay , this);
		timer.start();
	}
		
	
	public void paint(Graphics2D g2) {
		
		//Graphics2D g2 = (Graphics2D) g;
		//background
		g2.setColor(Color.black);
		//g2.clear(com.sun.prism.paint.Color.BLACK);;
		g2.fillRect(1,1,692,592);
		
		//borders
		g2.setColor(Color.yellow);
		g2.fillRect(0,0,3,592);
		g2.fillRect(0,0,692,3);
		g2.fillRect(691,0,3,592);
		
		//the paddle
		g2.setColor(Color.green);
		g2.fillRect(playerX , 550 , 100 ,8);
		
		//the ball
		g2.setColor(Color.yellow);
		g2.fillOval(ballposX , ballposY , 20 ,20);
		
		g2.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) { //this is for the ActionListener 
		// TODO Auto-generated method stub
		timer.start();
		
		if(play) {
			if(new Rectangle(ballposX,ballposY,20,20).intersection(new Rectangle(playerX,550,00,8)) != null) {
				ballposY -= ballYdir;
			}
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballXdir = -ballXdir;
				
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;
				
			}
		}
		
		repaint();  
	} 

	@Override
	public void keyTyped(KeyEvent e) { // this is for the KeyListener
		}
	@Override
	public void keyReleased(KeyEvent e) {  // this is for the KeyListener
		
	}
	@Override
	public void keyPressed(KeyEvent e) { // this is for the KeyListener
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}
			else {
				moveRight();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(playerX >= 10) {
				playerX = 10;
			} 
			else {
				moveLeft();
			}
		}

	}
	
	public void moveRight() {
		 play = true;
		 playerX += 20;
	}
	public void moveLeft() {
		play = true;
		playerX -= 20;
	}
	
}

