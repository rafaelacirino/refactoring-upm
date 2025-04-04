package usantatecla.movies.v22;

public class Rental {

	private usantatecla.movies.v22.Movie movie;

	private int daysRented;

	public Rental(usantatecla.movies.v22.Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public double getCharge() {
		return movie.getCharge(daysRented);
	}

	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

}