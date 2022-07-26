import java.io.*;
import java.util.*;

public class App {

    static int n;
    static int result = 0;
    static int list[];
    static StringBuilder str[];
    static StringBuilder find;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new int[n];
        find = new StringBuilder();

        for (int i = 0; i < n; i++) {

            result = 0;
            // input
            list[i] = Integer.parseInt(br.readLine());
            str = new StringBuilder[list[i]];
            for (int j = 0; j < list[i]; j++) {
                str[j] = new StringBuilder();
                str[j].append(br.readLine());
            }        
            
            // find
            Loop1 :
            for (int j = 0; j < list[i]; j++) {
                for (int k = 0; k <list[i]; k++) {
                    if (k == j || str[k].length() > str[j].length())
                        continue;
                    //System.out.println("str[k] = " + str[k] + " str[j] =" + str[j]);
                    if (str[j].indexOf(str[k].toString()) != -1) {
                        result = 1;
                        break Loop1;
                    }
                }
            }
            if (result == 1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}

    
