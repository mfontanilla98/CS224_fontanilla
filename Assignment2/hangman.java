import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
import java.lang.String;
import java.util.List;
import java.io.IOException;

public class hangman
{
	//Scanner scan = new Scanner(System.in);
	Scanner CPU_input = new Scanner("dictionary.txt");

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		menu(scan);
	}

	public static void menu(Scanner scnr)
	{
		String userDecision;
		int intUserDecision;

		outputMenu(scnr);

		intUserDecision = Integer.parseInt(JOptionPane.showInputDialog("What game mode would you like to play?: "));

		//System.out.println(intUserDecision + " nice");
		gameSelect(intUserDecision, scnr);
	}

	public static void outputMenu(Scanner scnr)
	{
		System.out.println("*****MENU*****");
		System.out.println("1. Vs. Computer");
		System.out.println("2. Vs. Player");
		System.out.println("3. Exit Game");
		System.out.print("\n");
	}

	public static void gameSelect(int userDecision, Scanner scnr)
	{
			if (userDecision == 1)
			{
				vsComputer(scnr);
			}
			else if (userDecision == 2)
			{
				vsPlayer(scnr);
			}
			else if(userDecision == 3)
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Invalid input: Please select a game mode");
				menu(scnr);
			}
	}

	public static void vsComputer(Scanner scnr)
	{

	}

	public static void vsPlayer(Scanner scnr)
	{
		String word = JOptionPane.showInputDialog("Player 1 Enter a word: ");
		word = word.toUpperCase();
		guessingStart(word, scnr);
	}
	public static void guessingStart(String word, Scanner scnr)
	{
		boolean finished = false;
		int size = word.length();
		int numErrors = 0;
		boolean[] correctWord = new boolean[size];

		while(!finished)
		{
			printTree(numErrors, word);
			checkWordArray(correctWord, size, word);

			//input and capitalize the guess
			String guess = JOptionPane.showInputDialog("Input a guess: ");
			char charGuess = guess.charAt(0);
			charGuess = Character.toUpperCase(charGuess);

			//check if the guess is in the word
			for (int i = 0; i < size; i++)
			{
				if (charGuess == (word.charAt(i)))
				{
					correctWord[i] = true;
				}
			}

			//if the guess is not in the word increment numErrors
			int inWord = word.indexOf(charGuess);
			if (inWord == -1)
			{
				numErrors++;
			}

			//when the word is completely guessed, exit game
			if (checkBoolArray(correctWord) == true)
			{
				checkWordArray(correctWord, size, word);
				System.out.println("Congratulations! You won!");
				finished = true;
			}
		}
	}

	public static void checkWordArray(boolean[] correctWord, int size, String word)
	{
		//empty word to be guessed
		for (int i = 0; i < size; i ++)
		{
			if (correctWord[i] == true)
				System.out.print(" " + word.charAt(i)+ " ");
			else
				System.out.print(" _ ");
		}
		System.out.println("\n\n");
	}

	public static boolean checkBoolArray(boolean[] correctWord)
	{
		for (boolean value : correctWord)
		{
        if (!value)
            return false;
    }
    return true;
	}

	public static void printTree(int numErrors, String word)
	{
		if (numErrors == 0)
		{
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("___");
			System.out.println("Here's how many errors you have: " + numErrors);
		}
		else if (numErrors == 1)
		{
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("___");
			System.out.println("Here's how many errors you have: " + numErrors);
		}
		else if (numErrors == 2)
		{
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |         |");
			System.out.println(" |         |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("___");
			System.out.println("Here's how many errors you have: " + numErrors);
		}
		else if (numErrors == 3)
		{
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |        \\|");
			System.out.println(" |         |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("___");
			System.out.println("Here's how many errors you have: " + numErrors);
		}
		else if (numErrors == 4)
		{
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |        \\|/");
			System.out.println(" |         |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("___");
			System.out.println("Here's how many errors you have: " + numErrors);
		}
		else if (numErrors == 5)
		{
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |        \\|/");
			System.out.println(" |         |");
			System.out.println(" |        /");
			System.out.println(" |");
			System.out.println("___");
			System.out.println("Here's how many errors you have: " + numErrors);
		}
		else if (numErrors == 6)
		{
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |        \\|/");
			System.out.println(" |         |");
			System.out.println(" |        / \\");
			System.out.println(" |");
			System.out.println("___");
			System.out.println("Sorry. You lost.");
			System.out.println("The word was: " + word);
			System.exit(0);
		}
	}
}
