package usantatecla.movies.v22;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CustomerAmountTest {

    @Test
    public void withoutRentalsAmountTest() {
        Customer customer = new CustomerBuilder().build();
        String statement = customer.statement();
        assertTrue(statement.contains("Amount owed is 0"));
    }

    @Test
    public void regularRental1DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().regular().build()).daysRented(1).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 2.0"));
    }

    @Test
    public void regularRental2DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().regular().build()).daysRented(2).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 2.0"));
    }

    @Test
    public void regularRental3DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().regular().build()).daysRented(3).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 3.5"));
    }

    @Test
    public void newReleaseRental1DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().newRelease().build()).daysRented(1).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 3.0"));
    }

    @Test
    public void newReleaseRental2DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().newRelease().build()).daysRented(2).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 3.0"));
    }

    @Test
    public void newReleaseRental3DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().newRelease().build()).daysRented(3).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 3.0"));
    }

    @Test
    public void childrensRental1DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().childrens().build()).daysRented(1).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 1.5"));
    }

    @Test
    public void childrensRental3DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().childrens().build()).daysRented(3).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 1.5"));
    }

    @Test
    public void childrensRental4DayAmountTest() {
        Rental rental = new RentalBuilder().movie(new MovieBuilder().childrens().build()).daysRented(4).build();
        String statement = new CustomerBuilder().rental(rental).build().statement();
        assertTrue(statement.contains("Amount owed is 6.0"));
    }

    @Test
    public void multipleRentalsAmountTest() {
        Customer customer = new CustomerBuilder()
                .rental(new RentalBuilder().movie(new MovieBuilder().regular().build()).daysRented(10).build())
                .rental(new RentalBuilder().movie(new MovieBuilder().newRelease().build()).daysRented(10).build())
                .rental(new RentalBuilder().movie(new MovieBuilder().childrens().build()).daysRented(10).build())
                .build();
        String statement = customer.statement();
        assertTrue(statement.contains("Amount owed is 32.0"));
    }
}
