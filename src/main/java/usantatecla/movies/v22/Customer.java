package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");

        for (Rental rental : rentals) {
            result.append(rental.getStatementLine());
        }

        result.append("Amount owed is ").append(this.getTotal(Rental::getCharge)).append("\n");
        result.append("You earned ").append(this.getTotal(Rental::getFrequentRenterPoints)).append(" frequent renter points");

        return result.toString();
    }

    private double getTotal(ToDouble<Rental> mapper) {
        return rentals.stream().mapToDouble(mapper::map).sum();
    }

    @FunctionalInterface
    private interface ToDouble<T> {
        double map(T item);
    }
}
