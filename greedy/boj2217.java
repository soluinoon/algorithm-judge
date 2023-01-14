import java.io.*;
import java.util.*;

public class Main {
    /**
     * https://www.acmicpc.net/problem/2217
     * 2217 로프
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }

        // 정렬을 해줍니다
        Arrays.sort(arr, (o1, o2) -> {
            return o2 - o1;
        });

        // 위에서 부터 계산해 나갑니다.
        long answer = 0;
        long weight = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // 최솟값을 갱신합니다.
            if (arr[i] < min) {
                min = arr[i];
            }
            // 최솟값으로 주어진 로프로 들 수 있는 최대 무게를 구합니다.
            weight = min * (i + 1);
            // 만약 구한 무게가 이전무게보다 크다면 갱신합니다.
            if (weight > answer) {
                answer = weight;
            }
        }
        System.out.println(answer);
    }
}