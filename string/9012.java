import java.io.*;
import java.util.*;

public class App {

    static int n;
    static StringBuilder str;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int count1 = 0;
            int count2 = 0;

            str = new StringBuilder();

            str.append(br.readLine());
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ')') 
                    count1++;
                else if (str.charAt(j) == '(') 
                    count2++;
            }
            if (count1 == count2)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}