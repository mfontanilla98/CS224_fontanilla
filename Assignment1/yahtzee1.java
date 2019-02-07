/**************
Homework 1

1/27/2019

Michael Fontanilla
***************/

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class yahtzee1
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
	
		final int DICE_IN_PLAY = 5;
		int[] hand = new int[DICE_IN_PLAY];
		char playAgain = 'y';

		while (playAgain == 'y')
		{
			String keep = "nnnnn"; //setup to roll all dice in the first roll
			int turn = 1;
			while (turn < 4 && keep != "yyyyy")
			{
				//roll dice not kept
				for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
				{
					if (keep.charAt(dieNumber) != 'y')
					{
						hand[dieNumber] = rollDie();
					}
				}
				//output roll
				System.out.println("Your roll was: ");
				for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
				{
					System.out.print(hand[dieNumber] + " ");
				}
				System.out.print("\n");
				//if not the last roll of the hand prompt the user for dice to keep
				if (turn < 3)
				{
					System.out.print("enter dice to keep (y or n) ");
					keep = scan.nextLine();
				}
				turn++;
			}
			//start scoring
			//hand need to be sorted to check for straights

			sortArray(hand, DICE_IN_PLAY);
			System.out.println("Here is your sorted hand : ");
			for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
			{
				System.out.print(hand[dieNumber] + " ");
			}
			System.out.print("\n");
			//upper scorecard
			for (int dieValue = 1; dieValue <= 6; dieValue++)
			{
				int currentCount = 0;
				for (int diePosition = 0; diePosition < 5; diePosition++)
				{
					if (hand[diePosition] == dieValue)
						currentCount++;
				}
				System.out.println("Score " + (dieValue * currentCount) + " on the ");
				System.out.println(dieValue + " line\n");
			}
			//lower scorecard
			if (maxOfAKindFound(hand) >= 3)
			{
				System.out.println("Score " + totalAllDice(hand) + " on the ");
				System.out.println("3 of a Kind line\n");
			}
			else System.out.println("Score 0 on the 3 of a Kind line");

			if (maxOfAKindFound(hand) >= 4)
			{
				System.out.println("Score " + totalAllDice(hand) + " on the ");
				System.out.println("4 of a Kind line");
			}
			else System.out.println("Score 0 on the 4 of a Kind line");

			if (fullHouseFound(hand))
				System.out.println("Score 25 on the Full House line");
			else
				System.out.println("Score 0 on the Full House line");

			if (maxStraightFound(hand) >= 4)
				System.out.println("Score 30 on the Small Straight line");
			else
			if (maxStraightFound(hand) >= 5)
				System.out.println("Score 40 on the Large Straight line");
			else
				System.out.println("Score 0 on the Large Straight line");

			if (maxOfAKindFound(hand) >= 5)
				System.out.println("Score 50 on the Yahtzee line");
			else
				System.out.println("Score 0 on the Yahtzee line");

			System.out.println("Score " + totalAllDice(hand) + " on the ");
			System.out.println("Chance line");
			System.out.println("\nEnter 'y' to play again ");
			playAgain = scan.nextLine().charAt(0);
		}
		
	}
	public static int rollDie()
	//this function simulates the rolling of a single die
	{
		int max = 6;
		int min = 1;
		int die = max - min + 1;

		int roll = (int)(Math.random() * die) + min;
		return roll;
	}
	public static int maxOfAKindFound(int hand[])
	//this function returns the count of the die value occurring most in the hand
	//but not the value itself
	{
		int maxCount = 0;
		int currentCount;
		for (int dieValue = 1; dieValue <= 6; dieValue++)
		{
			currentCount = 0;
			for (int diePosition = 0; diePosition < 5; diePosition++)
			{
				if (hand[diePosition] == dieValue)
					currentCount++;
			}
			if (currentCount > maxCount)
				maxCount = currentCount;
		}
		return maxCount;
	}
	public static int totalAllDice(int hand[])
	//this function returns the total value of all dice in a hand
	{
		int total = 0;
		for (int diePosition = 0; diePosition < 5; diePosition++)
		{
			total += hand[diePosition];
		}
		return total;
	}
	public static void sortArray(int array[], int size)
	//bubble sort from  Gaddis chapter 8
	{
		boolean swap;
		int temp;

		do
		{
			swap = false;
			for (int count = 0; count < (size - 1); count++)
			{
				if (array[count] > array[count + 1])
				{
					temp = array[count];
					array[count] = array[count + 1];
					array[count + 1] = temp;
					swap = true;
				}
			}
		} while (swap);
	}
	public static int maxStraightFound(int hand[])
	//this function returns the length of the longest
	//straight found in a hand
	{
		int maxLength = 1;
		int curLength = 1;
		for (int counter = 0; counter < 4; counter++)
		{
			if (hand[counter] + 1 == hand[counter + 1]) //jump of 1
				curLength++;
			else if (hand[counter] + 1 < hand[counter + 1]) //jump of >= 2
				curLength = 1;
			if (curLength > maxLength)
				maxLength = curLength;
		}
		return maxLength;
	}
	public static boolean fullHouseFound(int hand[])
	//this function returns true if the hand is a full house
	//or false if it does not
	{
		boolean foundFH = false;
		boolean found3K = false;
		boolean found2K = false;
		int currentCount;
		for (int dieValue = 1; dieValue <= 6; dieValue++)
		{
			currentCount = 0;
			for (int diePosition = 0; diePosition < 5; diePosition++)
			{
				if (hand[diePosition] == dieValue)
					currentCount++;
			}
			if (currentCount == 2)
				found2K = true;
			if (currentCount == 3)
				found3K = true;
		}
		if (found2K && found3K)
			foundFH = true;
		return foundFH;
	}
}
