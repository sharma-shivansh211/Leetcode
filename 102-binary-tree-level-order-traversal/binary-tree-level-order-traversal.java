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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> soln = new ArrayList<>();
        pre(root,0,soln);
        return soln;

    }
    public static void pre(TreeNode root,int l, List<List<Integer>> s){
        if(root == null) return;
        if(s.size() == l){
            List<Integer> a = new ArrayList<>();
            a.add(root.val);
            s.add(a);
        }else
            s.get(l).add(root.val);
        
        pre(root.left,l+1,s);
        pre(root.right,l+1,s);
    }
}