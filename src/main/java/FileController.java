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
    }

