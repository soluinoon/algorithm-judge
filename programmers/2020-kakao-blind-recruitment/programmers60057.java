import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            int size = getCompLenBySize(s, i);
            if (answer > size) {
                answer = size;
            }
        }
        
        return answer;
    }
    
    // 사이즈를 기준으로 잘라서 압축된 문자열의 길이를 반환하는 함수
    public int getCompLenBySize(String s, int size) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> strs = splitBySize(s, size);

        for (int i = 0; i < strs.size(); i++) {
            int count = 0;
            // i의 다음번 부터 검사해서 같은 문자열이라면 계속 카운트를 증가시키고, 아니라면 빠져나옵니다.
            for (int j = i + 1; j < strs.size(); j++) {
                if (strs.get(i).equals(strs.get(j))) {
                    count++;
                } else {
                    break;
                }
            }
            // count가 0이라면 앞에 숫자를 붙이지 않아도 되고 0이 아니라면 숫자를 넣고 문자열을 넣습니다.
            if (count != 0) {
                sb.append(count + 1);
            }
            sb.append(strs.get(i));
            // 같은 문자열이 없었다면 카운트는 그대로 0이라 i는 변화가 없고, 같은 문자열이 있었다면 그만큼 i를 증가시켜 스킵시킵니다.
            i += count;
        }

        return sb.length();
    }
    
    // 사이즈를 기준으로 문자열을 나누는 함수입니다.
    public ArrayList<String> splitBySize(String s, int size) {
        int startIndex = 0;
        // substring 함수는 끝으로 준 인덱스의 이전까지 들어가므로 이렇게 설정합니다.
        int endIndex = startIndex + size;
        ArrayList<String> strs = new ArrayList<>();
        
        while (startIndex < s.length()) {
            strs.add(s.substring(startIndex, endIndex));
            startIndex = endIndex;
            endIndex = startIndex + size;
            // 맨 끝 문자열은 사이즈가 작을 수 있으므로, 그에 맞게 문자열의 끝으로 보정해줍니다.
            if (endIndex >= s.length()) {
                endIndex = s.length();
            }
        }
        return strs;
    }
    
    // 자른 문자열을 출력하는 보조 함수입니다.
    public void printStrs(ArrayList<String> strs) {
        for (int i = 0; i < strs.size(); i++) {
            System.out.printf("str[%d] = %s\n", i, strs.get(i));
        }
    }
}
