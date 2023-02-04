package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {
    private final String name;
    private final Rentals rentals;

    HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
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
        return "Amount owed is " + "<b>" + rentals.totalAmount() + "</b>" + "\n"
                + "You earned " + "<b>" + rentals.frequentRenterPoints() + "</b>"
                + " frequent renter points";
    }
}
