import java.util.*;
import java.io.*;

/*
 * 1339 단어수학
 * 
 */

public class Main {

    static StringBuilder word[];
    static int res, n;
    static int[] next;
    static int alphabet[]; //-65;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        word = new StringBuilder[n];
        next = new int[2];
        alphabet = new int[26];

        // input
        for (int i = 0; i < n; i++) {
            word[i] = new StringBuilder();
            word[i].append(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            countCipher(word[i]);
        }
        // excute
        // check grade
        int number = 9;
        while (true) {
            next = checkBig();
            if (next[0] == -1)
                break;
            for (int i = 0; i < n; i++) {

                int cipher = 1;
                for (int index = word[i].length(); index > 1; index--) {
                    cipher *= 10;
                }

                for (int j = 0; j < word[i].length(); j++) {
                    if (word[i].charAt(j) - 65 == next[0]) {
                        res += number * cipher;
                    }
                    cipher /= 10;
                }
            }
            number--;
        }
        System.out.println(res);
    }
    
    public static int[] checkBig() {
        int big = 0;
        int index = -1;

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > big) {
                big = alphabet[i];
                index = i;
            }
        }
        if (index != -1)
            alphabet[index] = 0;
        int[] next = {index, big};
        return next;
    }

    public static void countCipher(StringBuilder str) {
        
        int cipher = 1;
        // 자릿수
        for (int index = str.length(); index > 1; index--) {
            cipher *= 10;
        }

        for (int i = 0; i < str.length(); i++) {
            alphabet[str.charAt(i) - 65] += cipher;
            cipher /= 10;
        }
        
    }
}