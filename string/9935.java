import java.io.*;
import java.util.*;

public class App {

    static int n;
    static StringBuilder str;
    static StringBuilder find;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = new StringBuilder();
        find = new StringBuilder();

        str = str.append(br.readLine());
        find = find.append(br.readLine());
        
        for (int i = 0; i < find.length(); i++) {
            destroy(find.charAt(i));
        }
        if (str.length() != 0)
            System.out.println(str);
        else
            System.out.println("FRULA");    
        }
    
        public static void destroy(char c) {
            int cIndex = 0;
            StringBuilder find = new StringBuilder();
            find.append(c);
            while(1) {
                cIndex = str.indexOf(find);
                if (cIndex == -1)
                    return;
                str.deleteCharAt(cIndex);
            }
        }
}