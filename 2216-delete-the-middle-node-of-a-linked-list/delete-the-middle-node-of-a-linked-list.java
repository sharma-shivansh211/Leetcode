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
        int n = 1;
        ListNode temp = head;
        while(temp.next !=  null){
            n++;
            temp = temp.next;
        }
        if(n==1)  return null;
        int i = 1;
        ListNode ans = head;
        while(i < n){
            if(i == n/2) ans.next = ans.next.next;
            ans = ans.next;
            i++;
        }
        return head;
    }}