// create a class TravelingFoodiesGroup with the following attributes:
// id, name, numberOfPeople, budget, destination
// create a constructor that accepts the id, name, numberOfPeople, budget, and destination
// create a method of viewState that returns a string

package travel;

import java.util.*;

public class TravelingFoodiesGroup {
	private int id;
	private String name;
	private int numberOfPeople;
	private float budget;
	private float amountRemaining;
	private Destination destination;
	// make a list of 10 ints
	private List<Integer> foodOptions = new ArrayList<Integer>(10);
	private List<FoodOption> options_booked = new ArrayList<FoodOption>(10);

	public TravelingFoodiesGroup(int id, String name, int numberOfPeople, float budget, Destination destination) {

		System.out.println("==Creating travelling foodies group..");
		System.out.println("==" + name + ": Setting destination '" + destination.getName() + "'");

		this.id = id;
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.budget = budget;
		this.amountRemaining = budget;
		this.destination = destination;
	}

	// make getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public float getAmountRemaining() {
		return amountRemaining;
	}

	public void setAmountRemaining(float amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void viewState() {
		String options_str = "";
		int i = 1;
		for (FoodOption foodOption : options_booked) {
			options_str += "\t" + i + ". " + foodOption.getName() + " - " + foodOption.getCostPerPerson()*numberOfPeople + "\n";
		}

		// if option_str is empty, return "No options booked"
		if (options_str.isEmpty()) {
			options_str += "\tNo entry yet";
		}

		System.out.println("\n----------------Travelling Foodies----------------\n"
			+ "Group ID: " + this.id + "\n"
			+ "Group Name: " + this.name + "\n"
			+ "Destination: " + this.destination.getName() + "\n"
			+ "No. of members: " + this.numberOfPeople + "\n"
			+ "Budget: " + this.budget + "\n"
			+ "Amount Remaining: " + this.amountRemaining + "\n"
			+ "Food Options: \n" + options_str + "\n");
	}

	// create addFoodOption function that takes in an integer as an argument
	// brings foodOption object from options list from main class
	// calls bookFor function on foodOption object for numberOfPeople
	public void addFoodOption(int index) {
		System.out.println("\n" + this.name +": chose food option no. " + index);
		boolean found = false;
		FoodOption foodOption = null;
		for(FoodOption i: Main.options) {
			if((i.getId() == index) && (i.getDestination() == this.destination)) {
				foodOption = i;
				found = true;
			}
		}
		
		if(!found){
			System.out.println("Cannot add food option. Invalid option number.");
			return;
		}
		System.out.println(this.name +": Adding food option no '" + foodOption.getName() + "'");

		if (foodOptions.contains(index)) {
			System.out.println("Cannot book food option more than once.");
			viewState();
			return;
		}

		if(foodOption.book(this) == 1){
			System.out.println("Succesfully added '" + foodOption.getName() + "'");
			options_booked.add(foodOption);
			foodOptions.add(index);
			amountRemaining -= (foodOption.getCostPerPerson() * numberOfPeople);
		}
		viewState();
		return;
	}
}