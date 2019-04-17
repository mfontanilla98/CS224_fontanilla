//ICA2 - Functions
//Michael Fontanilla
//January 25,2019

import java.util.Scanner;

public class Pet
{
	private String animal;
	private String name;
	private int age;

	public void setAnimal(String pet_species)
	{
		animal = pet_species;
	}

	public void setName(String pet_name)
	{
		name = pet_name;
	}

	public void setAge(int pet_age)
	{
		age = pet_age;
	}

	public String getAnimal()
	{
		return animal;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
}