import java.util.Scanner;

public class UC10NormalizedPalindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        // Normalize string
        input = input.toLowerCase().replaceAll("\\s+", "");

        boolean isPalindrome = true;

        int start = 0;
        int end = input.length() - 1;

        // Palindrome check
        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("The sentence is a Palindrome");
        } else {
            System.out.println("The sentence is NOT a Palindrome");
        }

        scanner.close();
    }
}