import utils.Input;
import utils.Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts{
    static public Input input = new Input();
    static public Utilities utility = new Utilities();
    static String directory = "data";
    static String filename = "contacts.txt";
    static Path contactsDirectory = Paths.get(directory);
    static Path contactsFile = Paths.get(directory, filename);

    public static void viewContacts(){
        System.out.printf("Name | Number%n---------------%n");
        try {
            List<String> lines = Files.readAllLines(contactsFile);
            int num = 1;
            for(String line : lines){
                String numString = String.valueOf(num);
                line = String.format("%s. %s", numString, line);
                num++;
                System.out.println(line.trim());
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
        String firstName = input.getString("Enter a first name: ").trim();
        String lastName = input.getString("Enter a last name: ").trim();
        String phoneNumber = utility.phoneNumberFormatter(input.getString("""
                                                                          Enter a phone number using one of the following formats:
                                                                          Valid phone numbers must be 7, 10, or 11 digits in length.
                                                                          """));
        String contactInfo = String.format("%s %s | %s", firstName, lastName, phoneNumber).trim();
        List<String> contactsList;
        List<String> newList = new ArrayList<>();
        try {
            contactsList = Files.readAllLines(contactsFile);
            newList.add(contactInfo);
            Files.write(contactsFile, newList, StandardOpenOption.APPEND);
        } catch (
                IOException e) {
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
        String number = input.getString("Enter the number of the contact to remove: ");
        try {
            List<String> lines = Files.readAllLines(contactsFile);
            List<String> newList = new ArrayList<>();
            for(String line : lines){
                if (!line.contains(number)){
                    newList.add(line);
                }
            }
            if (!newList.isEmpty()){
                Files.write(contactsFile, newList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
