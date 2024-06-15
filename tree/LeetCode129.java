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
    double total = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travel(root, 0, 0);

        return (int)total;
    }

    public void travel(TreeNode node, int depth, double sum) {
        double square = (depth == 0) ? 0 : 10; 
        double currentSum = sum * square + node.val;

        // System.out.println("pow = " + square + " cur = " + currentSum);

        if (node.left == null && node.right == null) total += currentSum;
        if (node.left != null) travel(node.left, depth + 1, currentSum);
        if (node.right != null) travel(node.right, depth + 1, currentSum);
    }
}
