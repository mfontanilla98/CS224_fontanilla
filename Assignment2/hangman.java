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

		System.out.println(intUserDecision + " nice");
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
		//scnr.nextLine();	//might need to remove. will allegedly catch the endline character
		guessingStart(word, scnr);
	}
	public static void guessingStart(String word, Scanner scnr)
	{
		boolean finished = false;
		int size = word.length();
		int numErrors = 0;
		boolean[] correctWord = new boolean[size];
		System.out.println(correctWord[0]);
		System.out.println(correctWord[1]);
		//while(!finished)
		//{
			for (int i = 0; i < size; i++)
			{
				if (correctWord[i] = true)
					numErrors++;
			}
			if (numErrors > 6)
			{
				System.out.println("Sorry. You lost.");
				//break;
			}
			System.out.println(" ___________");
			System.out.println(" |         |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("___");

			for (int i = 0; i < size; i ++)
			{
				System.out.print(" _ ");
			}

		//}
	}
}
