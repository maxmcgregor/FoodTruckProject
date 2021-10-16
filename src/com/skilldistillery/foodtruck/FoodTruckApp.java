package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	// variables are the array to hold food truck objects &
	// a running tally of the total number of trucks in the park
	private static FoodTruck[] foodTruckPark = new FoodTruck[5];
	private static int numFoodTrucks = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;

		// a while loop to collect data and instantiate FoodTruck objects
		// loop runs while quit = false and the number of food trucks is less than 5
		while (quit == false && numFoodTrucks < 5) {
			System.out.println("User, enter a food truck name, or 'quit' if you're done.");
			String inputName = scanner.nextLine();
			if (inputName.equals("quit")) {
				quit = true;
				System.out.println();
				break;
			} else {

				String truckName = inputName;

				System.out.println();
				System.out.println("What type of food does " + inputName + " serve?");
				String inputFoodType = scanner.nextLine();

				System.out.println();
				System.out.println("What is the rating of " + inputName + " on a scale of 1-10?");
				Double inputRating = scanner.nextDouble();
				scanner.nextLine();
				System.out.println();

				FoodTruck newTruck = new FoodTruck(truckName, inputFoodType, inputRating, 0);
				foodTruckPark[numFoodTrucks] = newTruck;
				numFoodTrucks++;

			}

		}

		boolean menuLoop = true;
		// while loop runs until the user selects to quit from the menu
		while (menuLoop) {
			System.out.println("========================================");
			System.out.println("| Select 1-4 from the menu below:      |");
			System.out.println("========================================");
			System.out.println("| 1. List all existing food trucks.    |");
			System.out.println("| 2. See average rating of food trucks.|");
			System.out.println("| 3. Display highest rated food truck. |");
			System.out.println("| 4. Quit the program.                 |");
			System.out.println("========================================");
			int choice = scanner.nextInt();
			scanner.nextLine();

			// switch uses user input to determine what path to take
			// i wanted to insert clean looking methods here but ran into trouble
			// without using static methods, so I only used methods within the for loop

			switch (choice) {
			// case 1 displays all info on food trucks in the park
			case 1:
				System.out.println("======================================================");
				System.out.println("| Data on food trucks in foodTruckPark listed below: |");
				System.out.println("======================================================\n");
				for (int i = 0; i < foodTruckPark.length; i++) {
					FoodTruck currentTruck = foodTruckPark[i];
					if (currentTruck != null) {
						System.out.println(currentTruck);
					} else {
						continue;
					}
				}
				System.out.println("======================================");
				System.out.println();
				break;

			case 2:
				// case 2 displays the average rating of all trucks in the park
				// a for loop iterates across the array of FoodTrucks while
				// ignoring any null entries in the array
				// it increments a totalRating variable, a totalTrucks variable then uses those
				// to print an average rating variable
				double totalRating = 0;
				int totalTrucksInPark = 0;
				double avgRating;
				for (int i = 0; i < foodTruckPark.length; i++) {
					FoodTruck currentTruck = foodTruckPark[i];
					if (currentTruck != null) {
						totalRating += currentTruck.getRating();
						totalTrucksInPark++;
					}
				}
				avgRating = totalRating / totalTrucksInPark;
				System.out.println("\nThe average rating of the trucks in the park is " + avgRating + ".\n");
				break;

			case 3:
				// case 3 displays the truck with the highest rating, including all of its data
				// this is similar to case 2, but the variables used are slightly different
				// i use a for loop to iterate across the array of food trucks
				// i use a string to track the highest rated, since truck name is a string,
				// replacing the old
				// highest rated truck if we find one rated higher
				// i use a highestRatedIndex variable to be able to print the truck to the
				// console
				// after leaving the for loop
				String highestRated = "";
				double highestRating = 0;
				int highestRatedIndex = 0;
				for (int i = 0; i < foodTruckPark.length; i++) {
					FoodTruck currentTruck = foodTruckPark[i];
					System.out.println("currentTruck test: " + currentTruck);
					if (currentTruck != null) {
						double currentRating = currentTruck.getRating();
						System.out.println("currentRating test: " + currentRating);
						if (currentRating > highestRating) {
							highestRated = currentTruck.getName();
							highestRating = currentRating;
							highestRatedIndex = i;
							System.out.println("highestRated test: " + highestRated);
							System.out.println("highestRating test: " + highestRating);
							System.out.println("highesRatedIndex test: " + i);
						}
					}
				}

				System.out.println("\nThe highest rated food truck is " + highestRated + ". All info printed below.");
				System.out.println(foodTruckPark[highestRatedIndex].toString());
				break;
			case 4:
				menuLoop = false;
				System.out.println("\nThank you, goodbye!");
				break;
			default:
				System.err.println("Your choice isn't within range.\n");
			}
		}

	}

}
