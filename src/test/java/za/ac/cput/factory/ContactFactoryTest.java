package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactFactoryTest {

    private static Contact contact;
    @Test
    @Order(1)
    void createContact() {
        contact = ContactFactory.createContact("thabangcebo@gmail.com", "0681523305", "0763588323");
        assertNotNull(contact);
        System.out.println(contact);
    }


    @Test
    @Order(2)
    void createContactFailEmail() {
        contact = ContactFactory.createContact("thabangcebogmail.com", "0681523305", "0763588323");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(3)
    void createContactFailMobile() {
        contact = ContactFactory.createContact("thabangcebo@gmail.com", "06815233051", "0763588323");
        assertNotNull(contact);
        System.out.println(contact);
    }
}