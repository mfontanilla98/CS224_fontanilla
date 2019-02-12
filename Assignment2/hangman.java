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
		outputMenu(scnr);
		String userDecision = JOptionPane.showInputDialog("Enter a number: ");

		//convert string to char and check if digit
		char charDecision = userDecision.charAt(0);
		boolean aNumber = isNumber(charDecision);

		//convert char to integer
		int intUserDecision = Character.getNumericValue(charDecision);
		if (aNumber == true)
		{
			gameSelect(intUserDecision, scnr);
		}
		else
		{
			System.out.println("Please enter a valid digit.");
			menu(scnr);
		}
	}

	public static boolean isNumber(char number)
	{
		char charNum = (char) number;
		if(!Character.isDigit(charNum))
			return false;
		return true;
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
		boolean aWord = isAlpha(word);
		if (aWord == true)
		{
			word = word.toUpperCase();
			guessingStart(word, scnr);
		}
		else
				System.out.println("Please enter a valid word.");
				vsPlayer(scnr);
	}

	public static boolean isAlpha(String name)
	{
    char[] chars = name.toCharArray();

    for (char c : chars)
		{
      if(!Character.isLetter(c))
			{
        return false;
      }
    }
    return true;
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
				System.exit(0);
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
