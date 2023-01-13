import java.io.*;
import java.util.*;

public class Main {
    /**
     * https://www.acmicpc.net/problem/1946
     * 1946 신입사원
    */
    static int fcount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        // input
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] scores = new int[n][2];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.parseInt(st.nextToken());
                scores[j][1] = Integer.parseInt(st.nextToken());
            }
            // logic
            // 서류 점수를 기준으로 정렬합니다.
            sortScoresByApplication(scores);
            int beforeInterviewScore = scores[0][1];
            int sum = 1;
            for (int j = 0; j < scores.length; j++) {
                if (beforeInterviewScore > scores[j][1]) {
                    sum++;
                    beforeInterviewScore = scores[j][1];
                }
            }
            System.out.println(sum);
        }
    }

    public static void sortScoresByApplication(int[][] scores) {
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
    }
}