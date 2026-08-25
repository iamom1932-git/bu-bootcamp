import java.util.*; 

public class ContactManager { 

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Alan Turing", new Contact("Alan Turing", "+1 617 555 0102"));
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 617 555 0103"));
        contacts.put("Tim Berners-Lee", new Contact("Tim Berners-Lee", "+1 617 555 0104"));
        contacts.put("Katherine Johnson", new Contact("Katherine Johnson", "+1 617 555 0105"));

        // Step 5: look up a contact 
        Contact contact = contacts.get("Ada Lovelace");

        if (contact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(contact);
        }

        // Test with a name that does not exist
        Contact missingContact = contacts.get("Albert Einstein");

        if (missingContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missingContact);
        }

        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");

        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}