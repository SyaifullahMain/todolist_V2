package saef.presentation.tui.utils;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtil {
    private final Scanner scanner;

    public InputUtil(InputStream source) {
        this.scanner = new Scanner(source).useDelimiter(Pattern.compile("\r\n|\n"));
    }
    public void close() {
        scanner.close();
    }
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.next().trim();
    }
    public String getNonEmptyString(String prompt) {
        while (true) {
            String userInput = getString(prompt);
            if (!userInput.trim().isEmpty()) {
                return userInput;
            }
            System.out.println("Input can't be empty!");
        }
    }
    public int getNonEmptyPositiveInteger(String prompt) {
        while (true) {
            String userInput = getNonEmptyString(prompt);
            int userInputNumber;
            try {
                userInputNumber = Integer.parseInt(userInput);
            } catch (InputMismatchException e) {
                System.out.println("Please insert the number correctly!");
                continue;
            }
            return userInputNumber;
        }
    }
}
