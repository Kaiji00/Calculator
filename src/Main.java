import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static int result;
    static final String[] arabicNumerals = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static final String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
    static String resultRoman;
    static List arabicList = new ArrayList<>(Arrays.asList(arabicNumerals));
    static List romanList = new ArrayList<>(Arrays.asList(roman));

    public static void main(String[] args) throws IOException {
        System.out.println("Enter an expression with two variables in one line separated by a space");
        String userInput = scanner.nextLine();
        if (userInput == null) {
            throw new IOException("Empty string");
        }
        System.out.println(calc(userInput));
    }

    public static String calc(String input) throws IOException {
        String[] values = input.split(" ");
        if (values.length != 3) {
            throw new IOException("The format of the mathematical operation does not satisfy the task");
        }
        if (arabicList.contains(values[0]) &&  arabicList.contains(values[2])) {
            number1 = Integer.parseInt(values[0]);
            number2 = Integer.parseInt(values[2]);
            if ((number1 < 0 || number1 > 10) && (number2 < 0 || number2 > 10))
                throw new IOException("You can only enter numbers from 1 to 10");
            calculate(values[1]);
            return Integer.toString(result);
        }
        if (romanList.contains(values[0]) &&  romanList.contains(values[2])){
             number1 = romanToNumber(values[0]);
             number2 = romanToNumber(values[2]);
             calculate(values[1]);
             if (result <= 0)
                 throw new IOException("Roman numerals cannot be negative or 0");
        for (int i = 0; i <= roman.length; i++) {
            if (result == i) {
                resultRoman = roman[i - 1];
            }
        }
        return resultRoman;
        } else throw new IOException("You can only use Arabic and Roman integer numerals at 1 or I do 10 or X");
    }

    private static int romanToNumber (String roman){

        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new InputMismatchException("You can use Roman numerals at I do X");
        };
    }

    static void calculate(String value) {
        switch (value) {
            case "+" -> result = number1 + number2;
            case "-" -> result = number1 - number2;
            case "/" -> result = number1 / number2;
            case "*" -> result = number1 * number2;
            default -> throw new IllegalStateException("Invalid operator: " + value);
        }
    }
}


