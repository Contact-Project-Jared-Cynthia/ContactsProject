package utils;
import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.printf(prompt);
        return scanner.nextLine();
    }

    public boolean yesNo() {
        String userInput = scanner.nextLine();
        return userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes");
    }

    public boolean yesNo(String prompt) {
        System.out.printf(prompt);
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes");
    }

    public int getInt(int min, int max) {
        System.out.printf("Enter an integer between %d and %d%n", min, max);
        int userInput = scanner.nextInt();
        if (userInput >= min && userInput <= max) {
            return userInput;
        }
        return getInt(min, max);
    }

    public int getInt(String prompt) {
        System.out.printf(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getInt() {
        System.out.println("Enter a whole number.");
        return scanner.nextInt();
    }

    public double getDouble(double min, double max) {
        System.out.printf("Enter a double between %.2f and %.2f", min, max);
        double userInput = scanner.nextDouble();
        if (userInput >= min && userInput <= max) {
            return userInput;
        }
        return getDouble(min, max);
    }

    public double getDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(scanner.nextLine());
    }

    public double getDouble() {
        System.out.println("Enter a number");
        return scanner.nextDouble();
    }

    public void getGhost(){
        System.out.println("");
        String ghost = scanner.nextLine();
    }

}
