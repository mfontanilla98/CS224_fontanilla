import java.util.Scanner;
import java.util.Random;

public class hangman
{
	Scanner scan = new Scanner(System.in);

	public static void main(String args[])
	{

	}

	public static void menu()
	{
		int userDecision;

		outputMenu();
		userDecision = scan.nextInt();
		gameSelect(userDecision);
	}

	public static void outputMenu()
	{
		System.out.println("*****MENU*****");
		System.out.println("1. Vs. Computer");
		System.out.println("2. Vs. Player");
		System.out.println("3. Exit Game");
		System.out.print("\n");
		System.out.print("What game mode would you like to play?: ");
	}

	public static void gameSelect(int userDecision)
	{
		while(userDecision != 3)
		{
			if (userDecision == 1)
			{
				vsComputer();
			}
			else if (userDecision == 2)
			{
				vsPlayer();
			}
			else if(userDecision == 3)
			{
				break;
			}
			else
			{
				System.out.println("Invalid input: Please select a game mode");
			}
		}
	}

	public static void vsComputer()
	{
	
	}
	
	public static void vsPlayer()
	{
	
	}

}
