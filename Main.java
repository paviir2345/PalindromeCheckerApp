import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker using Stack");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String original = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        // Push characters
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        // Pop characters to reverse
        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare
        if (original.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }
}