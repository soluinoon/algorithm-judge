import java.io.*;
import java.util.*;

class Main {
    /**
     * 25305
     * 2022-12-17
     */
    static ArrayList<Integer> arr = new ArrayList<>();
    static int size, prize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        prize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        System.out.println(arr.get(prize - 1));
    }
}
