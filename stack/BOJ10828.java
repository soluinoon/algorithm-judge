import java.io.*;
import java.util.*;

class BOJ10828 {
    /**
     * 10828
     * 스택
     * 22-12-24
     */
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> stack = new ArrayList<>();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String action = st.nextToken();

            if (action.equals("push")) {
                push(stack, Integer.parseInt(st.nextToken()));
            } else if (action.equals("top")) {
                System.out.println(top(stack));
            } else if (action.equals("size")) {
                System.out.println(size(stack));
            } else if (action.equals("empty")) {
                System.out.println(empty(stack));
            } else {
                System.out.println(pop(stack));
            }
        }
    }

    public static void push(ArrayList<Integer> stack, int value) {
        stack.add(value);
    }

    public static int pop(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        } else {
            int value = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return value;
        }
    }

    public static int size(ArrayList<Integer> stack) {
        return stack.size();
    }

    public static int top(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    public static int empty(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}