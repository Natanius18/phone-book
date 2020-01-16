import java.util.ArrayList;
public class ConsoleDisplay {
    public static void printMenu() {
        System.out.println("PERSONAL PHONE BOOK");
        System.out.println("Select number and press ENTER:");
        System.out.println(String.format("%s - ADD; %s - DELETE; %s - UPDATE; %s - SHOW; %s - FIND; %s - Exit",
                ActionType.ADD.getIndex(), ActionType.DELETE.getIndex(), ActionType.UPDATE.getIndex(), ActionType.SHOW.getIndex(),ActionType.FIND.getIndex(),ActionType.EXIT.getIndex()));
    }

    public static void printContacts(ArrayList<Contact> contacts){
        System.out.println("CONTACTS: ");
        if (contacts.size()==0){
            System.out.println("No contacts found");
        }
        int index = 1;
        for (Contact contact : contacts){
            System.out.println("Index: " + index++);
            System.out.println("Name: " + contact.getName());
            System.out.println("_____________");
        }
    }

    public static void printContact(Contact contact, int id){
        System.out.println("CONTACT " + id + ":");
        System.out.println("Name: " + contact.getName());
        System.out.println("Surname: " + contact.getSurname());
        System.out.println("Phone: " + contact.getPhone());
        System.out.println("Birthday: " + contact.getBirthday());
        System.out.println("_____________________________");
    }

//    public static void printFoundContacts(ArrayList<Contact> contacts){
//        Phonebook phonebook = new Phonebook();
//        System.out.println("CONTACTS: ");
//        if (contacts.size()==0){
//            System.out.println("No contacts found");
//        }
//        for (Contact contact : contacts){
//            System.out.println("Index: " + phonebook.getAllContact().indexOf(contact));
//            System.out.println("Name: " + contact.getName());
//            System.out.println("_____________");
//        }
//    }
}
