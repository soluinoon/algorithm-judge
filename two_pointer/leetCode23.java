class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ptr1 = 0;
        int ptr2 = 0;
        int index = 0;
        int bigTarget = 0;
        int smallTarget = 0;
        int answer = 0;

        if ((nums1.length + nums2.length) % 2 == 0) {
            bigTarget = (nums1.length + nums2.length) / 2;
            smallTarget = ((nums1.length + nums2.length) / 2) - 1;
        } else {
            bigTarget = (nums1.length + nums2.length) / 2;
            smallTarget = -1;
        }

        while (true) {
            int number1;
            int number2;

            if (ptr1 < nums1.length) {
                number1 = nums1[ptr1];
            } else {
                number1 = Integer.MAX_VALUE;
            }
            if (ptr2 < nums2.length) {
                number2 = nums2[ptr2];
            } else {
                number2 = Integer.MAX_VALUE;
            }
            
            if (number1 < number2) {
                if (index == bigTarget || index == smallTarget) {
                    answer += number1;
                }
                ptr1++;
            } else {
                if (index == bigTarget || index == smallTarget) {
                    answer += number2;
                }
                ptr2++;
            }
            index++;
            if (index > bigTarget) {
                break;
            }
        }
        System.out.println("answer = " + answer);
        if (smallTarget == -1) {
            return (double)answer;
        } else {
            return (double)answer / 2;
        }
    }
}
