package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void shouldReturnStringStatementForACustomer() {
        Customer customer = new Customer("Customer");
        Rental regularMovieRental = new Rental(new Movie("Regular Movie", Movie.REGULAR), 3);
        Rental newReleaseMovieRental = new Rental(new Movie("New Release Movie", Movie.NEW_RELEASE), 2);
        Rental childrensMovieRental = new Rental(new Movie("Children's Movie", Movie.CHILDRENS), 4);
        String expectedStatement = """
                Rental Record for Customer
                \tRegular Movie\t3.5
                \tNew Release Movie\t6.0
                \tChildren's Movie\t3.0
                Amount owed is 12.5
                You earned 4 frequent renter points""";

        customer.addRental(regularMovieRental);
        customer.addRental(newReleaseMovieRental);
        customer.addRental(childrensMovieRental);
        String actualStatement = customer.statement();

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldReturnHTMLStatementForACustomer() {
        Customer customer = new Customer("Customer");
        Rental regularMovieRental = new Rental(new Movie("Regular Movie", Movie.REGULAR), 3);
        String expectedStatement = """
                <h1>Rental Record for <b>Customer</b></h1>
                \tRegular Movie\t3.5
                Amount owed is <b>3.5</b>
                You earned <b>1</b> frequent renter points""";

        customer.addRental(regularMovieRental);
        String actualStatement = customer.htmlStatement();

        assertEquals(expectedStatement, actualStatement);
    }
}