import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest {
 
    private Contact contact; 
 
    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    } 
 
    @Test
    void getName_returnsCorrectName() {
        assertEquals("Ada Lovelace", contact.getName());
    } 
 
    @Test
    void getPhone_returnsCorrectPhone() {
        assertEquals("+1 617 555 0101", contact.getPhoneNumber());
    } 
 
    @Test
    void toString_containsBothFields() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
    void toString_formatIsCorrect() {
        String expected = "Name: Ada Lovelace, Phone Number: +1 617 555 0101";
        assertEquals(expected, contact.toString());
    }
}