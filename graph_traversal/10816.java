import java.io.*;
import java.util.*;

class Main {
    /**
     * 10816
     * 2022-12-17
     */
    static int[] cards;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sb.append((findUpperBound(temp) - findLowerBound(temp)) + " ");
        }

        System.out.println(sb);
    }

    public static int findLowerBound(int target) {
        int low = 0;
        int high = cards.length;
        int mid;

        while (low < high) {
            mid = low + ((high - low) / 2);

            if (cards[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findUpperBound(int target) {
        int low = 0;
        int high = cards.length;
        int mid;

        while (low < high) {
            mid = low + ((high - low) / 2);

            if (cards[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int updateAnswer(int number, int index) {
        int count = 0;

        while (index < cards.length && cards[index] == number) {
            count++;
            index++;
        }

        return count;
    }
}