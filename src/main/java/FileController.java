import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
                String[] dataName = data[0].split(" ");
                String[] dataSurname = data[1].split(" ");
                String[] dataNumber = data[2].split(" ");
                String[] dataAge = data[3].split(" ");
                contact = new Contact(dataName[1], dataSurname[2], dataNumber[2], dataAge[2]);
            }
            return contact;
        }

    }

