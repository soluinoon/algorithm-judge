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
    ArrayList<Integer> answer = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        travel(root, answer);

        return answer;
    }

    private void travel(TreeNode node, List<Integer> answer) {
        // left
        if (node.left != null) {
            travel(node.left, answer);
        }
        // me
        answer.add(node.val);
        // right
        if (node.right != null) {
            travel(node.right, answer);
        }
    }
}
