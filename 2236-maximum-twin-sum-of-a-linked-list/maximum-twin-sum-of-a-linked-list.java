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
    public int pairSum(ListNode head) {
        int n = no(head,0);
        int[] arr = values(head,n);
        int max = 0;
        for(int left = 0, right = n-1; left < right ; left++,right--){
            int sum = arr[left] + arr[right];
            max = Math.max(sum,max);
        }
        return max;
    }
    static int no(ListNode head , int n){
        while(head.next !=  null){
            n++;
            head = head.next;
        }
        return n+1;
    }
    static int[] values(ListNode head,int n){
        int[] arr = new int[n];
        int i = 0;
        while(i != n){
            arr[i] = head.val;
            head = head.next;
            i++;
        }
        return arr;
    }
}