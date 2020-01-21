import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Phonebook {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static ArrayList<Contact> getAllContact() {
        return contacts;
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public Contact get(int id) {
        return contacts.get(--id);
    }

    public void del(int id) {
        if (contacts.size() < id) {
            System.out.println("The contact with index " + id + " doesn't exist!");
        } else {
            contacts.remove(--id);
            System.out.println("The contact was deleted successfully!");
        }
    }

    public ArrayList<Contact> findByName(String name) {
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equals(String.valueOf(name.charAt(0)).toUpperCase() + name.substring(1))) {
                result.add(contact);
            }
        }
        return result;
    }

    public ArrayList<Contact> findByNameStart(String value) {
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith(String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1))) {
                result.add(contact);
            }
        }
        return result;
    }

    public ArrayList<Contact> findByPhone(String value) {
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getPhone().endsWith(value)) {
                result.add(contact);
            }
        }
        return result;
    }

    public static ArrayList<Contact> sortContacts(){
        ArrayList<Contact> sortedArray = contacts;
        sortedArray.sort(Comparator.comparing(Contact::getName));
        return sortedArray;
    }
}