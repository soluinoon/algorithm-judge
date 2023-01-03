import java.io.*;
import java.util.*;

public class Main {

    /**
     * 4949
     * 균형잡힌 세상
     * 23-01-02
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = "";
        while (true) {
            temp = br.readLine();
            if (temp.equals(".")) {
                break;
            }
            if (isHarmony(temp)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isHarmony(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isBracket(c)) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if (canDestroy(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isBracket(char c) {
        return (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']');
    }

    public static boolean canDestroy(char peek, char c) {
        if (peek == '(' && c == ')') {
            return true;
        } else if (peek == '{' && c == '}') {
            return true;
        } else if (peek == '[' && c == ']') {
            return true;
        }
        return false;
    }
}