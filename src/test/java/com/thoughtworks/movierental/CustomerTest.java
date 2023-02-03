package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void shouldReturnStatementForACustomer() {
        Customer customer = new Customer("Customer");
        Rental regularMovieRental = new Rental(new Movie("Regular Movie", Movie.REGULAR), 3);
        Rental newReleaseMovieRental = new Rental(new Movie("New Release Movie", Movie.NEW_RELEASE), 2);
        Rental childrensMovieRental = new Rental(new Movie("Children's Movie", Movie.CHILDRENS), 4);
        String expectedStatement = "Rental Record for Customer\n" +
                "\tRegular Movie\t3.5\n" +
                "\tNew Release Movie\t6.0\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 12.5\n" +
                "You earned 4 frequent renter points";

        customer.addRental(regularMovieRental);
        customer.addRental(newReleaseMovieRental);
        customer.addRental(childrensMovieRental);
        String actualStatement = customer.statement();

        assertEquals(expectedStatement, actualStatement);
    }
}