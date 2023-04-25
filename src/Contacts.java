import utils.Input;
import utils.PhoneNumberFormatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts{
    static private Input input = new Input();
    static private PhoneNumberFormatter numberFormatter = new PhoneNumberFormatter();
    static String directory = "data";
    static String filename = "contacts.txt";
    static Path contactsDirectory = Paths.get(directory);
    static Path contactsFile = Paths.get(directory, filename);

    public static void viewContacts(){
        try {
            List<String> lines = Files.readAllLines(contactsFile);
            for(String line : lines){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createContactsList(){
        if (Files.notExists(contactsDirectory)){
            try {
                Files.createDirectories(contactsDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Files.notExists(contactsFile)){
            try {
                Files.createFile(contactsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addContact(){
        String firstName = input.getString("Enter a first name: ");
        String lastName = input.getString("Enter a last name: ");
        String phoneNumber = numberFormatter.phoneNumberFormatter(input.getString("""
                                                                                  Enter a phone number using one of the following formats:
                                                                                  Valid phone numbers must be between 7 and 11 digits in length.
                                                                                  """));

        String contactInfo = String.format("%s %s | %s", firstName, lastName, phoneNumber);
        List<String> contactsList = Arrays.asList(contactInfo);
        try {
            Files.write(contactsFile, contactsList, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchContacts(){
        String contact = input.getString("Enter the name or number of the contact you're searching for: ");

        try {
            List<String> lines = Files.readAllLines(contactsFile);
            for(String line : lines){
                if (line.toLowerCase().contains(contact.toLowerCase())){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeContact(){
        String contact = input.getString("Enter the name or number of the contact you want to remove: ");
        try {
            List<String> lines = Files.readAllLines(contactsFile);
            for (String line : lines) {
                if (line.toLowerCase().contains(contact.toLowerCase())){
                    lines.remove(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
