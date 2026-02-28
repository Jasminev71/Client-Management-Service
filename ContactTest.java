package org.snhu.cs320.contact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContactTest {

    @Test
    void testSuccessfulCreation() throws Exception {
        Contact contact = new Contact("1", "first", "last", "1234455677", "123 Lehi Lane");
        assertThat(contact)
                .hasFieldOrPropertyWithValue("contactId", "1")
                .hasFieldOrPropertyWithValue("firstName", "first")
                .hasFieldOrPropertyWithValue("lastName", "last")
                .hasFieldOrPropertyWithValue("phone", "1234455677")
                .hasFieldOrPropertyWithValue("address", "123 Lehi Lane");
    }

    @Test
    void testSuccessfulSetters() throws Exception {
        Contact contact = new Contact("1", "first", "last", "1234455677", "123 Lehi Lane");

        contact.setFirstName("Jim");
        contact.setLastName("Bob");
        contact.setPhone("1112223344");
        contact.setAddress("124 Lehi Lane");

        assertThat(contact)
                .hasFieldOrPropertyWithValue("firstName", "Jim")
                .hasFieldOrPropertyWithValue("lastName", "Bob")
                .hasFieldOrPropertyWithValue("phone", "1112223344")
                .hasFieldOrPropertyWithValue("address", "124 Lehi Lane");
    }

    @ParameterizedTest
    @CsvSource({
            "'',first,last,1234455677,123 Lehi Lane",
            "12345678901,first,last,1234455677,123 Lehi Lane",
            "1234,first,last,12345,123 Lehi Lane"
    })
    void testFailedCreation(String contactId, String firstName, String lastName, String phone, String address) {
        assertThatThrownBy(() ->
                new Contact(contactId, firstName, lastName, phone, address)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}