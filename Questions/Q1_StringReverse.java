import java.util.Scanner;

// Time Complexity = O(n)
public class Q1_StringReverse {
    public static String reverseStr(String input) {
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--) { // Modified loop condition
            output += input.charAt(i);
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        String output = reverseStr(input);
        System.out.println(output);
    }
}
