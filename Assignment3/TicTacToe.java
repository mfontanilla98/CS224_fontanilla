import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame
{
	private JLabel p1Header;
	private JLabel p2Header;
	private JPanel playerPanel;
	private JPanel player1Panel;
	private JPanel p1NamePanel;
	private JPanel player2Panel;
	private JPanel p2NamePanel;
	private JPanel boardPanel;
	private JPanel optionsPanel;
	private JLabel p1Name;
	private JLabel p1Wins;
	private JLabel p1Losses;
	private JLabel p2Name;
	private JLabel p2Wins;
	private JLabel p2Losses;
	private int numWins;
	private int numLosses;
	private JButton newGame;
	private JButton reset;
	private JButton exit;
	private JButton[][] boardButtons = new JButton[3][3];
	private ButtonGroup optionsGroup;
	private ButtonGroup boardGroup;
	private JTextField player1TextField;
	private JTextField player2TextField;
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
		buildBoardPanel();

		//For the Buttons
		buildOptionsPanel();

		//Layout Type
		setLayout(new BorderLayout());
		
		//Content adder
		add(playerPanel, BorderLayout.NORTH);
		add(boardPanel, BorderLayout.CENTER);
		add(optionsPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	private void buildPlayerPanel()
	{
		p1Header = new JLabel ("Player 1 (X):");
		p1Name = new JLabel("Name: ");
		player1TextField = new JTextField(10);
		p1Wins = new JLabel ("Wins: " + numWins);
		p1Losses = new JLabel("Losses: " + numLosses);

		p2Header = new JLabel ("Player 2 (O):");
		p2Name = new JLabel("Name: ");
		player2TextField = new JTextField(10);
		p2Wins = new JLabel ("Wins: " + numWins);
		p2Losses = new JLabel("Losses: " + numLosses);

		//Name Panels
		p1NamePanel = new JPanel(new BorderLayout());
		p1NamePanel.add(p1Name, BorderLayout.WEST);
		p1NamePanel.add(player1TextField, BorderLayout.EAST);

		p2NamePanel = new JPanel(new BorderLayout());
		p2NamePanel.add(p2Name, BorderLayout.WEST);
		p2NamePanel.add(player2TextField, BorderLayout.EAST);


		//Player 1
		player1Panel = new JPanel(new GridLayout(4, 1));
		player1Panel.add(p1Header);
		player1Panel.add(p1NamePanel);
		player1Panel.add(p1Wins);
		player1Panel.add(p1Losses);

		//Player 2
		player2Panel = new JPanel(new GridLayout(4, 1));
		player2Panel.add(p2Header);
		player2Panel.add(p2NamePanel);
		player2Panel.add(p2Wins);
		player2Panel.add(p2Losses);

		//Final Panel
		playerPanel = new JPanel(new BorderLayout());
		playerPanel.add(player1Panel, BorderLayout.WEST);
		playerPanel.add(player2Panel, BorderLayout.EAST);
		


	}

	private void buildBoardPanel()
	{
		//Add buttons to boardPanel
		boardPanel = new JPanel(new GridLayout(3,3));
		for(int rows = 0; rows < 3; rows++)
		{
			for(int columns = 0; columns < 3; columns++)
			{
				boardButtons[rows][columns] = new JButton();
				boardPanel.add(boardButtons[rows][columns]);
			}
		}
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

		/*Option Listeners
		newGame.addActionListener(new OptionsListener());
		reset.addActionListener(new OptionsListener());
		exit.addActionListener(new OptionsListener());*/

		optionsPanel = new JPanel();
		optionsPanel.add(newGame);
		optionsPanel.add(reset);
		optionsPanel.add(exit);
	}

	/*Option Button Listner Class
	private class OptionsListener implements ActionListener
	{
		public void optionPerformed(ActionEvent option)
		{
			if(options.getSource() == newGame)
			{
				//Reset whole game
			}
			else if(options.getSource() == reset)
			{
				//Reset Game
			}
			else if(options.getSource() == exit)
			{
				/Exit Game
			}
		}
	}*/


	public static void main(String[] args)
	{
		new TicTacToe();
	}
}