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
    public int diameterOfBinaryTree(TreeNode root) {
        t a = diameter(root);
        return a.d;
    }

    public t diameter(TreeNode root) {
        if (root == null) {
            return new t(0, 0);
        }

        t left = diameter(root.left);
        t right = diameter(root.right);

        int hght = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.d;
        int dia2 = right.d;
        int dia3 = left.ht + right.ht ;

        return new t(hght, Math.max(dia3, Math.max(dia1, dia2)));
    }

    static class t {
        int ht;
        int d;

        t(int ht, int d) {
            this.ht = ht;
            this.d = d;
        }
    }
}