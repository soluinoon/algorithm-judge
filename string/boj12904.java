import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder source = new StringBuilder(br.readLine());
        StringBuilder target = new StringBuilder(br.readLine());

        while (target.length() != source.length()) {
            if (target.charAt(target.length() - 1) == 'A') {
                deleteA(target);
            } else {
                deleteBAndReverse(target);
            }
        }

        if ((target.toString()).equals(source.toString())) {
            answer = 1;
        }

        System.out.println(answer);

    }



    public static void appendA(StringBuilder str) {
        str.append("A");
    }

    public static void deleteA(StringBuilder str) {
        str.deleteCharAt(str.length() - 1);
    }

    public static void reverseAndAppendB(StringBuilder str) {
        str.reverse();
        str.append("B");
    }

    public static void deleteBAndReverse(StringBuilder str) {
        str.deleteCharAt(str.length() - 1);
        str.reverse();
    }
}
