/*************************************************************************************************************
 * 
 * Topic: Abstraction (Laboratory exercise)
 * 
 * (refer to pdf file for the problem domain)
 *
 * @date 2022-03-09 17:00
 * (c) Institute of Computer Science, UPLB
 * 
 */
package travel;

import java.util.*;

public class Main {

	public static List<FoodOption> options = new ArrayList<FoodOption>();

	public static void main(String[] args) {
		/*
		 * Create 2 sample destinations
		 */
		Destination destination1 = new Destination("Binondo", "Binondo food crawl", Destination.NATIONAL_CAPITAL_REGION);
		destination1.viewState();

		Destination destination2 = new Destination("Pampanga", "Pampanga food trip", Destination.CENTRAL_LUZON);
		destination2.viewState();

		/*
		 * Create 5 sample travel options. Travel option is specific to a destination.
		 * Upon creation, specify destination.
		 * 
		 */

		FoodOption option1 = new FoodOption("Eng Bee Tin", "Eng Bee Tin Chinese Deli", 700f, 10, destination1);
		option1.viewState();

		FoodOption option2 = new FoodOption("Sincerity", "Sincerity Caf� and Restaurant", 800f, 5, destination1);
		option2.viewState();

		FoodOption option3 = new FoodOption("Aling Lucing", "Aling Lucing Sisig", 300f, 7, destination2);
		option3.viewState();

		FoodOption option4 = new FoodOption("Mila's", "Mila�s Tokwa't Baboy", 300f, 5, destination2);
		option4.viewState();

		FoodOption option5 = new FoodOption("Razon's", "The Original Razon's", 1000f, 9, destination2);
		option5.viewState();

		// add the options to the list
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		options.add(option5);

		/*
		 * At this point, the following are the destinations and corresponding food
		 * options
		 * (note the option order or sequence number)
		 * 
		 * Destination: Binondo
		 * options list:
		 * 1. Eng Bee Tin
		 * 2. Sincerity
		 * 
		 * 
		 * Destination: Pampanga
		 * options list:
		 * 1. Aling Lucing
		 * 2. Mila's
		 * 3. Razon's
		 * 
		 * -- end of list --
		 */

		/*
		 * Create 4 sample travel foodies groups. Upon creation, specify the
		 * destination.
		 */

		TravelingFoodiesGroup group1 = new TravelingFoodiesGroup(1, "Team Uhaw", 5, 20000f, destination1);
		group1.viewState();

		TravelingFoodiesGroup group2 = new TravelingFoodiesGroup(2, "Team Gutom", 2, 10000f, destination1);
		group2.viewState();

		TravelingFoodiesGroup group3 = new TravelingFoodiesGroup(3, "Team Puyat", 6, 8000f, destination1);
		group3.viewState();

		TravelingFoodiesGroup group4 = new TravelingFoodiesGroup(4, "Team GG", 7, 7000f, destination2);
		group4.viewState();

		System.out.println("\n----------------------------------------------------------------");
		System.out.println("Start booking process...");
		System.out.println("----------------------------------------------------------------\n");

		/*
		 * Group 1 tries to book for food option no. 1 in the options list (Eng Bee Tin)
		 * Booking should succeed.
		 * Food option will have 5 slots left
		 */
		group1.addFoodOption(1);

		/*
		 * Group 2 tries to book for food option no. 1 in the options list (Eng Bee Tin)
		 * Booking should succeed.
		 * Food option will have 3 slots left
		 */
		group2.addFoodOption(1);

		/*
		 * Group 3 tries to book for food option no. 1 in the options list (Eng Bee Tin)
		 * With 6 members > 3 slots left, booking should not succeed.
		 */
		group3.addFoodOption(1);

		/*
		 * Group 2 tries to book again for food option no. 1 in the options list (Eng
		 * Bee Tin)
		 * Booking should fail.
		 * Cannot book food option more than once
		 */
		group2.addFoodOption(1);

		/*
		 * Group 4 tries to book for an invalid food option in destination 'Pampanga'
		 */
		group4.addFoodOption(4);

		/*
		 * Group 4 tries to book for food option #1 (Aling Lucing)
		 * Booking should succeed.
		 * No more slots left for food option
		 */
		group4.addFoodOption(1);

		/*
		 * Group 4 tries to book for food option #2 (Mila's)
		 * Booking should not succeed.
		 * No more slots left for food option
		 */
		group4.addFoodOption(2);

		/*
		 * Group 4 tries to book for food option #2 (Mila's)
		 * Booking should not succeed.
		 * Exceeds budget (at P1000 each, need P7000 for 7 persons; Group only has P4900
		 * left)
		 */
		group4.addFoodOption(3);

		System.out.println("\n----------------------------------------------------------------");
		System.out.println("                           SUMMARY");
		System.out.println("----------------------------------------------------------------\n");

		group1.viewState();
		group2.viewState();
		group3.viewState();
		group4.viewState();
		destination1.viewState();
		destination2.viewState();
		option1.viewState();
		option2.viewState();
		option3.viewState();
		option4.viewState();
		option5.viewState();

		/*
		 * You may add more test cases after this comment.
		 * Wala nang iba pang kailangan baguhin sa itaas.
		 * Kung mayroon man, class-level attributes: the ID of groups can be assigned
		 * programmatically using a class-level attribute in TravelingFoodiesGroup.
		 * Right now, if you noticed, the ids are hard-coded. Similarly, food options
		 * can also have IDs.
		 */

	}

}
