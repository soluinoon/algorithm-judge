import java.util.*;
import java.io.*;
import java.util.stream.Stream;

class Main {
    /**
     * https://www.acmicpc.net/problem/2263
     * 2263 트리의 순
     */
    static Set<Integer> set1 = new HashSet<>();
    static Set<Integer> set2 = new HashSet<>();
    static List<Integer> answer = new ArrayList<>();

    static List<Integer> inOrder = new ArrayList<>();
    static List<Integer> postOrder = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder.add(Integer.parseInt(st.nextToken()));
        }

        getAnswer(0, inOrder.size() - 1);
        System.out.println(answer);
        /*
        if in-order 4 1 7 / 2 / 6 3 5
        and post-order    4 7 1 / 6 5 3 / 2
        pre-order = 2 / 1 4 7 / 3 6 5
                2
          1           3
        4  7        6  5
     9 11 10 8  13 12 14 15

     if in-order        9 4 11 / 1 / 10 7 8 / 2 / 13 6 12 / 3 / 14 5 15
     and post-order     9 11 4 10 8 7 1 / 13 12 6 14 15 5 3 / 2
     pre-order          2 / 1 / 4 / 9 11 / 7 / 10 8 / 3 / 6 / 13 12 / 5 / 14 15


         */

        // in-order -> L D R
        // post-order -> L R D
        // pre-order -> D L R // what we want

        // 1. 포스트 오더에서 맨 오른쪽 값을 D로 찾음
        // 2. 찾은 D로 인오더에서 왼쪽 파트의 L과 오른쪽 파트의 L을 찾음
        // 3. 찾은 왼쪽 L과 오른쪽 L로 포스트 오더에서 파트를 나눔
        // 4. 각 나눈 파트에 대해 1~3 반복
    }

    private static void getAnswer(int start, int end) {
        System.out.printf("start = %d, end = %d\n", start, end);
        // 1. 포스트 오더에서 맨 왼쪽 값을 D로 찾음
        int data = getDataAtPost(start, end);
        answer.add(data);
        
        // 2. 찾은 D로 인오더에서 왼쪽 파트의 L과 오른쪽 파트의 L을 찾음
        int dataIndex = getIndexOfDataAtIn(start, end, data);
        int leftL = getLeftAtIn(start, dataIndex - 1);
        int rightL = getLeftAtIn(dataIndex + 1, end);
        System.out.println(String.format("dataIndex = %d leftL = %d rightL = %d", dataIndex, leftL, rightL));

        if (end - start <= 3) {
            answer.add(leftL);
            answer.add(rightL);
            return;
        } else {
            getAnswer(postOrder.indexOf(leftL), postOrder.indexOf(rightL) - 1);
            getAnswer(postOrder.indexOf(rightL), end - 1);
            answer.add(leftL);
            answer.add(rightL);
        }
    }

    private static int getLeftAtIn(int start, int end) {
        return inOrder.get(start);
    }

    private static int getDataAtPost(int start, int end) {
        return postOrder.get(end);
    }

    private static int getIndexOfDataAtIn(int start, int end, int data) {
        for (int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i) == data) {
                return i;
            }
        }
        return -1;
    }
}
