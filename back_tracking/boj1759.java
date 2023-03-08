import java.util.*;
import java.io.*;

class Main {
    /**
     * https://www.acmicpc.net/problem/1759
     * 1759 암호 만들기
     */
    static List<Character> moum = new ArrayList<>();
    static List<Character> zaum = new ArrayList<>();
    static List<Character> words = new ArrayList<>();
    static HashMap<Character, Boolean> visited = new HashMap<>();
    static List<String> answer = new ArrayList<>();

    /// 상 하 좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            char c = st.nextToken().charAt(0);
            classify(c);
            visited.put(c, false);
        }

        getAnswer(n);
        Collections.sort(answer);
        LinkedHashSet<String> answerSet = new LinkedHashSet<>(answer);
        for (String str : answerSet) {
            System.out.println(str);
        }
    }

    private static void classify(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            moum.add(c);
        } else {
            zaum.add(c);
        }
        words.add(c);
    }

    private static void getAnswer(int size) {
        // add 1 moum and 2 zaum
        for (int i = 0; i < moum.size(); i++) {
            char moum1 = moum.get(i);
            for (int j = 0; j < zaum.size(); j++) {
                for (int k = j + 1; k < zaum.size(); k++) {
                    char zaum1 = zaum.get(j);
                    char zaum2 = zaum.get(k);

                    StringBuilder sb = new StringBuilder();
                    sb.append(moum1);
                    sb.append(zaum1);
                    sb.append(zaum2);

                    visited.put(moum1, true);
                    visited.put(zaum1, true);
                    visited.put(zaum2, true);
                    makeAnswer(sb, 0, size);
                    visited.put(moum1, false);
                    visited.put(zaum1, false);
                    visited.put(zaum2, false);
                }
            }
        }
    }

    private static void makeAnswer(StringBuilder sb, int index, int size) {
        if (sb.length() == size) {
            char[] temp = sb.toString().toCharArray();
            Arrays.sort(temp);
            answer.add(new String(temp));
            return;
        }

        for (int i = index; i < words.size(); i++) {
            char c = words.get(i);
            if (visited.get(c) == false) {
                visited.put(c, true);
                sb.append(c);
                makeAnswer(sb, i + 1, size);
                sb.deleteCharAt(sb.length() - 1);
                visited.put(c, false);
            }
        }


    }
}