import java.io.*;
import java.util.*;

// 12:58
class Solution {
    static boolean visited[];
    static int network;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
    
        visited = new boolean[computers.length];
        Queue<Integer> q = new LinkedList<>();
        // start visit
        for (int cur = 0; cur < computers.length; cur++) {
            // 이미 방문했다면, 스킵
            if (visited[cur]) {
                continue;
            }
            // 방문 시작
            q.add(cur); // 현재 노드 삽입
            while (!q.isEmpty()) {
                int temp = q.poll();
                if (visited[temp]) {
                    continue;
                }
                // 방문 처리
                visited[temp] = true;
                fillQueue(temp, computers, q);
            }
            network++;
        }
        /*
        0) 1 1 0
        1) 1 1 0
        2) 0 0 1
        */
        
        return network;
    }
    
    public void fillQueue(int index, int[][] computers, Queue<Integer> q) {
        for (int i = 0; i < computers.length; i++) {
            if (i != index && computers[index][i] == 1) {
                q.add(i);
                ;
            }       
        }
    }
}
