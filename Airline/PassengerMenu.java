import java.util.*;

public class PassengerMenu {
	
	public static Scanner in = new Scanner(System.in);
	public static int userChoice = 0;
	
	// used in menu1
	public static String name = " ";
	public static String last = " ";
	public static String newPassenger = " ";
	public static String alreadyPassenger = " ";
	public static ArrayList<String> passengerName = new ArrayList<>();
	
	// used in menu2
	public static String originatingA = " ";
	public static String destinationA = " ";
	public static String fafPlans = " ";

	// Menu 1
	public static void menuOne() {

		System.out.println("================== Menu 1 ==================");
		System.out.println(" 1. Create a new itinerary.");
		System.out.println(" 2. Manage existing itinerary.");
		System.out.println(" 3. Exit the program.");
		System.out.print(" Enter option (1,2,3): ");

		userChoice = intValidation1();

		if (userChoice == 1) {

			//info
			getUserInfo();
			newPassenger = CreateNI(name, last);
			passengerName.add(newPassenger);
			System.out.println("newPassenger: " + newPassenger);

			// Menu 2
			menuTwo();

		}

		else if (userChoice == 2) {

			getUserInfo();

			alreadyPassenger = CreateNI(name, last);
			System.out.println("findPassenger: " + alreadyPassenger);

			// Menu 2
			menuTwo();

		}

		else {
			System.out.print("You have exited our system.");
		}

	}

	// Menu 2
	public static void menuTwo() {

		ArrayList<String> flightSequence = new ArrayList<String>(Arrays.asList(RandomItinerary.get()));

		System.out.println("================== Menu 2 ==================");
		System.out.println(" 1. Search for flight / flight sequence.");
		System.out.println(" 2. Cancel one flight on the itinerary.");
		System.out.println(" 3. Cancel all flights on the itinerary.");
		System.out.println(" 4. Rerurn to Menu 1.");
		System.out.print(" Enter option (1,2,3,4): ");

		userChoice = intValidation2();

		if (userChoice == 1) {
			
			System.out.print("Enter originating airport: ");
			originatingA = in.next();
			System.out.print("Enter destination airport: ");
			destinationA = in.next();
			System.out.println("findAvailableFlightPlans: " + findAFP(originatingA, destinationA));
			
			menuTwo();
			
		} 
		else if (userChoice == 2) {

			for (int i = 0; i < flightSequence.size(); i++) {
				System.out.println(i + 1 + ". " + flightSequence.get(i));
			}
			
			int cancel = flightSequence.size() + 1; 
			System.out.println(cancel + ". cancel");
			System.out.print("Enter flight number: ");
			int flight2berase = intValidation2_2();
				
			if (flight2berase != cancel){
					String cancelFlight = flightSequence.get(flight2berase-1);
					flightSequence.remove(flight2berase-1); // removing specific flight 
					System.out.println("cancelFlight: " + cancelFlight + " " + name + " " + last); //si uso el arraylist me salen [name last]
					menuTwo();

			}
			else{
				menuTwo();
			}

		} 
		else if (userChoice == 3) {
			
			for (int i=0; i<flightSequence.size(); i++){
				
				System.out.println("cancelFlight: " + flightSequence.get(i) + " " + name + " " + last);
			}
			
			flightSequence.clear();
			menuTwo();

		} 
		else{
			menuOne();
		}

	}
	
	public static void getUserInfo(){
		
		System.out.print("Enter your first name: ");
		name = in.next();

		System.out.print("Enter your last name: ");
		last = in.next();
	}

	// Menu 1 Option 1. Creating a new itinerary
	public static String CreateNI(String firstN, String lastN) {

		String personName = firstN + " " + lastN;

		return personName;

	}

	// Menu 1 Option 2. Managing existing itinerary
	public static String manageEI(String firstN, String lastN) {

		String personName = firstN + " " + lastN;

		return personName;

	}

	// Validating user integer menu 1
	public static int intValidation1() {

		int n = 0;

		while (true) {

			if (in.hasNextInt()) {
				n = in.nextInt();

				if (n > 0 && n < 4) {
					break;
				} else {
					System.out
							.println("Not a valid option on the menu. Try again please.");
				}

			} else {
				in.next();
				System.out.println("Not a valid input. Try again please.");

			}

		}

		return n;
	}

	// Menu 2 Option 1. Search for a flight
	public static String findAFP(String oA, String dA) {

		fafPlans = oA + " " + dA;

		return fafPlans;
	}

	// Validating user integer menu 2
	public static int intValidation2() {

		int n = 0;

		while (true) {

			if (in.hasNextInt()) {
				n = in.nextInt();

				if (n > 0 && n < 5) {
					break;
				} else {
					System.out
							.println("Not a valid option on the menu. Try again please.");
				}

			} else {
				in.next();
				System.out.println("Not a valid input. Try again please.");

			}

		}

		return n;
	}
	
	// Validating user integer Menu 2 Option 2
		public static int intValidation2_2() {

			int n = 0;

			while (true) {

				if (in.hasNextInt()) {
					n = in.nextInt();

					if (n > 0 && n < 7) {
						break;
					} else {
						System.out
								.println("Not a valid option on the menu. Try again please.");
					}

				} else {
					in.next();
					System.out.println("Not a valid input. Try again please.");

				}

			}

			return n;
		}


	public static void main(String[] args) {

		System.out.println("Welcome to DreamsAirline. Where your travels become true!");
		System.out.println();
		menuOne();
		in.close();
	}

}


