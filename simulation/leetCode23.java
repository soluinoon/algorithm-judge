class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = new ListNode(0);
        ListNode temp = answer;

        while (!isEnd(lists)) {
            int minimalCost = getMinimalCost(lists);
            ListNode cur = new ListNode(minimalCost);
            answer.next = cur;
            answer = cur;
        }
        temp = temp.next;
        return temp;
    }

    private boolean isEnd(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return false;
            }
        }
        return true;
    }

    private int getMinimalCost(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                index = i;
            }
        }
        lists[index] = lists[index].next;
        return min;
    }
}
