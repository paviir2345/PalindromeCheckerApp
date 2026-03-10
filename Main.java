import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack based strategy
class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : input.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }
}

// Deque based strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// Context class to use strategy
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.checkPalindrome(input);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word:");
        String input = scanner.nextLine();

        PalindromeContext context = new PalindromeContext();

        System.out.println("Choose strategy: 1-Stack  2-Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                context.setStrategy(new StackStrategy());
                break;
            case 2:
                context.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice, defaulting to Stack");
                context.setStrategy(new StackStrategy());
        }

        boolean result = context.executeStrategy(input);

        if (result) {
            System.out.println("The word is a Palindrome");
        } else {
            System.out.println("The word is NOT a Palindrome");
        }

        scanner.close();
    }
}