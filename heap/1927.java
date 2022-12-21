import java.io.*;
import java.util.*;

class Main {
    /**
     * 1927
     * 22-12-21
     */
    static PriorityQueue<Integer> heap = new PriorityQueue<>();
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                if (heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.add(number);
            }
        }
    }
}