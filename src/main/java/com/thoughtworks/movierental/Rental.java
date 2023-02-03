package com.thoughtworks.movierental;

public class Rental {
    private int daysRented;
    private Movie movie;
    int frequentRenterPoints = 0;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int frequentRenterPoints() {
        frequentRenterPoints++;
        if (movie.getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public double amount() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public String updateResult(String result) {
        return result + "\t" + movie.getTitle() + "\t" + amount() + "\n";
    }
}