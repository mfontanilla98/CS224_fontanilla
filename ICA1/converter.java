//ICA1 - Functions
//Michael Fontanilla
//January 25/2019

import java.util.Scanner;

public class converter
{
   public static void main(String[] args)
   {
	Scanner scan = new Scanner(System.in);
    
	double meters = -1;
	int userDecision = 0;

    System.out.println("This program converts meters to kilometers, inches, or feet.\n");

	while(meters < 0)
	{
		System.out.print("How many meters would you like to convert: ");
		meters = scan.nextDouble();
		if(meters > 0){
			System.out.println("Your input: " + meters + " meters\n");
			break;
		}
		else
		{
			System.out.println("Please only input positive numbers.");
		}

	}

		while(userDecision > 0 | userDecision < 5)
		{
						menu();						

						System.out.print("Enter your decision: ");
						userDecision = scan.nextInt();
						System.out.print("\n");
		
						if(userDecision == 1)
						{
							showKilometers(meters);
						}
						else if(userDecision == 2)
						{
							showInches(meters);
						}
						else if(userDecision == 3)
						{
							showFeet(meters);
						}
						else if(userDecision == 4)
						{
							break;
						}
						else
						{
							System.out.println("Error: Only Enter 1-4 for your decision\n");
						}	
		}

	
	System.out.println("Bye!");

	}  /*-------End Main----------*/

	

	public static void menu()
	{
		 System.out.println("What would you like to convert to?");
		 System.out.println("1. Convert to kilometers\n2. Convert to inches\n3. Convert to feet\n4. Quit the program\n");
	}

	public static void showKilometers(double m)
	{
		double kilometers = m * 0.001;
		System.out.println(m + " meters is " + kilometers + " kilometers\n");
	}

	public static void showInches(double m)
	{
		double inches = m * 39.37;
		System.out.println(m + " meters is " + inches + " inches\n");
	}

	public static void showFeet(double m)
	{
		double feet = m * 3.281;
		System.out.println(m + " meters is " + feet + " feet\n");
	}

}

	


	


