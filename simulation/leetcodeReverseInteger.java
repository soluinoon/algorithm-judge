class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        Integer wrapperX = x;
        int minusIndex = 0;
        if (x < 0) {
            sb.append('-');
            x *= -1;
            minusIndex = 1;
        }

        String number = wrapperX.toString();
        int digitCount = 0;
        int index = number.length() - 1;

        while(index >= minusIndex) {
            sb.append(number.charAt(index));
            digitCount++;
            index--;
            if (digitCount > 10 || (digitCount == 10 && !isInRange(sb))) {
                return 0;
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public boolean isInRange(StringBuilder sb) {
        String maxPositive = "2147483647";
        String maxNegative = "-2147483648";
        String currentMax = maxPositive;
        int index = 0;
        System.out.println("sb = " + sb);
        if (sb.charAt(0) == '-') {
            index = 1;
            currentMax = maxNegative;
        }

        while (index < currentMax.length()) {
            int number = Character.getNumericValue(sb.charAt(index));
            int maxNumber = Character.getNumericValue(currentMax.charAt(index));
            // System.out.println("number = " + number + " maxNumber = " + maxNumber);
            if (number > maxNumber) {
                return false;
            } else if (number < maxNumber) {
                return true;
            }
            index++;
        }
        return true;
    }
}
