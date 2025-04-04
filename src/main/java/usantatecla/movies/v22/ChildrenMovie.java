package usantatecla.movies.v22;

class ChildrenMovie extends Movie {

    private static final double CHARGE = 1.5;
    private static final double EXTRA_CHARGE = 1.5;
    private static final int DAYS_RENTED_THRESHOLD = 3;

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        double result = CHARGE;
        if (daysRented > DAYS_RENTED_THRESHOLD) {
            result += (daysRented - 1) * EXTRA_CHARGE;
        }
        return result;
    }
}