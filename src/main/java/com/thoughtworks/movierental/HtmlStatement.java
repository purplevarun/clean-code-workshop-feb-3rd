package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {
    private final String name;
    private final List<Rental> rentals;

    private final double totalAmount;
    private final int frequentRenterPoints;

    HtmlStatement(String name, List<Rental> rentals, double totalAmount, int frequentRenterPoints) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h1>Rental Record for " + "<b>" + name + "</b></h1>" + "\n";
    }

    private String htmlBody() {
        StringBuilder body = new StringBuilder();
        for (Rental rental : rentals) {
            body.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.amount()).append("\n");
        }
        return body.toString();
    }

    private String htmlFooter() {
        return "Amount owed is " + "<b>" + totalAmount + "</b>" + "\n"
                + "You earned " + "<b>" + frequentRenterPoints + "</b>"
                + " frequent renter points";
    }
}
