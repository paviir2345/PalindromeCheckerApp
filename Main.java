import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String original = scanner.nextLine();

        // Using StringBuilder to reverse
        StringBuilder builder = new StringBuilder(original);
        String reversed = builder.reverse().toString();

        // Compare strings
        if(original.equals(reversed)) {
            System.out.println(original + " is a palindrome");
        } else {
            System.out.println(original + " is not a palindrome");
        }

        scanner.close();
    }
}