do
{
	//Get the three test scores
	System.out.print("Enter score #1: ");
	score1 = keyboard.nextDouble();
	System.out.print("Enter score #2: ");
	score2 = keyboard.nextDouble;
	System.out.print("Enter score #3: ");
	score3 = keyboard.nextDouble();

	//Calculate and print the average test score.
	average = (score1 + score2 + score3) / 3.0;
	System.out.println("THe average is " + average);
	System.out.println();
	
	//Does the user want to average another set?
	System.out.println("Would you like to average another set of test scores?");
	System.out.print("Enter Y for yes or N for no: ");
	input = keyboard.next();
	repeat = input.charAt(0);
} while (repeat == 'Y' || repeat == 'y');