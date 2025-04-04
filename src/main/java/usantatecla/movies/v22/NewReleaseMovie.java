package usantatecla.movies.v22;

class NewReleaseMovie extends Movie {

    private static final double CHARGE = 3;
    private static final int DAYS_RENTED_THRESHOLD = 1;
    private static final int FREQUENT_RENTER_POINTS = 2;

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        return CHARGE;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > DAYS_RENTED_THRESHOLD) ? FREQUENT_RENTER_POINTS : super.getFrequentRenterPoints(daysRented);
    }
}