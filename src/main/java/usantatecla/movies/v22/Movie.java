package usantatecla.movies.v22;

public abstract class Movie {

	private static final int FREQUENT_RENTER_POINTS = 1;

	private final String title;

	protected Movie(String title) {
		this.title = title;
	}

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return FREQUENT_RENTER_POINTS;
	}

	public String getTitle() {
		return title;
	}

	public static Movie newRelease(String title) {
		return new NewReleaseMovie(title);
	}

	public static Movie regular(String title) {
		return new RegularMovie(title);
	}

	public static Movie children(String title) {
		return new ChildrenMovie(title);
	}
}