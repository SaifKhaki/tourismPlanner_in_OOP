// create a class of FoodOption with the following attributes:
// name, description, costPerPerson, capacity, destination
// create a constructor that accepts the name, description, costPerPerson, capacity, and destination
// create a method of viewState that returns a string

package travel;

import java.util.*;

public class FoodOption {
    public static int options_count [] = {1,1,1};
    private String name;
    private String description;
    private float costPerPerson;
    private int capacity;
    private int remaining_slots;
    private Destination destination;
    private boolean available = true;
    private int id;

    // make a list of 50 groups
    private List<TravelingFoodiesGroup> visited_groups = new ArrayList<TravelingFoodiesGroup>(50);

    public FoodOption(String name, String description, float costPerPerson, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.costPerPerson = costPerPerson;
        this.capacity = capacity;
        this.remaining_slots = capacity;
        this.destination = destination;
        if(this.destination.getCountry() == "National Capital Region")
            this.id = options_count[0]++;
        else if(this.destination.getCountry() == "Central Luzon")
            this.id = options_count[1]++;
        else if(this.destination.getCountry() == "Calabarzone")
            this.id = options_count[2]++;
        tellDestination(destination);
    }

    private void tellDestination(Destination destination) {
        destination.addFoodOption(this);
    }

    // create getter and setters
    public String getName() {
        return name;
    }
    
    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(float costPerPerson) {
        this.costPerPerson = costPerPerson;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRemainingSlots() {
        return remaining_slots;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void viewState() {
        String groups_str = "";
        int i = 1;
        for (TravelingFoodiesGroup group : visited_groups) {
            groups_str += "\t" + i++ + ". " + group.getName() + " - " + group.getNumberOfPeople() + " (members count)" + "\n";
        }

        // if option_str is empty, return "No options booked"
        if (groups_str.isEmpty()) {
            groups_str += "\tNo entry yet.";
        }

        System.out.println("\n----------------FOOD OPTION----------------\n"
            + "Location: " + this.destination.getName() + "\n"
            + "Food Option Id: " + this.id + "\n" 
            + "Name: " + this.name + "\n"
            + "Description: " + this.description + "\n"
            + "Cost: " + this.costPerPerson + "\n"
            + "Capacity: " + this.capacity + "\n"
            + "Remaining Slots: " + this.remaining_slots + "\n"
            + "Groups: \n" + groups_str + "\n"); 
    }

    public int book(TravelingFoodiesGroup group) {
        int count = group.getNumberOfPeople();
        float amountRemaining = group.getAmountRemaining();

        if (!available) {
            System.out.println("Sorry, this food option is no longer available");
            return 0;
        }
        if (count * costPerPerson > amountRemaining) {
            System.out.println("Di na kaya ng budget. Sad lyf.");
            return 0;
        }else{
            System.out.println("Yes! Kaya pa ng budget");
        }
        if (count > remaining_slots) {
            System.out.println("Sorry, exceeds capacity. Unable to accomodate group.");
            return 0;
        }

        remaining_slots -= count;
        if (remaining_slots == 0) {
            available = false;
        }

        visited_groups.add(group);
        return 1;
    }
}