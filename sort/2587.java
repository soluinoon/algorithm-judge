import java.io.*;
import java.util.*;

class Main {
    /**
     * #2587
     * 2022-12-17
     */
    static ArrayList<Integer> arr = new ArrayList<>();
    static int size, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            arr.add(temp);
        }
        Collections.sort(arr);
        System.out.println(sum / 5 + sum % 5);
        System.out.println(arr.get(2));
    }
}
