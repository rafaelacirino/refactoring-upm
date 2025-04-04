package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class Customer {

	private final String name;
	private final List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");

		rentals.forEach(rental -> result.append(rental.getStatementLine()));

		result.append("Amount owed is ").append(getTotalCharge()).append("\n");
		result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
		return result.toString();
	}

	private double getTotalCharge() {
		return calculateTotal(Rental::getCharge);
	}

	private int getTotalFrequentRenterPoints() {
		return (int) calculateTotal(Rental::getFrequentRenterPoints);
	}

	private double calculateTotal(ToDoubleFunction<Rental> mapper) {
		return rentals.stream().mapToDouble(mapper).sum();
	}

}
