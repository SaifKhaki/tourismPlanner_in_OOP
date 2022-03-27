package travel;

import java.util.*;

public class Destination {
    public static int count = 1;
    public static String NATIONAL_CAPITAL_REGION = "National Capital Region";
    public static String CENTRAL_LUZON = "Central Luzon";
    public static String CALABARZONE = "Calabarzone";

    private int id;
    private String name;
    private String country;
    private String description;

    // create a list of FoodOptions
    private List<FoodOption> foodOptions = new ArrayList<FoodOption>(10);

    // create a constructor
    public Destination(String name, String description, String country) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.id = count++;
    }

    // add foodOption
    public void addFoodOption(FoodOption foodOption) {
        foodOptions.add(foodOption);
    }

    // getName getter
    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    // getDescription getter
    public String getDescription() {
        return description;
    }

    // getCountry getter
    public String getCountry() {
        return country;
    }

    // setName setter
    public void setName(String name) {
        this.name = name;
    }

    // setDescription setter
    public void setDescription(String description) {
        this.description = description;
    }

    // setCountry setter
    public void setCountry(String country) {
        this.country = country;
    }

    // create a method of viewState that returns a string
    public void viewState() {
        String options_str = "";
        int i = 1;
        for (FoodOption foodOption : foodOptions) {
            options_str += "\t" + i + ". " + foodOption.getName() + " - " + foodOption.getCapacity() + " (capacity), "
                    + foodOption.getRemainingSlots() + " (remaining slots)\n";
        }

        // if option_str is empty, return "No options booked"
        if (options_str.isEmpty()) {
            options_str += "\tNo entry yet.";
        }

        System.out.println("\n----------------DESTINATION----------------\n" 
            + "Destination ID: " + this.id + "\n"
            + "Name: " + this.name + "\n"
            + "Description: " + this.description + "\n"
            + "Location: " + this.country + "\n"
            + "Food Options: \n" + options_str + "\n");

    }
}