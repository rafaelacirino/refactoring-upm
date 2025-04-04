package usantatecla.movies.v22;

public abstract class Movie {

    private final String title;

    protected Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        if (this instanceof NewReleaseMovie && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
