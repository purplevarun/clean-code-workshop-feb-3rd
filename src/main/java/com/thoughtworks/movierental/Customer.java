package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            frequentRenterPoints += rental.frequentRenterPoints();
            result = getResult(result, rental, rentalAmount);
            totalAmount += rentalAmount;
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private String getResult(String result, Rental rental, double rentalAmount) {
        result += "\t" + rental.getMovie().getTitle() + "\t" +
                rentalAmount + "\n";
        return result;
    }
}
