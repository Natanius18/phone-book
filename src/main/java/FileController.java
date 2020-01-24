import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

    public class FileController {
        public static void saveToFile(ArrayList<Contact> contacts){
            try {
                FileWriter fstream = new FileWriter("PhoneBook.txt");
                for (Contact contact : contacts) {
                    fstream.write(contact.toString() + "\n");
                }
                fstream.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public static ArrayList<Contact> importFromTxt(){
            ArrayList<Contact> contacts = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("PhoneBook.txt"));
                String line;
                while (true){
                    line = reader.readLine();
                    if (line == null){
                        break;
                    }
                    contacts.add(parseContactLine(line));
                }
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            return contacts;
        }

        private static Contact parseContactLine(String line){
            String [] data = line.split(";");
            Contact contact = null;
            if (data.length == 4){
                contact = new Contact(data[0], data[1], data[2], data[3]);
            }
            return contact;
        }

    }

