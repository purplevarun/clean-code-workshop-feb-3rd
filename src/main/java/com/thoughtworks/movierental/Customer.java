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
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private String body() {
        String body = new String();
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" + rental.amount() + "\n";
        }
        return body;
    }

    private String footer() {
        return "Amount owed is " + totalAmount() + "\n"
                + "You earned " + frequentRenterPoints()
                + " frequent renter points";
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }
}
