import java.io.*;
import java.util.*;

class Solution {
    
    // 1:00
    HashMap<String, Integer> orderCounter = new HashMap<>();
    int[] courseMaxOrder = new int[11];
    ArrayList<String> answer = new ArrayList<>();
    
    
    public String[] solution(String[] orders, int[] course) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < orders.length; i++) {
            char[] charList = orders[i].toCharArray();
            Arrays.sort(charList);
            String sortedStr = new String(charList);
            
            for (int j = 1; j <= sortedStr.length(); j++) {
                getSubSet(sortedStr, sb, j, 0, -1);
            }    
        }
        
        for (int courseSize : course) {
            for (String key : orderCounter.keySet()) {
                if (key.length() == courseSize && orderCounter.get(key) >= 2 && orderCounter.get(key) == courseMaxOrder[courseSize]) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        String[] answerToStrs = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerToStrs[i] = answer.get(i);
        }
        return answerToStrs;
    }
    
    public void getSubSet(String str, StringBuilder sb, int size, int count, int beforeIndex) {
        if (count == size) {
            Integer num = orderCounter.getOrDefault(sb.toString(), 0);
            if (num + 1 > courseMaxOrder[size]) {
                courseMaxOrder[size] = num + 1;
            }
            orderCounter.put(sb.toString(), num + 1);
            return; 
        }
        
        for (int i = beforeIndex + 1; i <= str.length() - size + count; i++) {
            sb.append(str.charAt(i));
            getSubSet(str, sb, size, count + 1, i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
