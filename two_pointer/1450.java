import java.io.*;
import java.util.*;

class Main {
    /**
     * 1450
     * 22-12-21
     */
    static int[] arr1, arr2;
    static ArrayList<Integer> sum1, sum2;
    static boolean[] visited1, visited2;
    static int n, weight, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        weight = Integer.parseInt(st.nextToken());

        double exponential = Math.pow(2, 1);
        // 9 -> 4 / 5
        int half = n / 2;
        arr1 = new int[half];
        arr2 = new int[n - half];
        visited1 = new boolean[half];
        visited2 = new boolean[n - half];

        sum1 = new ArrayList<>();
        sum2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < half; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - half; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        getCombSum1();
//        System.out.println("sum1 = " + sum1.size());

        getCombSum2();
//        System.out.println("sum2 = " + sum2.size());
        Collections.sort(sum2);

        for (int i = 0; i < sum1.size(); i++) {

            int value = weight - sum1.get(i);
            int index = getUpperCase(value, sum2);
//            System.out.println("index = " + index);;
            count += index;
        }
        System.out.println(count);
    }

    public static void getCombSum1() {
        int size = arr1.length;

        for (int i = 0; i <= size; i++) {
            getCombSub1(i, 0, 0);
        }
    }

    public static void getCombSub1(int size, int sum, int index) {
        if (sum > weight) {
            return;
        }
        if (size == 0) {
            sum1.add(sum);
        }
        for (int i = index; i < arr1.length; i++) {
            if (!visited1[i]) {
                visited1[i] = true;
                getCombSub1(size - 1, sum + arr1[i], i + 1);
                visited1[i] = false;
            }
        }
    }

    public static void getCombSum2() {
        int size = arr2.length;

        for (int i = 0; i <= size; i++) {
            getCombSub2(i, 0, 0);
        }
    }

    public static void getCombSub2(int size, int sum, int index) {
        if (sum > weight) {
            return;
        }
        if (size == 0) {
            sum2.add(sum);
        }
        for (int i = index; i < arr2.length; i++) {
            if (!visited2[i]) {
                visited2[i] = true;
                getCombSub2(size - 1, sum + arr2[i], i + 1);
                visited2[i] = false;
            }
        }
    }

    public static int getUpperCase(int val, ArrayList<Integer> arr) {
        int low = 0;
        int high = arr.size();
        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;

            if (arr.get(mid) <= val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}