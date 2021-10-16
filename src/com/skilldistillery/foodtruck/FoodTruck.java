package com.skilldistillery.foodtruck;
//only stuff here is data food trucks all have

public class FoodTruck {
	private String name;
	private String foodType;
	private double rating;
	private int truckId = 0;
	private static int nextID = 1;
	// this food truck class has data
	// including the id which will be generated

	public FoodTruck() {
	}

	public FoodTruck(String truckName, String truckFoodType, double truckRating, int thisTruckId) {
		this.name = truckName;
		this.foodType = truckFoodType;
		this.rating = truckRating;
		this.truckId = nextID;
		nextID++;
		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTruckId() {
		return truckId;
	}


	public String toString() {
		String output = "Truck Info -  Name: " + name + ", Food Type: " + foodType + ", Rating: " + rating + ", Truck ID: " + truckId+ "\n";
		return output;
	}

}
