//ICA2 - Functions
//Michael Fontanilla
//January 25,2019

public class Pet_test
{
   public static void main(String[] args)
   {
      // Create a Pet object.
      Pet myPet = new Pet();

      myPet.setAnimal("Dog");
      myPet.setName("Jack-Jack");
	  myPet.setAge(7);

      // Display the Animal
      System.out.println("This is my " +
                         myPet.getAnimal());

      // Display the Name
      System.out.println("His name is: " +
                         myPet.getName());

      // Display the Age
      System.out.println("He is: " +
                         myPet.getAge() + " years old.");
   }
}