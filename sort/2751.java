import java.io.*;
import java.util.*;

class Main {
    /**
     * 2751
     * 2022-12-17
     */
    static ArrayList<Integer> arr = new ArrayList<>();
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        int[] arr2 = new int[size];
        for (int i = 0; i < size; i++) {
//          arr.add(Integer.parseInt(br.readLine()));
            arr2[i] = Integer.parseInt(br.readLine());
        }
        // Collections.sort(arr);
        Arrays.sort(arr2);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < size; i++) {
            bw.write(arr2[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}