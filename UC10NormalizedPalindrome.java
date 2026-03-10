import java.util.Scanner;

class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        input = input.toLowerCase().replaceAll("\\s+", "");

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word or sentence:");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The input is a Palindrome");
        } else {
            System.out.println("The input is NOT a Palindrome");
        }

        scanner.close();
    }
}