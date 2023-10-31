package saef.presentation.tui.utils;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtil {
    private final Scanner scanner;
    private final ResourceBundleUtil bundle;

    public InputUtil(InputStream source, ResourceBundleUtil bundle) {
        this.scanner = new Scanner(source).useDelimiter(Pattern.compile("\r\n|\n"));
        this.bundle = bundle;
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
            System.out.println(bundle.loadBandle("cantEmpty"));
        }
    }
    public int getNonEmptyPositiveInteger(String prompt) {
        while (true) {
            String userInput = getNonEmptyString(prompt);
            int userInputNumber;
            try {
                userInputNumber = Integer.parseInt(userInput);
            } catch (InputMismatchException e) {
                System.out.println(bundle.loadBandle("pleaseInsertNumber"));
                continue;
            }
            return userInputNumber;
        }
    }
}
