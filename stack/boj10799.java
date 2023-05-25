import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int answer = 0;
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // '('면 카운터 증가
            if (c == '(') {
                count++;
            }
            // ')'
            else if (c == ')') {
                count--;
                // 전 단어가 '('면 레이저
                if (i > 0 && str.charAt(i - 1) == '(') {
                    answer += count;
                }
                // 전 단어가 '('가 아니라면 막대의 끝 -> +1을 해준다.
                else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
