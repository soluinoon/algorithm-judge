import java.io.*;
import java.util.*;

// start 15:21
// end : 15:47
class Solution {
    static int max;

    public int solution(int[] menu, int[] order, int k) {
        Queue<Integer> visitor = new LinkedList<>();


        int waitTime = 1;
        int curVisitor = -1;
        // 시간 돈다.
        for (int i = 0; i <= (order.length - 1) * k; i++) {
            if (i % k == 0) {
                // 단위 시간 되면 방문자 추가
                visitor.add(i / k);
            }
            if (waitTime > 0) {
                waitTime--;
            }
            // 주문 제조중 아니라면
            if (waitTime == 0) {
                // curVisitor == -1 이면 아무 주문도 없었다는 뜻
                if (curVisitor == -1) {
                    if (visitor.isEmpty()) {
                        continue;
                    }
                    curVisitor = visitor.peek();
                    waitTime = menu[order[curVisitor]];
                } else { // 누군가의 주문이 끝났다는 뜻
                    visitor.poll();
                    if (visitor.isEmpty()) {
                        curVisitor = -1;
                        continue;
                    }
                    curVisitor = visitor.peek();
                    waitTime = menu[order[curVisitor]];
                }
            }
            // 기다리는 손님 수 세기
            if (visitor.size() > max) {
                max = visitor.size();
            }
        }

        return max;
    }
}
