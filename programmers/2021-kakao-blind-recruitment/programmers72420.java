import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder before = new StringBuilder();

        // 1
        new_id = new_id.toLowerCase();
        // System.out.println(String.format("1 = %s", new_id));
        
        // 2 && 3
        for (int i = 0; i < new_id.length(); i++) {
            if (isAllowedWord(new_id.charAt(i))) {
                if (before.length() != 0 && before.charAt(before.length() - 1) == '.' &&  new_id.charAt(i) == '.') {
                    continue;
                }
                before.append(new_id.charAt(i));

            }
        }
        // System.out.println(String.format("2, 3 = %s", before));
                           
        // 4
        if (before.charAt(0) == '.') {
            before.deleteCharAt(0);
        }                  
        if (before.length() != 0 && before.charAt(before.length() - 1) == '.') {
            before.deleteCharAt(before.length() - 1);
        }
        // System.out.println(String.format("4 = %s", before));
                           
        // 5
        if (before.length() == 0) {
            before.append("a");
        }
        // System.out.println(String.format("5 = %s", before));
                           
        // 6
        if (before.length() >= 16) {
            // System.out.println("catch");
            before.delete(15, before.length());
            if (before.charAt(before.length() - 1) == '.') {
                before.deleteCharAt(before.length() - 1);
            }
        }
        // System.out.println(String.format("6 = %s", before));
                           
        // 7
        if (before.length() <= 2) {
            char c = before.charAt(before.length() - 1);
            // System.out.println("c = " + c);
            while (before.length() < 3) {
                before.append(c);
            }
        }
        // System.out.println(String.format("7 = %s", before));
        
        return before.toString();
    }
    
    private boolean isAllowedWord(char c) {
        return c == '-' || c == '.' || c == '_' || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
