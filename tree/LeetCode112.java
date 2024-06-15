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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return travel(root, 0, targetSum);
    }

    public boolean travel(TreeNode node, int currentSum, int targetSum) {
        boolean isLeftHasPathSum = false;
        boolean isRightHasPathSum = false;

        if (node.left == null && node.right == null) {
            return (node.val + currentSum) == targetSum; 
        }
        if (node.left != null) {
            isLeftHasPathSum = travel(node.left, currentSum + node.val, targetSum);
        }
        if (node.right != null) {
            isRightHasPathSum = travel(node.right, currentSum + node.val, targetSum);
        }
        return isLeftHasPathSum || isRightHasPathSum;
    }
}
