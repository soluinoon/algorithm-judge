class Solution {
    public boolean buddyStrings(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                if (i != j) {
                    char temp = s.charAt(j);
                    sb.setCharAt(j, s.charAt(i));
                    sb.setCharAt(i, temp);
                    if (sb.toString().equals(goal)) {
                        return true;
                    }
                    sb.setCharAt(i, s.charAt(j));
                    sb.setCharAt(j, temp);
                }
            }
        }
        return false;
    }
}
