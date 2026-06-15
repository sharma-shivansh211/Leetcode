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
    public ListNode deleteMiddle(ListNode head) {
        int n = no(head,0);
        if(n==1){
            return null;
        }
        if(n == 2){
            head.next = null;
            return head;
        }
        int i = 1;
        ListNode ans = head;
        while(i < n){
            if(i == n/2){
                ListNode temp = ans.next;
                ans.next = temp.next;
            }
            ans = ans.next;
            i++;
        }
        return head;
    }
    static int no(ListNode head , int n){
        while(head.next !=  null){
            n++;
            head = head.next;
        }
        return n+1;
    }
}