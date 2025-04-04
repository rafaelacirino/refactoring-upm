package usantatecla.movies.v022;

import org.junit.Test;
import usantatecla.movies.v21.*;

import static org.junit.Assert.assertTrue;

public class CustomerFrequentRenterPointsTest {

    @Test
    public void newRelease1DayPointsTest() {
        Movie movie = new MovieBuilder().newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().rental(rental).build();

        String statement = customer.statement();

        assertTrue(statement.contains("frequent renter points") && statement.contains("1"));
    }

    @Test
    public void newRelease2DaysPointsTest() {
        Movie movie = new MovieBuilder().newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().rental(rental).build();

        String statement = customer.statement();

        assertTrue(statement.contains("frequent renter points") && statement.contains("2"));
    }

    @Test
    public void multipleRentalsPointsTest() {
        Customer customer = new CustomerBuilder()
                .rental(new RentalBuilder().movie(new MovieBuilder().regular().build()).daysRented(1).build())
                .rental(new RentalBuilder().movie(new MovieBuilder().newRelease().build()).daysRented(3).build())
                .rental(new RentalBuilder().movie(new MovieBuilder().childrens().build()).daysRented(4).build())
                .build();

        String statement = customer.statement();

        assertTrue(statement.contains("frequent renter points") && statement.contains("4"));
    }
}
