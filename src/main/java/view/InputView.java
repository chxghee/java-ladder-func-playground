package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        int inputInt = scanner.nextInt();
        System.out.println();
        return inputInt;
    }

    public static String getString() {
        String inputString = scanner.next();
        System.out.println();
        return inputString;
    }
}
