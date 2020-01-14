import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay();
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);

        while (true){
            consoleDisplay.printMenu();
            if (scanner.hasNextInt()){
                int input = scanner.nextInt();
                if (input==0){
                    System.out.println("Close Phone Book ;P");
                    break;
                }
                else if (input == 1) {
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter surname: ");
                    String surname = scanner.next();
                    System.out.print("Enter phone: ");
                    String phone = scanner.next();
                    System.out.print("Enter birthday: ");
                    String birthday = scanner.next();
                    Contact contact = new Contact(name, surname, phone, birthday);

                    phonebook.add(contact);
                    consoleDisplay.printContacts(phonebook.getAllContact());

                }else if (input ==2){
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    phonebook.del(id);
                    consoleDisplay.printContacts(phonebook.getAllContact());
                }else if (input == 3){
                    System.out.print("Enter id of the contact which you want to update: ");
                    while (!scanner.hasNextInt()){
                        System.out.println("Write the index!");
                        scanner.next();
                    }
                    int id = scanner.nextInt();
                    consoleDisplay.printContact(phonebook.get(id), id);
                    System.out.println("Which field do you want to change?");
                    System.out.println("1 - Name; 2 - Surname; 3 - Phone; 4 - Birthday; 0 - EXIT");
                    while (!scanner.hasNextInt()){
                        System.out.println("Write the number of option!");
                        scanner.next();
                    }
                    while (scanner.hasNextInt()) {
                        int option = scanner.nextInt();
                        if (option == 1) {
                            System.out.print("Set new name: ");
                            String newName = scanner.next();
                            phonebook.get(id).setName(newName);
                            System.out.println("The contact was updated successfully!");
                            consoleDisplay.printContact(phonebook.get(id), id);
                            break;
                        }else if (option == 2){
                            System.out.print("Set new surname: ");
                            String newName = scanner.next();
                            phonebook.get(id).setSurname(newName);
                            System.out.println("The contact was updated successfully!");
                            consoleDisplay.printContact(phonebook.get(id), id);
                            break;
                        } else if (option == 3) {
                            System.out.print("Set new phone: ");
                            String newName = scanner.next();
                            phonebook.get(id).setPhone(newName);
                            System.out.println("The contact was updated successfully!");
                            consoleDisplay.printContact(phonebook.get(id), id);
                            break;
                        } else if (option == 4) {
                            System.out.print("Set new birthday: ");
                            String newName = scanner.next();
                            phonebook.get(id).setBirthday(newName);
                            System.out.println("The contact was updated successfully!");
                            consoleDisplay.printContact(phonebook.get(id), id);
                            break;
                        } else if (option == 0) {
                            System.out.println("Close Phone Book ;P");
                            return;
                        }else {
                            System.out.println("1 - Name; 2 - Phone; 3 - Birthday; 0 - EXIT");
                        }
                    }
                }else if (input == 4){
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    consoleDisplay.printContact(phonebook.get(id), id);
                }else if (input == 5) {
                    System.out.println("How do you want to find the contact?");
                    System.out.println("1 - by name; 2 - by first letters; 3 - by last 4 digits of number; 0 - EXIT");
                    if (scanner.hasNextInt()) {
                        int option = scanner.nextInt();
                        if (option == 1) {
                            System.out.print("Enter name: ");
                            String name = scanner.next();
                            ArrayList<Contact> filteredContacts = phonebook.findByName(name);
                            consoleDisplay.printContacts(filteredContacts);
                        }else if (option == 2){
                            System.out.print("Enter first letters: ");
                            String name = scanner.next();
                            ArrayList<Contact> filteredContacts = phonebook.findByNameStart(name);
                            consoleDisplay.printContacts(filteredContacts);
                        }else if (option == 3){
                            System.out.print("Enter last 4 digits of number: ");
                            String name = scanner.next();
                            while (name.length() != 4){
                                System.out.println("You should write 4 digits");
                                name = scanner.next();
                            }
                            ArrayList<Contact> filteredContacts = phonebook.findByPhone(name);
                            consoleDisplay.printContacts(filteredContacts);
                        }
                    } else {
                        System.out.println("Looser! ;P");
                        break;
                    }
                }
            }else {
                System.out.println("Looser! ;P");
                break;
            }
        }
        scanner.close();
    }
}