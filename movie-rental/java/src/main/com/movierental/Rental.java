package com.movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getAmount() {
        double thisAmount = 0;

        //determine amounts for each line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return calculate(getMovie().getPriceCode());
            case Movie.NEW_RELEASE:
                return calculate(getMovie().getPriceCode());
            case Movie.CHILDRENS:
                return calculate(getMovie().getPriceCode());
        }
        return thisAmount;
    }

    private double calculate(int movieType) {
        double thisAmount = 0;
        switch (movieType) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                return thisAmount;
            case Movie.NEW_RELEASE:
                return getDaysRented() * 3;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
                return thisAmount;
        }
        return 0;
    }
}
