package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {

    private final String name;
    private final Rentals rentals;

    TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
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
        return "Amount owed is " + rentals.totalAmount() + "\n"
                + "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
    }
}
