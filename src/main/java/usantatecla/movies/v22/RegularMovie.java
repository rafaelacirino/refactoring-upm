package usantatecla.movies.v22;

class RegularMovie extends Movie {

    private static final double CHARGE = 2.0;
    private static final double EXTRA_CHARGE = 1.5;
    private static final int DAYS_RENTED_THRESHOLD = 2;

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        double result = CHARGE;
        if (daysRented > DAYS_RENTED_THRESHOLD) {
            result += (daysRented - DAYS_RENTED_THRESHOLD) * EXTRA_CHARGE;
        }
        return result;
    }
}