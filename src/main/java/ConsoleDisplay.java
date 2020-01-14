import java.util.ArrayList;
public class ConsoleDisplay {
    public void printMenu() {
        System.out.println("Personal phone book");
        System.out.println("Select number and press ENTER:");
        System.out.println("1 - ADD; 2 - DELETE; 3 - UPDATE; 4 - SHOW; 5 - FIND; 0 - Exit;");
    }

    public void printContacts(ArrayList<Contact> contacts){
        System.out.println("CONTACTS: ");
        if (contacts.size()==0){
            System.out.println("No contacts found");
        }
        int index = 1;
        for (Contact contact : contacts){
            System.out.println("Index: " + index++);
            System.out.println("Name: " + contact.getName());
            System.out.println("Birthday: " + contact.getBirthday());
            System.out.println("_______________________________________");
        }
    }

    public void printContact(Contact contact){
        System.out.println("CONTACT: ");
        System.out.println("Name: " + contact.getName());
        System.out.println("Phone: " + contact.getPhone());
        System.out.println("Birthday: " + contact.getBirthday());
        System.out.println("_______________________________________");
    }
}
