package usantatecla.movies.v22;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CustomerFrequentRenterPointsTest {

    @Test
    public void withoutRentalsPointsTest() {
        Customer customer = new CustomerBuilder().build();
        String statement = customer.statement();
        assertTrue(statement.contains("frequent renter points") && statement.contains("0"));
    }

    @Test
    public void regularRentalPointsTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().regular().build()).daysRented(5).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("frequent renter points") && statement.contains("1"));
    }

    @Test
    public void newRelease1DayPointsTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().newRelease().build()).daysRented(1).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("frequent renter points") && statement.contains("1"));
    }

    @Test
    public void newRelease2DaysPointsTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().newRelease().build()).daysRented(2).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("frequent renter points") && statement.contains("2"));
    }

    @Test
    public void childrensRentalPointsTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().childrens().build()).daysRented(5).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("frequent renter points") && statement.contains("1"));
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
