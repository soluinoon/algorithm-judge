/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder number1 = new StringBuilder();
        StringBuilder number2 = new StringBuilder();
        StringBuilder sum = new StringBuilder();

        ListNode temp = l1;
        while (temp != null) {
            // System.out.println("val = " + temp.val);
            number1.append(String.valueOf(temp.val));
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            // System.out.println("val = " + temp.val);
            number2.append(String.valueOf(temp.val));
            temp = temp.next;
        }
        sum = createSum(number1, number2);

        return createAnswerWithSum(sum);
    }

    private StringBuilder createSum(StringBuilder number1, StringBuilder number2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int carry = 0;
        while (i < number1.length() && i < number2.length()) {
            int temp = Character.getNumericValue(number1.charAt(i)) + Character.getNumericValue(number2.charAt(i)) + carry;

            sb.append(temp % 10);
            if (temp >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            i++;
        }
        while (i < number1.length()) {
            int temp = Character.getNumericValue(number1.charAt(i)) + carry;
            sb.append(temp % 10);
            if (temp >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            i++;
        }
        while (i < number2.length()) {
            int temp = Character.getNumericValue(number2.charAt(i)) + carry;
            sb.append(temp % 10);
            if (temp >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            i++;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        // System.out.println(sb);
        return sb;
    }

    private ListNode createAnswerWithSum(StringBuilder sum) {
        
        ListNode listNode = new ListNode();
        ListNode answer = listNode;

        for (int i = 0; i < sum.length(); i++) {
            listNode.val = Character.getNumericValue(sum.charAt(i));
            // System.out.println(listNode.val);
            if (i != sum.length() - 1) {
                listNode.next = new ListNode();
                listNode = listNode.next;
            }        
        }
        return answer;
    }
}
