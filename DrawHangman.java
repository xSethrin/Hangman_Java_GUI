//package hw0;

import java.awt.*;
import javax.swing.JComponent;
/**
 * 
 * @author Nikolo
 *This class handles the drawing of the hangman
 */

public class DrawHangman extends JComponent {
	
	private int count;
	
	public DrawHangman(int count) {
		this.count = count;
	}
	/**
	 * this method draws each portion of the hangman as the count increases
	 */
	public void paintComponent(Graphics g){
		removeAll();
		setBackground(Color.WHITE);
		
		if (count == 1){
			drawGallow(g);
			
		}
		else if (count == 2) {
			drawGallow(g);
			drawHead(g);
			
		}
		else if (count == 3) {
			drawGallow(g);
			drawHead(g);
			drawBody(g);
			
		}
		else if (count == 4) {
			drawGallow(g);
			drawHead(g);
			drawBody(g);
			drawLeftArm(g);
			
		}
			
		else if (count == 5) {
			drawGallow(g);
			drawHead(g);
			drawBody(g);
			drawLeftArm(g);
			drawRightArm(g);
			
		}
		else if (count == 6) {
			drawGallow(g);
			drawHead(g);
			drawBody(g);
			drawLeftArm(g);
			drawRightArm(g);
			drawLeftLeg(g);
			
		}
		else if (count == 7) {
			drawGallow(g);
			drawHead(g);
			drawBody(g);
			drawLeftArm(g);
			drawRightArm(g);
			drawLeftLeg(g);
			drawRightLeg(g);
		}

	}
	
	/**
	 * this method draws the gallow
	 * @param g
	 */
	public void drawGallow(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(80, 30, 10, 20);
		g.setColor(Color.blue);
		g.fillRect(90, 30, 70, 10);
		g.setColor(Color.blue);
		g.fillRect(150, 40, 10, 210);
		g.setColor(Color.blue);
		g.fillRect(40, 250, 200, 10);
	}
	
	/**
	 * this method draws the head
	 * @param g
	 */
	public void drawHead(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(60, 50, 50, 50);
	}
	
	/**
	 * this method draws the body
	 * @param g
	 */
	public void drawBody(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(80, 100, 10, 60);
	}
	
	/**
	 * this method draws the left arm
	 * @param g
	 */
	public void drawLeftArm(Graphics g) {
		int[] x = {80, 55, 65, 80};
		int [] y = {110, 145, 150, 125};
		g.setColor(Color.blue);
		g.fillPolygon(x, y, x.length);
	}
	
	/**
	 * this method draws the right arm
	 * @param g
	 */
	public void drawRightArm(Graphics g) {
		int[] x1 = {90, 115, 105, 90};
		int [] y1 = {110, 145, 150, 125};
		g.setColor(Color.blue);
		g.fillPolygon(x1, y1, x1.length);
	}
	
	/**
	 * this method draws the left leg
	 * @param g
	 */
	public void drawLeftLeg(Graphics g) {
		int[] x2 = {80, 60, 70, 90};
		int [] y2 = {160, 200, 200, 160};
		g.setColor(Color.blue);
		g.fillPolygon(x2, y2, x2.length);
	}
	
	/**
	 * this method draws the right leg
	 * @param g
	 */
	public void drawRightLeg(Graphics g) {
		int[] x3 = {80, 100, 110, 90};
		int [] y3 = {160, 200, 200, 160};
		g.setColor(Color.blue);
		g.fillPolygon(x3, y3, x3.length);
	}	
}