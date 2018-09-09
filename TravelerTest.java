package hw1;

public class TravelerTest {

	public static void main(String[] args) {
		// a few cities to visit
		City paris = new City("Paris", 75);
		City rome = new City("Rome", 50);
		// start out in Paris
		Traveler t = new Traveler(500, paris);
		// initial state 
		System.out.println(t.getCurrentCity());// expected "Paris"
		System.out.println(t.getJournal());// expected "Paris(start)"
		// try going to Rome
		t.visit(rome, 2); 
		System.out.println(t.getCurrentCity());// expected "Rome"
		System.out.println(t.getJournal());// expected "Paris(start),Rome(2)"
		
		
		// back to Paris for a week
		t.visit(paris, 7);
		System.out.println(t.getCurrentCity()); // expected "Paris" 
		System.out.println(t.getJournal()); // "Paris(start),Rome(2),Paris(7)"
		

		t = new Traveler(500, paris); // start over

		// initial state
		System.out.println(t.getCurrentFunds()); // expected 500
		// visit a city
		t.visit(rome, 2);
		System.out.println(t.getCurrentFunds()); // expected 400

		t.visit(paris, 7);
		System.out.println(t.getCurrentFunds()); // expected 25
		System.out.println(t.getTotalNightsInTrainStation()); // expected 2
		t.visit(paris, 7);
		System.out.println(t.getCurrentFunds()); // expected 25
		System.out.println(t.getTotalNightsInTrainStation()); // expected 9
		t.sendPostcardsHome(1);
		System.out.println(t.getCurrentFunds()); // expected 21
		t.sendPostcardsHome(12);
		System.out.println(t.getCurrentFunds()); // expected 1
		System.out.println(t.isSOL()); // expected true
		t.callHomeForMoney();
		System.out.println(t.getCurrentFunds()); // expected 181
		t.callHomeForMoney();
		System.out.println(t.getCurrentFunds()); // still just 181
	}
}
