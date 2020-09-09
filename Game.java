//package hw0;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 
 * @author Nikolo
 *this class runs the hangman game and uses GamePanel to create all the pretty stuff that goes in, and DrawHangman to make a picture of a blue dude getting hung
 */

public class Game extends JFrame{
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	public Game(String fn) throws FileNotFoundException{
		
		JPanel gp = new GamePanel(fn);
		add(gp);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
	}
	/**
	 * this method uses the GamePanel class to create the gui for the game
	 * @param args the file given to the user
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{
	
		JFrame frame = new Game("test.txt");
		frame.setTitle("Hangman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}