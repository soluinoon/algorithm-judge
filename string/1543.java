import java.util.*;
import java.io.*;

/*
 * 1543 문서검색
 * 
 */

public class Main {

    static StringBuilder doc;
    static StringBuilder find;
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        doc = new StringBuilder();
        find = new StringBuilder();

        doc.append(br.readLine());
        find.append(br.readLine());

        // input
        for (int i = 0; i < doc.length(); i++) {
            if (doc.charAt(i) == find.charAt(0)) {
                i = checkFind(i);
            }
        }

        System.out.println(res);
    }

    public static int checkFind(int index) {
        
        for (int i = 0; i < find.length(); i++) {
            if (index + i >= doc.length())
                return index;
            if (find.charAt(i) != doc.charAt(index + i))
                return index;
        }
        res++;
        return index + find.length() - 1;
    }
}