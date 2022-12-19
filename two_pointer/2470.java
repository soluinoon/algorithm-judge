import java.io.*;
import java.util.*;

class Main {
    /**
     * 2470
     * 2022-12-19
     */
    static int[] arr;
    static int p1, p2, answer_p1, answer_p2;
    static int gap = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int count = 0;

        // input
        arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // logic
        Arrays.sort(arr);
        p1 = 0;
        p2 = arr.length - 1;
        while (p1 < p2) {
            int absoluteValue = getAbsoluteValue(arr[p1] + arr[p2]);
            if (absoluteValue < gap) {
                gap = absoluteValue;
                answer_p1 = p1;
                answer_p2 = p2;
                if (gap == 0) {
                    break;
                }
            }
            if (arr[p1] + arr[p2] < 0) {
                p1++;
            } else if (arr[p1] + arr[p2] > 0) {
                p2--;
            }
        }
        System.out.println(arr[answer_p1] + " " + arr[answer_p2]);
    }

    public static int getAbsoluteValue(int num) {
        if (num < 0) {
            return -1 * num;
        }
        return num;
    }
}