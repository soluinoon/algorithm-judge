import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ1874 {

        static Stack<Integer> stack = new Stack<>();
        static ArrayList<Character> answer = new ArrayList<>();
        static int count = 1;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int number = Integer.parseInt(br.readLine());
//            System.out.println("number = " + number + " counter = " + count);

                if (stack.isEmpty()) {
                    if (count <= number) {
//                    System.out.println("Main.main");
                        while (count <= number) {
                            pushWithSout(count);
                            count++;
                        }
                        popWithSout();
                    } else {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    if (stack.peek() == number) {
//                    System.out.println("stack = " + stack.peek());
//                    System.out.println("Main.main2");
                        popWithSout();
                    } else {
//                    System.out.println("stack = " + stack.peek());
//                    System.out.println("Main.main3");
                        if (count <= number) {
                            while (count <= number) {
                                pushWithSout(count);
                                count++;
                            }
                            popWithSout();
                        } else {
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }

        public static void pushWithSout(int number) {
            stack.push(number);
            answer.add('+');
        }

        public static void popWithSout() {
            stack.pop();
            answer.add('-');
        }
    }
}
