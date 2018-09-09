package hw1;

public class Traveler {
/* author richa patel
*/

	public static final int SYMPATHY_FACTOR = 30;
	//this is when calling home for more money
	private String journal;
	private City currentCity;
	private int currentFunds;
	private int nightsAtTrainStation;
	private int sentPostcard;

	

	public Traveler(int initialFunds, City initialCity) {
		currentFunds = initialFunds;
		currentCity = initialCity;
		journal = currentCity.getName();
		journal = journal + "(start)";
		sentPostcard = 0;
		nightsAtTrainStation = 0;
		//constructing a traveler starting out with the given amount of money in the given city
	}

	public String getCurrentCity() {
		return currentCity.getName();
		//returning the name of the traveler's current city
	}
	
	public int getCurrentFunds() {
		return currentFunds;
		//returning the amount of money the traveler has
	}
	

	public String getJournal() {
		return journal;
		//returns traveler's journal
	}

	public boolean isSOL() {
		int numPostcards = currentCity.maxNumberOfPostcards(currentFunds);
		if (numPostcards <= 0)
			return true;
		else
			return false;

		//in this case it is wise to use a if else statement because 
		//it returns true if the traveler does not have enough money
		//to send a postcard from the current city or else it's false
	}
	

	public int getTotalNightsInTrainStation() {
		return nightsAtTrainStation;
		//returns the number of nights in the train station
		// when visiting a city without enough momey for lodging
	
	}
	
	public void visit(City c, int numNights)	{
		currentCity = c;
		int maxNightCanAfford = currentCity.maxLengthOfStay(currentFunds);
		
		if (maxNightCanAfford > numNights) {
			// Person has sufficient funds to stey in city
			currentFunds = currentFunds - currentCity.lodgingCost() * numNights;
			//traveler's funds are reduced based on the number of nights
			//of lodging in the city
			
		} else {
			// spend partial nights at hotel if person can afford
			currentFunds = currentFunds - currentCity.lodgingCost() * maxNightCanAfford;
			// spend remaining nights at train station
			nightsAtTrainStation = nightsAtTrainStation + (numNights - maxNightCanAfford);
			
			
		}
		
		journal = journal + ","+ currentCity.getName() + "(" + numNights + ")";
		//journal is updated by appending a comma, the city name
		//and the number of nights in parentheses
	
	}


	public void sendPostcardsHome(int howMany) {
		int sent;
		sent = Math.min(howMany, currentCity.maxNumberOfPostcards(currentFunds));
		currentFunds = currentFunds - sent*currentCity.costToSendPostcard();
		sentPostcard = sentPostcard + sent;
		
		//sending the given number of postcards
		//reducing the traveler's funds appropriately and increasing the count of postcards
		//sending as many postcards as possible without allowing the funds to go below zero
		
	}
	
	public void callHomeForMoney() {
		currentFunds = currentFunds + (sentPostcard * SYMPATHY_FACTOR) ;
		sentPostcard = 0;
		//reseting the count of the number of postcards sent back to zero
	}
		
		
		
		
	}
