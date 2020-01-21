import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        ConsoleDisplay.printMenu();
        while (true){
            if (scanner.hasNextInt()){
                int input = scanner.nextInt();
                if (input== ActionType.EXIT.getIndex()){
                    System.out.println("Close Phone Book ;P");
                    break;
                }
                else if (input == ActionType.ADD.getIndex()) {
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
                    ConsoleDisplay.printMenu();
                    ConsoleDisplay.printContacts(Phonebook.getAllContact());

                }else if (input == ActionType.DELETE.getIndex()){
                    if (Phonebook.getAllContact().size()==0){
                        System.out.println("There are no contacts to delete!");
                    }else {
                        System.out.println("Write the index of the contact which you want to delete");
                        while (true) {
                            if (scanner.hasNextInt()) {
                                int index = scanner.nextInt();
                                phonebook.del(index);
                                ConsoleDisplay.printContacts(Phonebook.getAllContact());
                                break;

                            } else {
                                System.out.println("Please, write the index");
                                scanner.next();
                            }
                        }
                    }
                }else if (input == ActionType.UPDATE.getIndex()){
                    if (Phonebook.getAllContact().size()==0) {
                        System.out.println("There are no contacts to update");
                        ConsoleDisplay.printMenu();
                    }else {
                        System.out.print("Enter id of the contact which you want to update: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Write the index!");
                            scanner.next();
                        }
                        int id = scanner.nextInt();
                        if (Phonebook.getAllContact().size() < id) {
                            System.out.println("The contact with index " + id + " doesn't exist!");
                            ConsoleDisplay.printMenu();
                        } else {
                            ConsoleDisplay.printContact(phonebook.get(id), id);
                            System.out.println("Which field do you want to change?");
                            System.out.println(String.format("%s - Name; %s - Surname; %s - Phone; %s - Birthday; %s - EXIT",
                                    ActionType.Name.getIndex(), ActionType.Surname.getIndex(), ActionType.Phone.getIndex(), ActionType.Birthday.getIndex(), ActionType.EXIT.getIndex()));
                            while (!scanner.hasNextInt()) {
                                System.out.println("Write the number of option!");
                                scanner.next();
                            }
                            while (scanner.hasNextInt()) {
                                int option = scanner.nextInt();
                                if (option == ActionType.Name.getIndex()) {
                                    System.out.print("Set new name: ");
                                    String newName = scanner.next();
                                    phonebook.get(id).setName(newName);
                                    System.out.println("The contact was updated successfully!");
                                    ConsoleDisplay.printContact(phonebook.get(id), id);
                                    break;
                                } else if (option == ActionType.Surname.getIndex()) {
                                    System.out.print("Set new surname: ");
                                    String newName = scanner.next();
                                    phonebook.get(id).setSurname(newName);
                                    System.out.println("The contact was updated successfully!");
                                    ConsoleDisplay.printContact(phonebook.get(id), id);
                                    break;
                                } else if (option == ActionType.Phone.getIndex()) {
                                    System.out.print("Set new phone: ");
                                    String newName = scanner.next();
                                    phonebook.get(id).setPhone(newName);
                                    System.out.println("The contact was updated successfully!");
                                    ConsoleDisplay.printContact(phonebook.get(id), id);
                                    break;
                                } else if (option == ActionType.Birthday.getIndex()) {
                                    System.out.print("Set new birthday: ");
                                    String newName = scanner.next();
                                    phonebook.get(id).setBirthday(newName);
                                    System.out.println("The contact was updated successfully!");
                                    ConsoleDisplay.printContact(phonebook.get(id), id);
                                    break;
                                } else if (option == ActionType.EXIT.getIndex()) {
                                    System.out.println("Close Phone Book ;P");
                                    return;
                                } else {
                                    System.out.println("Please, choose one of the given options");
                                    System.out.println(String.format("%s - Name; %s - Surname; %s - Phone; %s - Birthday; %s - EXIT",
                                            ActionType.Name.getIndex(), ActionType.Surname.getIndex(), ActionType.Phone.getIndex(), ActionType.Birthday.getIndex(), ActionType.EXIT.getIndex()));                                }
                            }
                        }
                    }
                }else if (input == ActionType.SHOW.getIndex()) {
                    if (Phonebook.getAllContact().size() == 0) {
                        System.out.println("There are no contacts to show");
                    } else {
                        System.out.print("Enter id: ");
                        int id = scanner.nextInt();
                        if (Phonebook.getAllContact().size() < id) {
                            System.out.println("The contact with index " + id + " doesn't exist!");

                        } else {
                            ConsoleDisplay.printContact(phonebook.get(id), id);
                        }
                    }
                    ConsoleDisplay.printMenu();
                }
                else if (input == ActionType.FIND.getIndex()) {
                    System.out.println("How do you want to find the contact?");
                    System.out.println(String.format("%s - by name; %s - by first letters; %s - by last 4 digits of number; %s - EXIT",
                            ActionType.byName.getIndex(), ActionType.byFirstLetters.getIndex(), ActionType.byLastDigitsOfNumber.getIndex(), ActionType.EXIT.getIndex()));
                    if (scanner.hasNextInt()) {
                        int option = scanner.nextInt();
                        if (option == ActionType.byName.getIndex()) {
                            System.out.print("Enter name: ");
                            String name = scanner.next();
                            ConsoleDisplay.printFoundContacts(phonebook.findByName(name));
                        } else if (option == ActionType.byFirstLetters.getIndex()) {
                            System.out.print("Enter first letters: ");
                            String name = scanner.next();
                            ConsoleDisplay.printFoundContacts(phonebook.findByNameStart(name));
                        } else if (option == ActionType.byLastDigitsOfNumber.getIndex()) {
                            System.out.print("Enter last 4 digits of number: ");
                            String name = scanner.next();
                            while (name.length() != 4) {
                                System.out.println("You should write 4 digits");
                                name = scanner.next();
                            }
                            ConsoleDisplay.printFoundContacts(phonebook.findByPhone(name));
                        } else if (option == ActionType.EXIT.getIndex()) {
                            System.out.println("Close Phone Book ;P");
                            return;
                        }
                        ConsoleDisplay.printMenu();
                    } else {
                        System.out.println("You should write number");
                    }
                }else if (input == ActionType.SAVE.getIndex()) {
                    FileController.saveToFile(Phonebook.getAllContact());
                    System.out.println("Your contacts were saved successfully!");
                    ConsoleDisplay.printMenu();
                }else if (input == ActionType.SORT.getIndex()) {
                        ConsoleDisplay.printContacts(Phonebook.sortContacts());
                }else {
                    System.out.println("You should write number from 0 to 7");
                }
            }else {
                System.out.println("Please, write the number of option");
                scanner.next();
            }

        }
    }
}