class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        List<List<Character>> charList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        // edge case
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        for (int i = 0; i < digits.length(); i++) {
            charList.add(parseDigitToLetter(digits.charAt(i)));
        }
        dfs(charList, sb, answer, 0);
        return answer;
    }

    public void dfs(List<List<Character>> charList, StringBuilder sb, List<String> answer, int count) {
        if (charList.size() == count) {
            answer.add(sb.toString());
            return;
        }

        List<Character> cur = charList.get(count);
        for (Character c : cur) {
            sb.append(c);
            dfs(charList, sb, answer, count + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<Character> parseDigitToLetter(Character digit) {
        if (digit == '2') {
            return new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        } else if (digit == '3') {
            return new ArrayList<Character>(Arrays.asList('d', 'e', 'f'));
        } else if (digit == '4') {
            return new ArrayList<Character>(Arrays.asList('g', 'h', 'i'));
        } else if (digit == '5') {
            return new ArrayList<Character>(Arrays.asList('j', 'k', 'l'));
        } else if (digit == '6') {
            return new ArrayList<Character>(Arrays.asList('m', 'n', 'o'));
        } else if (digit == '7') {
            return new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's'));
        } else if (digit == '8') {
            return new ArrayList<Character>(Arrays.asList('t', 'u', 'v'));
        } else if (digit == '9'){
            return new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z'));
        } else {
            return new ArrayList<Character>();
        }
    }
}
