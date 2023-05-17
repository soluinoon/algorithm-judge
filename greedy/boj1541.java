import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int n;
        String temp;
        int minus = 0;
        int count = 0;
        int res = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp = br.readLine();
        minus = countChar(temp, '-');
        StringTokenizer st = new StringTokenizer(temp, "-");
        for (int i = 0; i <= minus; i++) {
            temp = st.nextToken();
            if (i == 0)
                res += sum(temp);
            else
                res -= sum(temp);
        }
        System.out.println(res);
    }

    static int sum(String str) {
        int plus = countChar(str, '+');
        int sum = 0;
        int next;

        StringTokenizer st = new StringTokenizer(str, "+");
        for (int i = 0; i <= plus; i++) {
            next = Integer.parseInt(st.nextToken());
            sum = sum + next;
        }
        return (sum);
    }
    static int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i <str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }
        return count;
    }
}
