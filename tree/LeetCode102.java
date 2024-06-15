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
import java.io.*;
import java.util.*;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        for (int i = 0; i < 2000; i++) {
            answer.add(new ArrayList<Integer>());
        }

        travel(root, 0);

        for (int i = 0; i < 2000; i++) {
            if (answer.get(i).isEmpty()) {
                answer.subList(i, answer.size()).clear();
                break;
            }
        }

        return answer;
    }

    public void travel(TreeNode node, int depth) {
        if (node.left != null) travel(node.left, depth + 1);
        if (node.right != null) travel(node.right, depth + 1);

        answer.get(depth).add(node.val);
    }
}
