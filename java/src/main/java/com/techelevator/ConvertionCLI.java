package com.techelevator;
import com.techelevator.view.Menu;
import com.techelevator.Fibonacci;
import java.awt.*;
import java.util.Scanner;

public class ConvertionCLI {

        private static final String MAIN_MENU_OPTION_CONVERSION_TABLE = "Main Conversion Table";
        private static final String MAIN_MENU_OPTION_EXIT = "Exit";
        private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_CONVERSION_TABLE,
                MAIN_MENU_OPTION_EXIT};
        private Menu menu;

        private Scanner userInput = new Scanner(System.in);

    public ConvertionCLI(Menu menu) {
        this.menu = menu;
    }

        public void run() {

            boolean shouldLoop = true;
            while (shouldLoop) {
                String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
                if (choice.equals(MAIN_MENU_OPTION_CONVERSION_TABLE)) {
                    conversionMenu();
                } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                    shouldLoop = false;
                } else {
                    shouldLoop = false;
                }
            }
        }

    public void conversionMenu() {
        final String DECIMAL_TO_BINARY = "Decimal to Binary";
        final String FIBONACCI = "Fibonacci Sequence Generator";
        final String LIN_CONVERT = "Linear Conversion";
        final String MAKE_CHANGE = "Make Change";
        final String TEMP_CONVERT  = "Temperature Converter";
        final String EXIT_CONVERTER = "" +
                "Exit Converter";

        final String[] PURCHASE_MENU_OPTIONS = {DECIMAL_TO_BINARY, FIBONACCI, LIN_CONVERT, MAKE_CHANGE, TEMP_CONVERT, EXIT_CONVERTER};


        boolean purchaseLoop = true;

        while (purchaseLoop) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            switch (choice) {
                case DECIMAL_TO_BINARY:
                    decimalToBinary();
                    break;
                case FIBONACCI:
                    fibonacci();
                    break;
                case LIN_CONVERT:
                    linearConvert();
                    break;
                case MAKE_CHANGE:
                    makeChange();
                    break;
                case TEMP_CONVERT:
                    tempConvert();
                    break;
                case EXIT_CONVERTER:
                    System.out.println("Thank you for visiting my unit converter program");
                    purchaseLoop = false;

            }

        }
    }
    public void decimalToBinary() {
        String[] args = null;
        for (int ix = 0; ix < args.length; ix++) {

            String binary = "";

            int decimal = Integer.parseInt(args[ix]);
            for (; decimal > 0; decimal = decimal / 2) { // the first and last section of the for loop are optional.  Here, we do not do anything before the for loop begins.
                binary = (decimal % 2) + binary;
            }

            System.out.println(args[ix] + " in binary is " + binary);
        }
    }
    public void fibonacci() {
        String[] args = null;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        String limitInput = userInput.nextLine();

        int limit = Integer.parseInt(limitInput);
        int previous = 1;
        System.out.print("0, 1");

        for (int next = 1; next <= limit; ) {
            System.out.print(", " + next);
            int temp = previous + next;
            previous = next;
            next = temp;
        }
    }
    public void linearConvert() {
        String[] args = null;
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the length: ");
        String lengthInput = userInput.nextLine();
        int length = Integer.parseInt(lengthInput);

        System.out.print("Is the measurement in (m)eters, or (f)eet?: ");
        String unitInput = userInput.nextLine();

        if ("f".equals(unitInput)) {
            int meterLength = (int) (length * .3048);
            System.out.println(length + "f is " + meterLength + "m.");
        } else if ("m".equals(unitInput)) {
            int feetLength = (int) (length * 3.2808399);
            System.out.println(length + "m is " + feetLength + "f.");
        } else {
            System.out.println(unitInput + " is an invalid choice.");
        }

    }
    public void makeChange() {
        String[] args = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Change Calculator!");
        System.out.println("Please enter the bill amount: ");
        String billAmount = scanner.nextLine();
        double bill = Double.parseDouble(billAmount);
        System.out.println("Please enter the amount tendered: ");
        String tenderedAmount = scanner.nextLine();
        double tender = Double.parseDouble(tenderedAmount);

        double change = tender - bill;
        System.out.println("The change required is " + change);
    }
    public void tempConvert() {
        String[] args = null;
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the temperature: ");
        String tempInput = userInput.nextLine();
        int temp = Integer.parseInt(tempInput);

        System.out.print("Is the temperature in (C)elcius, or (F)arenheit?: ");
        String scaleInput = userInput.nextLine();

        if ("F".equals(scaleInput)) {
            int celciusTemp = (int) ((temp - 32) / 1.8);
            System.out.println(temp + "F is " + celciusTemp + "C.");
        } else if ("C".equals(scaleInput)) {
            int fahrenheitTemp = (int) ((temp * 1.8) + 32);
            System.out.println(temp + "C is " + fahrenheitTemp + "F.");
        } else {
            System.out.println(scaleInput + " is an invalid choice.");
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        ConvertionCLI cli = new ConvertionCLI(menu);
        cli.run();

    }
    }
