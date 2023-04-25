import utils.Input;

public class Main{
    static Input input = new Input();
    public static void main(String[] args){
        Contacts.createContactsList();
        while (true){
            String menuSelection = input.getString("""
                                                   
                                                   Please select from the following options:
                                                   1. View Contacts
                                                   2. Search Contacts
                                                   3. Add a new contact
                                                   4. Delete a contact
                                                   5. Exit
                                                   """);
            if (menuSelection.equalsIgnoreCase("5")){
                System.out.println("Thanks");
                break;
            }

            switch (menuSelection){
                case "1" -> Contacts.viewContacts();
                case "2" -> Contacts.searchContacts();
                case "3" -> Contacts.addContact();
                case "4" -> Contacts.removeContact();
            }
        }
    }
}