import java.io.*;
import java.util.*;

// start 2:48
// end 2:57
class Solution {
    
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;
        
        for (int num : ability) {
            heap.add(num);
        }
        
        for (int i = 0; i < number; i++) {
            int student1 = heap.poll();
            int student2 = heap.poll();
            int power = student1 + student2;
            
            heap.add(power);
            heap.add(power);
        }
        
        for (int abil : heap) {
            // System.out.println(abil);
            answer += abil;
        }
        
        return answer;
    }
}
