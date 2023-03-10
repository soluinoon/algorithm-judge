import java.io.*;
import java.util.*;

class Solution {
    static Set<Set<String>> answerSet;

    static boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        answerSet = new HashSet<>();
        
        tracking(user_id, banned_id, 0);
        
        return answerSet.size();
    }
    
    public void tracking(String[] user_id, String[] banned_id, int bannedIndex) {
        if (banned_id.length == bannedIndex) {
            addAnswer(user_id);
            //printSet(user_id);
            return;
        }
        String bannedId = banned_id[bannedIndex];
        
        for (int i = 0; i < user_id.length; i++) {
            if (isMatch(user_id[i], bannedId) && !visited[i]) {
                visited[i] = true;
                tracking(user_id, banned_id, bannedIndex + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isMatch(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void printSet(String[] user_id) {
        System.out.println("set");
        for (Set<String> set : answerSet) {
            for (String str : set) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void addAnswer(String[] user_id) { 
        Set<String> answer = new HashSet<>();
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                answer.add(user_id[i]);
            }
        }
        answerSet.add(answer);
    }
}
