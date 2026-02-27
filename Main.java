import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App");

        // Take input from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String original = scanner.nextLine();

        // Reverse string using loop
        String reversed = "";

        for(int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Compare original and reversed
        if(original.equals(reversed)) {
            System.out.println(original + " is a palindrome");
        } else {
            System.out.println(original + " is not a palindrome");
        }

        scanner.close();
    }
}