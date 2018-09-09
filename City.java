package hw1;

public class City {

	
	public static final double RELATIVE_COST_OF_POSTCARD = 0.05;
	//cost to mail a postcard from a city
	
	private String cityName;
	private int lodging;

	public City(String givenName, int givenLodgingCost) {
		//constructing a new city with the given name and also the lodging cost per night
		cityName = givenName;
		lodging = givenLodgingCost;
	}
	public String getName() {
		return cityName;
		//return city name
	}
	
	public int lodgingCost() {
		return lodging;
		//returning the city's lodging cost per night
	}

	public int costToSendPostcard() {

		int i = (int) Math.round(RELATIVE_COST_OF_POSTCARD * lodging);
		return i;
		//returning the cost to send a postcard from this city
	}
	public int maxLengthOfStay(int funds) {

		int days = (int)(funds/lodging);
		return days;
		//returning number of nights of lodging in this city that a traveler can afford
		//with the give amount of money
		
	}
	
	
		public int maxNumberOfPostcards(int funds) {
			int postcards = (int) (funds/costToSendPostcard());
				return postcards;
				//returns the number of postcards that which a traveler can afford
				// to send with the fiven amount of money
		}
		
}

