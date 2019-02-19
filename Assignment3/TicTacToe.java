import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame
{
	private JLabel p1Header;
	private JPanel playerPanel;
	private JPanel optionsPanel;
	private JLabel p1Name;
	private JLabel wins;
	private JLabel losses;
	private int numWins;
	private int numLosses;
	private JButton newGame;
	private JButton reset;
	private JButton exit;
	private JButton topLeft;
	private	JButton topMid;
	private	JButton topRight;
	private	JButton midLeft;
	private	JButton mid;
	private	JButton midRight;
	private	JButton bottomLeft;
	private	JButton bottomMid;
	private	JButton bottomRight;
	private JTextField player1TextField;
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 300;

	public TicTacToe()
	{
		setTitle ("Tic Tac Toe");

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//For the Player input
		buildPlayerPanel();

		//For the playfield
		buildBoard();

		//For the Buttons
		buildOptionsPanel();

		//Layout Type
		setLayout(new BorderLayout());
	
		//Content adder
		add(playerPanel, BorderLayout.NORTH);
		add(optionsPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	private void buildPlayerPanel()
	{
		p1Header = new JLabel ("Player 1 (X):");
		p1Name = new JLabel("Name: ");
		player1TextField = new JTextField(10);

		wins = new JLabel ("Wins: " + numWins);
		losses = new JLabel("Losses: " + numLosses);

		playerPanel = new JPanel();
		playerPanel.add(p1Header, BorderLayout.NORTH);
		playerPanel.add(p1Name, BorderLayout.NORTH);
		playerPanel.add(player1TextField, BorderLayout.NORTH);
		playerPanel.add(wins, BorderLayout.NORTH);
		playerPanel.add(losses, BorderLayout.NORTH);
	}

	private void buildBoard()
	{
		setLayout(new GridLayout());

		//Play Buttons
		topLeft = new JButton();
		topMid = new JButton();
		topRight = new JButton();
		midLeft = new JButton();
		mid = new JButton();
		midRight = new JButton();
		bottomLeft = new JButton();
		bottomMid = new JButton();
		bottomRight = new JButton();
	}

	private void buildOptionsPanel()
	{
		//Function Buttons
		newGame = new JButton("New Game");
		reset = new JButton("Reset");
		exit = new JButton("Exit");

		//Grouping option buttons
		optionsGroup = new ButtonGroup();
		optionsGroup.add(newGame);
		optionsGroup.add(reset);
		optionsGroup.add(exit);

		//Option Listeners
		newGame.addActionListener(new OptionsListener());
		reset.addActionListener(new OptionsListener());
		exit.addActionListener(new OptionsListener())

		optionsPanel = new JPanel();
		optionsPanel.add(newGame);
		optionsPanel.add(reset);
		optionsPanel.add(exit);
	}

	/****Option Button Listner Class*********/
	private class OptionsListener implements ActionListener
	{
		public void optionPerformed(ActionEvent option)
		{
			if(options.getSource() == newGame)
			{
				/*Rest whole game*/
			}
			else if(options.getSource() == reset)
			{
				/*Reset Game*/
			}
			else if(options.getSource() == exit)
			{
				/*Exit Game*/
			}
		}
	}


	public static void main(String[] args)
	{
		new TicTacToe();
	}
}