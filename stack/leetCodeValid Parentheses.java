class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (!isOpenBracket(s.charAt(0)) || isOpenBracket(s.charAt(s.length() - 1))) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isOpenBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if (!isOpenBracket(c) || !isSameType(s.charAt(i), c)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    public boolean isSameType(Character c, Character stackCharacter) {
        if (c == ')') {
            if (stackCharacter == '(') {
                return true;
            } else {
                return false;
            }
        }
        if (c == ']') {
            if (stackCharacter == '[') {
                return true;
            } else {
                return false;
            }
        }
        if (c == '}') {
            if (stackCharacter == '{') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
