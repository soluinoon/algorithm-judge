import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        StringBuilder reversedTarget = new StringBuilder(br.readLine()).reverse();

//        System.out.println("str = " + str);
//        System.out.println("reversedTarget = " + reversedTarget.toString());

        for (int i = 0; i < str.length(); i++) {
            // 스택에 문자 추가
            stack.add(str.charAt(i));
            boom(stack, reversedTarget);
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        if (answer.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer.reverse().toString());
        }
    }

    private static void boom(Stack<Character> stack, StringBuilder reversedTarget) {
        // 스택의 사이즈가 타겟길이보다 크거나 같고, 타겟 문자열의 첫번째 문자랑 같다면 검사
        while (stack.size() >= reversedTarget.length() && stack.peek() == reversedTarget.charAt(0)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < reversedTarget.length(); i++) {
                sb.append(stack.pop());
            }
//            System.out.println("sb = " + sb.toString());
//            System.out.println("reversedTarget = " + reversedTarget);
            // 만약 타겟 문자열이라면 continue로 또 검사
            if (sb.toString().equals(reversedTarget.toString())) {
//                System.out.println("Main.boom");
                continue;
            }
            // 아니라면 다시 넣고 break
            else {
                for (int j = sb.length() - 1; j >= 0; j--) {
                    stack.add(sb.charAt(j));
                }
                break;
            }
        }
    }

}
