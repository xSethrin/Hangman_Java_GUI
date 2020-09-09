//package hw0;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
/**
 * This class draws the GameFram as well as creates arrays for the text file of words, the array list for the answer, and the array list for the to guess
 * It also contains an action listener that checks for valid input, and whether the input is right or wrong for the game
 * selected shape.
 * @author NIKOLO
 *
 */
public class GamePanel extends JPanel{ 
	
	
	static ArrayList <Character> toGuess = new <Character> ArrayList();
	static ArrayList <Character> answer = new <Character> ArrayList();
	int count;
	int count2;
	String guessedLetters = "";
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JLabel wordTo = new JLabel ("Word to guess ");
	private JLabel guessLabel = new JLabel("Guess a letter ");
	private JLabel guessedLabel = new JLabel("Guessed Letters ");
	private JTextField blankField = new JTextField(10);
	private JTextField guessedLetterField = new JTextField(10);
	private JTextField letterField = new JTextField(10);
	private JButton button = new JButton ("Submit Letter");
	private DrawHangman drawHangman;
	private JLabel wrong = new JLabel ("You loose!  The word was: ");
	private JLabel right = new JLabel ("You won!  Yay!");
	private JFrame frame = new JFrame();


/**
 * this method creates the array of words from the file give via the user
 * @param f
 * @throws FileNotFoundException
 */
	public void createWords(String f) throws FileNotFoundException{

		ArrayList <String> words = new <String> ArrayList (); 
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(new File(f));
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			words.add(line);
			}
		getWord(words, answer); //method that grabs the word to guess
		fillBlanks(toGuess, answer); // method that fills in the guessing array with _
	}
/**
 * 
 * @param words
 * @param answer
 * 
 * creates word to guess array
 */
	
	public static void getWord(ArrayList <String> words, ArrayList <Character> answer) {
		Random randomNum = new Random();
		int r = randomNum.nextInt(words.size() - 1);
		char c;
		String randomWord = words.get(r);
		for (int i = 0; i < randomWord.length(); i++) {
			c = randomWord.charAt(i);
			answer.add(i, c);
		}
	}
/**
 * adds _ to array list toGuess
 * @param toGuess
 * @param answer
 */
	public static void fillBlanks (ArrayList <Character> toGuess, ArrayList <Character> answer) {
		int l = answer.size();
		for (int i = 0; i < l; i++) {
			toGuess.add('_');
		}
	}
/**
 * creates game panel
 * @throws FileNotFoundException 
 */
	
	public GamePanel(String filename) throws FileNotFoundException{
		createWords(filename);
		JPanel panel = new JPanel();
		panel.add(wordTo);
		panel.add(blankField);
		blankField.setEditable(false);
		blankField.setText(toGuess.toString().replace("[", "").replace(",","").replace("]", ""));
		JPanel panel2 = new JPanel();
		JLabel wordHas = new JLabel ("The word to guess has " + toGuess.size() + " letters.  Good luck!");
		panel2.add(wordHas);
		JPanel panel3 = new JPanel();
		panel3.add(guessLabel);
		panel3.add(letterField);
		panel3.add(button);
		ActionListener submit = new SubmitLetterAction();
		button.addActionListener(submit);
		JPanel panel4 = new JPanel();
		panel4.add(guessedLabel);
		panel4.add(guessedLetterField);
		guessedLetterField.setEditable(false);
		guessedLetterField.setText(guessedLetters);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));//vertical
		setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
	
	}

/**
 * checks for vaild input and updates guessedLetters and toGuess array
 * @author Nikolo
 *
 */
	private class SubmitLetterAction implements ActionListener{
		
			public void actionPerformed(ActionEvent event){
				
				JLabel word = new JLabel (answer.toString().replace("[", "").replace(",","").replace("]", "").replace(" ", ""));
				int length = toGuess.size();
				String letter = letterField.getText().toLowerCase();//get the text from your field that holds the user’s guess.
				letterField.setText("");
				if(letter.length()!=1){//then more than one character
		        	JOptionPane.showMessageDialog(frame, "You need to guess one letter ");
					letterField.setText(letter);
				}
				else{//it was only one character
					Character ch = new Character(letter.charAt(0));
				          if(!Character.isLetter(ch)){//not a letter
				        	  JOptionPane.showMessageDialog(frame, "You need to guess one letter ");
				        	  letterField.setText(letter);	
				        	  }
				          else{//it was a letter
				                   if(guessedLetters.indexOf(letter)!= -1) {//they guessed it already
				                	   JOptionPane.showMessageDialog(frame,"You already guessed that letter ");
				                	   letterField.setText(letter);
				                   }
				          else{//they have not guessed this letter yet
				                             guessedLetters = guessedLetters + " " + letter;
				                             guessedLetterField.setText(guessedLetters);
				                             revalidate();
				                             repaint();
				                             //display guessedLetter
				                             if(answer.contains(ch)){
				                            	 for(int i = 0; i <= length - 1; i++) {
				                            		 if ((char)ch == answer.get(i)) {
				                            			 toGuess.set(i, ch);
				                            			 blankField.setText(toGuess.toString().replace("[", "").replace(",","").replace("]", ""));
				                            			 revalidate();
				                            			 repaint();
				                            			 count2++;
				                            			 if (count2 == answer.size()) {
				                            				 right.setFont(new Font ("", Font.PLAIN, 30));
				                            				 panel6.add(right);
				                            				 button.setEnabled(false);
				                            				 revalidate();
				                            				 repaint();
				                            			 }
				                            				 
				                            		 }
				                            	 }
				                             }
				                             else{//wrong guess
				                            	 if (count != 0) {
				                            		 panel5.remove(drawHangman);
				                            	 }
				                            	 count ++;
				                            	 drawHangman = new DrawHangman(count);
				                 				 drawHangman.setPreferredSize(new Dimension(500, 500));
				                 				 revalidate();
				                 				 repaint();
				                 				 panel5.add(drawHangman);
				                 				 if (count == 7) {
				                 					 wrong.setFont(new Font ("", Font.PLAIN, 30));
				                 					 word.setFont(new Font ("", Font.PLAIN, 30));
				                 					 panel6.add(wrong);
				                 					 panel6.add(word);
				                 					 button.setEnabled(false);
				                 					 revalidate();
				                 					 repaint();
				                 					 
				                 				 }
				                             }
				                   }
				          }
				}
			}
		}
}