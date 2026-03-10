import java.util.*;
import java.util.Stack;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack based
class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) stack.push(ch);
        for (char ch : input.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }
}

// Deque based
class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// Recursive based
class RecursiveStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        return isPalindrome(input, 0, input.length() - 1);
    }
    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
}

// Context
class PalindromeContext {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean executeStrategy(String input) { return strategy.checkPalindrome(input); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word or sentence:");
        String input = scanner.nextLine();

        PalindromeContext context = new PalindromeContext();

        // List of strategies
        Map<String, PalindromeStrategy> strategies = new LinkedHashMap<>();
        strategies.put("Stack", new StackStrategy());
        strategies.put("Deque", new DequeStrategy());
        strategies.put("Recursive", new RecursiveStrategy());

        System.out.println("\nPerformance Comparison:");

        for (Map.Entry<String, PalindromeStrategy> entry : strategies.entrySet()) {
            context.setStrategy(entry.getValue());
            long startTime = System.nanoTime();
            boolean result = context.executeStrategy(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println(entry.getKey() + " → " +
                (result ? "Palindrome" : "Not Palindrome") +
                " | Time: " + duration + " ns");
        }

        scanner.close();
    }
}