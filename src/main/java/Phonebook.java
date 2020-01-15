import java.util.ArrayList;

public class Phonebook {
    private ArrayList<Contact> contacts = new ArrayList<>();


    public ArrayList<Contact> getAllContact(){
        return contacts;
    }

    protected void add(Contact contact){
        contacts.add(contact);
    }

    public Contact get(int id){
        return contacts.get(--id);
    }

    public void del(int id){
        if (contacts.size() < id) {
            System.out.println("The contact with index " + id + " doesn't exist!");
            System.out.println("1 - ADD; 2 - DELETE; 3 - UPDATE; 4 - SHOW; 5 - FIND; 0 - Exit;");

        }else {
            contacts.remove(--id);
            System.out.println("The contact was deleted successfully!");
        }
    }

    public ArrayList<Contact> findByName(String name){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equals(String.valueOf(name.charAt(0)).toUpperCase()+ name.substring(1))){
                result.add(contact);
            }
        }
        return result;
    }

    public ArrayList<Contact> findByNameStart(String value){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts){
            if (contact.getName().startsWith(value)){
                result.add(contact);
            }
        }
        return result;
    }

    public ArrayList<Contact> findByPhone(String value){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts){
            if (contact.getPhone().endsWith(value)){
                result.add(contact);
            }
        }
        return result;
    }
}
