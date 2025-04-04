package usantatecla.movies.v22;

public class Rental {
	private final Movie movie;
	private final int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public double getCharge() {
		return movie.getCharge(daysRented);
	}

	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}

	public String getMovieTitle() {
		return movie.getTitle();
	}

	public String getStatementLine() {
		return "\t" + getMovieTitle() + "\t" + getCharge() + "\n";
	}
}