/***************
Homework #3
Due Date: 2/24/19
Names: Michael Fontanilla, Ryan Hays
********************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame {

	private JTextField p1Header;
 	private JTextField p2Header;
	private String player1Name;
	private String player2Name;
	private JLabel name;
	private JLabel name2;
	private JPanel boardPanel;
	private JPanel playerPanel;
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JPanel bottomPanel;
	private JPanel buttonPanel;
	private JLabel statusLabel;
	private JLabel player1Losses;
	private JLabel player1Wins;
	private int player1WinCount = 0;
	private int player1LossCount = 0;
	private JLabel p1Wins;
	private JLabel p1Losses;
	private JLabel p2Wins;
	private JLabel p2Losses;
	private JLabel player2Losses;
	private JLabel player2Wins;
	private int player2WinCount = 0;
	private int player2LossCount = 0;
	private JButton buttonTL;    // Top left
	private JButton buttonTM;    // Top middle
	private JButton buttonTR;    // Top right
	private JButton buttonML;    // Middle left
	private JButton buttonMM;    // Middle middle
	private JButton buttonMR;    // Middle right
	private JButton buttonBL;    // Bottom left
	private JButton buttonBM;    // Bottom middle
	private JButton buttonBR;    // Bottom right
	private JButton newGameButton;
	private JButton resetButton;
	private JButton exitButton;

	private Boolean gameInPlay = false;
	private Boolean p1Turn = true;

	private Boolean p1TL = false;
	private Boolean p1TM = false;
	private Boolean p1TR = false;
	private Boolean p1ML = false;
	private Boolean p1MM = false;
	private Boolean p1MR = false;
	private Boolean p1BL = false;
	private Boolean p1BM = false;
	private Boolean p1BR = false;
	private Boolean p2TL = false;
	private Boolean p2TM = false;
	private Boolean p2TR = false;
	private Boolean p2ML = false;
	private Boolean p2MM = false;
	private Boolean p2MR = false;
	private Boolean p2BL = false;
	private Boolean p2BM = false;
	private Boolean p2BR = false;

	private Boolean checkTL = false;
	private Boolean checkTM = false;
	private Boolean checkTR = false;
	private Boolean checkML = false;
	private Boolean checkMM = false;
	private Boolean checkMR = false;
	private Boolean checkBL = false;
	private Boolean checkBM = false;
	private Boolean checkBR = false;

	private final int WINDOW_WIDTH = 500; // Window width
	private final int WINDOW_HEIGHT = 500; // Window height

	public TicTacToe()
	{
		setTitle("Tic-Tac-Toe");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//initialize the player infos
		buildPlayersPanel();

		//build the middle boardPanel to hold the TicTacToe buttons
		buildButtonsPanel();

		//build the boardPanel to hold player info
		buildPlayerPanel();

		//build bottom boardPanel to hold 3 status buttons and status bar
		buildOptionsPanel();

		// Add the info to the window
		add(boardPanel, BorderLayout.CENTER);
		add(playerPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		// Display the window.
		setVisible(true);
	}

	private void buildPlayersPanel()
	{
		p1Header = new JTextField("", 8);
		name = new JLabel("Name: ");
		p1Wins = new JLabel("Wins:");
		p1Losses = new JLabel("Losses:");
		player1Wins = new JLabel("0");
		player1Losses = new JLabel("0");

		p2Header = new JTextField("", 8);
		name2 = new JLabel("Name: ");
		p2Wins = new JLabel("Wins:");
		p2Losses = new JLabel("Losses:");
		player2Wins = new JLabel("0");
		player2Losses = new JLabel("0");

		statusLabel = new JLabel("Welcome to Tic-Tac-Toe!");
	}

	private void buildButtonsPanel()
	{
		buildButtons();

		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3));
		boardPanel.add(buttonTL);
		boardPanel.add(buttonTM);
		boardPanel.add(buttonTR);
		boardPanel.add(buttonML);
		boardPanel.add(buttonMM);
		boardPanel.add(buttonMR);
		boardPanel.add(buttonBL);
		boardPanel.add(buttonBM);
		boardPanel.add(buttonBR);
	}

	private void buildButtons()
	{
		buttonTL = new JButton();
		buttonTM = new JButton();
		buttonTR = new JButton();
		buttonML = new JButton();
		buttonMM = new JButton();
		buttonMR = new JButton();
		buttonBL = new JButton();
		buttonBM = new JButton();
		buttonBR = new JButton();

		buttonTL.addActionListener(new ButtonListener());
		buttonTM.addActionListener(new ButtonListener());
		buttonTR.addActionListener(new ButtonListener());
		buttonML.addActionListener(new ButtonListener());
		buttonMM.addActionListener(new ButtonListener());
		buttonMR.addActionListener(new ButtonListener());
		buttonBL.addActionListener(new ButtonListener());
		buttonBM.addActionListener(new ButtonListener());
		buttonBR.addActionListener(new ButtonListener());
	}

	private void buildOptionsPanel()
	{
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		statusLabel.setBorder(BorderFactory.createEtchedBorder(1));

		buildButtonPanel();
		bottomPanel.add(buttonPanel);
		bottomPanel.add(statusLabel, BorderLayout.SOUTH);
	}

	private void buildButtonPanel(){
		buttonPanel = new JPanel();

		newGameButton = new JButton("New Game");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		newGameButton.addActionListener(new ButtonListener());
		resetButton.addActionListener(new ButtonListener());
		exitButton.addActionListener(new ButtonListener());

		buttonPanel.add(newGameButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(exitButton);
	}

	private void resetGame()
	{
		clearBoard();

		statusLabel.setText("Welcome to Tic-Tac-Toe!");
		p1Header.setEditable(true);
		p2Header.setEditable(true);
		player1WinCount = 0;
		player2LossCount = 0;
		player1Wins.setText("" + player1WinCount);
		player2Losses.setText("" + player2LossCount);
		player2WinCount = 0;
		player1LossCount = 0;
		player2Wins.setText("" + player1WinCount);
		player1Losses.setText("" + player2LossCount);

		p1Header.setText("Player 1");
		p2Header.setText("Player 2");
		gameInPlay = false;
	}

	private void clearBoard()
	{
		p1TL = false;
		p1TM = false;
		p1TR = false;
		p1ML = false;
		p1MM = false;
		p1MR = false;
		p1BL = false;
		p1BM = false;
		p1BR = false;
		p2TL = false;
		p2TM = false;
		p2TR = false;
		p2ML = false;
		p2MM = false;
		p2MR = false;
		p2BL = false;
		p2BM = false;
		p2BR = false;
		checkTL = false;
		checkTM = false;
		checkTR = false;
		checkML = false;
		checkMM = false;
		checkMR = false;
		checkBL = false;
		checkBM = false;
		checkBR = false;
		buttonTL.setIcon(null);
		buttonTM.setIcon(null);
		buttonTR.setIcon(null);
		buttonML.setIcon(null);
		buttonMM.setIcon(null);
		buttonMR.setIcon(null);
		buttonBL.setIcon(null);
		buttonBM.setIcon(null);
		buttonBR.setIcon(null);

		p1Turn = true;
	}

	private void buildPlayerPanel()
	{
		playerPanel = new JPanel();
        buildPlayerOne();
        buildPlayerTwo();
        playerPanel.add(player1Panel);
        playerPanel.add(player2Panel);

	}

	private void buildPlayerOne()
	{
		player1Panel = new JPanel();
        player1Panel.setBorder(BorderFactory.createTitledBorder("Player 1 (X)"));
        player1Panel.setLayout(new GridLayout(3, 2));
        player1Panel.add(name);
        player1Panel.add(p1Header);
        player1Panel.add(p1Wins);
        player1Panel.add(player1Wins);
        player1Panel.add(p1Losses);
        player1Panel.add(player1Losses);
	}

	private void buildPlayerTwo()
	{
		player2Panel = new JPanel();
        player2Panel.setBorder(BorderFactory.createTitledBorder("Player 2 (O)"));
        player2Panel.setLayout(new GridLayout(3, 2));
        player2Panel.add(name2);
        player2Panel.add(p2Header);
        player2Panel.add(p2Wins);
        player2Panel.add(player2Wins);
        player2Panel.add(p2Losses);
        player2Panel.add(player2Losses);

	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String actionCommand = e.getActionCommand();
			switch (actionCommand) {
				case "New Game":
					player1Name = p1Header.getText();
					player2Name = p2Header.getText();

					if(player1Name.equals("") || player2Name.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Both names must be entered to start the game!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						p1Header.setEditable(false);
						p2Header.setEditable(false);
						gameInPlay = true;
						statusLabel.setText(player1Name + "'s turn");
					}   break;

				case "Reset":
					int confirm = JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", "ARE YOU SURE?", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION)
					{
						resetGame();
					}   break;

				case "Exit":
					System.exit(0);

				default:
					if(p1Turn)
					{
						turn(e, p1Turn);
					}
					else
					{
						turn(e, p1Turn);
					}   break;
			}
		}
	}

	public void checkIfWin()
	{
		if (checkTL && checkMM && checkBR)
		{
			if(p1TL && p1MM && p1BR)
                winner(1);
			else if (p2TL && p2MM && p2BR)
                winner(2);
		}
		if (checkTR && checkMM && checkBL)
		{
			if(p1TR && p1MM && p1BL)
                winner(1);
			else if (p2TR && p2MM && p2BL)
                winner(2);
		}
		if (checkTL && checkML && checkBL)
		{
			if(p1TL && p1ML && p1BL)
                winner(1);
			else if (p2TL && p2ML && p2BL)
                winner(2);
		}
		if (checkTM && checkMM && checkBM)
		{
      if(p1TM && p1MM && p1BM)
                winner(1);
			else if (p2TM && p2MM && p2BM)
                winner(2);
		}
		if (checkTR && checkMR && checkBR)
		{
			if(p1TR && p1MR && p1BR)
                winner(1);
			else if (p2TR && p2MR && p2BR)
                winner(2);
		}
		if(checkTL && checkTM && checkTR)
		{
			if(p1TL && p1TM && p1TR)
                winner(1);
			else if(p2TL && p2TM && p2TR)
                winner(2);
		}
		if(checkML && checkMM && checkMR)
		{
			if(p1ML && p1MM && p1MR)
                winner(1);
			else if (p2ML && p2MM && p2MR)
                winner(2);
		}
		if(checkBL && checkBM && checkBR)
		{
			if(p1BL && p1BM && p1BR)
                winner(1);
			else if (p2BL && p2BM && p2BR)
                winner(2);
		}
		if(checkTL && checkTM && checkTR && checkML && checkMM && checkMR && checkBL && checkBM && checkBR){ //else if all 9 buttons are presses and no one got 3 in a row
			JOptionPane.showMessageDialog(null, "Cat's Game!");
			clearBoard();
		}
	}

	private void winner(int player)
	{
		if(player == 1){
			player1WinCount++;
			player2LossCount++;
			player1Wins.setText("" + player1WinCount);
			player2Losses.setText("" + player2LossCount);
			JOptionPane.showMessageDialog(null, player1Name + " wins!");
			clearBoard();
		}
		else if(player == 2){
			player2WinCount++;
			player1LossCount++;
			player2Wins.setText("" + player2WinCount);
			player1Losses.setText("" + player1LossCount);
			JOptionPane.showMessageDialog(null, player2Name + " wins!");
			clearBoard();
		}
	}

	public void turn(ActionEvent e, Boolean turn)
	{
		if(gameInPlay)
		{
			ImageIcon XImage = new ImageIcon("X.png");
      ImageIcon OImage = new ImageIcon("O.png");
    	Image XsImage = XImage.getImage();
      Image OsImage = OImage.getImage();
      Image scaledX = XsImage.getScaledInstance((int) (buttonTL.getSize()).getWidth(), (int) (buttonTL.getSize()).getHeight(), java.awt.Image.SCALE_SMOOTH);
      Image scaledO = OsImage.getScaledInstance((int) (buttonTL.getSize()).getWidth(), (int) (buttonTL.getSize()).getHeight(), java.awt.Image.SCALE_SMOOTH);
      XImage = new ImageIcon(scaledX);
      OImage = new ImageIcon(scaledO);

      if(e.getSource() == buttonTL)
      {
        if(!checkTL)
				{
          checkTL = true;
          if(turn)
					{
            p1TL = true;
            p1Turn = false;
						buttonTL.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2TL = true;
            p1Turn = true;
						buttonTL.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
      else if(e.getSource() == buttonTM)
      {
        if(!checkTM)
				{
          checkTM = true;
          if(turn)
					{
            p1TM = true;
            p1Turn = false;
						buttonTM.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2TM = true;
            p1Turn = true;
						buttonTM.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
      else if(e.getSource() == buttonTR)
      {
        if(!checkTR)
				{
          checkTR = true;
          if(turn)
					{
            p1TR = true;
            p1Turn = false;
						buttonTR.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2TR = true;
            p1Turn = true;
						buttonTR.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
      else if(e.getSource() == buttonML)
      {
        if(!checkML)
				{
          checkML = true;
          if(turn)
					{
            p1ML = true;
            p1Turn = false;
						buttonML.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2ML = true;
            p1Turn = true;
						buttonML.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
      else if(e.getSource() == buttonMM)
      {
        if(!checkMM)
				{
          checkMM = true;
          if(turn)
					{
            p1MM = true;
            p1Turn = false;
						buttonMM.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2MM = true;
            p1Turn = true;
						buttonMM.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
      else if(e.getSource() == buttonMR)
      {
        if(!checkMR)
				{
          checkMR = true;
          if(turn)
					{
            p1MR = true;
            p1Turn = false;
						buttonMR.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2MR = true;
            p1Turn = true;
						buttonMR.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
      else if(e.getSource() == buttonBL)
      {
        if(!checkBL)
				{
          checkBL = true;
          if(turn)
					{
            p1BL = true;
            p1Turn = false;
						buttonBL.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2BL = true;
            p1Turn = true;
						buttonBL.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
            checkIfWin();
        }
      }
      else if(e.getSource() == buttonBM)
      {
        if(!checkBM)
				{
          checkBM = true;
          if(turn)
					{
            p1BM = true;
            p1Turn = false;
						buttonBM.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2BM = true;
            p1Turn = true;
						buttonBM.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
      else if(e.getSource() == buttonBR)
      {
        if(!checkBR)
				{
          checkBR = true;
          if(turn)
					{
            p1BR = true;
            p1Turn = false;
						buttonBR.setIcon(XImage);
            statusLabel.setText(player2Name + "'s turn");
          }
					else
					{
            p2BR = true;
            p1Turn = true;
						buttonBR.setIcon(OImage);
            statusLabel.setText(player1Name + "'s turn");
          }
          checkIfWin();
        }
      }
    }
	}

	public static void main(String[] args)
	{
        new TicTacToe();
  }
}
