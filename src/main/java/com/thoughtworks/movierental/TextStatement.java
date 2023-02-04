package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {

    private final String name;
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int frequentRenterPoints;

    TextStatement(String name, List<Rental> rentals, double totalAmount, int frequentRenterPoints) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        StringBuilder body = new StringBuilder();
        for (Rental rental : rentals) {
            body.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.amount()).append("\n");
        }
        return body.toString();
    }

    private String footer() {
        return "Amount owed is " + totalAmount + "\n"
                + "You earned " + frequentRenterPoints
                + " frequent renter points";
    }
}
