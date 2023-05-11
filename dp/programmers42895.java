import java.io.*;
import java.util.*;

class Solution {
    static List<Set<Integer>> sets = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public int solution(int N, int number) {
        int answer = -1;
        // arr 초기화
        for (int i = 0; i < 9; i++) {
            sets.add(new HashSet<Integer>());
        }
        sets.get(1).add(N);
        sb.append(N);
        for (int i = 2; i < 9; i++) {
            Set<Integer> curSet = sets.get(i);
            sb.append(N);
            curSet.add(Integer.parseInt(sb.toString()));
            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = sets.get(j);
                Set<Integer> postSet = sets.get(i - j);
                
                for (Integer preNum : preSet) {
                    for (Integer postNum : postSet) {
                        curSet.add(preNum + postNum);
                        curSet.add(preNum - postNum);
                        curSet.add(preNum * postNum);
                        if (postNum != 0)
                            curSet.add(preNum / postNum);
                    }
                }
            }
            
                
        }
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> curSet = sets.get(i);
            if (curSet.contains(number)) {
                return i;
            }
        }
        return answer;
    }
}
