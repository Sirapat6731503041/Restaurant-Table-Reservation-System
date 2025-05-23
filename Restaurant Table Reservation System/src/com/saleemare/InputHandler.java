package src.com.saleemare;
import java.util.Scanner;

/**
 * This class handles input from the keyboard.
 * It uses exception handling to ensure valid user input.
 */
public class InputHandler {
    private Scanner scanner = new Scanner(System.in);

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("⚠️ Input must be between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid number format.");
            }
        }
    }


    //Accept only alphabetic names
    public String getValidatedName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine();
            if (name.matches("[a-zA-Z ]+")) {
                return name;
            } else {
                System.out.println("Name must contain letters only.");
            }
        }
    }
}

