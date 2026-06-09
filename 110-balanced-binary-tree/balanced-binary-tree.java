/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        int n = ht(root,0);
        if(n == -1) return false;
        return true;
    }
    static int  ht(TreeNode root,int h){
        if(root == null) return 0;
        int a = ht(root.left,h);
        int b = ht(root.right,h);
        if(a == -1 || b == -1) return -1;
        if( Math.abs(a-b) >1) return -1;
        return 1+ Math.max(a, b) ;
    }
}