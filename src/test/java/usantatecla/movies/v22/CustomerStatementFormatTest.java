package usantatecla.movies.v22;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerStatementFormatTest {

    @Test
    public void emptyStatementFormatTest() {
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).build();
        String statement = customer.statement();

        assertTrue(statement.startsWith("Rental Record for " + customerName));
        assertTrue(statement.contains("\nAmount owed is "));
        assertTrue(statement.contains("\nYou earned "));
        assertFalse(statement.contains("\t"));
    }

    @Test
    public void singleRentalFormatTest() {
        String movieName = "Movie";
        double charge = 2.0;
        Rental rental = new RentalBuilder()
                .movie(new MovieBuilder().title(movieName).regular().build())
                .daysRented(1)
                .build();

        String statement = new CustomerBuilder().rental(rental).build().statement();

        assertTrue(statement.contains("\t" + movieName + "\t" + charge));
        assertEquals(1, countOccurrences(statement));
    }

    @Test
    public void multipleRentalsFormatTest() {
        Customer customer = new CustomerBuilder()
                .rental(new RentalBuilder().movie(new MovieBuilder().title("A").regular().build()).daysRented(1).build())
                .rental(new RentalBuilder().movie(new MovieBuilder().title("B").newRelease().build()).daysRented(2).build())
                .build();

        String statement = customer.statement();

        assertEquals(2, countOccurrences(statement));
        assertTrue(statement.indexOf("A") < statement.indexOf("B"));
    }

    private int countOccurrences(String str) {
        return str.split("\n\t", -1).length - 1;
    }

    @Test
    public void singleMovieFormatTest() {
        String movieTitle = "Movie";
        Movie movie = new MovieBuilder().title(movieTitle).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().rental(rental).build();

        String statement = customer.statement();

        assertTrue(statement.contains("\t" + movieTitle + "\t2.0"));
    }

    @Test
    public void multiMovieFormatTest() {
        Customer customer = new CustomerBuilder()
                .rental(new RentalBuilder().movie(new MovieBuilder().title("A").regular().build()).daysRented(2).build())
                .rental(new RentalBuilder().movie(new MovieBuilder().title("B").newRelease().build()).daysRented(1).build())
                .build();

        String statement = customer.statement();

        assertTrue(statement.contains("\tA\t2.0"));
        assertTrue(statement.contains("\tB\t3.0"));
        assertTrue(statement.contains("Amount owed is 5.0"));
    }
}
