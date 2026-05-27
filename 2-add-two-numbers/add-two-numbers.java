class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode h3 = l3;

        int c = 0;

        while (l1 != null || l2 != null || c != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + c;

            c = sum / 10;

            h3.next = new ListNode(sum % 10);

            h3 = h3.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return l3.next;
    }
}