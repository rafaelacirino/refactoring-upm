package usantatecla.movies.v022;

import org.junit.Test;
import usantatecla.movies.v21.*;

import static org.junit.Assert.assertTrue;

public class CustomerStatementFormatTest {

    @Test
    public void emptyStatementFormatTest() {
        Customer customer = new CustomerBuilder().name("John").build();

        String statement = customer.statement();

        assertTrue(statement.startsWith("Rental Record for John"));
        assertTrue(statement.contains("Amount owed is 0"));
        assertTrue(statement.contains("frequent renter points"));
    }

    @Test
    public void singleMovieFormatTest() {
        String movieTitle = "The Matrix";
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
