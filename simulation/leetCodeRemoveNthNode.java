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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;

        Info info = backTracking(temp, 1, n);
        if (info.size == 1) {
            return null;
        } else if (info.size == n) {
            return head.next;
        }
        return head;
    }

    private Info backTracking(ListNode temp, int count, int n) {
        if (temp.next == null) {
            return new Info(count);
        }
        ListNode cur = temp;

        Info info = backTracking(temp.next, count + 1, n);
        if (count == info.size - n + 1) {
            System.out.println("catchDeleteNode when count = " + count);
            info.nextOfDeleteNode = cur.next;
        } else if (count == info.size - n) {
            System.out.println("catchNode when count = " + count);
            cur.next = info.nextOfDeleteNode;
        }
        return info;
    }

    class Info {
        ListNode nextOfDeleteNode;
        int size;

        public Info(int size) {
            this.size = size;
        }
    }
}
