import java.io.*;
import java.util.*;

class Solution {
    static int answer = 1;
    
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        // print(routes);
        getAnswer(routes);
        return answer;
    }
    
    public void print(int[][] routes) {
        for (int i = 0; i < routes.length; i++) {
            System.out.println(String.format("arr[%d] = [%d, %d]", i, routes[i][0], routes[i][1]));
        }
    }
    
    public void getAnswer(int[][] routes) {
        int limit = routes[0][1];
        int index = 0;
        
        while (true) {
            // System.out.println("limit = " + limit);

            if (index == routes.length) {
                break;
            }
            if (routes[index][0] > limit) {
                System.out.println("catch");
                answer++;
                limit = routes[index][1];
            }
            index++;
        }
    }
}
