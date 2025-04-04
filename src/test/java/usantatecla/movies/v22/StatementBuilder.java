package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class StatementBuilder {

    private String customerName;
    private final List<String> movieNames;
    private final List<Double> amounts;
    private double totalAmount = 0;
    private int frequentRenterPoints = 0;

    public StatementBuilder() {
        movieNames = new ArrayList<String>();
        amounts = new ArrayList<Double>();
    }

    public StatementBuilder customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public StatementBuilder movie(String movieName, double amount) {
        movieNames.add(movieName);
        amounts.add(amount);
        return this;
    }

    public StatementBuilder totalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public StatementBuilder frequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
        return this;
    }

    public String build() {
        StringBuilder result = new StringBuilder("Rental Record for " + customerName + "\n");
        for(int i=0; i<movieNames.size(); i++) {
            result.append("\t").append(movieNames.get(i)).append("\t").append(amounts.get(i)).append("\n");
        }
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }


}
