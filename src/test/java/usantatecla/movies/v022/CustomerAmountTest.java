package usantatecla.movies.v022;

import org.junit.Test;
import usantatecla.movies.v21.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerAmountTest {

    @Test
    public void regularRental3DayAmountTest() {
        Movie movie = new MovieBuilder().regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().rental(rental).build();

        String statement = customer.statement();

        assertTrue(statement.contains("Amount owed is 3.5"));
    }

    @Test
    public void newReleaseRental2DayAmountTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String expectedStatement = new StatementBuilder().customerName(customerName)
                .movie(movieName, 3.0)
                .totalAmount(3.0)
                .frequentRenterPoints(2)
                .build();
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void childrensRental4DayAmountTest() {
        Movie movie = new MovieBuilder().childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        Customer customer = new CustomerBuilder().rental(rental).build();

        String statement = customer.statement();

        assertTrue(statement.contains("Amount owed is 6.0"));
    }
}
